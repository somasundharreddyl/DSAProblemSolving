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
        int pStart=0,pEnd=preorder.length-1,iStart=0,iEnd=inorder.length-1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
      return  constructTree(preorder,inorder,pStart,pEnd,iStart,iEnd,map);
    }
    public TreeNode constructTree(int[] preorder,int[] inorder,int pStart,int pEnd,
    int iStart,int iEnd,Map<Integer,Integer> map){
         if(pStart>pEnd || iStart>iEnd){
            return null;
         }
         TreeNode root=new TreeNode(preorder[pStart]);
         int idx=map.get(preorder[pStart]);
         int count=idx-iStart;
         root.left=constructTree(preorder,inorder,pStart+1,pStart+count,iStart,idx-1,map);
         root.right=constructTree(preorder,inorder,pStart+count+1,pEnd,idx+1,iEnd,map);
         return root;
    }
}