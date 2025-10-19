/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Node temp=root;
        while(temp!=null){
            Node temp1=temp;
           while(temp1!=null && temp1.left!=null){
             temp1.left.next=temp1.right;
             if(temp1.next!=null){
               temp1.right.next=temp1.next.left;
             }else{
               temp1.right.next=null;
             } 
           temp1=temp1.next; 
           } 
           temp=temp.left;
        }
        
        return root;
    }
}