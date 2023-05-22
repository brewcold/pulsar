import TagItem from '../../module/common/TagItem.vue';

export default {
  /**
   * DOCS
   */
  title: 'common/Tag (태그)',
  component: TagItem,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { TagItem },
    template: '<tag-item @onClick="handleClick" v-bind="$props" />',
  }),
};
export const Primary = {};
