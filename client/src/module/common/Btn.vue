<template>
  <button class="btn" :style="styles">
    {{ value }}
  </button>
</template>

<style scoped>
@import '../assets/root.css';

button {
}
</style>

<script>
export default {
  name: 'Btn',
  data() {
    return {
      value: String,
      color: String,
    };
  },
  computed: {
    styles() {
      return {
        color: this.color,
        value: this.value,
      };
    },
  },
};
</script>
