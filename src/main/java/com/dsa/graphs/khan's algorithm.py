from collections import deque
from typing import List


def topological_sort_kahn(graph: dict[int, List[int]]) -> List[int]:
    indegree = {node: 0 for node in graph}
    for node in graph:
        for neighbour in graph[node]:
            indegree[neighbour] += 1

    q = deque([node for node in graph if indegree[node] == 0])
    res = []

    while q:
        node = q.popleft()
        res.append(node)

        for neighbour in graph[node]:
            indegree[neighbour] -= 1
            if indegree[neighbour] == 0:
                q.append(neighbour)

    return [] if len(res) != len(graph) else res

if __name__ == "__main__":
    # A simple DAG: 5 -> 0, 5 -> 2, 4 -> 0, 4 -> 1, 2 -> 3, 3 -> 1
    graph = {
        5: [0, 2],
        4: [0, 1],
        2: [3],
        3: [1],
        0: [],
        1: []
    }

    order = topological_sort_kahn(graph)
    if order:
        print("Topological order:", order)
        # Possible output: [4, 5, 0, 2, 3, 1] or [5, 4, 2, 0, 3, 1] (multiple valid orders)
    else:
        print("Graph contains a cycle, cannot topologically sort.")