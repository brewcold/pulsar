import RoutinesView from '../RoutinesView.vue';
import RoutineDetailContainer from '../components/RoutineDetailContainer.vue';
import RoutineDetailWrapper from '../components/RoutineDetailWrapper.vue';
import RoutineListContainer from '../components/RoutineListContainer.vue';
import RoutineModifyContainer from '../components/RoutineModifyContainer.vue';
import RoutineWriteContainer from '../components/RoutineWriteContainer.vue';

export default [
  {
    path: '/routines', //루틴 관리
    component: RoutinesView,
    children: [
      {
        path: '',
        component: RoutineListContainer,
      },
      {
        path: ':routineNo', //routines/:routineNo (루틴 상세보기)
        component: RoutineDetailWrapper,
        children: [
          { path: '', component: RoutineDetailContainer },
          {
            path: 'modify', //routines/:routineNo/modify (루틴 수정)
            component: RoutineModifyContainer,
          },
          //세부 운동 종목 추가는 모달로 설정
        ],
      },
      {
        path: 'write', //routines/write (새 루틴 작성)
        component: RoutineWriteContainer,
      },
    ],
  },
];
