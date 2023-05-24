<template>
  <div id="detail_container">
    <community-detail-content
      :routine="routine"
      @modal-toggle="modalToggle"
    />
    <modal-view
      v-if="displayModal"
      :modal-type="'community'"
      :modal-title="'글 수정하기'"
      :modal-caption="'작성한 글을 수정합니다.'"
      @modal-exercise-submit="updateArticle"
      @modal-toggle="modalToggle"
    />
  </div>
</template>

<script>
import CommunityDetailContent from './CommunityDetailContent.vue';
import ModalView from '../../common/ModalView.vue';
import { getRoutineDetail } from '../../../core/api/routine';
import { mapGetters } from 'vuex';
export default {
  name: 'CommunityDetailContainer',
  components: { CommunityDetailContent, ModalView },
  created() {
    this.getRoutine();
  },
  data() {
    return {
      routine: null,
      displayModal: false,
    };
  },
  methods: {
    getRoutine() {
      getRoutineDetail(
        this.$route.params.routineNo,
        this.getToken
      ).then((res) => (this.routine = res.data));
    },
    addExercise() {},
    modalToggle() {
      this.displayModal = !this.displayModal;
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
