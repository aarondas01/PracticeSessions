class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }

        int size =1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        k = k%size;
        k = size -k;
        temp.next = head;
        while(k-->0){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}

// TC: O(n)
// SC: O(1)

