import LandingContainer from '../LandingContainer.vue';
import LoginContainer from '../components/LoginContainer.vue';
import SignUp from '../components/SignUp.vue';

export default [
  {
    path: '/',
    name: 'landing', //랜딩 페이지 (로그인, 로그아웃, 회원가입)
    component: LandingContainer,
    children: [
      { path: '', component: LoginContainer },
      {
        path: 'signup', //회원가입 폼
        component: SignUp,
      },
    ],
  },
];
