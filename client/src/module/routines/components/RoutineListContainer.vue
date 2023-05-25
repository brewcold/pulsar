<template>
  <div id="routine_list_container">
    <RoutineListContent
      :routines="routineList"
      @modal-toggle="modalToggle"
    />
    <ModalView
      v-if="displayModal"
      :modal-type="'routine'"
      :modal-title="'루틴 추가하기'"
      :modal-caption="'루틴을 추가합니다.'"
      @modal-routine-submit="addRoutine"
      @modal-toggle="modalToggle"
    />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>

<script>
import { mapGetters } from 'vuex';
import { getRoutines, postRoutine } from '../../../core/api/routine';
import RoutineListContent from './RoutineListContent.vue';
import ModalView from '../../../module/common/ModalView.vue';

export default {
  name: '',
  components: { RoutineListContent, ModalView },

  data() {
    return {
      displayModal: false,
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
      getRoutines(this.getMemberNo, this.$store.getters.getToken)
        .then((res) => (this.routineList = res.data))
        .catch((err) => [err]);
    },
    addRoutine(data) {
      postRoutine(data, this.$store.getters.getToken)
        .then((res) => this.getRoutineList())
        .catch((err) => console.log('실패'));
      return this.modalToggle();
    },
    modalToggle() {
      this.displayModal = !this.displayModal;
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
