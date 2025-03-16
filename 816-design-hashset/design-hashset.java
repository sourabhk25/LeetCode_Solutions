class MyHashSet {

    boolean[][] storge;
    int primaryBuckets;
    int secondaryBuckets;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storge = new boolean[this.primaryBuckets][];
    }
    
    private int getPrimaryHashKey(int key) {
        return key % this.primaryBuckets;
    }

    private int getSecondaryHashKey(int key) {
        return key / this.secondaryBuckets;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(storge[primaryIndex] == null) {
            if(primaryIndex == 0) {
                storge[primaryIndex] = new boolean[this.secondaryBuckets + 1];    
            } else {
                storge[primaryIndex] = new boolean[this.secondaryBuckets];
            }
        }
        int secondaryIndex = getSecondaryHashKey(key);
        storge[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(storge[primaryIndex] == null) {
            return;
        }
        int secondaryIndex = getSecondaryHashKey(key);
        storge[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = getPrimaryHashKey(key);
        if(storge[primaryIndex] == null) {
            return false;
        }
        int secondaryIndex = getSecondaryHashKey(key);
        return storge[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */