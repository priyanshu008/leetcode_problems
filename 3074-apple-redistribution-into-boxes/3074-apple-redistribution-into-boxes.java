class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int su = 0;
        for(int a : apple){
            su += a;
        }
        int cap = 0;
        int count = 0;

        for(int i = capacity.length-1; i >= 0; i--){
            cap += capacity[i];
            count++;
            if (cap >= su) return count;
        }
        return count;
    }
}