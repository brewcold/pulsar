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
        :selected="selected()"
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
        :selected="selected"
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
  data() {
    return {
      selectable_selectedTag: [],
    };
  },
  methods: {
    selectTag(tagNo, tagName, selected) {
      if (!this.selectable) {
        if (selected)
          //태그를 골랐을 때
          this.selectable_selectedTag.push({
            tagNo: tagNo,
            tagName: tagName,
          });
        //태그를 다시 눌러 뺐을 때
        else
          this.selectable_selectedTag =
            this.selectable_selectedTag.filter(
              (item, idx) => item.tagNo !== tagNo
            );
      }
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
