import Community from '../Community.vue';
import CommunityDetail from '../components/CommunityDetail.vue';
import CommunityModify from '../components/CommunityModify.vue';
import CommunityWrite from '../components/CommunityWrite.vue';
import CommunitySearchResult from '../components/CommunitySearchResult.vue';

export default [
  {
    path: '/community', //게시판, 기본으로 글 리스트 보여줌
    component: Community,
    children: [
      {
        path: ':id', //상세보기
        component: CommunityDetail,
        children: [
          {
            path: 'modify', //글 수정
            component: CommunityModify,
          },
        ],
      },
      {
        path: 'write', //글 작성
        component: CommunityWrite,
      },
      {
        path: 'search', //글 검색 결과
        component: CommunitySearchResult,
      },
    ],
  },
];
