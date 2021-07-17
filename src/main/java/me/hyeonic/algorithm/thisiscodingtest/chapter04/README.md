## CHAPTER 04 구현

---

### 1. 아이디어를 코드로 바꾸는 기술

#### 피지컬로 승부하기
> 구현이란? '머릿속에 있는 알고리즘을 소스코드로 바꾸는 과정' 이다.
> 문제에 대한 정확한 풀이 방법과 우리가 원하는 프로그래밍 언어로 정확히 구현해냈을 때 비로소 정답 처리를 받을 수 있다.

해당 책엣허는 완전 탐색, 시뮬레이션 유형을 모두 '구현' 유형으로 묶어서 다루고 있다.
 - 완전 탐색: 모든 경우의 수를 주저 없이 다 계산하는 해결 방법
 - 시뮬레이션: 문제에서 제시한 알고리즘을 한 단계씩 차례대로 직접 수행

---

#### 구현 시 고려해야 할 메모리 제약 사항

1. C/C++와 자바에서 정수형 종류에 따른 범위

|정수형 종류|자료형의 크기|자료형의 범위 |
|---|---|---|
|int|4바이트|-2,147,483,648 ~ 2,147,438,647|
|long long|8바이트|-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807|
|BigInteger (클래스)|가변적|제한 없음|

---

#### 채점 환경

보통 코딩 테스트 환경에서는 다음과 같은 채점 시스템의 시간 제한 밑 메모리 제한 정보가 적혀 있다.
 - 시간 제한: 1초
 - 메모리 제한: 128MB

알고리즘 문제를 풀 때 시간 제한과 데이터의 개수를 먼저 확인한 뒤에 
이 문제를 어느 정도의 시간 복잡도의 알고리즘으로 작성해야 풀 수 있을 것인지 예측할 수 있어야 한다.

---

#### 구현 문제에 접근하는 방법

보통 구현 유형의 문제는 사소한 입력 조건 등을 문제에서 명시해주며 문제의 길이가 꽤 긴 편이다. 고차원적인 사고력을 요구하는 문제는 나오지 않는 편이라
문법에 익숙하다면 오히려 쉽게 풀 수 있다.

---

1. 상하좌우 [예제 4-1](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter04/Example4_1.java)

2. 시각 [예제 4-2](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter04/Example4_2.java)
 - 완전 탐색
 - 경우의 수를 모두 검사
 - 완전 탐색의 경우 비효율적인 시간 복잡도를 가지고 있다. 데이터의 개수가 큰 경우 정상적으로 동작하지 않을 수 있다. 
   확인해야 할 전체 데이터의 개수가 100만 개 이하일 때 완전 팜색을 사용하면 적절하다.
 - 위 문제의 경우 모든 경우의 수는 24 x 60 x 60 으로 86,400 가지이기 때문에 완전 탐색이 가능하다.

3. 왕실의 나이트 [실전 4-3](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter04/Practice4_3.java)
 - 나이트는 이동할 때 L자 형태로만 이동 가능하다.
 - 즉 갈 수 있는 스텝이 정해져있다.
 - 수평으로 두 칸 이동한 뒤 수직으로 한 칸 이동, 수직으로 두 칸 이동한 뒤 수평으로 한 칸 이동으로 총 8가지의 경우가 나온다.
 - 문자를 좌표로 바꾸기 위한 초반부를 잘 알아두자.

4. 게임 개발 [실전 4-4](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter04/Practice4_4.java)