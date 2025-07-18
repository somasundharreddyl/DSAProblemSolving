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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){return root;}
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
          TreeNode node=q.remove();
          if(node==null){return null;}
          if(node.val==val){
            return node;
          }else if(val>node.val){
            q.add(node.right);
          }else{
            q.add(node.left);
          }
        }
        return null;
    }
}