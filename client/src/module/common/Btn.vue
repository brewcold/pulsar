<template>
  <button class="btn" :style="styles">
    {{ value }}
  </button>
</template>

<style scoped>
@import '../assets/root.css';

button {
  background-color: var(--color);
}
</style>

<script>
export default {
  name: 'Btn',
  props: { color: String, value: String },
  computed: {
    styles() {
      return {
        '--color': this.color,
      };
    },
  },
};
</script>
