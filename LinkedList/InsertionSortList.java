class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(head != null){
            ListNode next = head.next;
            if(head.val < temp.val){
                temp = dummy;
            }
            while(temp.next != null && temp.next.val < head.val){
                temp = temp.next;
            }
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return dummy.next;
    }
}

// TC: O(n^2)
// SC: O(1)