import axios from 'axios';

//base url을 가져옵니다. 코드상으로 공개되지 않으며 .env파일에 있습니다
//.env는 git에 업로드하지 않으며, git repository secret에서 이 부분을 관리합니다.
// const root = process.env.VUE_APP_BASE_URL;
const root = `http://localhost:8080/`;

//AUTH가 필요하지 않은 요청입니다.
//content-type 헤더를 설정하면 stringify하지 않아도 json으로 알아서 잘 갑니다.
const NORMAL = {
  headers: { 'Content-Type': 'application/json; charset=UTF-8' },
  baseURL: root,
};

//AUTH가 필요한 요청입니다. JWT를 쓸 때 authorization 헤더에,
//BEARER authentification을 적용하기 위한 자리입니다.
const AUTH = {
  headers: {
    'Content-Type': 'application/json; charset=UTF-8',
    Authorization: '',
  },
  baseURL: root,
};

//설정 객체를 가지고 axios instance를 생성합니다.
const NORMAL_INSTANCE = axios.create(NORMAL);
const AUTH_INSTANCE = axios.create(AUTH);
NORMAL_INSTANCE.defaults.withCredentials = true;
AUTH_INSTANCE.defaults.withCredentials = true;
//withCredentials를 설정합니다. 프론트 단에서 인증정보를 담는 경우 이 설정이 없으면
//CORS 에러가 발생합니다 (server에서 allow 어쩌고 하는 것처럼...)

//instance를 가지고 api call부분을 담당하는 함수를 생성합니다.
//첫 번째 파라미터부터 URI, HTTP 메서드, 서버로 보낼 데이터, 보안 타입을 받고
//해당 타입에 따라 데이터 혹은 에러 메시지를 반환합니다.
const call = async (URI, method = 'get', data, authType = 'normal') => {
  //bearer auth가 필요하면 authType에 문자열 'auth'를 입력하면 됩니다.
  const instance =
    authType === 'auth' ? AUTH_INSTANCE : NORMAL_INSTANCE;

  try {
    let result;
    if (method === 'get') result = await instance.get(URI);
    if (method === 'post') result = await instance.post(URI);
    if (method === 'put') result = await instance.put(URI);
    if (method === 'delete') result = await instance.delete(URI);
    //promise 객체
    return result.data;
  } catch (err) {
    return err.message;
  }
};

export default call;
