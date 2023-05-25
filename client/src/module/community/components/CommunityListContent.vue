<template>
  <div id="list_content">
    <div id="logo_container">
      <img id="logo" src="../../../assets/images/logo.svg" alt="logo" />
    </div>

    <h1>COMMUNITY</h1>
    <p id="list_caption">소통할 수 있는 공간이에요.</p>

    <square-button
      :value="'글 작성'"
      :theme="'point'"
      @handle-click="$emit('modal-toggle')"
    />

    <div id="list_content_listWrapper">
      <div v-if="articles?.length > 0">
        <CommunityList
          v-for="{
            articleNo,
            writerNickname,
            title,
            createdAt,
            viewCnt,
            recommendCnt,
            articleTag,
          } = article in articles"
          :key="articleNo"
          :articleNo="articleNo"
          :title="title"
          :viewCnt="viewCnt"
          :writerNickname="writerNickname"
          :createdAt="createdAt"
          :recommendCnt="recommendCnt"
          :articleTag="articleTag"
        />
      </div>

      <div v-else>
        <p id="no_contents">게시글이 없어요.</p>
      </div>
    </div>
  </div>
</template>

<script>
import SquareButton from '../../../module/common/SquareButton.vue';
import CommunityList from '../../../module/common/CommunityList.vue';

export default {
  name: 'CommunityListContent',
  components: { CommunityList, SquareButton },
  props: {
    articles: Array,
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
  height: 2.25rem;
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
