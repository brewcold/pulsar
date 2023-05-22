import TheHeader from '../../../core/components/Header/TheHeader.vue';

export default {
  /**
   * DOCS
   */
  title: 'layout/TheHeader (헤더)',
  component: TheHeader,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { TheHeader },
    template: '<the-header v-bind="$props" />',
  }),
};
export const Primary = {};
