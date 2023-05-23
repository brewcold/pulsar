import axios from 'axios';

//base url을 가져옵니다. 코드상으로 공개되지 않으며 .env파일에 있습니다
//.env는 git에 업로드하지 않으며, git repository secret에서 이 부분을 관리합니다.
// const root = process.env.VUE_APP_BASE_URL;
const root = `http://localhost:8080`;

//AUTH가 필요하지 않은 요청입니다.
//content-type 헤더를 설정하면 stringify하지 않아도 json으로 알아서 잘 갑니다.
const NORMAL = {
  headers: {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Credentials': 'true',
  },
  baseURL: root,
};
const IMG = {
  headers: {
    'Content-Type': 'multipart/form-data',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Credentials': 'true',
  },
  baseURL: root,
};
//AUTH가 필요한 요청입니다. JWT를 쓸 때 authorization 헤더에,
//BEARER authentification을 적용하기 위한 자리입니다.
const AUTH = (token) => {
  return {
    headers: {
      'Content-Type': 'application/json; charset=UTF-8',
      Authorization: `${token}`,
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': 'true',
      // Authorization: '',
    },
    baseURL: root,
  };
};
const AUTH_IMG = (token) => {
  return {
    headers: {
      'Content-Type': 'multipart/form-data',
      Authorization: `${token}`,
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': 'true',
    },
    baseURL: root,
  };
};

/**
 * ### 실질적으로 API CALL을 통해 결과값을 리턴하는 함수입니다.
 * 파라미터로 `uri`, `method`, `data`, `authType`을 받습니다.
 * authType 및 HTTP method에 따라 `axios` 인스턴스를 생성,
 * 요청을 보내 결과값을 받습니다. `method`에 아무것도 입력하지 않을 경우 `get`,
 * `authType`은 `normal`로 각각 기본값이 적용됩니다.
 * @param {string} URI
 * @param {'get'|'post'|'put'|'delete'} method
 * @param {Object} data
 * @param {'normal'|'auth'|'normal_img'|'auth_img'} authType
 * @returns `Promise<Object>`
 */
const call = async (
  uri,
  method = 'get',
  data,
  authType = 'normal',
  token
) => {
  //bearer auth가 필요하면 authType에 문자열 'auth'를 입력하면 됩니다.
  let instance;
  if (authType === 'auth') instance = axios.create(AUTH(token));
  else if (authType === 'auth_img')
    instance = axios.create(AUTH_IMG(token));
  else if (authType === 'normal_img') instance = axios.create(IMG);
  else instance = axios.create(NORMAL);

  const URI = root + uri;
  try {
    let result;
    if (method === 'get') result = await instance.get(URI);
    if (method === 'post') result = await instance.post(URI, data);
    if (method === 'put') result = await instance.put(URI, data);
    if (method === 'delete') result = await instance.delete(URI);
    //promise 객체
    return result;
  } catch (err) {
    return err;
  }
};

export default call;
