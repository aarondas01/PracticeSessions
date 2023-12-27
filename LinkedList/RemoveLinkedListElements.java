class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head  == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;

        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //recursion

        if(head == null){
            return null;
        }

        ListNode dummy = removeElements(head.next,val);

        if(head.val == val){
            return dummy;
        }
        head.next= dummy;
        return head;
    }
}

// TC: O(N)
// SC: O(N)


