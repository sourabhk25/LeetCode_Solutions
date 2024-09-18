class Solution {
    public String largestNumber(int[] nums) {
        //convert all int to String
        String[] numStrings = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        //sort with lambda function to get greater concatenated string
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));

        //handle a case when all numbers are 0 i.e. max num is 0
        if(numStrings[0].equals("0")) {
            return "0";
        }

        //create an output concatenated string
        StringBuilder ans = new StringBuilder();
        for(String str: numStrings) {
            ans.append(str);
        }

        return ans.toString();
    }
}