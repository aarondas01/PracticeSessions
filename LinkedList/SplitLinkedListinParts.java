class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // If there are N nodes in the list, and k parts, then every part has N/k elements, except the first N%k parts have an extra one.
        ListNode[] res = new ListNode[k];
        int total = 0;

        ListNode temp = head;
        while(temp != null){
            total++;
            temp = temp.next;
        }

        int parts = total/k;
        int remaining = total%k;

        ListNode curr = head;
        ListNode prev = null;

        int i = 0;
        while(curr != null && i < k){
            res[i] = curr;

            for(int j = 0 ; j < parts + (remaining > 0 ? 1 : 0); j++){
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            i++;
            remaining--;

        }
        return res;

    }
}

// TC: O(n+k)
// SC: O(k)

