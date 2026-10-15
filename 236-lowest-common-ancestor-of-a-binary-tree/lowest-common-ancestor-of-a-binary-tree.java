class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        if (p == q) return p;

       TreeNode leftans = lowestCommonAncestor(root.left, p , q); 
       TreeNode rightans = lowestCommonAncestor(root.right, p , q);

        if(leftans != null && rightans != null) return root;

      
        return leftans != null ? leftans : rightans;
       
    }
}