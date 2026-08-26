from collections import defaultdict

# Tarjan's Algorithm for finding articulation/critical points in a graph
# Time Complexity: O(V + E)
# Space Complexity: O(V + E) due to the adjacency list
def find_articulation_points(n, edges):
    graph = defaultdict(list)
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    # discovery time
    dt = [-1] * n
    low = [-1] * n
    critical_points, time = set(), 0

    def dfs(node, parent):
        nonlocal time

        dt[node], low[node] = time
        time += 1
        children = 0 # use for checking the condition of root node, it is an AP if it has more than 1 child

        for neighbor in graph[node]:
            if neighbor == parent:
                continue

            if dt[neighbor] == -1:
                children += 1
                dfs(neighbor, node)
                low[node] = min(low[node], low[neighbor])

                if parent != -1 and low[neighbor] >= dt[node]:
                    critical_points.add(node)
            else:
                low[node] = min(low[node], dt[neighbor])

        if parent == -1 and children > 1:
            critical_points.add(node)

    for node in range(n):
        if dt[node] == -1:
            dfs(node, -1)

    return critical_points