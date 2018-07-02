package kongming;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 斐波拉契数列数列
 * <p>
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * F1 = 1 F2 = 1 F3 = 2 F4 = 3 F5 = 5 F6 = 8 F7 = 13 F8 = 21 F9 = 34 F10 = 55 F11 = 89 F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * <p>
 * Created by lizhirong on 2018/06/25.
 */
public class DigitFibonacciNumber {
    public int getDigits(int digits) {
        int[] a = new int[digits];
        a[0] = 1;
        int[] b = new int[digits];
        b[0] = 1;
        boolean addToA = true;
        int index = 2;
        int maxDigits = 1;
        while (maxDigits < digits) {
            int extraVal = 0;
            for (int idx = 0; idx <= maxDigits; idx++) {
                int sum = a[idx] + b[idx] + extraVal;
                if (addToA) {
                    a[idx] = (sum >= 10) ? sum - 10 : sum;
                } else {
                    b[idx] = (sum >= 10) ? sum - 10 : sum;
                }
                extraVal = (sum >= 10) ? 1 : 0;
            }

            addToA = !addToA;
            if (a[maxDigits] != 0 || b[maxDigits] != 0) {
                maxDigits++;
            }
            index++;
        }
       return index;
    }

    public static void main(String[] args) {
        DigitFibonacciNumber digitFibonacciNumber = new DigitFibonacciNumber();
        int digits = digitFibonacciNumber.getDigits(1000);
        System.out.print(digits);
    }
}
