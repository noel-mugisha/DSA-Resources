from collections import defaultdict


def find_bridges(n, connections):
    graph = defaultdict(list)
    for u, v in connections:
        graph[u].append(v)
        graph[v].append(u)

    visited, bridges = set(), []
    disc = [-1] * n
    low = [-1] * n
    time = 0

    def dfs(node, parent):
        nonlocal time

        visited.add(node)
        disc[node] = low[node] = time
        time += 1

        for neighbour in graph[node]:
            if neighbour == parent:
                continue

            if neighbour not in visited:
                dfs(neighbour, node)
                # update low
                low[node] = min(low[node], low[neighbour])

                if low[neighbour] > disc[node]:
                    bridges.append((node, neighbour))
            else:
                low[node] = min(low[node], disc[neighbour])

    for node in graph:
        if node not in visited:
            dfs(node, None)

    return bridges