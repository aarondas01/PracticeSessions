class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        Node temp = head;

        while(temp != null){
            Node next = temp.next;
            Node random = temp.random;
            temp.next = new Node(temp.val, next, random);
            temp = temp.next.next;
        }

        Node newHead = head.next;
        temp = head;

        //moving the original linkedlist
        while(temp != null){
            Node next = temp.next;
            if(next.random != null){
                next.random = next.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;

        // moving the copy linked list
        while(temp != null){
            Node copy = temp.next;
            temp.next = copy.next;
            if(copy.next != null){
                copy.next = temp.next.next;
            }
            temp = temp.next;
        }

        return newHead;
    }
}

// TC: O(n)
// SC: O(1)



/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head ==null){
            return head;
        }

        Map<Node,Node> map = new HashMap<>();

        Node curr = head;

        while(curr != null){
            Node copy = new Node(curr.val);
            map.put(curr,copy);
            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}

// TC: O(n)
// SC: O(n)


