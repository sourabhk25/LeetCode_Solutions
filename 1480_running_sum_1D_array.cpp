#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        vector<int> ret;
        int sum = 0;
        for(int i=0; i<nums.size(); i++){
            sum += nums.at(i);
            ret.push_back(sum);
        }
        return ret;
    }
};