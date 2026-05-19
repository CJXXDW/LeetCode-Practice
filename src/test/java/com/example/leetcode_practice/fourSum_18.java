import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：四数之和 (4Sum)
 * 给你一个由 n 个整数组成的数组 nums，和一个目标值 target。
 * 请你找出并返回满足下述全部条件且不重复的四元组：
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 且 a、b、c 和 d 互不相同。
 *
 * 方法名：fourSum_18
 * 参数: int[] nums   整数数组
 * 参数: int target   目标值
 * 返回值: java.util.List<java.util.List<Integer>>  所有不重复四元组
 *
 * 示例:
 * 输入: nums = [1,0,-1,0,-2,2], target = 0
 * 输出: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 输入: nums = [2,2,2,2,2], target = 8
 * 输出: [[2,2,2,2]]
 */
static java.util.List<java.util.List<Integer>> fourSum_18(int[] nums, int target) {
    // 本题就是在15题三数之和的基础上的延申，双指针法的作用就是使得时间复杂度降低一个层级
    Arrays.sort(nums);  // 排序数组
    List<List<Integer>> result = new ArrayList<>();  // 结果集
    for(int k = 0; k < nums.length; k++){
        // 剪枝处理
        if (nums[k] > target && nums[k] >= 0) {
            break;	// 此处的break可以等价于return result;
        }
        if (k > 0 && nums[k] == nums[k - 1]) {
            continue;
        }
        for(int i = k + 1; i < nums.length; i++){
            // 第二级剪枝
            if (nums[k] + nums[i] > target && nums[k] + nums[i] >= 0) {
                break;	// 注意是break到上一级for循环，如果直接return result;会有遗漏
            }
            // 对nums[i]去重
            if (i > k + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(right > left){
                long sum = (long)nums[k] + nums[i] + nums[left] + nums[right];//防止溢出，转化数据类型，java会根据第一个转化的自动将后面的int转化成long
                if(sum > target){
                    right--;
                } else if (sum <target) {
                    left++;
                }else{
                    result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                    while(right > left && nums[right] == nums[right - 1]) right--;
                    while(right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
    }
    return result;
}
public static void main(String[] args) {
    // --- 测试用例 1: 经典示例 ---
    int[] nums1 = {1, 0, -1, 0, -2, 2};
    java.util.List<java.util.List<Integer>> expected1 = buildQuadruplets(new int[][]{
            {-2, -1, 1, 2},
            {-2, 0, 0, 2},
            {-1, 0, 0, 1}
    });
    System.out.println("Test 1 (classic): " + (listOfListEqual(fourSum_18(nums1, 0), expected1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: 全相同元素 ---
    int[] nums2 = {2, 2, 2, 2, 2};
    java.util.List<java.util.List<Integer>> expected2 = buildQuadruplets(new int[][]{
            {2, 2, 2, 2}
    });
    System.out.println("Test 2 (all same): " + (listOfListEqual(fourSum_18(nums2, 8), expected2) ? "PASS" : "FAIL"));

    // --- 测试用例 3: 无解 ---
    int[] nums3 = {1, 2, 3, 4};
    java.util.List<java.util.List<Integer>> expected3 = new java.util.ArrayList<>();
    System.out.println("Test 3 (no solution): " + (listOfListEqual(fourSum_18(nums3, 100), expected3) ? "PASS" : "FAIL"));

    // --- 测试用例 4: 含负数 ---
    int[] nums4 = {-3, -1, 0, 2, 4, 5};
    java.util.List<java.util.List<Integer>> expected4 = buildQuadruplets(new int[][]{
            {-3, -1, 0, 4}
    });
    System.out.println("Test 4 (negative values): " + (listOfListEqual(fourSum_18(nums4, 0), expected4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: 多组结果 ---
    int[] nums5 = {-2, -1, -1, 1, 1, 2, 2};
    java.util.List<java.util.List<Integer>> expected5 = buildQuadruplets(new int[][]{
            {-2, -1, 1, 2},
            {-1, -1, 1, 1}
    });
    System.out.println("Test 5 (multiple answers): " + (listOfListEqual(fourSum_18(nums5, 0), expected5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: 边界较小数组 ---
    int[] nums6 = {1, 2, 3};
    java.util.List<java.util.List<Integer>> expected6 = new java.util.ArrayList<>();
    System.out.println("Test 6 (too short): " + (listOfListEqual(fourSum_18(nums6, 6), expected6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: 重复零元素 ---
    int[] nums7 = {0, 0, 0, 0, 0, 0};
    java.util.List<java.util.List<Integer>> expected7 = buildQuadruplets(new int[][]{
            {0, 0, 0, 0}
    });
    System.out.println("Test 7 (all zero): " + (listOfListEqual(fourSum_18(nums7, 0), expected7) ? "PASS" : "FAIL"));
}

private static java.util.List<java.util.List<Integer>> buildQuadruplets(int[][] data) {
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    for (int[] quad : data) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int num : quad) {
            list.add(num);
        }
        result.add(list);
    }
    return result;
}

private static boolean listOfListEqual(java.util.List<java.util.List<Integer>> actual,
                                       java.util.List<java.util.List<Integer>> expected) {
    if (actual == null || expected == null) {
        return actual == expected;
    }
    java.util.List<String> a = normalizeQuadruplets(actual);
    java.util.List<String> e = normalizeQuadruplets(expected);
    if (a.size() != e.size()) {
        return false;
    }
    for (int i = 0; i < a.size(); i++) {
        if (!a.get(i).equals(e.get(i))) {
            return false;
        }
    }
    return true;
}

private static java.util.List<String> normalizeQuadruplets(java.util.List<java.util.List<Integer>> list) {
    java.util.List<String> result = new java.util.ArrayList<>();
    for (java.util.List<Integer> quad : list) {
        java.util.List<Integer> copy = new java.util.ArrayList<>(quad);
        java.util.Collections.sort(copy);
        result.add(copy.toString());
    }
    java.util.Collections.sort(result);
    return result;
}
