## CHAPTER 07 이진 탐색

---

### 1. 범위를 반씩 좁혀가는 탐색

#### 순차탐색 Sequential Search
> 리스트 안에 잇는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법

순차 탐색은 데이터 정렬 여부와 상관없이 가장 앞에 있는 원소부터 하나씩 확인해야 한다. 
데이터의 개수가 N개 일 때 최대 N번의 비교 연산이 필요하므로 최악의 경우 시간 복잡도는 **O(N)**이다.

[예제 7-1](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter7/Example7_1.java)

---

#### 이진 탐색 Binary Search : 반으로 쪼개면서 탐색
> 배열 내부의 데이터가 정렬되어 있으면, 탐색 범위를 좁혀가며 데이터를 탐색한다.

이진 탐색의 위치를 나타내는 변수 3개 시작점, 끝점, 중간점이 필요하다. 
찾으려는 데이터와 중간점 위치에 있는 데이터를 반복 비교하여 데이터를 검색한다.

이진 탐색은 한 번 확인할 때마다 확인하는 원소의 개수가 절반씩 줄어들기 때문에 시간 복잡도가 **O(logN)**이다.
이진 탐색을 구현하는 방법은 1. 재귀 함수와 단순 반복문을 이용하는 방법이다.

1. 재귀 함수
[예제 7-2](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter7/Example7_2.java)
2. 단순 반복문
[예제 7-3](https://github.com/hyeonic/algorithm/blob/main/src/main/java/me/hyeonic/algorithm/thisiscodingtest/chapter7/Example7_3.java)

코딩 테스트의 이진 탐색 문제는 탐색 범위가 큰 상황에서의 탐색을 가정하는 문제가 많다. 
따라서 탐색 범위가 2,000만을 넘어가면 이진 탐색과 같이 **O(logN)**의 속도를 내야 하는 알고리즘을 떠올려야 문제를 풀 수 있는 경우가 많다.

---
### References

나동빈, 『이것이 취업을 위한 코딩 테스트다』, 출판지-한빛미디어(2020), 186p ~ 205p.
