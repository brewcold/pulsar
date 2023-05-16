import Landing from '../Landing.vue';
import Login from '../components/Login.vue';
import Signup from '../components/Signup.vue';

export default [
  {
    path: '/',
    name: 'landing', //랜딩 페이지 (로그인, 로그아웃, 회원가입)
    component: Landing,
    children: [
      {
        path: 'signin', //회원가입 폼
        component: Signup,
      },
    ],
  },
];
