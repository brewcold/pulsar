<template>
  <div id="detail_content">
    <div id="detail_menu">
      <router-link to="/community">
        <go-back-icon />
      </router-link>
    </div>

    <h1>COMMUNITY</h1>
    <div id="detail_content_container">
      <h3>
        {{ article ? article?.title : '죄송합니다.' }}
      </h3>
      <span>
        {{ article?.writerInfo.writerNickname }}님이
        {{ article?.createdAt }}에 작성
      </span>
      <p id="content">
        {{
          article
            ? article.body.content
            : '서버로부터 정보를 가져오지 못했어요.'
        }}
      </p>
    </div>
    <div id="detail_content_detailWrapper">
      <div id="detail_content_comment_list">
        <div id="detail_content_comment_list_title">
          <h3>댓글</h3>

          <div id="detail_content_comment_list_input">
            <text-input
              :input-type="'textarea'"
              :placeholder="'댓글을 입력하세요.'"
              @handle-input="handleInput"
              :margin="'1rem'"
              :height="'5rem'"
            />
            <square-button
              :value="'댓글 작성'"
              :theme="'point'"
              @keyup.enter="$emit('comment')"
              @handle-click="$emit('comment')"
            />
          </div>
          <div id="detail_content_comment_list">
            <div v-if="commentList?.length > 0">
              <comment-list
                v-for="(c, idx) in commentList"
                :key="idx"
                :comment="c"
              />
            </div>
            <div v-else>
              <p>아직 댓글이 없어요.</p>
            </div>
          </div>
        </div>
        <div id="delete">
          <square-button
            :value="'글 삭제하기'"
            @handle-click="$emit('delete-article')"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GoBackIcon from '../../common/icons/GoBackIcon.vue';
import CommentList from '../../common/CommentList.vue';
import SquareButton from '../../common/SquareButton.vue';
import TextInput from '../../common/TextInput.vue';
export default {
  name: '',
  components: {
    GoBackIcon,
    CommentList,
    TextInput,
    SquareButton,
  },
  props: {
    article: Object,
    commentList: Array,
  },
  methods: {
    handleInput(data) {
      this.$emit('handle-input', data);
    },
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
#detail_content_container {
  border: 1px solid var(--light-color-lightgrey);
  padding: 1rem;
  border-radius: 8px;
}
h3 {
  margin-bottom: 0.5rem;
}
span {
  font-size: 0.8rem;
  color: var(--light-color-darkgrey);
}
p {
  margin: 0;
}
#content {
  margin-top: 0.5rem;
  border-radius: 8px;
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
#delete {
  margin-top: 1rem;
}
</style>
