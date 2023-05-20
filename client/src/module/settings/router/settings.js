import SettingsView from '../SettingsView.vue';
import Edit from '../components/Edit.vue';
import Quit from '../components/Edit.vue';

export default [
  {
    path: '/settings', //계정 관리 및 설정
    component: SettingsView,
    children: [
      {
        path: 'edit', //회원정보 수정 페이지
        component: Edit,
      },
      {
        path: 'quit', //회원탈퇴 페이지
        component: Quit,
      },
    ],
  },
];
