class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        for(int num:nums){
            sum+= num;
        }
        if(sum%k==0){
            return 0;
        }else{
            ans = sum %= k;
            return ans; 
        }
    }
}