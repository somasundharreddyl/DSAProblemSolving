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
        preorder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] charArr=data.split("_");
       return construct(charArr);
    }
    public void preorder(TreeNode root,StringBuilder s){
       if(root==null){s.append("#"+"_"); return;}
        s.append(root.val+"_");
        preorder(root.left,s);
        preorder(root.right,s);
    }
    public TreeNode construct(String[] s){
        if(s[i].equals("#")){
            i++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(s[i]));
          i++;
        root.left=construct(s);
        root.right=construct(s); 
        return root;    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));