package leetcode.array;

/**
 * 35.搜索插入位置
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * 你可以假设在数组中无重复元素。
 * 案例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 案例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 案例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 案例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * Created by lizhirong on 2018/3/28.
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 3, 2, 3};
        int val = 2;
        int res = searchInsert(nums, val);
        System.out.println(res);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int searchInsert(int[] nums, int target) {

        return -1;
    }
}
