<template>
  <div id="tagform_container">
    <!--전체 태그를 불러올 때-->

    <div id="tagform_caption">
      <span v-if="caption?.length > 0" id="caption">{{ caption }}</span>
    </div>

    <div id="tagform">
      <div v-if="tags?.length > 0" id="tagform_list_container">
        <TagItem
          v-for="({ tagNo, tagName } = tag, idx) in tags"
          :key="idx"
          :tagNo="tagNo"
          :tagName="tagName"
          :selectable="selectable"
          @tag-click="selectTag"
        />
      </div>
      <!--선택된 태그를 불러올 때-->
      <div v-else id="tagform_list_container">
        <TagItem
          v-for="({ tagNo, tagName } = tag, i) in selectedTag"
          :key="i"
          :idx="i"
          :tagNo="tagNo"
          :tagName="tagName"
          v-model="selectedArr[i]"
          @tagClick="selectTag"
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
      selectable_selectedTag: [],

      selectedArr: new Array(this.tags.length).fill(false),
    };
  },
  methods: {
    selectTag(tagNo, tagName, selected, idx) {
      if (this.selectable) {
        if (selected) {
          if (this.plural) {
            //태그를 골랐을 때
            this.selectable_selectedTag = [
              ...this.selectable_selectedTag,
              {
                tagNo: tagNo,
                tagName: tagName,
              },
            ];
          } else {
            //지금 고른거 말고 다른 태그 선택 해제 되어야함
            // this.selectable_selectedTag.forEach((tag, i) => {
            //   //지금 올라온 Idx가 아니면 false, 올라왔으면 true
            //   if (idx === i) this.selectedArr[idx] = true;
            //   else this.selectedArr[idx] = false;
            // });
            this.selectable_selectedTag = [
              {
                tagNo: tagNo,
                tagName: tagName,
              },
            ];
          }
        }

        //태그를 다시 눌러 뺐을 때
        else {
          this.selectable_selectedTag =
            this.selectable_selectedTag.filter(
              (item, idx) => item.tagNo !== tagNo
            );
        }
      }
      this.$emit('tagform', this.selectable_selectedTag);
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
