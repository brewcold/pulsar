import Vue from 'vue';
import VueRouter from 'vue-router';
import landing from '../../module/landing/router/landing.js';
import community from '../../module/community/router/community.js';
import routines from '../../module/routines/router/routines.js';
import statistics from '../../module/statistics/router/statistics.js';
import mypage from '../../module/mypage/router/mypage.js';
import settings from '../../module/settings/router/settings.js';

Vue.use(VueRouter);

const routes = [
  ...landing,
  ...community,
  ...routines,
  ...statistics,
  ...mypage,
  ...settings,
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
