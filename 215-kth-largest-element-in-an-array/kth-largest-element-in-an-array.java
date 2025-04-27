class Solution {
    public int findKthLargest(int[] nums, int k) {        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);  //default are min heaps in Java
        for(int num: nums) { // o(n)
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();  //log k
            }
        }
        return pq.poll();
    }
}