
### 기본 정보
"https://start.spring.io/" 에서 
spring web / lombok / spring data jpa / h2 database / PostgreSQL Driver

### 기본 프로젝트 폴더 구조 변경.
 - 도메인 기반으로 분리함
 - domain: 도메인 기반으로 폴더 생성.
 - domain.{도메인명}.controller: api 컨트롤러
 - domain.{도메인명}.dto: response, request model
 - domain.{도메인명}.entity: 엔티티 / DAO
 - domain.{도메인명}.repository: db
 - domain.{도메인명}.service: 비지니스 로직
 - domain.{도메인명}.exception: 에러 정의
 - common: 유틸성 / 공통
 - infra: 이외의 인프라 관련

### 기본적인 정보
 - controller <-> service <-> repository <-> db
 - controller 단위는 dto가 떠다니고
 - service 단위는 dto / entity 가 떠다닐꺼고
 - repository / db 단위는 entity 떠다님.
 - dto <-> entity 간 컨버트는 dto에서 담당
 - 상황의 따라 controller <-> service1 <-> service2 <-> ... <-> repository <-> db 가능성 존재.

### 로그인
 - 스프링 시큐리티 추가
 - jwt 기반으로..
 - 로그인 후, 세션 리턴받음. 해당 세션으로 API 동작하는지 확인.
 - 테스트
   - 로그인 확인 / "POST /api/v1/login"
   - 세션으로 로그인 내 정보 확인. / "GET /api/v1/users/{id}"
 - 다중 서버에 대한 세션관리를 위한 redis 고려,
 
### 해야될것
 - 스웨거 API 문서 붙이기.
 - 로컬 / 개발 / 배포 빌드 유형별 설정파일 처리
 - ~~도메인별(또는 공통) exception 처리~~
 - h2 -> mariadb 변경
 - infra.{radis} - 레디스 관련 추가
 - ~~api 공통화 처리~~


## 백엔드 개발시 유의 사항
 - 코드 컨벤션
   - 인텔리제이 기본 값 따라감(들여쓰기.. 드읃ㅇ..?)
   - 소나린트 설치하여 기본값 따라.
   - 변수 네이밍
     - 축약X(차라리 번역기 돌려서 쓰기를) / 한국어 발음대로 X 
     - 의미 있게 쓰는것을 권장함.
   - 패키지명
     - 소문자, 카멜표기법
     - ex) daouCorp X => daoucorp
   - 클래스명, 인터페이스명
     - 첫시작은 대문자로
     - ex) MemberService
   - 메소드
     - 하나의 한기능만을 수행하는것을 권장함
     - 절대 null 리턴 안됨 (유지보수 힘듭니다)
   - 주석
     - 필요하다면 추가
     - 주석없이 코드만으로 의미를 전달한다면 베스트
 - **테스트 코드 작성하는것을 권장함**.
   - 테스트 코드는 해당 파일의 맞게 생성
   - 통합테스트가 아닌 단위테스트를 기본으로 함.
   - 통합테스트 코드는 RestAPI를 통해 진행하며 RestAPI로 진행이 불가할때는 고민해보기로..
   - 통합테스트?? 단위테스트?? => https://newwisdom.tistory.com/41
 - RestAPI 규칙
   - 주어듣기로는 openstack rest api가 잘되어있다고 하던데.. 참고하시길
   - 기본적인 규칙은 찾아보면 많으니 따로 정리 안함.
   - https://meetup.toast.com/posts/92 참고.
 - 코드 리뷰
   - 위 사항 모두 체크하는것을 기본(코드컨벤션)
   - 비지니스 로직적인 부분 추가.
 - 개발전 설계하는것을 매우 권장함(제발)
 - 
 
## 깃 브랜치 운영
 - master, release, feature(or bugfix) 3가지 줄기로 운영될 예정.
   - master: 메인 브랜치
   - release: 릴리즈 전 테스트등을 수행하는 브랜치
     - 릴리즈 시, master 브랜치에서 release/{version} 브랜치 생성.
     - release 브랜치 최종 배포 시 tag 생성
   - feature(or bugifx): 신규 기능 개발 및 버그 수정 브랜치
     - 기능 개발(버그 수정)시 master 브랜치에서 feature/{기능 상세} 브랜치 생성
     - feature -> master merge시 PR 진행.
 - 깃 사용법을 모른다?
   - https://learngitbranching.js.org/?locale=ko 참고.
    
   