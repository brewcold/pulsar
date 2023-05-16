import Mypage from '../Mypage.vue';
import Bookmarks from '../components/Bookmarks.vue';
import MyArticles from '../components/MyArticles.vue';

export default [
  {
    path: '/mypage', //마이페이지
    component: Mypage,
    children: [
      {
        path: 'bookmarks', //북마크 보기
        component: Bookmarks,
      },
      {
        path: 'myarticles', //내가 작성한 글 및 댓글
        component: MyArticles,
      },
    ],
  },
];
