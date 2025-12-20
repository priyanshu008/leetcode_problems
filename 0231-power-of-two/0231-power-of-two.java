class Solution {
    public boolean isPowerOfTwo(int n) {

        while(n > 0){
            if (n==1) return true;
            if(n%2==0){
                if(n == 0){return true;}
                n /= 2;
            }else if(n%2 != 0){
                return false;
            }
        }
        return false;
    }
}