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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //two passes
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(n==size){
            return head.next;
        }

        int nEnd = size-n;
        int count = 1;

        temp = head;

        while(count < nEnd){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;

        return head;

    }
}

// TC: O(n)
// SC: O(1)


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //one pass

        ListNode slow = head;
        ListNode fast = head;

        for(int i =0;i < n ; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}

// TC: O(n)
// SC: O(1)