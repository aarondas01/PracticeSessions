class Solution {
    public ListNode sortList(ListNode head) {
        //merge sort
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode secondStart = middle.next;
        middle.next = null;


        ListNode leftHalf = mergeSort(head);
        ListNode rightHalf = mergeSort(secondStart);


        ListNode mergedList = mergeTwoLists(leftHalf,rightHalf);
        return mergedList;
    }

    private ListNode getMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list2 == null){
            return list1;
        }

        if(list1 == null){
            return list2;
        }

        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}

// TC: O(nlogn)
// SC: O(1)

class Solution {
    public ListNode sortList(ListNode head) {
        //using heap
        if(head == null){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        ListNode temp = head;

        while(temp != null){
            pq.offer(temp);
            temp = temp.next;
        }

        ListNode newNode = new ListNode();
        ListNode newHead = newNode;

        while(!pq.isEmpty()){
            newNode.next = new ListNode(pq.poll().val);
            newNode = newNode.next;
        }

        return newHead.next;
    }
}

// TC: O(nlogn)
// SC: O(n)