class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length + 1;
        int sum = len *(len-1) /2;
        int temp = 0;
        for(int num:nums){
            temp += num;
        }
        return sum - temp;

    }
}