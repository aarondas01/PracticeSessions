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
    public int getDecimalValue(ListNode head) {
        int res = 0;

        ListNode temp = head;
        while(temp != null){
             res *= 2;
//            res = res << 1;
            res += temp.val;
            temp = temp.next;
        }
        return res;
    }
}

// TC: O(n)
// SC: O(1)