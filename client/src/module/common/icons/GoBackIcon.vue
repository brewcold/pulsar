<template>
  <div :style="styles">
    <svg
      xmlns="http://www.w3.org/2000/svg"
      height="48"
      viewBox="0 -960 960 960"
      width="48"
      class="item"
    >
      <path d="M655-80 255-480l400-400 56 57-343 343 343 343-56 57Z" />
    </svg>
  </div>
</template>

<style scoped>
div {
  display: inline;
}
.item {
  width: 2.25rem;
  height: 2.25rem;
  fill: var(--light-color-black);
  cursor: pointer;
}
.item:hover {
  opacity: 0.75;
}
</style>

<script>
export default {
  name: '',
  components: {},
  computed: {
    styles() {
      return {
        '--active': this.active ? '#666666' : '#cccccc',
      };
    },
    active() {
      return this.$route.path.includes('community');
    },
  },
};
</script>
