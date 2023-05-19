import TextInput from '../../module/common/TextInput.vue';

export default {
  /**
   * DOCS
   */
  title: 'TextInput (텍스트 입력)',
  component: TextInput,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { TextInput },
    template: '<text-input @onChange="handleChange" v-bind="$props" />',
  }),
};
export const Primary = {};
