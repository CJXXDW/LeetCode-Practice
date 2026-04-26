/**
 * 977. 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 * - 1 <= nums.length <= 10^4
 * - -10^4 <= nums[i] <= 10^4
 * - nums 已按 非递减顺序 排序
 *
 * 进阶：
 * - 请你设计时间复杂度为 O(n) 的算法
 */
public static int[] sortedSquares_977(int[] nums) {
    int k = nums.length;
    int[] result =new int[k];
    for(int i = 0,j = k - 1,n = k - 1;i <= j; ){
        if(nums[i] * nums[i] > nums[j] * nums[j]){
            result[n] = nums[i] * nums[i];
            n--;
            i++;
        }else {
            result[n] = nums[j] * nums[j];
            n--;
            j--;
        }
    }
    return result;
}

public static void main(String[] args) {
    int[] nums1 = {-4,-1,0,3,10};
    System.out.println(java.util.Arrays.toString(sortedSquares_977(nums1)));
    // 期望: [0, 1, 9, 16, 100]

    int[] nums2 = {-7,-3,2,3,11};
    System.out.println(java.util.Arrays.toString(sortedSquares_977(nums2)));
    // 期望: [4, 9, 9, 49, 121]

    int[] nums3 = {-5,-3,-2,-1};
    System.out.println(java.util.Arrays.toString(sortedSquares_977(nums3)));
    // 期望: [1, 4, 9, 25]

    int[] nums4 = {0,1,2,3};
    System.out.println(java.util.Arrays.toString(sortedSquares_977(nums4)));
    // 期望: [0, 1, 4, 9]

    int[] nums5 = {-2,0};
    System.out.println(java.util.Arrays.toString(sortedSquares_977(nums5)));
    // 期望: [0, 4]
}