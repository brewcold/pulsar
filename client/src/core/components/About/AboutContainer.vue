<template>
  <div id="about_container">
    <about-btn @show-content="display" />
    <about-content :show="show" />
  </div>
</template>

<script>
import AboutBtn from '../About/AboutBtn.vue';
import AboutContent from '../About/AboutContent.vue';

export default {
  name: 'AboutContainer',
  components: {
    AboutBtn,
    AboutContent,
  },
  data() {
    return {
      show: true,
    };
  },
  methods: {
    display() {
      this.show = !this.show;
    },
  },
};
</script>

<style scoped>
@import url('@/assets/css/init.css');
@import url('@/assets/css/root.css');
@import url('@/assets/css/typography.css');
</style>
