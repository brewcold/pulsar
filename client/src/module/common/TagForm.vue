<template>
  <div class="tagform" :style="styles">
    <!--전체 태그를 불러올 때-->
    <div v-if="tags.length > 0">
      <TagItem
        v-for="({ tagNo, tagName } = tag, idx) in tags"
        :key="idx"
        :tagNo="tagNo"
        :tagName="tagName"
        :selectable="selectable"
        :selectedTag="selectedTag"
      />
    </div>
    <!--선택된 태그를 불러올 때-->
    <div v-else>
      <TagItem
        v-for="({ tagNo, tagName } = tag, idx) in selectedTag"
        :key="idx"
        :tagNo="tagNo"
        :tagName="tagName"
        :selectable="selectable"
        :selectedTag="selectedTag"
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
  },

  components: { TagItem },
  computed: {
    isValid() {
      const regex =
        /^(?=.*[a-z])(?=.*\d)(?=.*[@$!%*#?&])[a-z\d@$!%*#?&]{8,}$/i;
      return regex.test(this.value);
    },
    styles() {
      return {
        '--margin': this.margin,
        '--display': this.caption ? 'block' : 'none',
        '--caption-color':
          //중첩 삼항연산자입니다. inputType이 password이고 비밀번호가 valid하다면...
          this.inputType === 'password'
            ? this.isValid
              ? '#09DF78'
              : '#DF093D'
            : '#666666',
      };
    },
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
.text_input_container {
  margin-bottom: var(--margin);
}
input[type='text'],
input[type='email'],
input[type='password'] {
  padding: 0.75rem;
  border: 1px solid var(--light-color-black);
  border-radius: 6px;
  outline: none;
  font-size: 0.9rem;
  width: calc(100% - 2rem);
}

input::placeholder {
  color: var(--light-color-grey);
}
.caption {
  color: var(--caption-color);
  text-align: right;
  font-size: 0.85rem;
  padding: 0.5rem 0 0.5rem 0;
  display: var(--display);
}
</style>
