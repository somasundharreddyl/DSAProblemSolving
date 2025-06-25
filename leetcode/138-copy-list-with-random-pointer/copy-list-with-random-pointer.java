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
            Node n=new Node(temp.val);
            Node tempp1=temp.next;
            temp.next=n;
            n.next=tempp1;
            temp=tempp1;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
         temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        Node h1=head;
        Node h2=head.next;
        Node ans=head.next;
        while(h1!=null){
            Node h1p1=h1.next.next;
            Node h2p1=null;
            if(h2.next!=null){
                h2p1=h2.next.next;
            }
            h1.next=h1p1;
            h2.next=h2p1;
            h1=h1.next;
            h2=h2.next;
        }
        return ans;
    }
}