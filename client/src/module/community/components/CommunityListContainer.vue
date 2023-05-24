<template>
  <div id="list_container">
    <CommunityListContent
      :articles="articleList"
      @modal-toggle="modalToggle"
    />
    <modal-view
      v-if="displayModal"
      :modal-type="'community'"
      :modal-title="'글쓰기'"
      :modal-caption="'게시판에 글을 작성합니다.'"
      @modal-community-submit="addArticles"
      @modal-toggle="modalToggle"
    />
  </div>
</template>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');
</style>

<script>
import { mapGetters } from 'vuex';
import CommunityListContent from './CommunityListContent.vue';
import ModalView from '../../../module/common/ModalView.vue';
import {
  getArticleList,
  postArticle,
} from '../../../core/api/community';

export default {
  name: 'CommunityListContainer',
  components: { CommunityListContent, ModalView },

  data() {
    return {
      displayModal: false,
      articleList: null,
      // {
      //   routineNo: 1,
      //   routineTitle: '아침 운동',
      //   time: {
      //     repeatPeriod: 1, //직접입력, 0~30
      //     repeatUnit: 'day', //day, week, month 중 하나
      //     repeatDay: ['mon', 'tue'], //mon, tue, wed, thu, fri, sat, sun
      //     startHour: 17, // 루틴 시작 시간, 24시 기준
      //     startMin: 30, // 루틴 시작 분
      //   },
      // },
    };
  },
  created() {
    this.getArticles();
  },
  methods: {
    getArticles() {
      getArticleList()
        .then((res) => {
          return (this.articleList = res.data);
        })
        .catch((err) => [err]);
    },
    addArticles(data) {
      postArticle(data, this.$store.getters.getToken)
        .then((res) => console.log('성공'))
        .catch((err) => console.log('실패'));
      this.getArticles();
      return modalToggle();
    },
    modalToggle() {
      this.displayModal = !this.displayModal;
    },
  },
  watch: {
    articleList(data) {
      this.articleList = data;
    },
  },
  computed: {
    ...mapGetters(['getMemberNo', 'getToken']),
  },
};
</script>

<style scoped>
/* 가장 아래쪽 화면도 잘 볼 수 있도록 드립니다 */
#list_container {
  margin-bottom: 10rem;
}
</style>
