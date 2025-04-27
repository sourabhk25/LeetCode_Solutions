class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);   //sort array based on starting time
        PriorityQueue<Integer> meetingRooms = new PriorityQueue<>((a,b) -> a - b);    //min-heap for end time of meetings
        meetingRooms.add(intervals[0][1]);  //adding first element's end index

        for(int i = 1; i < intervals.length; i++) {
            if(meetingRooms.peek() <= intervals[i][0]) {
                meetingRooms.poll();
            }

            meetingRooms.add(intervals[i][1]);
        }

        return meetingRooms.size();
    }
}