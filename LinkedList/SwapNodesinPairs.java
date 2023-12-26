class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while(curr.next != null && curr.next.next != null){
            ListNode swap1 = curr.next;
            ListNode swap2 = curr.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;

            curr.next = swap2;
            curr = swap1;
        }
        return dummy.next;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next.next;
        ListNode curr = head.next;

        curr.next = head;
        head.next= swapPairs(temp);
        return curr;
    }
}
// TC: O(n)
// SC:O(n)