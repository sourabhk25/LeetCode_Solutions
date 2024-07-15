class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        if (m == 0 && n == 0) {
            return 0;
        }
        
        // Convert primitive int arrays to Integer arrays for sorting with Collections
        Integer[] hCuts = Arrays.stream(horizontalCut).boxed().toArray(Integer[]::new);
        Integer[] vCuts = Arrays.stream(verticalCut).boxed().toArray(Integer[]::new);
        
        // Sort cuts in descending order of cost
        Arrays.sort(hCuts, Collections.reverseOrder());
        Arrays.sort(vCuts, Collections.reverseOrder());
        
        int hIndex = 0, vIndex = 0;
        int hCount = 1, vCount = 1;  // Start with 1 segment
        long totalCost = 0;
        
        // Process both lists of cuts
        while (hIndex < hCuts.length && vIndex < vCuts.length) {
            // Choose the more expensive cut to minimize total cost
            if (hCuts[hIndex] >= vCuts[vIndex]) {
                totalCost += hCuts[hIndex] * vCount;  // Multiply by the number of vertical segments
                hIndex++;
                hCount++;
            } else {
                totalCost += vCuts[vIndex] * hCount;  // Multiply by the number of horizontal segments
                vIndex++;
                vCount++;
            }
        }
        
        while (hIndex < hCuts.length) {
            totalCost += hCuts[hIndex] * vCount;  // Multiply by the number of vertical segments
            hIndex++;
        }
        
        while (vIndex < vCuts.length) {
            totalCost += vCuts[vIndex] * hCount;  // Multiply by the number of horizontal segments
            vIndex++;
        }
        
        return totalCost;
    }
}