import {createRouter, createWebHashHistory} from 'vue-router';
import WelcomeVue from '@/components/Welcome';
import Overview31 from "@/components/offers/Overview31";
import Overview32 from "@/components/offers/Overview32";
import UnknownRoute from "@/components/UnknownRoute";
import Overview33 from "@/components/offers/Overview33";
import Detail33 from "@/components/offers/Detail33";

const routes = [
    {path: '/home', component: WelcomeVue},
    {path: '/offers/Overview31', component: Overview31},
    {path: '/offers/Overview32', component: Overview32},
    { path: '/offers/overview33', component: Overview33, children:[{
            path:':id', component: Detail33
        }]},

    {path: '/offers/Overview33', component: Overview33},
    {path: '/', redirect: '/home'},
    {path: '/:unknown(.*)', component: UnknownRoute}
];


export const router = createRouter({
    history:createWebHashHistory(),
    routes
})