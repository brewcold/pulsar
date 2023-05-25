<template>
  <div class="community_list_item">
    <h3>
      <router-link :to="'/community/' + articleNo">
        {{ title || '정보를 가져오는 데 실패했어요.' }}
      </router-link>
    </h3>
    <p class="community_list_item_writerNickname">
      {{ writerNickname ? 'by ' + writerNickname : '---' }}
      <span class="community_list_item_createdAt"
        >{{ createdAt ? 'at ' + createdAt : '---' }}
      </span>
    </p>
    <p>
      <span class="community_list_item_recommendCnt">
        {{ recommendCnt ? recommendCnt : '0' }} Likes</span
      >
      <span class="community_list_item_viewCnt">
        / {{ viewCnt ? viewCnt : '0' }} Views
      </span>
    </p>
    <div class="community_list_item_tags">
      <tag-form :selected-tag="articleTag" />
    </div>
  </div>
</template>

<script>
import TagForm from './TagForm.vue';
export default {
  name: 'CommunityList',
  components: { TagForm },
  props: {
    articleNo: Number,
    writerNickname: String,
    title: String,
    createdAt: String,
    viewCnt: Number,
    recommendCnt: Number,
    articleTag: Array,
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

.community_list_item {
  border: 1px solid var(--light-color-grey);
  border-radius: 8px;
  padding: 1rem 1rem 0 1rem;
  margin-bottom: 1rem;
}
h3 {
  color: var(--light-color-black);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 0.5rem;
}
.community_list_item p {
  margin-left: 0;
}
.community_list_item_writerNickname,
.community_list_item_createdAt,
.community_list_item_viewCnt,
.community_list_item_recommendCnt {
  font-size: 0.85rem;
  line-height: 1;
  color: var(--light-color-grey);
}
.community_list_item_recommendCnt {
  color: var(--light-color-point);
}
</style>
