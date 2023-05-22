import RoundButton from '/src/module/common/RoundButton.vue';

export default {
  /**
   * DOCS
   */
  title: 'common/RoundButton (원형 버튼)',
  component: RoundButton,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { RoundButton },
    template: '<round-button @onClick="handleClick" v-bind="$props" />',
  }),
};
export const Primary = {};
