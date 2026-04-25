/**
 * 704. 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 你必须编写一个时间复杂度为 O(log n) 的算法。
 *
 * 示例 1：
 * 输入：nums = [-1,0,3,5,9,12], target = 9
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [-1,0,3,5,9,12], target = 2
 * 输出：-1
 *
 * 提示：
 * - 1 <= nums.length <= 10^4
 * - -10^4 < nums[i], target < 10^4
 * - nums 中的所有元素是唯一的
 * - nums 是升序数组
 */
public static int search_704(int[] nums, int target) {
int left = 0;
int right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid;
    }else if (nums[mid] > target) {
        right = mid - 1;
    }
    else if (nums[mid] < target) {
        left = mid + 1;
    }
}
return -1;
}

public static void main(String[] args) {
    int[] nums1 = {-1,0,3,5,9,12};
    System.out.println(search_704(nums1, 9));  // 期望: 4

    int[] nums2 = {-1,0,3,5,9,12};
    System.out.println(search_704(nums2, 2));  // 期望: -1

    int[] nums3 = {1};
    System.out.println(search_704(nums3, 1));  // 期望: 0

    int[] nums4 = {1};
    System.out.println(search_704(nums4, 0));  // 期望: -1

    int[] nums5 = {1,2,3,4,5,6};
    System.out.println(search_704(nums5, 1));  // 期望: 0

    int[] nums6 = {1,2,3,4,5,6};
    System.out.println(search_704(nums6, 6));  // 期望: 5

    int[] nums7 = {1,2,3,4,5,6};
    System.out.println(search_704(nums7, 4));  // 期望: 3

    int[] nums8 = {2,5};
    System.out.println(search_704(nums8, 2));  // 期望: 0

    int[] nums9 = {2,5};
    System.out.println(search_704(nums9, 5));  // 期望: 1

    int[] nums10 = {2,5};
    System.out.println(search_704(nums10, 3)); // 期望: -1
}