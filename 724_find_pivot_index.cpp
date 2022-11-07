#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int size = nums.size();
        int totalSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<size;i++)
            totalSum+= nums[i];
        
        if(totalSum - nums[0] == 0){
            return 0;
        } else{
            for(int i=1;i<size;i++){
                leftSum += nums[i-1];
                rightSum = totalSum - nums[i] - leftSum;
                if(leftSum == rightSum){
                    return i;
                }
            }
        }
        return -1;
    }

};