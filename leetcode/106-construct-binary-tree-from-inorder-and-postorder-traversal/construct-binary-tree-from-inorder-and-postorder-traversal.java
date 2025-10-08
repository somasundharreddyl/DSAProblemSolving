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

    public TreeNode buildTree(int[] inorder, int[] postorder) {    
    return construct(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode construct(int[] postorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps>pe || is>ie){
            return null;
        }
        int value=postorder[pe];
        int idx=0;
        TreeNode root=new TreeNode(value);
        for(int i=is;i<=ie;i++){
            if(value==inorder[i]){
               idx=i;
               break;
            }
        }
       int count=idx-is;
       root.left= construct(postorder,ps,ps+count-1,inorder,is,idx-1);
       root.right= construct(postorder,ps+count,pe-1,inorder,idx+1,ie);
       return root;
    }

}