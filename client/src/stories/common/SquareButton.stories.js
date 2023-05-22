import SquareButton from '../../module/common/SquareButton.vue';

export default {
  /**
   * DOCS
   */
  title: 'common/SquareButton (사각형 버튼)',
  component: SquareButton,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { SquareButton },
    template:
      '<square-button @onClick="handleClick" v-bind="$props" />',
  }),
};
export const Primary = {};
