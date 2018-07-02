package kongming;

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
 * Created by lizhirong on 2018/06/27.
 */
public class DigitFibonacciNumber1 {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "1";
        int length = 1000;
        int index = 2;
        while (true) {
            index++;
            String tmp = getNum2(num1, num2);
//            System.out.println("tmp=" + tmp);
//            System.out.println();

            num1 = num2;
            num2 = tmp;

            if (num2.length() >= length) {
//                System.out.println(num2);
                System.out.println(index);
                break;
            }
        }
    }

    private static String getNum2(String num1, String num2) {
//        System.out.println("num1=" + num1);
//        System.out.println("num2=" + num2);

        int length1 = num1.length();
        int length2 = num2.length();

        // 将num1的位数补足，与num2位数保持一样，便于后面每一位做加法运算时进位
        if (length1 < length2) {
            String fill0 = "";
            for (int i = 0; i < length2 - length1; i++) {
                fill0 += "0";
            }
            num1 = fill0 + num1;
        }

        StringBuilder tmpNum = new StringBuilder();
        int carryNum = 0;
        for (int i = length2 - 1; i >= 0; i--) {
            //48，ASCII编码48到57为char字符'0'~'9'的编码
//            char c1 = num1.charAt(i);
//            char c2 = num2.charAt(i);
            int c1 = num1.charAt(i) - 48;
            int c2 = num2.charAt(i) - 48;

//            System.out.println("c1=" + c1);
//            System.out.println("c2=" + c2);

            if (c1 + c2 + carryNum < 10) {
                tmpNum = tmpNum.append(c1 + c2 + carryNum);
                carryNum = 0;
            } else {
                tmpNum = tmpNum.append((c1 + c2 + carryNum) - 10);
                carryNum = 1;
            }
        }

//        System.out.println("carryNum=" + carryNum);
        if (carryNum == 1) {
            tmpNum.append("1");
        }

        return tmpNum.reverse().toString();
    }
}
