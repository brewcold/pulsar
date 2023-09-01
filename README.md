# Pulsar

## 🛠️ 제작: 민병기, 유승윤

<div align=center>
  <table style="display:table; table-layout:fixed;">
    <tbody>
      <tr padding>
               <td align="center" justify="center"><a href="https://github.com/bmincof"><img src="https://avatars.githubusercontent.com/u/104330984?v=4" width="100px;" alt=""/><br /><sub><b>민병기 (BE)<br/>bmincof</b></sub></a><br /></td>
        <td align="center" justify="center"><a href="https://github.com/brewcoldblue"><img src="https://avatars.githubusercontent.com/u/82228797?v=4" width="100px;" alt=""/><br /><sub><b>유승윤 (FE)<br/>brewcoldblue</b></sub></a><br /></td>
          </tr>
    </tbody>
  </table>
</div>

## 📑 프로젝트 개요

- 주제: 운동 일정 및 루틴을 체계적으로 관리할 수 있는 서비스
- 기술스택:
  - FE: Vue, Vuex
  - BE: Spring Boot, MyBatis
- 진행 기간:
  - 기획: 2023. 05. 09 - 2023. 05. 15
  - 개발: 2023. 05. 16 - 2023. 05. 26
- 기능:
  - 회원가입, 로그인, 로그아웃
  - 루틴 및 루틴 내의 세부 정보에 대한 CRUD
  - 자유게시판의 글 CRUD

## 🔥 프로젝트 진행

## 😣 민병기, BE

### 주요 고려 사항

- 처음부터 끝까지 협업을 해 본 첫 경험이었음
- 협업 시의 편의성을 많이 고려함
- 프론트엔드 팀원이 알아보기 쉬운 변수명 규칙 지정
  - 1.  request, response DTO 이름은 각각 request, response로 끝남
  - 2.  DB에서 쿼리한 값을 저장하는 DTO 이름은 명사형
- 유연하게 변경 가능하고 API 구현이 쉽도록 테이블을 설계하려고 노력함
  - 최대한 작게 분해해 조립이 쉽도록 함

### 아쉬웠던 점

- DB설계: API 구현은 쉬워졌지만 Join을 많이 해야 하거나 DB호출을 자주 해야 하는 상황이 발생함, DB호출 횟수와 Join의 성능 문제에 대해서는 프로젝트 당시 고려하지 못함. JMeter 등의 성능 분석 도구로 분석까지 진행해보았다면 좋았을 듯
- 로그인: 쿠키의 samesite 정책변경으로 생긴 문제를 해결하지 못해 JWT와 쿠키를 이용한 방법 대신 우회적으로 구현함
- 테스트: 기능을 변경할 때마다 기존 코드가 제대로 작동하는지에 대한 확신이 없었음. 프로젝트 기간이 짧아 테스트 코드 작성은 어려웠지만, 다음 프로젝트에서는 적용하고 싶음

## 😇 유승윤, FE

### 주요 고려 사항

- SPA 프레임워크의 '선언적' 코드에 대한 감 잡기
  - data fetching method를 비롯해 모든 메서드와 함수를 선언적으로 관리하려고 시도
- Atomic component pattern 적용해 보기, with storybook
- MVVM 패턴이 무엇인지 이해하기

### 아쉬웠던 점

- 마지막에 급하게 여러 컴포넌트를 만들다 보니 중첩된 컴포넌트들을 분리해내지 못한 부분이 너무 많았음
- 파일을 분리하지 않으려고 조건부 렌더링을 많이 걸었는데, 오히려 컴포넌트 구조와 코드 가독성만 떨어지는 결과를 낳음
- atomic component는 유연하게 설계했어야 하는데 그 부분을 고려하지 못했음. 설계가 유연하다는 것은 고려를 안 하는 것이 아니라, 모든 상황을 고려해 대응 가능하도록 하는 것이라는 점을 깨달음
- 중첩된 CRUD에서의 상태 관리, 태그 선택 폼 등 여러 깊이에 있는 컴포넌트들의 상태를 위쪽으로 끌어올려 관리하는 것이 다소 어려웠음
