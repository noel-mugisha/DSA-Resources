# First of all we need a disjoint set
class DSU:
    def __init__(self, n):
        self.parent = [i for i in range(n + 1)]
        self.size = [1] * (n + 1)

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])

        return self.parent[x]

    def union(self, x, y):
        root_x = self.find[x]
        root_y = self.find[y]

        if root_x == root_y:
            return False

        if self.size[root_x] < self.size[root_y]:
            root_x, root_y = root_y, root_x

        self.parent[root_y] = root_x
        self.size[root_x] += self.size[root_y]

        return True

def kruskal_algo(n, edges):
    total_cost, n_edges = 0, 0
    edges.sort(key=lambda edge:edge[2])
    dsu = DSU(n)

    for u, v, weight in edges:
        if dsu.union(u, v):
            total_cost += weight
            n_edges += 1

            if n_edges == n - 1:
                return total_cost

    return -1