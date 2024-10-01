class Solution {
    public boolean canArrange(int[] arr, int k) {
        //VIMP - for negative and positive nos both module you need to use (x % k + k) % k
        Map<Integer, Integer> remainderCount = new HashMap<>(); //store remainder and count of that remainder in array
        for(int x: arr) {
            int rem = ((x % k) + k) % k;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        System.out.println(arr.length);
        //now go through array again, find remainder again
        //if remainder is 0 then check if count of these nos is even if not return false
        //else if count of rem and count of k - rem is not same then also return false because we cannot make all pairs
        //use Objects.equal method for checking it correctly -> != doesnt work correctly for large Integer numbers
        //at the end return true
        for(int x: arr) {
            int rem = ((x % k) + k) % k;
            if(rem == 0) {
                if(remainderCount.get(rem) % 2 == 1) {
                    return false;
                }
            } else if(!Objects.equals(remainderCount.get(rem), remainderCount.get(k - rem))) {
                return false;
            }
        }
        return true;
    }
}