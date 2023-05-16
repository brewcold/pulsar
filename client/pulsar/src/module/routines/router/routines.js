import Routines from '../Routines.vue';
import RoutineDetail from '../components/RoutineDetail.vue';
import RoutineModify from '../components/RoutineModify.vue';
import RoutineWrite from '../components/RoutineWrite.vue';

export default [
  {
    path: '/routines', //루틴 관리
    component: Routines,
    children: [
      {
        path: ':id', //routines/:id (루틴 상세보기)
        component: RoutineDetail,
        children: [
          {
            path: 'modify', //routines/:id/modify (루틴 수정)
            component: RoutineModify,
          },
          //세부 운동 종목 추가는 모달로 설정
        ],
      },
      {
        path: 'write', //routines/write (새 루틴 작성)
        component: RoutineWrite,
      },
    ],
  },
];
