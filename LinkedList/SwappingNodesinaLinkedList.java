class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null){
            return head;
        }

        ListNode slow = head, fast = head;

        ListNode node1 = null, node2 = null;

        for(int i =1; i < k ; i++){
            fast = fast.next;
        }
        node1 = fast;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        node2 = slow;

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        return head;
    }
}

// TC: O(n)
// SC: O(1)

