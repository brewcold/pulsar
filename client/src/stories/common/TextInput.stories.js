import TextInput from '../../module/common/TextInput.vue';

export default {
  /**
   * docs
   */
  title: 'common/TextInput (텍스트, 이메일, 비밀번호)',
  component: TextInput,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { TextInput },
    template: '<text-input @onChange="handleChange" v-bind="$props" />',
  }),
};
export const Primary = {};
