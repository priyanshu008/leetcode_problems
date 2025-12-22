// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int count = 0;
        int sum = 0;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length;j++){
                if (arr[i][j] == 1) sum++;
            }
            if (sum > count){
                count = sum;
                index = i;
            }
            sum = 0;
        }
        return index;
    }
}