class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        //binary search always on partition indices in nums1 hence 0 to n1
        int low = 0, high = n1;
        while(low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];  //if partX at index then L1 should be -INF else partX -1 index value from nums1
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX]; //similarly if partX is at n1 the value should be +INF else partX+1 the value in nums1

            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1) {  //correct partition
                if((n1 + n2) % 2 == 0) {    //even total
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {    //because we are handling as for odd total one extra element will always in right partition
                    return Math.min(R1, R2);
                }
            } else if(L1 > R2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }


        return 111; //we wont be reaching here
    }
}