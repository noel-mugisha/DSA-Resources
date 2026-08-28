class Disjoint_set_union:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1] * n
        # To tell us how many connected components are there?
        self.components = n

    def find(self, x) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])

        return self.parent[x]

    def union(self, x, y) -> bool:
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x == root_y:
            return False

        if self.size[root_x] < self.size[root_y]:
            root_x, root_y = root_y, root_x

        self.parent[root_y] = root_x
        self.size[root_x] += self.size[root_y]

        self.components -= 1
        return True