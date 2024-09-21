class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicalNos = new ArrayList<>();
        int currentNo = 1;

        for(int i = 0; i < n; i++) {
            lexicalNos.add(currentNo);
            if(currentNo * 10 <= n) {
                currentNo *= 10;    //10*n is in limit so make it as currentNo
            } else {
                while(currentNo % 10 == 9 || currentNo >= n) {  //revert back condition 
                    currentNo /= 10;    //remove last digit
                }
                currentNo += 1; //add 1 to no
            }
        }

        return lexicalNos;
    }

}