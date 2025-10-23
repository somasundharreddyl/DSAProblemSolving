/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
     StringBuilder sb=new StringBuilder();
      TreeNode temp=root;
      serializeTree(temp,sb); 
     return sb.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ch=data.split("_");
        i=0;
        return deserializeTree(ch);
    }

    public void serializeTree(TreeNode root,StringBuilder sb){
       if(root==null){
          sb.append("#"+"_");
          return;
       }
       sb.append(root.val+"_");
       serializeTree(root.left,sb);
       serializeTree(root.right,sb);
    }

    public TreeNode deserializeTree(String[] st){
        if(st[i].equals("#")){
            i++;
            return null;
        } 
        TreeNode root=new TreeNode(Integer.parseInt(st[i]));
        i++;
        root.left=deserializeTree(st);
        root.right=deserializeTree(st);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));