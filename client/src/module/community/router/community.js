import CommunityView from '../CommunityView.vue';
import CommunityDetailContainer from '../components/CommunityDetailContainer.vue';
import CommunitySearchResult from '../components/CommunitySearchResult.vue';
import CommunityListContainer from '../components/CommunityListContainer.vue';

export default [
  {
    path: '/community', //게시판, 기본으로 글 리스트 보여줌
    component: CommunityView,
    children: [
      { path: '', component: CommunityListContainer },
      {
        path: 'search', //글 검색 결과
        component: CommunitySearchResult,
      },
      {
        path: ':articleNo', //상세보기
        component: CommunityDetailContainer,
      },
    ],
  },
];
