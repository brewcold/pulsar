<template>
  <div id="list_content">
    <div id="logo_container">
      <img id="logo" src="../../../assets/images/logo.svg" alt="logo" />
    </div>

    <h1>ROUTINES</h1>
    <p id="list_caption">내 운동 루틴이에요.</p>

    <square-button
      :value="'새 루틴 만들기'"
      :theme="'black'"
      @handle-click="$emit('modal-toggle')"
    />

    <div id="list_content_listWrapper">
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
        <p id="no_contents">아직 루틴이 없어요.</p>
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

#list_content {
  padding: 2rem;
  width: 430px;
}
#logo_container {
  margin: 1.5rem 0 0.25rem 0;
}
#logo {
  width: 2.25rem;
  height: 2.5rem;
}
#btn_container {
  width: 100%;
}
#list_caption {
  margin: 0 0 1rem 0;
}
#no_contents {
  color: var(--light-color-grey);
  text-align: center;
}
#list_content_listWrapper {
  margin-top: 2rem;
}
</style>
