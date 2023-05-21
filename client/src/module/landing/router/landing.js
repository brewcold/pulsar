import LandingView from '../LandingView.vue';
import LoginContainer from '../components/LoginContainer.vue';
import SignUp from '../components/SignUp.vue';

export default [
  {
    path: '/',
    //랜딩 페이지 (로그인, 로그아웃, 회원가입)
    component: LandingView,
    children: [
      { path: '', component: LoginContainer },
      {
        path: 'signup', //회원가입 폼
        component: SignUp,
      },
    ],
  },
];
