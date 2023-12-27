class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //recursion

        ListNode temp = head;
        for(int i = 0 ; i < k ; i++){
            if(temp == null){
                return head;
            }
            temp = temp.next;
        }
        ListNode rev = reverseKGroup(temp,k);
        ListNode prev = null;
        ListNode curr = head;

        for(int i =0 ;i <k ; i++){
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        head.next = rev;
        return prev;
    }
}

// TC: O(n)
// SC: O(1)