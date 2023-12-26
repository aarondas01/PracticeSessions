class Solution {
    public void reorderList(ListNode head) {
        //using Map
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode curr = head;
        int count = 0;

        while(curr != null){
            map.put(count++,curr);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        int low = 0, high = count-1;
        while(low<= high){
            dummy.next = map.get(low++);
            dummy = dummy.next;
            dummy.next = map.get(high--);
            dummy = dummy.next;
        }

        dummy.next = null;
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public void reorderList(ListNode head) {
        //find mid
        // reverse after mid
        // merge two lists

        if(head == null || head.next == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode reversed = reverse(mid);
        merge(head, reversed);


    }
    private ListNode middleNode(ListNode head) {
        ListNode prev = null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private void merge(ListNode l1 , ListNode l2){
        while(l2 != null){
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = temp;
        }
    }
}

// TC: O(n)
// SC: O(1)