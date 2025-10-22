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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode temp=root;
        while(temp!=null){
            if(temp.left==null){
                ans.add(temp.val);
                temp=temp.right;
            }else{
                TreeNode temp1=temp.left;
                while(temp1.right!=null && temp1.right!=temp){
                    temp1=temp1.right;
                }
                if(temp1.right==null){
                    temp1.right=temp;
                    ans.add(temp.val);
                    temp=temp.left;
                }else{
                    temp1.right=null;
                    temp=temp.right;
                }
            }
        }
        return ans;
    }
}