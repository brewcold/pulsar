import ModalView from '/src/module/common/ModalView.vue';

export default {
  /**
   * DOCS
   */
  title: 'common/ModalView (원형 버튼)',
  component: ModalView,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { ModalView },
    template: '<modal-view @onClick="handleClick" v-bind="$props" />',
  }),
};
export const Primary = {};
