from typing import List


def has_cycle(graph: dict[str, List[str]]) -> bool:
    visited = set()
    path = set()
    def dfs(node) -> bool:
        if node in path:
            return True
        if node in visited:
            return False

        visited.add(node)
        path.add(node)

        for neighbour in graph[node]:
            if dfs(neighbour):
                return True

        path.remove(node)

        return False

    for start in graph:
        if start not in visited:
            if dfs(start):
                return True

    return False