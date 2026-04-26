/**
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组 nums 和一个正整数 target，
 * 找出该数组中满足其总和 >= target 的长度最小的 连续子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是满足条件的最小长度子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * - 1 <= target <= 10^9
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 *
 * 进阶：
 * - 如果你已经实现 O(n) 时间复杂度的解法，请尝试设计 O(n log n) 的解法
 */
public static int minSubArrayLen_209(int target, int[] nums) {
    int left = 0;
    int sum = 0;
    int result = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (sum >= target) {
            result = Math.min(result, right - left + 1);
            sum -= nums[left++];
        }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
}

public static void main(String[] args) {
    int[] nums1 = {2,3,1,2,4,3};
    System.out.println(minSubArrayLen_209(7, nums1)); // 期望: 2

    int[] nums2 = {1,4,4};
    System.out.println(minSubArrayLen_209(4, nums2)); // 期望: 1

    int[] nums3 = {1,1,1,1,1,1,1,1};
    System.out.println(minSubArrayLen_209(11, nums3)); // 期望: 0

    int[] nums4 = {1,2,3,4,5};
    System.out.println(minSubArrayLen_209(11, nums4)); // 期望: 3（[3,4,5]）

    int[] nums5 = {5};
    System.out.println(minSubArrayLen_209(5, nums5)); // 期望: 1

    int[] nums6 = {1,2,3};
    System.out.println(minSubArrayLen_209(7, nums6)); // 期望: 0

    int[] nums7 = {1,2,3,4,5};
    System.out.println(minSubArrayLen_209(15, nums7)); // 期望: 5

    int[] nums8 = {1,2,3,4,5};
    System.out.println(minSubArrayLen_209(16, nums8)); // 期望: 0
}