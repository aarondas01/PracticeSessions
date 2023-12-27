class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);

        ListNode oddHead = odd, evenHead = even;

        ListNode temp = head;
        int count =1;

        while (temp != null){
            if(count % 2==1){
                oddHead.next = temp;
                oddHead = oddHead.next;
            }
            else{
                evenHead.next = temp;
                evenHead = evenHead.next;
            }
            temp = temp.next;
            count++;
        }

        evenHead.next = null;
        oddHead.next = even.next;

        return odd.next;
    }
}

// TC: O(N)
// SC: O(1)


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        ListNode oddHead  = head;
        ListNode evenHead = head.next;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

// TC: O(N)
// SC: O(1)