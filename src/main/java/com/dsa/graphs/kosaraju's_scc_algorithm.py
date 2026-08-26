from collections import defaultdict

# Time complexity O(V+E)
# Space complexity O(V+E)
def find_scc_kosaraju(n, edges):
    graph = {i: [] for i in range(n)}
    visited, stack = set(), []

    for u, v in edges:
        graph[u].append(v)

    # 1. First DFS to get finishing order
    def dfs1(node):
        visited.add(node)

        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs1(neighbor)

        stack.append(node)

    for node in range(n):
        if node not in visited:
            dfs1(node)

    # 2. Transpose the graph
    transpose = defaultdict(list)
    for u in graph:
        for v in graph[u]:
            transpose[v].append(u)


    visited = set()
    # 3. Second DFS on transposed graph
    def dfs2(node, group_components):
        visited.add(node)
        group_components.append(node)

        for neighbor in transpose[node]:
            if neighbor not in visited:
                dfs2(neighbor, group_components)

    sccs = []
    while stack:
        node = stack.pop()
        if node not in visited:
            group_components = []
            dfs2(node, group_components)
            sccs.append(group_components)

    return sccs