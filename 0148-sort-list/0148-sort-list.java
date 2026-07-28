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
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode leftHead,ListNode rightHead){
        ListNode t1 = leftHead;
        ListNode t2 = rightHead;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                temp.next=t1;
                temp = temp.next;
                t1 = t1.next;
            }else{
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }
        if(t1!=null){
            temp.next = t1;
        }else temp.next = t2;

        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = middle(head);
        ListNode rightHead = middle.next;
        middle.next =  null;
        ListNode leftHead = head;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead,rightHead);
        

        
    }
}