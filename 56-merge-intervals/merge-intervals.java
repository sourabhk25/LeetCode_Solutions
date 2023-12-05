class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer. compare(a[0], b[0])); //sort intervals by start time
        
        for(int i=0; i<intervals.length; i++) { //loop in all intervals
            if(ans.isEmpty() || ans.getLast()[1] < intervals[i][0]) {   //add interval if ans is empty or end of last interval in ans is less than start of current interval i.e. non-overlapping interval
                ans.add(intervals[i]);
            } else {    //overlapping intervals
                ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]); //find max of end time and merge intervals
            }
        }
        
        return ans.toArray(new int[ans.size()][]);  //convert ans to int[][] and return
    }
}