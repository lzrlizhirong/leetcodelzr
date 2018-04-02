package leetcode.array;

/**
 * 26.从排序数组中删除重复项
 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 * 示例：
 * 给定数组: nums = [1,1,2],
 * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
 * 不需要理会新的数组长度后面的元素
 * <p>
 * Created by lizhirong on 2018/3/28.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
//        int length = nums.length;
//        int newLength = length;
//        for (int i = 0; i < length; i++) {
//            if (i < length-2 && nums[i] + nums[i+1] == nums[i] * 2) {
//                newLength--;
//                nums[i+1] = nums[i+2];
//            }
//        }
//        return newLength;

        int length = nums.length;
        if (length == 0) return 0;
        int j = 0;
        for (int i = 0; i < length; ++i) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }

        return j + 1;
    }
}
