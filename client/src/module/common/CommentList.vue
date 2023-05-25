<template>
  <div class="comment_list_container">
    <div v-if="comment" class="comment_list_item">
      <p id="writer">{{ comment.writerInfo.writerNickname }}</p>
      <p id="content">
        {{ comment.content ? comment.content : '' }}
      </p>
      <p id="created_at">
        {{ comment.createdAt ? comment.createdAt + '에 작성' : '' }}
      </p>
      <div
        v-if="
          this.$store.getters.getUserNo == comment.writerInfo.writerNo
        "
      >
        <round-button :value="'댓글 삭제'" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'commentList',
  props: {
    comment: Object,
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

.comment_list_container {
  border: 1px solid var(--light-color-lightgrey);
  border-radius: 8px;
  padding: 1rem;
  margin-top: 1rem;
}
h3 {
  color: var(--light-color-black);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 0.5rem;
}
#content {
  margin-top: 0.5rem;
  margin-bottom: 0.5rem;
}
#created_at {
  font-size: 0.85rem;
  color: var(--light-color-darkgrey);
}
</style>
