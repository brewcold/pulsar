<template>
  <div id="list_container" ref="listContainer">
    <CommunityListContent
      :articles="articleList"
      @modal-toggle="modalToggle"
    />
    <modal-view
      v-if="displayModal"
      :modal-type="'community'"
      :tags="tags"
      :modal-title="'글 작성하기'"
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
import { getTag } from '../../../core/api/tag';

export default {
  name: 'CommunityListContainer',
  components: { CommunityListContent, ModalView },

  data() {
    return {
      displayModal: false,
      articleList: null,
      tags: [],
      isLoading: false,
    };
  },
  created() {
    this.getArticles();
    this.getTagList();
  },
  mounted() {
    this.$refs.listContainer.addEventListener(
      'scroll',
      this.infiniteScroll
    );
  },
  beforeUnmount() {
    this.$refs.listContainer.removeEventListener(
      'scroll',
      this.infiniteScroll
    );
  },
  methods: {
    infiniteScroll() {
      const target = this.$refs.listContainer;
      console.log(
        target.scrollTop + target.clientHeight >= target.scrollHeight
      );
      if (
        target.scrollTop + target.clientHeight >= target.scrollHeight &&
        !this.isLoading
      ) {
        this.isLoading = true;
        getArticleList().then((res) => {
          console.log('한무스크롤 작동!');
          this.articleList = [...this.articleList, ...res.data];
          this.isLoading = false;
        });
      }
    },
    getTagList() {
      getTag().then((res) => (this.tags = res.data));
    },
    getArticles() {
      getArticleList()
        .then((res) => {
          return (this.articleList = res.data);
        })
        .catch((err) => [err]);
    },
    addArticles(data) {
      postArticle(data)
        .then((res) => {
          console.log('성공');
          this.modalToggle();
          this.getArticles();
        })
        .catch((err) => console.log('실패'));
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
  min-height: 100vh;
  margin-bottom: 10rem;
}
#list_container {
  height: 100vh;
  overflow-y: auto;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
#list_container::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Opera*/
}
</style>
