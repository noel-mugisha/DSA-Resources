# Used to find the shortest distance between each possible pair of nodes in the graph
# Time complexity O(V^3)
# Space complexity 0(V^2)
def floyd_warshall(n, edges):
    dist = [[float("inf")] * n for _ in range(n)]

    for i in range(n):
        dist[i][i] = 0

    for u, v, weight in edges:
        dist[u][v] = weight

    for k in range(n):
        for i in range(n):
            for j in range(n):
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

    for i in range(n):
        if dist[i][i] < 0:
            return None

    return dist