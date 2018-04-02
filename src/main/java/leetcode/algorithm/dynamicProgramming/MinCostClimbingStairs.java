package leetcode.algorithm.dynamicProgramming;

import java.util.HashMap;

import static java.lang.Math.min;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 *  示例 1:
 *      输入: cost = [10, 15, 20]
 *      输出: 15
 *      解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *
 *  示例 2:
 *      输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 *      输出: 6
 *      解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 *  注意：
 *      cost 的长度将会在 [2, 1000]。
 *      每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 *
 * Created by lizhirong on 2018/4/2.
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int res1 = minCostClimbingStairs1(cost1);
        System.out.println(res1);

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int res2 = minCostClimbingStairs1(cost2);
        System.out.println(res2);
    }

    /**
     * 这道题应该算是之前那道Climbing Stairs的拓展，这里不是求步数，而是每个台阶上都有一个cost，让我们求爬到顶端的最小cost是多少。
     * 换汤不换药，还是用动态规划Dynamic Programming来做。
     * 这里我们定义一个一维的dp数组，其中dp[i]表示爬到第i层的最小cost，然后我们来想dp[i]如何推导。
     * 我们来思考一下如何才能到第i层呢？
     * 是不是只有两种可能性，一个是从第i-2层上直接跳上来，一个是从第i-1层上跳上来。
     * 不会再有别的方法，所以我们的dp[i]只和前两层有关系，所以可以写做如下：
     * dp[i] = min(dp[i- 2] + cost[i - 2], dp[i - 1] + cost[i - 1])
     * 最后我们返回最后一个数字dp[n]即可。
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; ++i) {
            dp[i] = min(dp[i- 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }

    /**
     * 再来看一种DP的解法，跟上面的解法很相近，
     * 不同在于dp数组长度为n，其中dp[i]表示到第i+1层的最小cost，分别初始化dp[0]和dp[1]为cost[0]和cost[1]。
     * 然后从i=2处开始遍历，此时我们的更新思路是，要爬当前的台阶，肯定需要加上当前的cost[i]，
     * 那么我们还是要从前一层或者前两层的台阶上跳上来，那么我们选择dp值小的那个，所以递归式如下：
     * dp[i] = cost[i] + min(dp[i- 1], dp[i - 2])
     * 最后我们在最后两个dp值中选择一个较小的返回即可。
     */
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0]; dp[1] = cost[1];
        for (int i = 2; i < n; ++i) {
            dp[i] = cost[i] + min(dp[i- 1], dp[i - 2]);
        }
        return min(dp[n - 1], dp[n - 2]);
    }

    /**
     * 我们可以对空间复杂度进行优化，
     * 通过前面的分析我们可以发现，当前的dp值仅仅依赖前面两个的值，
     * 所以我们不必把整个dp数组都记录下来，只需用两个变量a和b来记录前两个值，然后不停的用新得到的值来覆盖它们就好了。
     * 我们初始化a和b均为0，然后遍历cost数组，首先将a和b中较小值加上num放入临时变量t中，然后把b赋给a，把t赋给b即可。
     */
    public static int minCostClimbingStairs3(int[] cost) {
        int a = 0, b = 0;
        for (int num : cost) {
            int t = min(a, b) + num;
            a = b;
            b = t;
        }
        return min(a, b);
    }
}
