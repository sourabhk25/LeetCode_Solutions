class Solution {
    // public int deleteAndEarn(int[] nums) {
    //     int max = 0;
    //     for(int num: nums) {
    //         max = Math.max(max, num);
    //     }

    //     //create array for points sum 
    //     int[] pointsArr = new int[max + 1];
    //     for(int num: nums) {
    //         pointsArr[num] += num;
    //     }

    //     //now problem is like house robber problem
    //     int prev = pointsArr[0]; //stores no choose values from previous 
    //     int curr = Math.max(pointsArr[0], pointsArr[1]); //option of choosing current or prev 

    //     for(int i = 2; i <= max; i++) {
    //         int temp = curr;
    //         curr = Math.max(curr, pointsArr[i] + prev);
    //         prev = temp;
    //     }

    //     return curr;
    // }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        //no need of input array anymore
        //iterate through map now
        //find prev and curr values as - 
        int prev = map.get(min);
        int curr = prev;
        if(map.containsKey(min + 1)) {
            curr = Math.max(prev, map.get(min + 1));
        }
        
        //iterate through range of min + 2  and max
        //since we already created prev and curr earlier
        for(int i = min + 2; i <= max; i++) {
            int temp = curr;
            if(map.containsKey(i)) {
                curr = Math.max(curr, map.get(i) + prev);
            } else {
                curr = Math.max(curr, 0 + prev);
            }
            prev = temp;
        }

        return curr;
    }
}