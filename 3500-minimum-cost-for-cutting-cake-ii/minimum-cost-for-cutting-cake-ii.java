class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        if(m == 0 && n == 0) {
            return 0;
        }
        // Convert int[] to Integer[] to use Collections.reverseOrder()
        Integer[] hCuts = Arrays.stream(horizontalCut).boxed().toArray(Integer[]::new);
        Integer[] vCuts = Arrays.stream(verticalCut).boxed().toArray(Integer[]::new);
        
        // Sort the cuts in descending order of cost
        Arrays.sort(hCuts, Collections.reverseOrder());
        Arrays.sort(vCuts, Collections.reverseOrder());
        
        // Priority queues to hold the cuts, initially sorted by cost
        PriorityQueue<Integer> hQueue = new PriorityQueue<>(Arrays.asList(hCuts));
        PriorityQueue<Integer> vQueue = new PriorityQueue<>(Arrays.asList(vCuts));
        
        int hIndex = 0, vIndex = 0;
        int hCount = 1, vCount = 1;
        long totalCost = 0;
        
        while (hIndex < hCuts.length && vIndex < vCuts.length) {
            if (hCuts[hIndex] >= vCuts[vIndex]) {
                totalCost += hCuts[hIndex] * vCount;
                hIndex++;
                hCount++;
            } else {
                totalCost += vCuts[vIndex] * hCount;
                vIndex++;
                vCount++;
            }
        }
        
        // Process remaining horizontal cuts
        while (hIndex < hCuts.length) {
            totalCost += hCuts[hIndex] * vCount;
            hIndex++;
        }
        
        // Process remaining vertical cuts
        while (vIndex < vCuts.length) {
            totalCost += vCuts[vIndex] * hCount;
            vIndex++;
        }
        
        return totalCost;
    }
}