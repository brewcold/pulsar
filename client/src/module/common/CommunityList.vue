<template>
  <div class="community_list_item">
    <h3>
      <router-link to="{ '/community/'+ articleNo }">
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
        {{ recommendCnt ? recommendCnt + ' Likes / ' : '---' }}</span
      >
      <span class="community_list_item_viewCnt">
        {{ viewCnt ? viewCnt + ' Views' : '---' }}
      </span>
    </p>
    <div class="community_list_item_tags">
      <router-link
        v-for="({ tagNo, tagName } = tag, idx) in articleTag"
        :key="idx"
      >
        <tag-item
          :tagNo="tagNo"
          :tagName="tagName"
          :selectable="false"
          :selected="true"
        />
      </router-link>
    </div>
  </div>
</template>

<script>
import TagItem from './TagItem.vue';
export default {
  name: 'CommunityList',
  components: { TagItem },
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
  border: 1px solid var(--light-color-lightgrey);
  border-radius: 8px;
  padding: 1rem;
}
h3 {
  color: var(--light-color-black);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.community_list_item p {
  margin-top: 0.25rem;
}
.community_list_item_writerNickname,
.community_list_item_createdAt,
.community_list_item_viewCnt,
.community_list_item_recommendCnt {
  font-size: 0.85rem;
  color: var(--light-color-darkgrey);
}
.community_list_item_tags {
  margin-top: 0.5rem;
}
</style>
