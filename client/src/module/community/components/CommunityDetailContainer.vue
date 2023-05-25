<template>
  <div id="detail_container">
    <community-detail-content
      :article="article"
      :comment-list="commentList"
      @modal-toggle="modalToggle"
      @handle-input="handleInput"
      @comment="comment"
      @delete-article="removeArticle"
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
import { mapGetters } from 'vuex';
import {
  getArticleDetail,
  getArticleComment,
  postArticleComment,
  deleteArticle,
} from '../../../core/api/community';
export default {
  name: 'CommunityDetailContainer',
  components: { CommunityDetailContent, ModalView },
  created() {
    this.getArticle();
    this.getComments();
  },
  data() {
    return {
      article: null,
      commentList: null,
      displayModal: false,
      commentContent: null,
    };
  },
  methods: {
    getArticle() {
      getArticleDetail(this.$route.params.articleNo)
        .then((res) => (this.article = res.data))
        .catch((err) => console.log(err));
    },
    getComments() {
      getArticleComment(this.$route.params.articleNo)
        .then((res) => (this.commentList = res.data))
        .catch((err) => console.log(err));
    },
    comment() {
      postArticleComment(this.$route.params.articleNo, {
        comment: this.commentContent,
      })
        .then((res) => (this.commentList = res.data))
        .catch((err) => console.log(err));
    },
    removeArticle() {
      deleteArticle(this.$route.params.articleNo);
    },
    handleInput(data) {
      this.commentContent = data;
    },
    modalToggle() {
      this.displayModal = !this.displayModal;
    },
  },
  watch: {
    article(data) {
      this.article = data;
    },
    commentList(data) {
      this.commentList = data;
    },
  },
  computed: {
    ...mapGetters(['getMemberNo']),
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
