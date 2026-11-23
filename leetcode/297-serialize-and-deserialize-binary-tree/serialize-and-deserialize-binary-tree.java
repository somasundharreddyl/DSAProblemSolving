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
        serialization(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       i=0;
       String[] arr=data.split(" ");
       TreeNode root=deserialization(arr); 
       return root;
    }

    public void serialization(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("# ");
            return;
        }
        sb.append(root.val+" ");
        serialization(root.left,sb);
        serialization(root.right,sb);
    }

    public TreeNode deserialization(String[] arr){
        if(arr[i].equals("#")){
            i++;
           return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left=deserialization(arr);
        root.right=deserialization(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));