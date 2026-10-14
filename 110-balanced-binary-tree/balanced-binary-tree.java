/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {

          if (root == null) {
            return true;
        }

        int leftans = height(root.left);
        if(root.left != null) leftans++;

        int rightans = height(root.right);
        if(root.right != null) rightans++;
        int balanced = leftans - rightans;

         if(balanced < 0) balanced = -balanced;

         if(balanced > 1) return false;

         return (isBalanced(root.left) && isBalanced(root.right));
    }
    public static int height(TreeNode root){
        if(root == null || root.left == null && root.right == null) return 0;

      return 1 + Math.max(height(root.left), height(root.right));

    }
}