<template>
  <div id="modal_wrapper">
    <div id="modal_backdrop" />
    <div id="modal_container">
      <div>
        <h1 id="modal_title">{{ modalTitle }}</h1>
        <p id="modal_caption">{{ modalCaption }}</p>
        <div id="modal_contents_container">
          <div v-if="modalType === 'routine'">
            <form>
              <div class="modal_text_input_container">
                <span class="modal_text_input_label">매</span>
                <text-input
                  :input-type="'text'"
                  :margin="'1rem'"
                  v-model="time.repeatPeriod"
                />
              </div>
              <div>
                <p>반복 주기</p>
                <TagForm />
              </div>
              <div>
                <p>반복 단위</p>
                <TagForm />
              </div>
              <text-input
                :input-type="'text'"
                v-model="time.startHour"
              />
              시
              <text-input
                :input-type="'text'"
                :margin="'1rem'"
                v-model="time.startMin"
              />
              분에 시작
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
              <TagForm />
              <text-input :margin="'1rem'" />
              <text-input
                :input-type="'text'"
                v-model="repeat"
                :margin="'1rem'"
              />
              회 <text-input :input-type="'text'" v-model="minute" /> 분
              <square-button
                class="modal_btn"
                @handle-click="modalRoutineSubmit"
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
              v-model="community.body.content"
            />

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
  },
  data() {
    return {
      display: false,
      routineTitle: '',
      time: {
        repeatPeriod: '0',
        repeatUnit: '',
        repeatDay: [],
        startHour: '0',
        startMin: '0',
      },
      exerciseList: [],
      exercise: {
        routineNo: 0,
        exerciseName: '',
        count: 0,
        duration: 0,
      },
      community: {
        title: '',
        body: {
          content: '',
        },
        tagList: [],
        imgs: [],
      },
    };
  },
  methods: {
    modalRoutineSubmit() {
      const data = this.time;
      this.$emit('modal-routine-submit', data);
    },
    modalExerciseSubmit() {
      const data = null;
      this.$emit('modal-exercise-submit', data);
    },
    modalCommunitySubmit() {
      const data = null;
      this.$emit('modal-community-submit', data);
    },
    modalClose() {
      this.$emit('modal-toggle');
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
  padding: 1.25rem;
  width: 398px;
  box-shadow: 0px 0px 6px var(--light-color-black);
  z-index: 9;
}

#modal_contents_container div {
  width: 100%;
}
#alert_content {
  margin: 0;
}
.modal_btn {
  margin-top: 2rem;
  margin-bottom: 1rem;
}
</style>
