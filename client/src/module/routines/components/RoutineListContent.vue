<template>
  <div id="routine_list_content">
    <div id="logo_container">
      <img id="logo" src="../../../assets/images/logo.svg" alt="logo" />
    </div>

    <h1>ROUTINES</h1>
    <p id="routine_list_caption">내 운동 루틴이에요.</p>
    <router-link to="/routines/write">
      <square-button :value="'새 루틴 만들기'" />
    </router-link>
    <div id="routine_list_content_listWrapper">
      <div v-if="routines?.length > 0">
        <RoutineList
          v-for="(
            { routineNo, routineTitle, time, exerciseList } = routine,
            idx
          ) in routines"
          :key="idx"
          :routineNo="routineNo"
          :routineTitle="routineTitle"
          :time="time"
          :exerciseList="exerciseList"
        />
      </div>
      <div v-else>
        <p id="no_routines">아직 루틴이 없어요.</p>
      </div>
    </div>
  </div>
</template>

<script>
import SquareButton from '../../../module/common/SquareButton.vue';
import RoutineList from '../../../module/common/RoutineList.vue';

export default {
  name: '',
  components: { RoutineList, SquareButton },
  props: {
    routines: Array,
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');

#routine_list_content {
  padding: 0 1.5rem 1rem 1.5rem;
}
#logo_container {
  margin: 1.5rem 0 0.25rem 0;
}
#logo {
  width: 2.25rem;
  height: 2.5rem;
}
#routine_list_caption {
  margin: 0 0 1rem 0;
}
#no_routines {
  color: var(--light-color-grey);
  text-align: center;
}
#routine_list_content_listWrapper {
  margin-top: 2rem;
}
</style>
