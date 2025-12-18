class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> hs = new HashSet<>();

        for(int num:nums){
            hs.add(num);
        }

        while(hs.contains(original)){
            original *= 2;
        }

        return original;
    }
}