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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> ans=new ArrayList<>();
        TreeNode temp=root;
        traverseNode(temp,ans);
        return ans;
    }
    public void traverseNode(TreeNode root,List<Integer> ans){
            if(root==null){
                return;
            }
            traverseNode(root.left,ans);
            traverseNode(root.right,ans);
            ans.add(root.val);
    }
}