<template>
  <div id="routine_detail_container">
    <RoutineDetailContent />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>

<script>
import RoutineDetailContent from './RoutineDetailContent.vue';

export default {
  name: '',
  components: { RoutineDetailContent },
  created() {
    //axios
  },
};
</script>
