class MedianFinder {
    
    //2 heaps approach
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());    
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || minHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            if(maxHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }

        int n = maxHeap.size();
        int m = minHeap.size();
        if(n - m == 2 || n - m == -2) {
            if(n > m) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int n = maxHeap.size();
        int m = minHeap.size();
        
        if((n + m) % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            if(n > m) {
                return (double) maxHeap.peek();
            } else {
                return (double) minHeap.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */