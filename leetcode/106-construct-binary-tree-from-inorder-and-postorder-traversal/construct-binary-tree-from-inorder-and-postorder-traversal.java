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
        Map<Integer,Integer> hMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hMap.put(inorder[i],i);
        }
        return constructTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,hMap);
    }
    public TreeNode constructTree(int[] postorder,int ps, int pe, int[] inorder, int is, int ie,Map<Integer,Integer> hMap){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode node=new TreeNode(postorder[pe]);
        int idx=hMap.get(postorder[pe]);
        node.left=constructTree(postorder,ps,ps+(idx-1-is),inorder,is,idx-1,hMap);
        node.right=constructTree(postorder,pe-1-(ie-idx-1),pe-1,inorder,idx+1,ie,hMap);
        return node;
    }
}