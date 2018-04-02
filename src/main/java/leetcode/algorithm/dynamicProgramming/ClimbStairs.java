package leetcode.algorithm.dynamicProgramming;

/**
 * 70. 爬楼梯
 * 你正在爬楼梯。需要 n 步你才能到达顶部。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
 * 注意：给定 n 将是一个正整数.
 *
 *  示例 1：
 *      输入： 2
 *      输出： 2
 *      说明： 有两种方法可以爬到顶端。
 *
 *      1.  1 步 + 1 步
 *      2.  2 步
 *
 *  示例 2：
 *
 *      输入： 3
 *      输出： 3
 *      说明： 有三种方法可以爬到顶端。
 *
 *      1.  1 步 + 1 步 + 1 步
 *      2.  1 步 + 2 步
 *      3.  2 步 + 1 步
 *
 * Created by lizhirong on 2018/4/2.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int res1 = climbStairs1(n1);
        int res2 = climbStairs2(n2);
        System.out.println(res1);
        System.out.println(res2);
    }


    /**
     * 这个爬梯子问题最开始看的时候没搞懂是让干啥的，后来看了别人的分析后，才知道实际上跟斐波那契数列非常相似，
     * 假设梯子有n层，那么如何爬到第n层呢，因为每次只能爬1或2步，那么爬到第n层的方法要么是从第n-1层一步上来的，要不就是从n-2层2步上来的，
     * 所以递推公式非常容易的就得出了：dp[n] = dp[n-1] + dp[n-2]。
     * 由于斐波那契额数列的求解可以用递归，所以我最先尝试了递归，拿到OJ上运行，显示Time Limit Exceeded，就是说运行时间超了，
     * 因为递归计算了很多分支，效率很低，这里需要用动态规划 (Dynamic Programming) 来提高效率.
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;//爬到第一层的方法，只有一种
        dp[1] = 2;//爬到第二层的方法，有两种，要么是一次一步爬上去，要么是直接两步上去
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 可以对空间进行进一步优化，只用两个整型变量a和b来存储过程值，
     * 首先将a+b的值赋给b，然后a赋值为原来的b，所以应该赋值为b-a即可。
     * 这样就模拟了上面累加的过程，而不用存储所有的值。
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            b += a;
            a = b - a;
        }
        return a;
    }
}
