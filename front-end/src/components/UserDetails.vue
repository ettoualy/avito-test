<template>
    <div class="container">
        <div class="line">
            Email {{ user.email }}
        </div>
        <div class="line">
            Name {{ user.name }}
        </div>
        <router-link :to="`/edit/${id}`"> Edit profile </router-link>
    </div>
</template>
<script>
import client from '../client'

export default {
    data() {
        return {
            user: {
                name: '',
                email: '',
                id: 0
            }
        }
    },
    mounted() {
        this.id = this.$route.params.id
        client.get(`/users/${this.$route.params.id}`)
            .then(res => this.user = res.data)
    }
}
</script>