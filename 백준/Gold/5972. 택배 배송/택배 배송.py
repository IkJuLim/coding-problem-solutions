import heapq
import sys


n, m = map(int, input().split())
graph = [[] for i in range(n + 1)]

for i in range(m):
    a, b, c = map(int, input().split())
    graph[a].append([c, b])
    graph[b].append([c, a])


def dijkstra():
    q = []
    heapq.heappush(q, (0, 1))
    total = [sys.maxsize] * (n+1)
    total[1] = 0
    while q:
        cost, node = heapq.heappop(q)
        if node == n:
            return total[node]
        if total[node] < cost:
            continue
        for tar in graph[node]:
            if cost + tar[0] < total[tar[1]]:
                total[tar[1]] = cost + tar[0]
                heapq.heappush(q, (cost + tar[0], tar[1]))


print(dijkstra())
