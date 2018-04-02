package leetcode.array;

/**
 * 27.移除元素
 * 给定一个数组和一个值，在这个数组中原地移除指定值和返回移除后新的数组长度。
 * 不要为其他数组分配额外空间，你必须使用 O(1) 的额外内存原地修改这个输入数组。
 * 元素的顺序可以改变。超过返回的新的数组长度以外的数据无论是什么都没关系。
 * 示例:
 * 给定 nums = [3,2,3,2,3,2,3]，val = 2，
 * 你的函数应该返回 长度 = 4，数组的前四个元素是 3。
 * <p>
 * Created by lizhirong on 2018/3/28.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 3, 2, 3};

        int val = 2;
        int res = removeElement(nums, val);
        System.out.println(res);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeElement(int[] nums, int val) {
//        int length = nums.length;
//        int newLength = length;
//        for (int i = 0; i < length; i++) {
//            if (i < length - 1 && nums[i] == val) {
//                newLength--;
//                for (int j = i +1; j < length; j++) {
//                    if (nums[j] != val) {
//                        nums[i] = nums[j];
//                        break;
//                    }
//                }
//            }
//        }
//        return newLength;
        int newLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[newLength] = nums[i];
                newLength++;
            }
        }
        return newLength;
    }
}
