public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast  = head, slow = head;
        boolean hasCycle = false;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                hasCycle = true;
                break;
            }

        }
        if(!hasCycle){
            return null;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}

// TC: O(n)
// SC: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //using HashSet
        Set<ListNode> set = new HashSet<>();

        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}

// TC: O(n)
// SC: O(n)


