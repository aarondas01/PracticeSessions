class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //using binary search

        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKListsHelper(lists,0,lists.length-1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        if(start +1 == end){
            return merger(lists[start], lists[end]);
        }
        int mid = start + (end-start)/2;

        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid+1, end);

        return merger(left,right);
    }

    private ListNode merger(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}

// TC: O(n)
// SC: O(1)




class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(int i = 0; i < lists.length; i++){
            result = mergeTwoLists(result,lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l2 == null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

// TC: O(nlogk)
// SC: O(1)




class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode node : lists){
            while(node != null){
                pq.offer(node.val);
                node = node.next;
            }
        }

        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while(!pq.isEmpty()){
            head.next = new ListNode(pq.poll(), null);
            head = head.next;
        }

        return newList.next;
    }
}

// TC: O(m*n*logmn)
// SC: O(mn)



