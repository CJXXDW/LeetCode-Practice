import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两数之和 (Two Sum)
 * 给定一个整数数组 nums 和一个整数 target，请你在该数组中找出和为 target 的那两个整数，并返回它们的数组下标。
 *
 * 方法名：twoSum_1
 * 参数: int[] nums   整数数组
 * 参数: int target   目标值
 * 返回值: int[]      满足条件的两个下标
 *
 * 示例:
 * 输入: nums = [2,7,11,15], target = 9
 * 输出: [0,1]
 *
 * 输入: nums = [3,2,4], target = 6
 * 输出: [1,2]
 */
static int[] twoSum_1(int[] nums, int target) {
    // 请在此处实现你的代码
    int[] res = new int[2];
    if(nums == null || nums.length ==0){
        return res;
    }
    Map<Integer,Integer> map =new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        int temp = target - nums[i];
        if(map.containsKey(temp)){
            res[1] = i;
            res[0] = map.get(temp);//如果匹配上说明之前的元素已经存在了map里，所以这个元素后面才能赋值
            break;
        }
       map.put(nums[i],i);
    }
    return res;
}

public static void main(String[] args) {
    // --- 测试用例 1: 经典示例 ---
    int[] nums1 = {2, 7, 11, 15};
    int[] expected1 = {0, 1};
    System.out.println("Test 1 (2,7,11,15 / 9): " + (arrayEqual(twoSum_1(nums1, 9), expected1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: 中间元素组成答案 ---
    int[] nums2 = {3, 2, 4};
    int[] expected2 = {1, 2};
    System.out.println("Test 2 (3,2,4 / 6): " + (arrayEqual(twoSum_1(nums2, 6), expected2) ? "PASS" : "FAIL"));

    // --- 测试用例 3: 重复元素 ---
    int[] nums3 = {3, 3};
    int[] expected3 = {0, 1};
    System.out.println("Test 3 (3,3 / 6): " + (arrayEqual(twoSum_1(nums3, 6), expected3) ? "PASS" : "FAIL"));

    // --- 测试用例 4: 包含负数 ---
    int[] nums4 = {-1, -2, -3, -4, -5};
    int[] expected4 = {2, 4};
    System.out.println("Test 4 (-1,-2,-3,-4,-5 / -8): " + (arrayEqual(twoSum_1(nums4, -8), expected4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: 答案在前后两端 ---
    int[] nums5 = {1, 5, 3, 7, 9};
    int[] expected5 = {1, 3};
    System.out.println("Test 5 (1,5,3,7,9 / 12): " + (arrayEqual(twoSum_1(nums5, 12), expected5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: 较长数组 ---
    int[] nums6 = {10, 22, 5, 75, 65, 80};
    int[] expected6 = {2, 4};
    System.out.println("Test 6 (10,22,5,75,65,80 / 70): " + (arrayEqual(twoSum_1(nums6, 70), expected6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: 末尾元素组合 ---
    int[] nums7 = {4, 1, 9, 7, 5};
    int[] expected7 = {0, 4};
    System.out.println("Test 7 (4,1,9,7,5 / 9): " + (arrayEqual(twoSum_1(nums7, 9), expected7) ? "PASS" : "FAIL"));
}

private static boolean arrayEqual(int[] arr1, int[] arr2) {
    if (arr1 == null || arr2 == null) {
        return arr1 == arr2;
    }
    if (arr1.length != arr2.length) {
        return false;
    }
    for (int i = 0; i < arr1.length; i++) {
        if (arr1[i] != arr2[i]) {
            return false;
        }
    }
    return true;
}
