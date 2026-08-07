class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None

def inorder_successor(node):
    if node is None:
        return None

    # Case 1: Right subtree exists
    if node.right:
        curr = node.right

        while curr.left:
            curr = curr.left

        return curr

    # Case 2: No right subtree
    curr = node

    while curr.parent and curr == curr.parent.right:
        curr = curr.parent

    return curr.parent