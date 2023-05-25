import TagForm from '../../module/common/TagForm.vue';

export default {
  /**
   * docs
   */
  title: 'common/TagForm',
  component: TagForm,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { TagForm },
    template: '<tag-form v-bind="$props" />',
  }),
};
export const Primary = {};
