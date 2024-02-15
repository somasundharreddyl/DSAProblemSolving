/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode h1=list1;
        ListNode h2=list2;
        
      if(h1 == null) return h2;
      if(h2 == null) return h1;
       ListNode ans = null , t = null;
      if(h1.val < h2.val){
          ans = h1;
          t = h1;
          h1 = h1.next;
      } else {
          ans = h2;
          t = h2;
          h2 = h2.next;
      }
      
      while(h1 != null && h2 != null){
          if(h1.val < h2.val){
            t.next = h1;
            t = t.next;
            h1 = h1.next;
         } else {
            t.next = h2;
            t = t.next;
            h2 = h2.next;
         }
      }
      if(h1 != null) t.next = h1;
      if(h2 != null) t.next = h2;
      
      return ans;

    }
}