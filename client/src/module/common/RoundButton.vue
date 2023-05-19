<template>
  <button
    type="button"
    class="btn"
    :style="styles"
    @click="handleClick"
  >
    {{ value ? value : 'example' }}
  </button>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

button {
  cursor: pointer;
  background-color: var(--color);
  padding: 0.5rem 0.75rem 0.5rem 0.75rem;
  border: var(--border);
  border-radius: 1.5rem;
  color: var(--text);
}

button:hover {
  opacity: 0.7;
}
</style>

<script>
export default {
  name: 'RoundButton',
  props: { theme: String, value: String, callback: Function },
  methods: {
    handleClick(event) {
      callback(event);
      this.$emit('handle-click');
    },
  },
  computed: {
    styles() {
      if (this.theme === 'black') {
        return {
          '--color': '#333333',
          '--border': 'none',
          '--text': 'white',
        };
      }
      if (this.theme === 'highlight') {
        return {
          '--color': '#eca23c',
          '--border': 'none',
          '--text': 'white',
        };
      } else
        return {
          '--color': 'white',
          '--border': '1px solid #333333',
          '--text': '#333333',
        };
    },
  },
};
</script>
