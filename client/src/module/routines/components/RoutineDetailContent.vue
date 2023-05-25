<template>
  <div id="detail_content">
    <div id="detail_menu">
      <router-link to="/routines">
        <go-back-icon />
      </router-link>
    </div>

    <h1>
      {{ routine ? routine?.title : '죄송합니다.' }}
    </h1>
    <p id="detail_caption">
      {{
        routine?.time
          ? routine.time.repeatPeriod +
            routine.time.repeatUnit +
            '마다 ' +
            routine.time.repeatDay +
            '요일 ' +
            routine.time.startHour +
            '시 ' +
            routine.time.startMin +
            '분에 시작'
          : '정보를 가져오는 데 실패했어요.'
      }}
    </p>
    <div id="detail_content_detailWrapper">
      <div id="detail_content_exercise_list">
        <div id="detail_content_exercise_list_title">
          <h3>운동 목록</h3>
          <round-button
            :value="'+ ADD'"
            :theme="'highlight'"
            @handle-click="$emit('modal-toggle')"
          />
        </div>

        <div v-if="routine?.exerciseList.length > 0">
          <exercise-list
            v-for="(e, idx) in routine.exerciseList"
            :key="idx"
            :exercise="e"
          />
        </div>
        <div v-else>
          <p>운동 목록이 없어요.</p>
        </div>
      </div>
      <div id="delete">
        <square-button
          :value="'루틴 삭제하기'"
          @handle-click="$emit('delete-routine')"
        />
      </div>
    </div>
  </div>
</template>

<script>
import GoBackIcon from '../../common/icons/GoBackIcon.vue';
import ExerciseList from '../../common/ExerciseList.vue';
import RoundButton from '../../common/RoundButton.vue';
import SquareButton from '../../common/SquareButton.vue';
export default {
  name: 'RoutineDetailContent',
  components: { GoBackIcon, ExerciseList, RoundButton, SquareButton },
  props: {
    routine: Object,
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');

#detail_content {
  padding: 0 1.5rem 1rem 1.5rem;
}
#detail_menu {
  margin: 1.5rem 0 0.5rem 0;
}
#go_back_container {
  display: flex;
  align-items: center;
}
#logo {
  width: 2.5rem;
  height: 2.5rem;
}
#detail_caption {
  margin: 0 0 1rem 0;
}
#detail_content_detailWrapper {
  margin-top: 2rem;
}
#detail_content_exercise_list {
  margin-top: 2rem;
}
#detail_content_exercise_list_title {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 1rem;
}
#detail_content_exercise_list_title h3 {
  margin: 0;
}
</style>
