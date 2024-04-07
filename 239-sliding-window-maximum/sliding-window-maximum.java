class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //using Deque to store index of elements in decreasing order
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int output[] = new int[n - k + 1];
        int outputIndex = 0;
        for(int i = 0; i < n; i++) {
            //remove numbers out of range k
            if(!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            //remove index of numbers which are less than ith number
            //go from back to front since numbers stored in decending order
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();   //remove index
            }

            //add index i to deque
            deque.offer(i);
            //start finding maximum after i is greater than required window size
            if(i >= k - 1) {
                output[outputIndex++] = nums[deque.peek()]; //add front from deque to output array at outputIndex
            }
        }
        return output;
    }
}