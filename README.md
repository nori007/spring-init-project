
### 기본 정보
"https://start.spring.io/" 에서 
spring web / lombok / spring data jpa / h2 database / PostgreSQL Driver

기본적인 테스트 코드 존재

프로젝트 변경 필요
 

### 기본 프로젝트 폴더 구조 변경.
 - 도메인 기반으로 분리함
 - domain: 도메인 기반으로 폴더 생성.
 - domain.controller: api 컨트롤러
 - domain.entity: 엔티티 / DAO
 - domain.model: response, request model
 - domain.service: 비지니스 로직
 - global: 유틸성.
 - infra: 유틸성 이외의 인프라 관련.


### 로그인
 - 스프링 시큐리티 추가
 - jwt 기반으로..
 - 로그인 후, 세션 리턴받음. 해당 세션으로 API 동작하는지 확인.
 - 테스트
   - 로그인 확인 / "POST /api/v1/login"
   - 세션으로 로그인 내 정보 확인. / "GET /api/v1/users/{id}"
 - 다중 서버에 대한 세션관리를 위한 redis 고려,

#### 음음음..??? 

[comment]: <> (|users|)

[comment]: <> (|-----|)

[comment]: <> (|Lang id|)

[comment]: <> (|String login_id|)

[comment]: <> (|String password|)

[comment]: <> (|String name|)

[comment]: <> (|String email|)

[comment]: <> (|user_oauth|)

[comment]: <> (|-----------|)

[comment]: <> (|users.id   |)

[comment]: <> (|oauths.id  |)

[comment]: <> (|oauths|)

[comment]: <> (|------|)

[comment]: <> (|Lang id|)

[comment]: <> (|emnu type|)
|String secret_key|
 - users_oauth / oauths 사용이될까?? 필요한걸까?? 아직 잘모르겠음.

참고
 - https://velog.io/@shinmj1207/Spring-Spring-Security-JWT-%EB%A1%9C%EA%B7%B8%EC%9D%B8
 - https://bcp0109.tistory.com/301