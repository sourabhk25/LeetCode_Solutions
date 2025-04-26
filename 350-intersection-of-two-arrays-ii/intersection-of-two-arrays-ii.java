class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int n: nums1) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int num: nums2) {
            if(hmap.containsKey(num)) {
                result.add(num);
                hmap.put(num, hmap.get(num) - 1);
                hmap.remove(num, 0);    //this removes the num as key if its frequency becomes 0
            }
        }

        int[] output = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}