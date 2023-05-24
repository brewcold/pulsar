<template>
  <div id="tagform">
    <!--전체 태그를 불러올 때-->
    <span v-if="caption?.length > 0" id="caption">{{ caption }}</span>
    <div v-if="tags?.length > 0" id="tagform_list_container">
      <TagItem
        v-for="({ tagNo, tagName } = tag, idx) in tags"
        :key="idx"
        :tagNo="tagNo"
        :tagName="tagName"
        :selectable="selectable"
        :selected="selectedTag"
        @handle-click="selectTag"
      />
    </div>
    <!--선택된 태그를 불러올 때-->
    <div v-else id="tagform_list_container">
      <TagItem
        v-for="({ tagNo, tagName } = tag, idx) in selectedTag"
        :key="idx"
        :tagNo="tagNo"
        :tagName="tagName"
        :selectedTag="selectedTag"
        @handle-click="selectTag"
      />
    </div>
  </div>
</template>

<script>
import TagItem from './TagItem.vue';

export default {
  name: 'TagForm',
  props: {
    tags: Array,
    selectable: Boolean,
    selectedTag: Array,
    caption: String,
  },
  methods: {
    selectTag() {
      if (!this.selectable)
        return;
        //prop의 selected를 true로 만들어줘야함...
      else;
    },
  },
  components: { TagItem },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

#tagform {
  min-width: calc(100% - 2rem);
  /* height: 4rem; */
  display: flex;
  align-items: flex-start;
  overflow-x: auto;
  overflow-y: hidden;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}
#tagform::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Opera*/
}
#tagform_list_container {
  display: flex;
}
#caption {
  color: var(--light-color-black);
  padding: 0.5rem 0 0.5rem 0;
}
</style>
