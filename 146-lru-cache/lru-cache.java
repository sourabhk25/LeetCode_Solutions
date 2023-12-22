class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;
    
    public ListNode (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> hmap;
    ListNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hmap = new HashMap<>();
        head = new ListNode(-1, -1);    //adding -1 as value due to constraints
        tail = new ListNode(-1, -1);    //adding -1 as value due to constraints
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)) {
            ListNode node = hmap.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)) {
            remove(hmap.get(key));
        }
        if(hmap.size() == capacity) {
            remove(tail.prev);
        }
        insert(new ListNode(key, value));
    }
    
    private void insert(ListNode node) {
        hmap.put(node.key, node);   //add in map
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void remove(ListNode node) {
        hmap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */