Reverse Linked List

class Solution {
    public ListNode reverseList(ListNode head) {
        //iterative

        ListNode prev= null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public ListNode reverseList(ListNode head) {
        //recursive

        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return prev;
    }
}

// TC: O(N)
// SC:O(1)
