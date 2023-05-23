<template>
  <div id="routine_detail_content">
    <div id="routine_detail_menu">
      <router-link to="/routines">
        <go-back-icon />
      </router-link>
    </div>

    <h1>
      {{ routine ? routine?.title : '죄송합니다.' }}
    </h1>
    <p id="routine_detail_caption">
      {{
        routine
          ? '내 운동 루틴 목록이에요.'
          : '서버로부터 정보를 가져오지 못했어요.'
      }}
    </p>
    <div id="routine_detail_content_detailWrapper"></div>
  </div>
</template>

<script>
import GoBackIcon from '../../common/icons/GoBackIcon.vue';
export default {
  name: '',
  components: { GoBackIcon },
  props: {
    routine: Object,
  },
};
</script>

<style scoped>
@import url('../../../assets/css/init.css');
@import url('../../../assets/css/root.css');
@import url('../../../assets/css/typography.css');

#routine_detail_content {
  padding: 0 1.5rem 1rem 1.5rem;
}
#routine_detail_menu {
  margin: 1.5rem 0 0.5rem 0;
}
#go_back_container {
  display: flex;
  align-items: center;
}
#logo {
  width: 2.5rem;
  height: 2.5rem;
}
#routine_detail_caption {
  margin: 0 0 1rem 0;
}
#routine_detail_content_detailWrapper {
  margin-top: 2rem;
}
</style>
