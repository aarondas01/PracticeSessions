
class Solution {
    HashMap<Node , Node > map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node,newNode);

        for(Node nd : node.neighbors){
            newNode.neighbors.add(cloneGraph(nd));
        }
        return newNode;
    }
}


class Solution {
    public Node cloneGraph(Node node) {
        //BFS
        if(node == null){
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node,newNode);


        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node curr= queue.poll();
            List<Node> newNeighbors = map.get(curr).neighbors;

            for(Node nd : curr.neighbors){
                if(!map.containsKey(nd)){
                    map.put(nd, new Node(nd.val));
                    queue.add(nd);
                }
                newNeighbors.add(map.get(nd));
            }
        }
        return newNode;
    }
}

// TC: O(V+E)
// SC: O(V)


class Solution {
    public Node cloneGraph(Node node) {
        //DFS
        return cloneGraphDFS(node, new HashMap<>());
    }

    private Node cloneGraphDFS(Node curr, HashMap<Node,Node> visited){
        if(curr == null){
            return null;
        }

        if(visited.containsKey(curr)){
            return visited.get(curr);
        }

        Node newNode = new Node(curr.val);
        visited.put(curr,newNode);

        for(Node nd  : curr.neighbors){
            newNode.neighbors.add(cloneGraphDFS(nd,visited));
        }

        return newNode;
    }
}
//
// TC: O(V+E)
// SC: O(V)