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

## 빌드하기

<img width="948" alt="image" src="https://github.com/proamateur92/exam/assets/68406448/39df6e7f-9a4e-452e-8538-e2f4042d837f">

<br>
1. 프로젝트 파일 경로 이동 <br>
2. 빌드 파일 생성 gradlew  build <br>
3. jar파일 경로 이동 cd build/libs <br>
4. 실행 java -jar jar명 <br>
<br>
* gradlew clean build 빌드 파일 삭제 후 빌드

<br>

## 정적 컨텐츠 호출

    static 이하에 생성된 정적 컨텐츠는 파일명으로 url호출 가능

    static/hi-static.html 
    ex) http://localhost:8080/hi-static.html

<br>

## MVC & 템플릿 엔진

- MVC: Model(조작데이터), View(표출 페이지), Controller(url 맵핑 및 비즈니스 로직)
- 템플릿 엔진을 사용하여 동적 데이터로 페이지에 출력 가능하다.

```java
// @RequestParam 내부의 문자열이 url의 쿼리스트링 key값을 의미
// @RequestParam 옵션 값으로 required = false 하지 않으면 쿼리스트링 값이 null일 때 에러 발생
String mvc-test (@RequestParam("쿼리스트링 키 값") String value, Model model) {

    // model에 데이터 담기
    model.attribute("key값", value);
    
    // ViewResolver를 통해 Model에 담긴 데이터를
    // 템플릿 엔진에 담아 반환 - key값으로 value값을 가져올 수 있다.
    return "반환할 페이지명";
}
```