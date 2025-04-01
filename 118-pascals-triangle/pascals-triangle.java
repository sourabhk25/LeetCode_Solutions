class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        //base case: if numRows is 0, just return empty list
        if (numRows == 0) {
            return output;
        }

        //the first row is always [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        output.add(firstRow);

        //create next rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = output.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            //first element in each row is always 1
            currentRow.add(1);

            //middle elements are sums of adjacent elements from the previous row
            for (int j = 1; j < prev.size(); j++) {
                currentRow.add(prev.get(j - 1) + prev.get(j));
            }

            //last element in each row is always 1
            currentRow.add(1);
            //add row to list
            output.add(currentRow);
        }
        return output;
    }
}