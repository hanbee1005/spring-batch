# Spring Batch
### 의존성 추가
```
implementation 'org.springframework.boot:spring-boot-starter-batch'
```
### 활성화 시키기
- ```@EnableBatchProcessing``` 애노테이션 추가
- 총 4개의 설정 클래스를 실행시키며 스프링 배치의 모든 초기화 및 실행 구성이 이루어진다.
  - BatchAutoConfiguration
    - 스프링배치가 초기화될 때 자동으로 실행되는 설정 클래스
    - Job을 수행하는 JobLauncherApplicationRunner 빈을 생성
  - SimpleBatchConfiguration
    - JobBuilderFactory 와 StepBuilderFactory 생성
    - 스프링 배치의 주요 구성 요소 생성 - 프록시 객체로 생성됨
  - BatchConfigurerConfiguration
    - BasicBatchConfigurer
      - SimpleBatchConfiguration 에서 생성한 프록시 객체의 실제 대상 객체를 생성하는 설정 클래스
      - 빈으로 의존성 주입을 받아서 주요 객체들을 참조해서 사용할 수 있다.
    - JpaBatchConfigurer
      - Jpa 관련 객체를 생성하는 설정 클래스
    - 사용자 정의 BatchConfigurer 인터페이스를 구현하여 사용할 수 있음       
    <img src="./src/main/resources/img/batch_init_step.png" width="200" height="400"/>
- 스프링 부트 배치의 자동 설정 클래스가 실행됨으로 빈으로 등록된 모든 Job을 검색해서 초기화와 동시에 Job을 수행하도록 구성됨

### 참고
- [인프런 강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B0%B0%EC%B9%98/dashboard)