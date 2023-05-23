<template>
  <div id="routine_detail_container">
    <RoutineDetailContent :routine="routine" />
  </div>
</template>

<script>
import RoutineDetailContent from './RoutineDetailContent.vue';
import { getRoutineDetail } from '../../../core/api/routine';
import { mapGetters } from 'vuex';
export default {
  name: '',
  components: { RoutineDetailContent },
  created() {
    this.getRoutine();
  },
  data() {
    return {
      routine: null,
    };
  },
  methods: {
    getRoutine() {
      getRoutineDetail(
        this.$route.params.routineNo,
        this.getToken
      ).then((res) => (this.routine = res.data));
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
#routine_detail_container {
  margin-bottom: 10rem;
}
</style>
