<template>
  <div id="detail_container">
    <RoutineDetailContent
      :routine="routine"
      @modal-toggle="modalToggle"
    />
    <ModalView
      v-if="displayModal"
      :modal-type="'routine-exercise'"
      :modal-title="'운동 추가하기'"
      :modal-caption="'운동을 추가합니다.'"
      :tags="exercise"
      @modal-exercise-submit="addExercise"
      @modal-toggle="modalToggle"
    />
  </div>
</template>

<script>
import RoutineDetailContent from './RoutineDetailContent.vue';
import ModalView from '../../common/ModalView.vue';
import {
  getRoutineDetail,
  putRoutine,
} from '../../../core/api/routine';
import { mapGetters } from 'vuex';
import { getExercise } from '../../../core/api/tag';
export default {
  name: 'RoutineDetailContainer',
  components: { RoutineDetailContent, ModalView },
  created() {
    this.getRoutine();
  },
  data() {
    return {
      routine: null,
      displayModal: false,
      exercise: null,
    };
  },
  methods: {
    getRoutine() {
      getRoutineDetail(
        this.$route.params.routineNo,
        this.getToken
      ).then((res) => (this.routine = res.data));
    },
    getExerciseTags() {
      getExercise().then((res) => {
        this.exercise = res.data;
      });
    },
    addExercise(exercise) {
      this.routine.exerciseList.push(exercise);
      putRoutine(this.$route.params.routineNo, this.routine).then(
        (res) => this.modalToggle()
      );
    },
    modalToggle() {
      this.displayModal = !this.displayModal;
      if (this.displayModal) this.getExerciseTags();
    },
  },
  watch: {
    routine(data) {
      this.routine = data;
    },
  },
  computed: {
    ...mapGetters(['getMemberNo', 'getToken']),
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
#detail_container {
  margin-bottom: 10rem;
}
</style>
