import heapq


def prim_mst(graph, start):
    heap = [(0, start)]
    total_cost = 0
    visited = set()

    while heap:
        cost, node = heapq.heappop(heap)
        if node in visited:
            continue

        visited.add(node)
        total_cost += cost

        for weight, neighbour in graph[node]:
            if neighbour not in visited:
                heapq.heappush(heap, (weight, neighbour))

    return total_cost