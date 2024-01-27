# 스프링 입문 강의

```
https://start.spring.io/ 

artifactId: jar파일명
pacakageName: 도메인 역으로 나열

dependencies
1. spring web
2. thymeleaf
```

- build.gradle
  1. 스프링 부트 버전 2.7.5로 다운그레이드
  2. 자바 11로 변경

<br>

## 설정 파일 확인

<img width="412" alt="image" src="https://github.com/proamateur92/exam/assets/68406448/bfe2a491-df8f-4d5d-a0b9-6ac4a49e0e8b">
<br>

-> 프로젝트 설정 때 주입했던 디펜던시 정보를 확인해보면 하위 패키지를 잔뜩 가지고 있음을 알 수 있다.
1. thymeleaf - spring boot, core
2. Spring boot starter web - tomcat, mvc

<br>

ㅁ 참고 사이트

1. 스프링 부트 메뉴얼
```
https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/
https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page
```
2. thymeleaf 템플릿 엔진
```
https://www.thymeleaf.org/
```

3.tutorial 페이지
```
https://spring.io/guides/gs/serving-web-content/
```

<br>

