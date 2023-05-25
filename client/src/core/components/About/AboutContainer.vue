<template>
  <div id="about_container">
    <!--show-content 이벤트가 발생하면 display메서드를 실행합니다-->
    <about-btn @show-content="display" />
    <!--
			show라는 Prop이 data의 show의 값(true)로 전달됩니다.
			여기서는 display메서드가 show의 값을 바꾸므로, prop으로 show가 잘 전달됩니다.
		-->
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
      //기본값은 false로, 보이지 않는 상태입니다.
      show: false,
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
