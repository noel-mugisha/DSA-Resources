from collections import deque, defaultdict
from typing import Optional, List
from Trees.tree_node import TreeNode


class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        q = deque([(root, 0)])
        min_col, max_col = 0, 0
        map_ = defaultdict(list)

        while q:
            node, col = q.popleft()
            min_col, max_col = min(min_col, col), max(max_col, col)

            map_[col].append(node.val)

            if node.left:
                q.append((node.left, col - 1))

            if node.right:
                q.append((node.right, col + 1))

        return [map_[key] for key in range(min_col, max_col + 1)]
