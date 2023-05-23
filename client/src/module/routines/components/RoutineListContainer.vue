<template>
  <div id="routine_list_container">
    <RoutineListContent :routines="routineList" />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>

<script>
import { mapGetters } from 'vuex';
import { getRoutines } from '../../../core/api/routine';
import RoutineListContent from './RoutineListContent.vue';

export default {
  name: '',
  components: { RoutineListContent },

  data() {
    return {
      routineList: null,
      // {
      //   routineNo: 1,
      //   routineTitle: '아침 운동',
      //   time: {
      //     repeatPeriod: 1, //직접입력, 0~30
      //     repeatUnit: 'day', //day, week, month 중 하나
      //     repeatDay: ['mon', 'tue'], //mon, tue, wed, thu, fri, sat, sun
      //     startHour: 17, // 루틴 시작 시간, 24시 기준
      //     startMin: 30, // 루틴 시작 분
      //   },
      // },
    };
  },
  created() {
    this.getRoutineList();
  },
  methods: {
    getRoutineList() {
      getRoutines(this.getMemberNo, this.getToken)
        .then((res) => (this.routineList = res.data))
        .catch((err) => [err]);
    },
  },
  watch: {
    routineList(data) {
      this.routineList = data;
    },
  },
  computed: {
    ...mapGetters(['getMemberNo', 'getToken']),
  },
};
</script>

<style scoped>
/* 가장 아래쪽 화면도 잘 볼 수 있도록 드립니다 */
#routine_list_container {
  margin-bottom: 10rem;
}
</style>
