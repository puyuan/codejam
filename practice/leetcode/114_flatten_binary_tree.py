'''
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    curnode = None
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        self.traverse_helper(root)

    def traverse_helper(self, node):
        if node == None:
            return
        self.traverse_helper(node.right)
        self.traverse_helper(node.left)
        # Fix path
        node.right = self.curnode
        node.left = None
        self.curnode = node