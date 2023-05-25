import StatisticsView from '../StatisticsView.vue';
import StatisticsContainer from '../components/StatisticsContainer.vue';

export default [
  {
    path: '/statistics',
    component: StatisticsView,
    children: [
      {
        path: '',
        component: StatisticsContainer,
      },
    ],
  },
];
