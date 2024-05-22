class Solution {
    private int squareSum(int num) {
        int sum = 0;
        while(num != 0) {
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = squareSum(n);
        }
        return n == 1;
    }
}