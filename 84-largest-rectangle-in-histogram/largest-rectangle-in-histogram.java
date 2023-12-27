class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        //filling leftSmall
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = st.peek() + 1;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {    //empty stack for reuse
            st.pop();
        }

        //filling rightSmall
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = st.peek() - 1;
            }
            st.push(i);
        }

        //calculate ans
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, (rightSmall[i] - leftSmall[i] + 1) * heights[i]);
        }
        return ans;
    }
}