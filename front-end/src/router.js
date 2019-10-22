import EditUser from './components/EditUser'
import ShowUser from './components/ShowUser'
import UserDetails from './components/UserDetails'
import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)

export default new VueRouter({
    routes: [
        {
            path: '/',
            component: ShowUser
        },
        {
            path: '/edit/:id',
            component: EditUser
        },
        {
            path: '/user/:id',
            component: UserDetails
        }
    ]
})