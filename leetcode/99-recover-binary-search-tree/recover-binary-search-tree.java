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
    TreeNode firstNode=null;
    TreeNode secondNode=null;
    TreeNode prevNode=null;
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int temp=firstNode.val;
        firstNode.val=secondNode.val;
        secondNode.val=temp;
    }
    public void inorderTraverse(TreeNode node){
        if(node==null){
            return;
        }
        inorderTraverse(node.left);
        if(prevNode!=null && prevNode.val>node.val && firstNode==null){
            firstNode=prevNode;
            secondNode=node;
        }else if(prevNode!=null && prevNode.val>node.val && firstNode!=null){
            secondNode=node;
        }
        prevNode=node;
        inorderTraverse(node.right);
    }
}