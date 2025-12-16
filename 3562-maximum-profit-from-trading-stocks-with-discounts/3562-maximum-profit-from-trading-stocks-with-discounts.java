class Solution {
    private int[][][] dp;
    private List<Integer> adList[];

    private int getCost(int node, int curCost, int rep) {
        int cost = 0;
        if (rep == 0) {
            cost = Math.max(dp[node][curCost][0], dp[node][curCost][1]);
        } else if (rep == 1) {
            cost = Math.max(dp[node][curCost][0], dp[node][curCost][2]);
        } else {
            cost = Math.max(dp[node][curCost][0], Math.max(dp[node][curCost][1], dp[node][curCost][2]));
        }
        return cost;
    }

    private void dfs(int v, int[] present, int[] future, int budget) {
        if (budget <= 0) return;

        int profit = future[v] - present[v];
        int profitWithDiscount = future[v] - present[v] / 2;
        
        List<Integer> childNodes = new ArrayList<>();
        
        int[] child = new int[3];
        for (int u : adList[v]) {
            dfs(u, present, future, budget);
            childNodes.add(u);
        }
        int len = childNodes.size();
        for (int rep = 0; rep < 3; rep++) {

            int[][] childDp = new int[len + 1][budget + 1];

            for (int l = 0; l < len; l++) {
                int node = childNodes.get(l);
                
                for (int b = 0; b <= budget; b++) {
                    childDp[l + 1][b] = Math.max(childDp[l + 1][b], childDp[l][b]);
                    for (int cb = 0; cb <= budget; cb++) {
                        if (b + cb <= budget) {
                            childDp[l + 1][b + cb] = Math.max(childDp[l + 1][b + cb], childDp[l][b] + getCost(node, cb, rep));
                        }
                    }
                }
            }
            for (int b = 0; b <= budget; b++) {
                if (rep == 0) {
                    dp[v][b][0] = childDp[len][b];
                } else if (rep == 1) {
                    if (b - present[v] >= 0) {
                        dp[v][b][1] = childDp[len][b - present[v]] + profit;
                    }
                } else {
                    if (b - present[v] / 2 >= 0) {
                        dp[v][b][2] = childDp[len][b - present[v] / 2] + profitWithDiscount;
                    }
                }
            }
            
        }


    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        dp = new int[n][budget + 1][3];
        adList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int[] h : hierarchy) {
            int u = h[0] - 1;
            int v = h[1] - 1;
            adList[u].add(v);
        }
        dfs(0, present, future, budget);
        int solution = 0;
        for (int i = 0; i <= budget; i++) {
            solution = Math.max(solution, Math.max(dp[0][i][0], dp[0][i][1]));
        }
        return solution;
    }
}