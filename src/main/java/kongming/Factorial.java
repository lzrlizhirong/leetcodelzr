package kongming;

import java.util.ArrayList;
import java.util.List;

/**
 * 各位数字的阶乘
 * 
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * 145是个神奇的数，因为 1! + 4! + 5! = 1 + 24 + 120 = 145
 * 找出所有各位数字的阶乘和等于其本身的数，并求它们的和。
 * 注意：因为 1! = 1 和 2! = 2 不是和的形式，因此不包括它们。
 * 
 * 分析：结束条件是各位数的和小于9!*7,即 2540160
 * 
 * Created by lizhirong on 2018/07/02.
 */
public class Factorial {

    public static void main(String[] args) {
//        System.out.println(getFactorial(9) * 8); //2903040
//        System.out.println(getFactorial(9) * 7); //2540160

        // 初始化0-9的阶乘,存在list中
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            list.add(getFactorial(i));
        }

        int sum = 0;
        // 因为是要各位数和的形式，故从10开始计算
        for (int j = 10; j <= 2540160; j++) {
            if (j == getSum(j, list)) {
                sum += j;
                System.out.println(j);
            }
        }
        System.out.println(sum);
    }
    
    //递归求n的阶乘
    public static int getFactorial(int n) {
        if (n == 1 || n == 0)
            return 1;
        else {
            return n * getFactorial(n - 1);
        }
    }

    public static int getSum(int number, List<Integer> list) {
        int sum = 0;
        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length(); i++) {
            int num = numberStr.charAt(i) - 48;
            sum += list.get(num);
        }
        return sum;
    }
}
