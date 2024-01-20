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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallP = small;
        ListNode largeP = large;

        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
                smallP.next = temp;
                smallP = temp;
            }
            else{
                largeP.next = temp;
                largeP = temp;
            }

            temp = temp.next;
        }

        smallP.next = large.next;
        largeP.next = null;
        head = small.next;

        return head;
    }
}
// TC: O(n)
// SC: O(1)