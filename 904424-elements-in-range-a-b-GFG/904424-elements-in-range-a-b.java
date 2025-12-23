class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        
        Arrays.sort(arr);
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int[] q : queries){
            int left = lowerBound(arr, q[0]);
            int right = upperBound(arr, q[1]);
            result.add(right - left);
        }
        return result;
        
    }
    
    private int lowerBound(int[] arr, int target){
        int l = 0; int r = arr.length;
        
        while (l < r){
            int mid = (l+r)/2;
            if(arr[mid] < target)l= mid+1;
            else r = mid;
        }
        return l;
    }
    
    private int upperBound(int[] arr, int target){
        int l = 0; int r = arr.length;
        
        while (l<r){
            int mid = (l+r)/2;
            if(arr[mid] <= target)l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
