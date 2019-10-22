<template>
  <div class="form-container">
    <div class="online-bulb">
      <div class="connection-status">{{ hasConnection ? 'Online ': 'Offline ' }}</div>
      <div class="bulb" :class="hasConnection ? 'on': 'off'"></div>
    </div>
    <div class="form-outer-container">
      <h2>Update Form</h2>
      <form action @submit.prevent="submitForm">
        <div class="form-inner-container">
          <input type="text" placeholder="Id ?" v-model="user.id" />
          <input type="email" placeholder="Email ?" v-model="user.email" />
          <input type="text" placeholder="Name ?" v-model="user.name" />
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import client from "../client";

export default {
  name: "edit-user",

  data() {
    return {
      connectionInterval: 0,
      hasConnection: true,
      user: {
        email: "",
        name: "",
        id: 0,
        isDirty: false
      }
    };
  },
  methods: {
    submitForm() {
      if (this.hasConnection) {
        client
          .post("/users", JSON.stringify(this.user))
          .then(user => console.log("user is", user));
      } else {
        this.user.isDirty = true;
        localStorage.setItem("cache", JSON.stringify(this.user));
      }
    },
    checkForPendingUpdates() {
      const cachedUser = localStorage.getItem("cache");
      if (cachedUser != null && cachedUser.length > 0) {
        const user = JSON.parse(cachedUser);
        if (user.isDirty && this.hasConnection) {
          client.post("/users", JSON.stringify(user)).then(() => {
            localStorage.setItem(
              "cache",
              JSON.stringify({ ...user, isDirty: false })
            );
          });
        }
      }
    },
    startWatchForConnection() {
      this.connectionInterval = setInterval(() => {
        client
          .get("/ping")
          .then(() => {
            this.hasConnection = true;
            this.checkForPendingUpdates();
          })
          .catch(() => (this.hasConnection = false));
      }, 1000);
    }
  },
  mounted() {
    this.startWatchForConnection();
    client.get(`/users/${this.$route.params.id}`)
      .then(res => this.user = res.data)
  },
  beforeDestroy() {
    clearInterval(this.connectionInterval);
  }
};
</script>
<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.bulb {
  width: 10px;
  height: 10px;
  border-radius: 50%;
}
.online-bulb {
  position: absolute;
  right: 20%;
  line-height: 9px;
  display: flex;
}
.bulb.on {
  background-color: lightgreen;
}
.bulb.off {
  background-color: red;
}
.form-outer-container {
  max-width: 25rem;
  margin: 0 auto;
}
.form-inner-container {
  display: flex;
  flex-direction: column;
}
.form-inner-container input {
  margin-top: 0.5rem;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 3px;
  margin-bottom: 10px;
  width: 100%;
  box-sizing: border-box;
  font-family: montserrat;
  color: #2c3e50;
  font-size: 13px;
}
.form-inner-container button {
  width: 100px;
  background: #27ae60;
  font-weight: bold;
  color: white;
  border: 0 none;
  border-radius: 1px;
  cursor: pointer;
  padding: 10px 5px;
  margin: 10px 5px;
}
.form-container {
  position: relative;
}
.connection-status {
  padding-right: 5px;
}
</style>