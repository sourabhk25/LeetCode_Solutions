class MyHashMap {

    //linear chaining -> array main, for each primaryIndex create linkedLists
    Node[] storage;
    int buckets;

    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];
    }
    
    private int getPrimaryHashKey(int key) {
        return key % this.buckets;
    }

    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;   //iterators
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int primaryIndex = getPrimaryHashKey(key);
        if(this.storage[primaryIndex] == null) {
            //create dummy node first
            this.storage[primaryIndex] = new Node(-1, -1);
            this.storage[primaryIndex].next = new Node(key, value);
        }
        Node prev = getPrev(this.storage[primaryIndex], key);        
        if(prev.next == null) { //key is not present
            prev.next = new Node(key, value);
        } else {    //key is present then update the value
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(this.storage[primaryIndex] == null) {    //bucket empty
            return -1;
        }
        Node prev = getPrev(this.storage[primaryIndex], key);
        if(prev.next == null) { //end of list ie key not found
            return -1;
        } else {
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(this.storage[primaryIndex] == null) {    //bucket empty
            return;
        }
        Node prev = getPrev(this.storage[primaryIndex], key);
        if(prev.next == null) { //key not found return
            return;
        }
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */