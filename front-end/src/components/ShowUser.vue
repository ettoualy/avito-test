<template>
    <div class="container">
        <h1> Show user </h1>
        <input type="text" v-model="id" value="Choose use id ?" />
        <button @click="showUser">Show user</button>
    </div>
</template>
<script>
export default {
    data() {
        return {
            id: 0
        }
    },
    methods: {
        showUser() {
            this.$router.push(`/user/${this.id}`)
        }
    }
}
</script>