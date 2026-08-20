from typing import List


def topological_sort(graph: dict[str, List[str]]) -> List[str]:
    visited = set()
    stack = []

    def dfs(node):
        if node in visited:
            return

        visited.add(node)

        for neighbour in graph[node]:
            dfs(neighbour)

        stack.append(node)

    for start in graph:
        if start not in visited:
            dfs(start)

    return stack[::-1]