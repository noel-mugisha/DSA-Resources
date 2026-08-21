import heapq


def Dijkstra_algo(graph, start):
    distances = {node: float("inf") for node in graph}
    distances[start] = 0
    heap = [(0, start)]

    while heap:
        dist, node = heapq.heappop(heap)

        # Ignore outdated entries
        if dist > distances[node]:
            continue

        for neighbour, weight in graph[node]:
            if dist + weight < distances[neighbour]:
                distances[neighbour] = dist + weight
                heapq.heappush(heap, (distances[neighbour], neighbour))

    return distances

if __name__ == '__main__':
    graph = {
        "A": [("B", 4), ("C", 2)],
        "B": [("D", 1)],
        "C": [("D", 3)],
        "D": []
    }

    print(Dijkstra_algo(graph, "A"))