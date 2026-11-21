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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();

        preorder(root1, ans);
        preorder(root2, ans);

        Collections.sort(ans);

        return ans;
    }

    public void preorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;

        ans.add(root.val);

        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}