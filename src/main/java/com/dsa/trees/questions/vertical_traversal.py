from collections import deque, defaultdict
from typing import Optional, List

from Trees.tree_node import TreeNode

class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        q = deque([(root,0, 0)])
        map_ = defaultdict(list)
        min_col, max_col = 0, 0

        while q:
            node, row, col = q.popleft()
            min_col, max_col = min(min_col, col), max(max_col, col)

            map_[col].append((row, node.val))

            if node.left:
                q.append((node.left, row + 1, col - 1))

            if node.right:
                q.append((node.right, row + 1, col + 1))

        for key in map_:
            map_[key].sort()

        return [[val for row, val in map_[key]] for key in range(min_col, max_col + 1)]