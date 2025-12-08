class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        int Min_remainder1 = 99999, Second_Min_remainder1 = 99999;
        int Min_remainder2 = 99999, Second_Min_remainder2 = 99999;

        for(int num:nums){
            total += num;
            if(num %3 == 1){
                if(num<Min_remainder1){
                    Second_Min_remainder1 = Min_remainder1;
                    Min_remainder1 = num;
                }
                else if(num < Second_Min_remainder1){
                    Second_Min_remainder1 = num;
                }
            }
            else if(num % 3 == 2){
                if(num < Min_remainder2){
                    Second_Min_remainder2 = Min_remainder2;
                    Min_remainder2 = num;
                }
                else if(num < Second_Min_remainder2){
                    Second_Min_remainder2 = num;
                }
            }
        }

        if(total % 3 == 0) return total;
        if(total %3 == 1){
            return Math.max(total - Min_remainder1, total - Min_remainder2 - Second_Min_remainder2);
        }
        return Math.max(total - Min_remainder2, total - Min_remainder1 - Second_Min_remainder1);

    }
}