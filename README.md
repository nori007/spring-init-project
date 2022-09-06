
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
