# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0

        depth1 = self.minDepth(root.left)
        depth2 = self.minDepth(root.right)

        if depth1 == 0:
            return depth2 + 1
        elif depth2 == 0:
            return depth1 + 1

        if depth1 < depth2:
            return depth1 +1
        else:
            return depth2 +1
