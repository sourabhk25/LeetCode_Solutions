class Solution {
    //heap - TC - nlogn + klogk
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
    //         int dist1 = Math.abs(a - x);
    //         int dist2 = Math.abs(b - x);
    //         if(dist1 == dist2) {
    //             return b - a;
    //         } else {
    //             return dist2 - dist1;
    //         }
    //     });

    //     for(int num: arr) {
    //         pq.add(num);
    //         if(pq.size() > k) {
    //             pq.poll();
    //         }
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     while(!pq.isEmpty()) {
    //         result.add(pq.poll());
    //     }

    //     Collections.sort(result);   //k log k-> to sort in ascending order

    //     return result;
    // }

    // 2 pointers
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int n = arr.length;
    //     int left = 0, right = n-1;

    //     while(right - left >= k) {
    //         int distL = Math.abs(arr[left] - x);
    //         int distR = Math.abs(arr[right] - x);

    //         if(distL > distR) {
    //             left++;
    //         } else {
    //             right--;
    //         }
    //     }  

    //     List<Integer> result = new ArrayList<>();
    //     for(int i = left; i <= right; i++) {
    //         result.add(arr[i]);
    //     }

    //     return result;
    // }

// binary search - lower bound - O(log(n - k) + k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n - k;

        //we are chaning directions based on distance so we cannot take absolute values and if we take abs values then we get WA
        
        while(low < high) {
            int mid = low + (high - low) / 2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            
            if(distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}