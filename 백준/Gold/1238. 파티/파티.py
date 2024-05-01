INF = int(1e9)

n, m, x = map(int, input().split())
graph = [[[] for i in range(n + 1)] for j in range(2)]
visited = [[False] * (n + 1), [False] * (n + 1)]
distance = [[INF] * (n + 1), [INF] * (n + 1)]
ii = 109
distance[0][x] = 0
distance[1][x] = 0

for i in range(m):
    a, b, t = map(int, input().split())
    graph[0][a].append((b, t))
    graph[1][b].append((a, t))


def get_smallest_unvisited(d):
    smallest_node = [INF, INF]
    for i in range(1, n + 1):
        if distance[d][i] < smallest_node[1] and not visited[d][i]:
            smallest_node = [i, distance[d][i]]
    return smallest_node[0]


def dijkstra(start, d):
    distance[d][start] = 0

    for i in range(n):
        tar = get_smallest_unvisited(d)
        visited[d][tar] = True
        for node in graph[d][tar]:
            if distance[d][node[0]] > distance[d][tar] + node[1]:
                distance[d][node[0]] = distance[d][tar] + node[1]


def get_max():
    ret = 0
    for i in range(1, n + 1):
        if ret < distance[0][i] + distance[1][i]:
            ret = distance[0][i] + distance[1][i]
    return ret


dijkstra(x, 0)
dijkstra(x, 1)
print(get_max())
