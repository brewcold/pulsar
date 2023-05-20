<template>
  <div id="landing_wrapper">
    <view-container api-call="apiCall">
      <view-base title=""> </view-base>
    </view-container>
  </div>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
</style>

<script>
import ViewBase from '../common/ViewBase.vue';
import ViewContainer from '../common/ViewContainer.vue';

export default {
  name: '',
  components: { ViewContainer, ViewBase },
  data() {
    return {};
  },
  methods: {
    staticDataCall() {
      return Promise.all([]).then((res) => res.data);
    },
  },
};
</script>
