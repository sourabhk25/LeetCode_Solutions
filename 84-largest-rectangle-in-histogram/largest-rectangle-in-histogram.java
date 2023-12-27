class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= n; i++) {
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {  //found decending or last extra iteration when stack not empty
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()) {  //stack becomes empty like for last remaining column
                    width = i;
                } else {
                    width = i - st.peek() - 1;  //width is curent index - new top - 1
                }
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        return maxArea;
    }
}