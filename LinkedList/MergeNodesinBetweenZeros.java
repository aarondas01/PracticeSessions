class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;

        ListNode temp = head;
        while(temp != null){
            temp  = temp.next;
            int sum =0;
            while(temp != null && temp.val != 0){
                sum += temp.val;
                temp = temp.next;
            }

            if(sum != 0){
                newHead.next = new ListNode(sum);
                newHead = newHead.next;
            }
        }
        return dummy.next;
    }
}

// TC: O(n)
// SC: O(1)