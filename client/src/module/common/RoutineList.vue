<template>
  <div class="routine_list_item">
    <h3>
      <router-link :to="'/routines/' + routineNo">
        {{ routineTitle || '정보를 가져오는 데 실패했어요.' }}
      </router-link>
    </h3>
    <p class="routine_list_item_meta">
      <span>
        {{
          time
            ? time.repeatPeriod +
              time.repeatUnit +
              '마다 ' +
              time.repeatDay +
              '요일 ' +
              time.startHour +
              '시 ' +
              time.startMin +
              '분에 시작'
            : '정보를 가져오는 데 실패했어요.'
        }}
      </span>
    </p>
    <div v-if="exerciseList?.length">
      <ul class="routine_list_item_exerciseList">
        <li
          class="routine_list_item_exerciseList_item"
          v-for="(
            { exerciseName, count, duration } = exercise, idx
          ) in exerciseList"
          :key="idx"
        >
          {{ exerciseName ? exerciseName : ' --- ' }}
          {{ count ? count + '회' : '' }}
          {{ duration ? duration + '분' : '' }}
        </li>
      </ul>
    </div>
    <div v-else>
      <ul class="routine_list_item_exerciseList">
        <li class="routine_list_item_exerciseList_item">
          등록한 운동이 없어요.
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RoutineList',
  props: {
    routineNo: Number,
    routineTitle: String,
    time: Object,
    //     {
    //   "repeatPeriod": 3,
    //   "repeatUnit": "주",
    //   "repeatDay": "월",
    //   "startHour": 13,
    //   "startMin": 30
    // }
    exerciseList: Array,
    //     [
    //   {
    //     "exerciseNo": 3,
    //     "order": 1,
    //     "exerciseName": "얏호",
    //     "count": 5,
    //     "duration": null
    //   },
    //   {
    //     "exerciseNo": 2,
    //     "order": 1,
    //     "exerciseName": "끼얏호",
    //     "count": 7,
    //     "duration": null
    //   },
    //   {
    //     "exerciseNo": 2,
    //     "order": 1,
    //     "exerciseName": "끼이얏호",
    //     "count": null,
    //     "duration": 30
    //   }
    // ]
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

.routine_list_item {
  border: 1px solid var(--light-color-lightgrey);
  border-radius: 8px;
  padding: 1rem;
  margin-bottom: 1rem;
}
h3 {
  color: var(--light-color-black);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 0.5rem;
}
.routine_list_item_meta {
  font-size: 0.9rem;
  color: var(--light-color-darkgrey);
}
.routine_list_item_exerciseList {
  margin-top: 0.5rem;
  margin-left: 1.5rem;
}
.routine_list_item_exerciseList_item {
  font-size: 0.8rem;
  margin-top: 0.25rem;
  color: var(--light-color-darkgrey);
  list-style-type: disc;
}
</style>
