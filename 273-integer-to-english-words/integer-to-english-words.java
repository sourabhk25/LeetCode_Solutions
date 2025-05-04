class Solution {
    String[] below_20 = new String[]{"", "One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = new String[]{"", " Thousand ", " Million ", " Billion "};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        } 

        int i = 0; 
        StringBuilder result = new StringBuilder();

        while(num > 0) {
            int triplet = num % 1000;   //get last 3 digits

            if(triplet > 0) {   //we dont want 100 000 hence checking 3 digits greater than 0
                result.insert(0, (helper(triplet).trim() + thousands[i])); //we need to prepend newly formed tuple string each time since we are going unit place to thousand place etc.    //here trim is added for cases like fifty thousand etc.
            }

            num = num / 1000;
            i++;
        }       

        return result.toString().trim();    //trim added to remove extra spaces in some testcases
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        if(num < 20) {
            result.append(below_20[num]);
        } else if(num < 100) {
            result.append(tens[num / 10]).append(" ").append(below_20[num % 10]);
        } else {
            result.append(below_20[num / 100]).append(" Hundred ").append(helper(num % 100));
        }
        return result.toString();
    }
}