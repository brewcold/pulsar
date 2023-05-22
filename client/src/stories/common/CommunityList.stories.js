import CommunityList from '../../module/common/CommunityList.vue';

export default {
  /**
   * DOCS
   */
  title: 'common/CommunityList (게시판 리스트)',
  component: CommunityList,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { CommunityList },
    template: '<community-list v-bind="$props" />',
  }),
};
export const Primary = {};
