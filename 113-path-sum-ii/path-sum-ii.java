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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        helper(ans, res, root, targetSum);
        return ans;
    }

    public void helper(List<List<Integer>> ans,
                       List<Integer> res,
                       TreeNode root,
                       int targetSum) {

        if (root == null) return;

        // Add current node to the path
        res.add(root.val);

        // Check whether we reached a valid leaf
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ans.add(new ArrayList<>(res));
            }
        } else {
            helper(ans, res, root.left, targetSum - root.val);
            helper(ans, res, root.right, targetSum - root.val);
        }

        // Backtrack
        res.remove(res.size() - 1);
    }
}
