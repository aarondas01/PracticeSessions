class Solution {
    public Node connect(Node root) {
        //bfs using extra space

        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node temp = null;

            while(size-- >0){
                Node node = queue.poll();
                node.next = temp;
                temp = node;
        // take right node first
                if(node.right != null){
                    queue.add(node.right);
                }

                if(node.left != null){
                    queue.add(node.left);
                }
            }

        }
        return root;
    }
}

// TC: O(n)
// SC: O(logn)

class Solution {
    public Node connect(Node root) {
        //bfs without using extra space

        if(root == null)
            return null;

        Node node = root;

        while(node.left != null){
            Node curr = node;

            while(true){
                curr.left.next = curr.right;
                if(curr.next == null){
                    break;
                }
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            node = node.left;
        }
        return root;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public Node connect(Node root) {
        // DFS recursion

        if(root == null){
            return null;
        }
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = (root.next == null) ? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

// TC: O(n)
// SC: O(1)