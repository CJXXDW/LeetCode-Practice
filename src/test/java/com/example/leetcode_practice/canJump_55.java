/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组 nums，你最初位于数组的第一个下标。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到下标 1，然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标 3，但该位置的最大跳跃长度是 0，
 *      所以永远无法到达最后一个下标。
 *
 * 提示：
 * - 1 <= nums.length <= 10^4
 * - 0 <= nums[i] <= 10^5
 */
static boolean canJump_55(int[] nums) {
    int cover = 0;
    int n = nums.length;
    for(int i = 0; i < n; ++i){
        if(i <= cover){
            cover = Math.max(cover, i + nums[i]);
            if (cover >=n-1){
                return true;
            }
        }
    }
    return false;
}
public static void main(String[] args) {
    int[] nums1 = {2,3,1,1,4};
    System.out.println(canJump_55(nums1)); // 期望输出: true

    int[] nums2 = {3,2,1,0,4};
    System.out.println(canJump_55(nums2)); // 期望输出: false

    int[] nums3 = {0};
    System.out.println(canJump_55(nums3)); // 期望输出: true

    int[] nums4 = {2,0,0};
    System.out.println(canJump_55(nums4)); // 期望输出: true
}