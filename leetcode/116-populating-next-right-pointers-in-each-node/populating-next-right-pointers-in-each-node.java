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
        Node temp=root;
        while(temp!=null){
            Node n=temp;
            if(n.left!=null){
            while(true){
            n.left.next=n.right;
            if(n.next!=null){
            n.right.next=n.next.left;
            n=n.next;
            }
            else{
                break;
            } 
            }    
        }
        temp=temp.left;
        }
        return root;
    }
}