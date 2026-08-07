from collections import deque
from typing import List

from Trees.tree_node import TreeNode

class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

def list_of_depths(root: TreeNode) -> List[ListNode]:
    if not root:
        return []

    res = []
    q = deque([root])

    while q:
        q_len = len(q)
        head, tail = None, None

        for _ in range(q_len):
            node = q.popleft()
            list_node = ListNode(node.val)
            if not head:
                head = list_node
                tail = head

            else:
                tail.next = list_node
                tail = list_node

            if node.left:
                q.append(node.left)

            if node.right:
                q.append(node.right)

        res.append(head)

    return res