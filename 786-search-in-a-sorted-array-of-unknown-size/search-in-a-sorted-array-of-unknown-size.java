/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        //find the search space to reduce the search space and no of iterations
        while(reader.get(high) < target) {
            low = high;
            high = high * 2;    //multipply twice so that we would increase search space by 2, if we increase like *20 then logk in (logn + logk) will be large, *2 ensures n and k are close values
        }

        //found search space now do normal binary search 
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid) > target) {
                //lower half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        //not found 
        return -1;
    }
}