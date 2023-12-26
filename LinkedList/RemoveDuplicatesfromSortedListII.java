class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = new ListNode(-1);
        ListNode prev = newHead;
        ListNode curr = head;
        ListNode next = head.next;

        if(curr.val != next.val){
            prev.next = curr;
            prev = curr;
        }
        while(next != null){
            if(curr.val == next.val){
                curr = curr.next;
                next = next.next;
                continue;
            }
            else{
                curr = curr.next;
                next = next.next;

                if(next != null && curr.val == next.val){
                    continue;
                }
                prev.next = curr;
                prev = curr;
            }
        }
        prev.next = next;
        return newHead.next;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //using HashMap

        if(head == null || head.next == null){
            return head;
        }

        Map<Integer,Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            map.put(temp.val, map.getOrDefault(temp.val,0)+1);
            temp = temp.next;
        }
        ListNode result = new ListNode(0);
        temp = result;

        while(head !=  null){
            if(map.get(head.val) ==1){
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return result.next;
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode temp = dummy;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.next.val == head.val){
                    head = head.next;
                }
                temp.next = head.next;
            }
            else{
                temp = temp.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}

// TC: O(n)
// SC: O(1)