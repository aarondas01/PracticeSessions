class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode firstStart = head;
        ListNode mid = getMiddle(head);
        ListNode secondStart = reverse(mid.next);

        if(head == null || head.next == null){
            return true;
        }

        while(secondStart != null){
            if(firstStart.val != secondStart.val){
                return false;
            }
            firstStart = firstStart.next;
            secondStart = secondStart.next;
        }
        return true;
    }

    private ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// TC: O(n)
// SC: O(1)