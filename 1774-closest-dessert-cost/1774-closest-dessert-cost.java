class Solution {
    int ret;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ret = baseCosts[0];

        for (int base : baseCosts) {
            dfs(0, base, toppingCosts, target);
        }

        return ret;
    }

    private void dfs(int index, int currentCost, int[] toppingCosts, int target) {
        int currentDiff = Math.abs(currentCost - target);
        int bestDiff = Math.abs(ret - target);

        if (currentDiff < bestDiff) {
            ret = currentCost;
        } else if (currentDiff == bestDiff) {
            ret = Math.min(ret, currentCost);
        }

        if (index == toppingCosts.length || currentCost > target) {
            return;
        }

        for (int i = 0; i <= 2; i++) {
            dfs(index + 1, currentCost + (toppingCosts[index] * i), toppingCosts, target);
        }
    }
}