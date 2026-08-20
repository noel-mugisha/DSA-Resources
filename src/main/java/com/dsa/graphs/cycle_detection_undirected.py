from typing import List


def has_cycle(graph: dict[str, List[str]]) -> bool:
    visited = set()
    def dfs(node, parent) -> bool:
        if node in visited:
            return True
        visited.add(node)

        for neighbour in graph[node]:
            if neighbour == parent:
                continue

            if dfs(neighbour, node):
                return True

        return False

    for start in graph:
        if start not in visited:
            if dfs(start, None):
                return True

    return False