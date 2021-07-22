# CHAPTER05 DFS/BFS

---

## 1. 꼭 필요한 자료구조 기초

> 탐색<sup>Search</sup>이란 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정이다.

> 자료구조<sup>Data Structure</sup>란 데이터를 표현하고 관리하고 처리하기 위한 구조이다.

오버플로<sup>Overflow</sup>는 특정한 자료구조가 수용할 수 있는 데이터의 크기를 이미 가득 찬 상태에서 삽입 연산을 수행할 때 발생한다.

언더플로<sup>Underflow</sup>는 특정한 자료구조에 데이터가 전혀 들어 있지 않은 상태에서 삭제 연산을 수행할 때 발생한다.

---

### 스택
선입후출<sup>First in Last Out</sup> 구조 또는 후입 선출<sup>Last In First Out</sup> 구조라고 한다.
1. 스택 예제 [예제 5-1](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_1.java)
 - Java에서 제공하는 Stack 클래스 사용

---

### 큐
선입선출<sup>First in First Out</sup> 구조라고 한다.

2.  예제 [예제 5-2](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeoni큐algorithm/thisiscodingtest/chapter05/Example5_2.java)
 - Java에서 제공하는 Queue 클래스 사용
 - Deque 인터페이스를 활용하면 Stack과 Queue로 모두 사용 가능

---

### 재귀 함수
> 재귀 함수<sup>Recursive Function</sup>란 자기 자신을 다시 호출하는 함수를 의미한다.

3. 재귀 함수 예제 [예제 5-3](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_3.java)
 - 작성한 문자열을 무한히 출력
 - 어느 정도 출력이 진행되면 오류 메시지를 출력하고 멈춤

4. 재귀 함수 종료 예제 [예제 5-4](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_4.java)
 - 해당 메소드의 무한 호출을 막기 위해 종료 조건을 명시

재귀 함수는 내부적으로 스택 자료구조의 형태를 가지고 있다.

5. 2가지 방식으로 구현한 팩토리얼 예제 [예제 5-5](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_5.java)
 - 반복적으로 구현한 n!
 - 재귀적으로 구현한 n!

2가지 방식의 실행 결과는 동일하다. 반복문 대신 재귀 함수를 사용했을 때 얻는 이점은 코드가 더 간결해진다.
수학의 점화식을 그대로 소스코드로 옮겼기 때문이다.

---

## 2. 탐색 알고리즘 DFS/BFS
> DFS는 Depth-First Search. 깊이 우선 탐색이라고도 부르며, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다.

그래프<sup>Graph</sup>는 노드<sup>Node</sup>와 간선<sup>Edge</sup>로 표현되며 노드를 정점<sup>Vertex</sup>라고도 말한다.
그래프 탐색은 하나의 노드를 시작으로 다수의 노드를 방문하는 것을 말한다. 두 노드가 간선으로 연결되어 있으면 '두 노드는 인접하다<sup>Adjacent</sup>'
라고 표현한다.

 - 인접 행렬 (Adjacency Matrix): 2차원 배열로 그래프의 연결 관계를 표현하는 방식
 - 인접 리스트 (Adjacency List): 리스트로 그래프의 연결 관계를 표현하는 방식

6. 인접 행렬 방식 예제 [예제 5-6](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_6.java)
 - 2차원 배열에 각 노드가 연결된 형태를 기록하는 방식

7. 인접 리스트 방식 예제 [예제 5-7](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_7.java)
 - '연결 리스트' 라는 자료구조를 이용
 - java에 LinkedList 사용

---

### 두 방식의 차이

메모리 측면에서는 인접 행렬 방식은 모든 관계를 저장하기 때문에 노드 개수가 많을 수록 메모리가 불필요하게 낭비된다.
하지만 인접리스트 방식은 연결된 정보만 저장하기 때문에 메모리를 효율적으로 사용할 수 있다.

속도 측면에서 인접 리스트 방식은 인접 행렬 방식에 비해 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느리다.

||DFS|BFS|
|---|---|---|
|동작 원리|스택|큐|
|구현 방법|재귀 함수 이용|큐 자료구조 이용|

---

### DFS
DFS는 깊이 우선 탐색 알고리즘이다. DFS는 특정한 경로를 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 후, 
다시 돌아가 다른 경로로 탐색하는 알고리즘이다.

 1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
 2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리를 한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
 3. 2번의 과정을 더 이상 수행할 수 없을 때 까지 반복한다.

8. DFS 예제 [예제 5-8](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_8.java)

---

### BFS
BFS는 너브 우선 탐색이라는 의미를 가진다. 가까운 노드부터 탐색하는 알고리즘이다. BFS 구현은 선입선출 방식은 큐 자료구조를 이용한다.

 1. 탐색 시작 노드를 큐에 삽입하고 방문 처리한다.
 2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리한다.
 3. 2번의 과정을 더 이상 수행할 수 없을 때 까지 반복한다.

9. DFS 예제 [예제 5-9](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Example5_9.java)

*코딩 테스트에서는 보통 재귀 함수로 구현한 DFS보다 BFS구현이 조금 더 빠르게 동작한다.*

---

10. 음료수 얼려 먹기 [실전 5-10](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Practice5_10.java)
 - DFS로 풀이
 - BFS로도 충분히 풀이 가능할 것으로 보인다.

11. 미로 찾기 [실전 5-11](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter05/Practice5_11.java)
 - BFS로 풀이

---
### References

나동빈, 『이것이 취업을 위한 코딩 테스트다』, 출판지-한빛미디어(2020), 122p ~ 154p.