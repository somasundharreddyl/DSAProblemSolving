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
        while(temp!=null){
            if(temp.right==null){
                ans.add(temp.val); //1,
                temp=temp.left;
            }else{
                TreeNode temp1=temp.right;
                while(temp1.left!=null && temp1.left!=temp){
                    temp1=temp1.left;
                }
                if(temp1.left==null){
                    temp1.left=temp;
                    ans.add(temp.val);
                    temp=temp.right;
                }else{
                    temp1.left=null;
                    temp=temp.left;
                }
            }
        }
        int s=0,e=ans.size()-1;
        while(s<=e){
            int t=ans.get(s);
            ans.set(s,ans.get(e));
            ans.set(e,t);
            s++;
            e--;
        }
        return ans;
    }
}