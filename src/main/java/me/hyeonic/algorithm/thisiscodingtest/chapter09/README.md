# CHAPTER 09 최단 경로

## 가장 빠른 길 찾기

### 가장 빠르게 도달하는 방법

**최단 경로**<sup>Shortest Path</sup> 알고리즘은 말 그대로 가장 짧은 경로를 찾는 알고리즘이다. 

최단 경로 알고리즘은 보통 그래프로 표현하는데 각 지점은 그래프에서 '노드'로 표현되고, 
지점 간 연결된 도로는 그래프에서 '간선'으로 표현된다.

컴퓨터공학과 학부 수준에서 사용하는 최단 거리 알고리즘
1. **다익스트라 최단 경로 알고리즘**
2. **플로이드 워셜**
3. 벨만 포드 알고리즘

그 중 특히 다익스트라와 플로이드 워셜이 주로 출제 된다.

### 다익스트라 최단 경로 알고리즘

다익스트라<sup>Dijkstra</sup> 최단 경로 알고리즘은 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 
구해주는 알고리즘이다.

#### 특징
1. '음의 간선'이 없을 때 동작한다. 현실 세계의 길(간선)은 음의 간선으로 표현되지 않으므로 다익스트라 알고리즘은 실제로 GPS 소프트웨어의 기본 알고리즘으로 
채택되곤 한다.
2. 그리디 알고리즘으로 분류된다. 매번 '가장 비용이 적은 노드'를 선택해서 임의의 과정을 반복하기 때문이다.
3. 최단 경로를 구하는 과정에서 각 노드에 대한 현재까지의 최단 거리 정보를 항상 1차원 리스트에 저장하며 리스트를 계속 갱신한다는 특징이 있다.
4. 한 단계당 하나의 노드에 대한 최단 거리를 확실히 찾는 것이다.

#### 원리
1. 출발 노드를 설정한다.
2. 최단 거리 테이블을 초기화한다.
3. 방문하지 않은 노드 중에서 `최단 거리`가 가장 짧은 `노드`를 선택한다.
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 `최단 거리 테이블`을 갱신한다.
5. 위 과정에서 3, 4번을 반복한다.

#### 다익스트라 알고리즘을 구현하는 방법
1. 구현하기 쉽지만 느리게 동작하는 코드
2. 구현하기에 조금 더 까다롭지만 빠르게 동작하는 코드

#### 방법 1. 간단한 다익스트라 알고리즘

간단한 다익스트라 알고리즘은 O(V<sup>2</sup>)의 시간 복잡도를 가진다. V는 노드의 개수를 의미한다.

1. 처음에는 각 노드에 대한 최단 거리를 담는 1차원 리스트를 선언한다.
2. 단계마다 '방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택'하기 위해 매 단계마다 1차원 리스트의 모든 원소를 확인(순차 탐색)한다.

```java
public class Example9_1 {

    // 노드의 개수 (N), 간선의 개수 (M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    private static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static List<List<Node>> graph = new ArrayList<>();

    // 방문한 적이 있는지 체크하는 목적의 배열 만들기
    private static boolean[] visited = new boolean[100_001];

    // 최단 거리 테이블 만들기
    private static int[] d = new int[100_001];

    private static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    private static int getSmallestNode() {
        int minDistance = Integer.MAX_VALUE;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < minDistance && !visited[i]) {
                minDistance = d[i];
                index = i;
            }
        }

        return index;
    }

    private static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;

        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        // 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        start = scanner.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, Integer.MAX_VALUE);

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출략
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한이라고 출력
            if (d[i] == Integer.MAX_VALUE) {
                System.out.println("INFINITY");
            // 도달할 수 있는 경우 거리를 출력
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
```

총 O(V)번에 걸쳐 최단 거리가 가장 짧은 노드를 매번 선형 탐색해야 하고, 
현재 노드와 연결된 노드를 매번 일일히 확인하기 때문에 O(V<sup>2</sup>)의 시간 복잡도를 가진다.

전체 노드의 개수가 5,000개 이하라면 위 방식 적용이 가능하다.
하지만 노드의 개수가 10,000개를 넘어가는 문제라면 이 코드로 해결하기 어렵다.

#### 방법 2. 개선된 다익스트라 알고리즘

최단 거리가 가장 짧은 노드를 단순히 선형적으로 찾는 것이 아니라 더욱더 빠르게 찾을 수 있다면 알고리즘의 시간 복잡도를 더욱 줄일 수 있을 것이다.

개선된 다익스트라 알고리즘은 시간 복잡도 O(*ElogV*)를 보장하여 해결할 수 있다. 
여기서 V는 노드의 개수이고, E는 간선의 개수를 의미한다.

힙<sup>Heap</sup>자료구조를 사용한다. 
힙 자료구조를 이용하게 되면 특정 노드까지의 최단 거리에 대한 정보를 힙에 담아서 처리하므로 출발 노드로부터 가장 짧은 노드를 더욱 빠르게 찾을 수 있다.

##### 힙 설명

힙 자료구조는 우선순위 큐<sup>Priority Queue</sup>를 구현하기 위하여 사용하는 자료구조 중 하나이다.
**우선순위 큐**는 `우선순위가 가장 높은 데이터를 가장 먼저 삭제한다`는 점이 특징이다.

|자료구조|추출되는 데이터|
|---|---|
|스택(Stack)|가장 나중에 삽입된 데이터|
|큐(Queue)|가장 먼저 삽입된 데이터|
|우선순위 큐(Priority Queue)|가장 우선순위가 높은 데이터|

우선순위 큐를 구현할 때는 내부적으로 최소 힙<sup>Min Heap</sup> 혹은 최대 힙<sup>Max Heap</sup>을 이용한다. 
1. 최소 힙: 값이 낮은 데이터가 먼저 삭제
2. 최대 힙: 값이 큰 데이터가 먼저 삭제

Java에서는 아래와 같이 사용이 가능하다.

```java
// 우선순위가 낮은 숫자 순
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

// 우선순위가 높은 숫자 순
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```

우선순위 큐는 리스트로도 구현이 가능하다.

|우선순위 큐 구현 방식|삽입 시간|삭제 시간|
|---|---|---|
|리스트|O(1)|O(*N*)|
|힙(Heap)|O(*logN*)|O(*logN*)|

이러한 `우선순위 큐`는 `현재 가장 가까운 노드를 저장하기 위한 목적`으로만 사용한다.

```java
public class Example9_2 {

    // 노드의 개수 (N), 간선의 개수 (M), 시작 노드 번호(Start)
    // 노드의 개수는 최대 100,000개라고 가정
    private static int n, m, start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static List<List<Node>> graph = new ArrayList<>();

    // 최단 거리 테이블 만들기
    private static int[] d = new int[100_001];

    private static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDistance() < o2.getDistance()) {
                return -1;
            }
            return 1;
        });

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        priorityQueue.offer(new Node(start, 0));
        d[start] = 0;

        // 우선순위 큐가 비어있지 않은 동안
        while (!priorityQueue.isEmpty()) {

            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = priorityQueue.poll();
            int distance = node.getDistance(); // 현재 노드까지의 비용
            int now = node.getIndex(); // 현재 노드

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < distance) continue;

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    priorityQueue.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        start = scanner.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, Integer.MAX_VALUE);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == Integer.MAX_VALUE) {
                System.out.println("INFINITY");
            // 도달할 수 있는 경우 거리를 출력
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
```

### 플로이드 워셜 알고리즘

플로이드 워셜 알고리즘<sup>Floyd-Warshall Algorithm</sup>은 
'모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우' 에 사용할 수 있는 알고리즘이다.

1. 단계마다 '거쳐 가는 노드' 를 기준으로 알고리즘을 수행한다. 하지만 매번 방문하지 않은 노드 중에 최단 거리를 갖는 노드를 찾을 필요가 없다는 점이 다르다.
2. 플로이드 워셜 알고리즘은 다이나믹 프로그래밍이라는 특징을 가지고 있다.
3. 노드의 개수가 N개 일 때 알고리즘 상으로 N번의 단계를 수행하며, 단계마다 O(_N<sup>2</sup>_)의 연산을 통해 '현재 노드를 거쳐 가는' 모든  경로를 고려한다.
4. 총 시간 복잡도는 O(_N<sup>3</sup>_)이다.


```java
public class Example9_3 {

    private static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M)
    // 노드으 개수는 최대 500개 라고 가정
    private static int n, m;
    // 2차원 배열(그래프 표현)을 만들기
    private static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용 0으로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A에서 B로 가는 비용은 C라고 설정
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, INF 라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INF\t");
                } else {
                    // 도달할 수 있는 경우 거리를 출력
                    System.out.print(graph[a][b] + "\t");
                }
            }
            System.out.println();
        }
    }
}
```

### References

나동빈, 『이것이 취업을 위한 코딩 테스트다』, 출판지-한빛미디어(2020), 229p ~ 264p.