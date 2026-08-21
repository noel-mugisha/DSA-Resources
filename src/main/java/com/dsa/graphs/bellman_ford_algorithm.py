def bellman_ford(nodes, edges, start):
    distances = {node: float("inf") for node in nodes}
    distances[start] = 0

    for _ in range(len(nodes) - 1):
        updated = False
        for u, v, weight in edges:
            if distances[u] == float("inf"):
                continue

            new_dist = distances[u] + weight
            if new_dist < distances[v]:
                distances[v] = new_dist
                updated = True

        if not updated:
            break

    for u, v, weight in edges:
        if distances[u] == float("inf"):
            continue

        new_dist = distances[u] + weight
        if new_dist < distances[v]:
            return None

    return distances
