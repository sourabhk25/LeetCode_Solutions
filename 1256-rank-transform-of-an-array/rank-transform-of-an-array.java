class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> numAndRankMap = new HashMap<>();  //map to store num and its rank
        int[] sortedArr = Arrays.copyOf(arr, arr.length);   //make a copy of arr to sort
        Arrays.sort(sortedArr);
        int rank = 1;   //temp var to store rank of numbers
        for(int i = 0; i < sortedArr.length; i++) {
            if(i > 0 && sortedArr[i] > sortedArr[i-1]) {
                rank++;
            }
            numAndRankMap.put(sortedArr[i], rank);  //add sorted num and its rank
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = numAndRankMap.get(arr[i]); //replace arr with its rank
        }
        return arr;
    }
    //time - O(nlogn)
    //space - O(n + S) -> S for sorting in java since Quick sort is used internally
}