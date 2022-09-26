import {createRouter, createWebHashHistory} from 'vue-router';
import WelcomeVue from '@/components/Welcome';
import Overview31 from "@/components/offers/Overview31";
import Overview32 from "@/components/offers/Overview32";
import UnknownRoute from "@/components/UnknownRoute";

const routes = [
    {path: '/home', component: WelcomeVue},
    {path: '/offers/Overview31', component: Overview31},
    {path: '/offers/Overview32', component: Overview32},
    {path: '/', redirect: '/home'},
    {path: '/:unknown(.*)', component: UnknownRoute}
];


export const router = createRouter({
    history:createWebHashHistory(),
    routes
})