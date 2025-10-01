/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){return head;}
        Node temp=head;
        while(temp!=null){
            Node tempp1=temp.next;
            Node copyNode=new Node(temp.val);
            temp.next=copyNode;
            copyNode.next=tempp1;
            temp=tempp1;
        }
        Node tempNode=head;
        while(tempNode!=null ){
             Node rnd=tempNode.random;
             if(rnd!=null){
             tempNode.next.random=rnd.next;  
             }
             tempNode=tempNode.next.next;
        }
        Node head1=head;
        Node ans=head.next;
        Node head2=head.next;
        while(head1!=null){
        Node head1p1=head1.next.next;
        Node head2p2=null;
        if(head2.next!=null){
        head2p2=head2.next.next;
        }
           head1.next=head1p1;
           head2.next=head2p2;
           head1=head1p1;
           head2=head2p2;
        }
        return ans;
    }
}