public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //USING SET
        Set<ListNode> set = new HashSet<>();

        while(headA != null){
            set.add(headA);
            headA= headA.next;
        }

        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }
        return null;
    }
}

// TC: O(m+n)
// SC: O(m+n)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while(lenA > lenB){
            lenA--;
            headA = headA.next;
        }
        while(lenA < lenB){
            lenB--;
            headB = headB.next;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headB;
    }

    private int getListLength(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}

// TC: O(m+n)
// SC: O(1)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while( a!= b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}

// TC: O(m+n)
// SC: O(1)