<template>
  <div id="tagform_container">
    <!--전체 태그를 불러올 때-->

    <div id="tagform_caption">
      <span v-if="caption?.length > 0" id="caption">{{ caption }}</span>
    </div>

    <div id="tagform">
      <div v-if="tags?.length > 0" id="tagform_list_container">
        <TagItem
          v-for="{ tagNo, tagName } = tag in tags"
          :key="tagNo"
          :tagNo="tagNo"
          :tagName="tagName"
          :selectable="selectable"
          :selectable_selected="Boolean(selectedArr[tagNo])"
          @tag-click="selectTag"
        />
      </div>
      <!--선택된 태그를 불러올 때-->
      <div v-else id="tagform_list_container">
        <TagItem
          v-for="{ tagNo, tagName } = tag in selectedTag"
          :key="tagNo"
          :tagNo="tagNo"
          :tagName="tagName"
          @tag-click="selectTag"
        />
      </div>
    </div>
  </div>
</template>

<script>
import TagItem from './TagItem.vue';

export default {
  name: 'TagForm',
  props: {
    tags: Array,
    plural: Boolean,
    selectable: Boolean,
    selectedTag: Array,
    caption: String,
  },
  data() {
    return {
      selectableSelectedTag: [],
      selectedArr: [],
    };
  },
  methods: {
    selectTag(tagNo, tagName, selectable_selected) {
      if (this.selectable) {
        if (!this.plural) {
          //하나만 선택할 수 있을 때
          if (selectable_selected) {
            //태그를 골랐을 때
            this.selectableSelectedTag = [
              // ...this.selectableSelectedTag,
              {
                tagNo: tagNo,
                tagName: tagName,
              },
            ];
          }
          this.selectedArr = [];
          this.selectedArr[tagNo] = !this.selectedArr[tagNo];
        }
        this.$emit('tagform', this.selectableSelectedTag);
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
#tagform_caption {
  margin-bottom: 0.5rem;
}
#tagform {
  min-width: 100%;
  /* height: 4rem; */

  overflow-x: auto;
  overflow-y: hidden;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
  margin-bottom: 1rem;
}
#tagform::-webkit-scrollbar {
  display: none; /* Chrome, Safari, Opera*/
}
#tagform_list_container {
  width: 200%;
  display: flex;
}
#caption {
  color: var(--light-color-black);
  padding: 0.5rem 0 0.5rem 0;
}
</style>
