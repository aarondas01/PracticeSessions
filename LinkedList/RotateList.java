/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //brute force

        if (head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        int size = 0;


        while(temp != null){
            size++;
            temp = temp.next;
        }

        k %= size;

        int count = 0;
        while(count++ != k){
            temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }

            ListNode end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;

    }
}


// TC: O(n^2)
// SC: O(1)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //optimal

        if(head == null || head.next == null){
            return head;
        }

        int size =1;
        ListNode temp = head;

        while(temp.next != null){

            temp = temp.next;
            size++;
        }

        k %= size;
        k = size-k;
        temp.next = head;
        while(k-- > 0){
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;




    }
}

//TC: O(n)
//SC: O(1)
s