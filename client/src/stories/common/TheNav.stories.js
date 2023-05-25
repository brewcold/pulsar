import TheNav from '../../core/components/Nav/TheNav.vue';

export default {
  /**
   * DOCS
   */
  title: 'layout/theNav (내비게이션)',
  component: TheNav,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { TheNav },
    template: '<the-nav v-bind="$props" />',
  }),
};
export const Primary = {};
