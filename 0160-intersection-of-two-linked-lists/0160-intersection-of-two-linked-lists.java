/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode>set = new HashSet<>();
        // while(headA!=null){
        //     ListNode temp = headB;
        //     while(temp!=null){
        //         if(temp==headA){
        //             return temp;
        //         }
        //         temp=temp.next;
        //     }
        //     headA=headA.next;
        // }
        // return null;
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB))return headB;
            headB=headB.next;
        }
        return null;
    }
}