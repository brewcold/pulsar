import RoutineList from '../../module/common/RoutineList.vue';

export default {
  /**
   * DOCS
   */
  title: 'RoutineList (루틴 리스트)',
  component: RoutineList,
  render: (args, { argTypes }) => ({
    props: Object.keys(argTypes),
    components: { RoutineList },
    template: '<routine-list v-bind="$props" />',
  }),
};
export const Primary = {};
