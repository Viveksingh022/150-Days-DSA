class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        int count = noOfPaths(root, targetSum);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return count;
    }

    public int noOfPaths(TreeNode root, long targetSum) {
        if(root == null) return 0;

        int count = 0;

        if(root.val == targetSum) count++;

        count += noOfPaths(root.left, targetSum - root.val);
        count += noOfPaths(root.right, targetSum - root.val);

        return count;
    }
}