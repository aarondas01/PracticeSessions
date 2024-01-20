class Solution {
    //QUestion from leetcode premium

    public ListNode removeDuplicateNodes(ListNode head) {
        Node node1 = null, node2 = null;
        Node dup = null;
        Node temp = head;

        while(temp != null && temp.next != null){
                node2 = temp;

                while(node2 != null){
                    if(temp.val == node2.val){
                        node2.next = node2.next.next;
                    }
                    else{
                        node2 = node2.next;
                    }
                }
             temp = temp.next;
        }
        return node1;
    }
}

//TC: O(n^2)
//SC: O(1)



//using HashSet

class Solution {
    //QUestion from leetcode premium

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        Node temp = head, prev = null;

        while(temp != null){
            if(set.contains(temp.val)){
                prev.next = temp.next;
            }
            else{
                set.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
        return prev;
    }
}

//TC: O(n)
//SC: O(n)