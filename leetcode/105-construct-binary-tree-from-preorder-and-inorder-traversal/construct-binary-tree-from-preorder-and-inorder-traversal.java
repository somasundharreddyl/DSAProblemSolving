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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> hMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hMap.put(inorder[i],i);
        }
        return constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hMap);
    }
    public TreeNode constructTree(int[] preorder,int ps, int pe, int[] inorder, int is, int ie,Map<Integer,Integer> hMap){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode node=new TreeNode(preorder[ps]);
        int idx=hMap.get(preorder[ps]);
        node.left=constructTree(preorder,ps+1,ps+1+(idx-1-is),inorder,is,idx-1,hMap);
        node.right=constructTree(preorder,pe-(ie-idx-1),pe,inorder,idx+1,ie,hMap);
        return node;
    }
}