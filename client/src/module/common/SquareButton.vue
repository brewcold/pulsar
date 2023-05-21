<template>
  <div class="square_button_container">
    <button
      type="button"
      class="btn"
      :style="styles"
      @click="handleClick"
    >
      {{ value ? value : 'example' }}
    </button>
  </div>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

.square_button_container {
  width: 100%;
}

button {
  cursor: pointer;
  background-color: var(--color);
  padding: 0.75rem 1.25rem 0.75rem 1.25rem;
  border: var(--border);
  border-radius: 8px;
  color: var(--text);
  width: calc(100% - 3rem);
  margin-bottom: 1rem;
  font-size: 1rem;
  font-family: 'bd', sans-serif;
}

button:hover {
  opacity: 0.7;
}
</style>

<script>
export default {
  name: 'SquareButton',
  props: { theme: String, value: String },
  methods: {
    handleClick(event) {
      this.$emit('handle-click');
    },
  },
  computed: {
    styles() {
      if (this.theme === 'black') {
        return {
          '--color': '#333333',
          '--border': '1px solid #333333',
          '--text': 'white',
        };
      }
      if (this.theme === 'highlight') {
        return {
          '--color': '#ff8048',
          '--border': '1px solid #ff8048',
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
