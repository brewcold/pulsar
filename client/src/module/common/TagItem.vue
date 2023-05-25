<template>
  <button
    type="button"
    class="tagItem"
    @click="handleClick"
    :style="styles"
  >
    {{ tagName ? tagName : 'sample' }}
  </button>
</template>

<script>
export default {
  name: 'TagItem',
  props: {
    selected: Array,
    selectable: Boolean,
    selectable_selected: Boolean,
    tagNo: Number,
    tagName: String,
    idx: Number,
  },
  methods: {
    handleClick(event) {
      this.$emit(
        'tag-click',
        this.tagNo,
        this.tagName,
        !this.selectable_selected,
        this.idx
      );
    },
  },
  computed: {
    styles() {
      //고를 수 없는 태그 (결과로만 보여야 하는 태그, 단순히 검색 링크로만 이동하는 역할을 함)
      if (!this.selectable) {
        return {
          '--color': '#ff8048',
          '--text-color': 'white',
          '--border': '1px solid #ff8048',
          '--cursor': 'default',
        };
      } else {
        //고를 수 있는 태그 (결과로 보이지 않고, 글 작성이나 회원가입 시 클릭했을 때 보여야 하는 태그)
        //그 중 아직 체크되지 않은 경우
        if (!this.selectable_selected) {
          return {
            '--color': 'white',
            '--text-color': '#333333',
            '--border': '1px solid #333333',
            '--cursor': 'pointer',
          };
        } else {
          //체크된 경우
          return {
            '--color': '#db3f28',
            '--text-color': 'white',
            '--border': '1px solid #db3f28',
            '--cursor': 'pointer',
          };
        }
      }
    },
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

button {
  cursor: var(--cursor);
  padding: 0.33rem 0.75rem 0.33rem 0.75rem;
  background: var(--color);
  border: var(--border);
  color: var(--text-color);
  border-radius: 1.5rem;
  margin-right: 0.25rem;
}
</style>
