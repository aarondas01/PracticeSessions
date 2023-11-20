class Solution {
    public Node connect(Node root) {
        //iterative BFS
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node prev = null;
            int size = queue.size();
            for(int i=0 ; i< size; i++){

                Node curr = queue.poll();

                if(prev != null){
                    prev.next = curr;
                }
                prev = curr;

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}

// TC: O(n)
// SC: O(h)


class Solution {
    public Node connect(Node root) {
        //dfs
        if(root == null){
            return null;
        }

        Node head = root;
        while(head != null){
            Node curr = new Node();
            Node temp = curr;
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = curr.next;
        }
        return root;
    }
}

// TC: O(n)
// SC: O(1)