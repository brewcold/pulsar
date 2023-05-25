<template>
  <div id="modal_wrapper">
    <div id="modal_backdrop" />
    <div id="modal_container">
      <div>
        <h1 id="modal_title">{{ modalTitle }}</h1>
        <p id="modal_caption"></p>
        <div id="modal_contents_container">
          <div v-if="modalType === 'routine'">
            <form>
              <h3>루틴 이름</h3>
              <text-input
                :input-type="'text'"
                :margin="'1rem'"
                v-model="routineTitle"
                @input="setRoutineTitle"
              />
              <div class="input_repeat">
                <h3>반복 주기</h3>
                <div class="input_unit_item">
                  <text-input
                    :input-type="'text'"
                    :margin="'0.5rem'"
                    v-model="time.repeatPeriod"
                    @input="setRepeatPeriod"
                  />
                  <p></p>
                  <TagForm
                    v-model="time.repeatUnit"
                    :selectable="true"
                    :tags="[
                      { tagNo: 1, tagName: '주' },
                      // { tagNo: 2, tagName: '주' },
                    ]"
                    :plural="false"
                    @tagform="setRepeatUnit"
                  />
                </div>
                <div v-if="time.repeatUnit !== '일'">
                  <TagForm
                    v-model="time.repeatDay"
                    :selectable="true"
                    :tags="[
                      { tagNo: 1, tagName: '일' },
                      { tagNo: 2, tagName: '월' },
                      { tagNo: 3, tagName: '화' },
                      { tagNo: 4, tagName: '수' },
                      { tagNo: 5, tagName: '목' },
                      { tagNo: 6, tagName: '금' },
                      { tagNo: 7, tagName: '토' },
                    ]"
                    :plural="false"
                    @tagform="setRepeatDay"
                  />
                </div>
              </div>
              <h3>시작 시간</h3>
              <div class="input_unit">
                <div class="input_unit_item">
                  <text-input
                    :input-type="'text'"
                    v-model="time.startHour"
                  />
                  <p>시</p>
                </div>
                <div class="input_unit_item">
                  <text-input
                    :input-type="'text'"
                    v-model="time.startMin"
                  />
                  <p>분</p>
                </div>
              </div>
              <square-button
                class="modal_btn"
                @handle-click="modalRoutineSubmit"
                :theme="'point'"
                :value="'루틴 추가하기'"
              />
              <square-button
                @handle-click="modalClose"
                :value="'취소하기'"
              />
            </form>
          </div>
          <div v-if="modalType === 'routine-exercise'">
            <form>
              <tag-form
                v-model="exercise.exerciseName"
                :selectable="true"
                :tags="tags"
                :caption="'추가할 운동을 선택하세요.'"
                :plural="false"
                @tagform="setExercise"
              />
              <div class="input_unit">
                <div class="input_unit_item">
                  <text-input
                    :input-type="'text'"
                    v-model="exercise.count"
                  />
                  <p>회</p>
                </div>
                <div class="input_unit_item">
                  <text-input
                    :input-type="'text'"
                    v-model="exercise.duration"
                  />
                  <p>분</p>
                </div>
              </div>

              <square-button
                class="modal_btn"
                @handle-click="modalExerciseSubmit"
                :theme="'point'"
                :value="'운동 추가하기'"
              />
              <square-button
                @handle-click="modalClose"
                :value="'취소하기'"
              />
            </form>
          </div>
          <div v-if="modalType === 'community'">
            <text-input
              :input-type="'text'"
              :margin="'1rem'"
              :placeholder="'제목'"
              v-model="community.title"
            />
            <text-input
              :input-type="'textarea'"
              :placeholder="'내용'"
              :height="'13rem'"
              v-model="community.body.content"
            />
            <div id="tagFormContainer">
              <tag-form
                v-model="community.tagList"
                :selectable="true"
                :tags="tags"
                :caption="'글의 주제를 선택하세요.'"
                :plural="false"
                @tagform="setTagList"
              />
            </div>
            <square-button
              class="modal_btn"
              @handle-click="modalCommunitySubmit"
              :theme="'point'"
              :value="'글 작성하기'"
            />
            <square-button
              @handle-click="modalClose"
              :value="'취소하기'"
            />
          </div>
          <div v-if="modalType === 'alert'">
            <square-button
              @handle-click="modalClose"
              class="modal_btn"
              :theme="'black'"
              :value="'확인'"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SquareButton from './SquareButton.vue';
import TagForm from './TagForm.vue';
import TextInput from './TextInput.vue';

export default {
  name: 'ModalView',
  components: { TextInput, TagForm, SquareButton },
  props: {
    modalTitle: String,
    modalType: String,
    modalCaption: String,
    tags: Array,
  },
  data() {
    return {
      display: false,
      routineTitle: '',
      time: {
        repeatPeriod: '1',
        repeatUnit: '',
        repeatDay: [],
        startHour: '0',
        startMin: '0',
      },
      exercise: {
        exerciseNo: '',
        exerciseName: '',
        count: '0',
        duration: '0',
      },
      community: {
        title: '',
        body: {
          content: '',
        },
        tagList: [],
      },
    };
  },
  methods: {
    modalRoutineSubmit() {
      const data = { routineTitle: this.routineTitle, time: this.time };
      this.$emit('modal-routine-submit', data);
    },
    modalExerciseSubmit() {
      const data = {
        exerciseNo: Number(this.exercise.exerciseNo),
        exerciseName: this.exercise.exerciseName,
        count: Number(this.exercise.count),
        duration: Number(this.exercise.duration),
      };
      this.$emit('modal-exercise-submit', data);
    },
    modalCommunitySubmit() {
      const data = this.community;
      this.$emit('modal-community-submit', data);
    },
    setExercise(data) {
      this.exercise.exerciseNo = Number(data[0].tagNo);
      this.exercise.exerciseName = data[0].tagName;
    },
    modalClose() {
      this.$emit('modal-toggle');
    },
    setRoutineTitle(data) {
      this.routineTitle = data;
    },
    setRepeatUnit(data) {
      this.time.repeatUnit = data[0].tagName;
    },
    setRepeatPeriod(data) {
      this.time.repeatPeriod = data;
    },
    setRepeatDay(data) {
      this.time.repeatDay.push(data[0].tagName);
    },
    setTagList(data) {
      this.community.tagList.push(data[0]);
    },
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

#modal_wrapper {
  width: 430px;
  height: 100vh;
}
#modal_backdrop {
  position: fixed;
  left: 0;
  top: 0;
  width: 430px;
  height: 100vh;
  background-color: black;
  opacity: 0.7;
  z-index: 1;
}
#modal_caption {
  margin: 1rem 0 2rem 0;
}
#modal_container {
  position: fixed;
  top: 3rem;
  left: 1rem;
  background-color: white;
  border-radius: 8px;
  padding: 2rem;
  width: 398px;
  box-shadow: 0px 0px 6px var(--light-color-black);
  z-index: 9;
}
#tagFormContainer {
  margin-top: 1rem;
}
.input_repeat {
  margin-bottom: 1rem;
}
.input_unit {
  display: flex;
}
.input_unit p {
  margin-left: 0.5rem;
  margin-right: 2rem;
}
.input_unit_item {
  display: flex;
  align-items: center;
}
#modal_contents_container div {
  width: 100%;
}
#alert_content {
  margin: 0;
}
.modal_btn {
  margin-top: 0.5rem;
  margin-bottom: 1rem;
}
</style>
