class LRUCache {
    //implement using doubly linked list

    //Node class
    private class Node{
        Node next ;
        Node prev ;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    //create doubly linked list
    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);

    //map to store key and its node
    Map<Integer,Node> map = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //node set as most recently used by placing it right next to head
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //if map contains key remove the node from the map
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        // if map has reached max capacity , remove the LRU node right before tail node
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    //remove the node from the current position and remove mapping from HashMap
    private void remove(Node node){
        map.remove(node.key);

        //delete the node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //add the node to the right next of the head and put the mapping to the hashmap
    private void insert(Node node){
        map.put(node.key,node);

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//  TC: O(1)
//  SC: O(n)