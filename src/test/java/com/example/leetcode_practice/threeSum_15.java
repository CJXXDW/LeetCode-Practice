import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 题目：三数之和 (3Sum)
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k，并且 nums[i] + nums[j] + nums[k] == 0。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 方法名：threeSum_15
 * 参数: int[] nums   整数数组
 * 返回值: java.util.List<java.util.List<Integer>>  所有不重复三元组
 *
 * 示例:
 * 输入: nums = [-1,0,1,2,-1,-4]
 * 输出: [[-1,-1,2],[-1,0,1]]
 *
 * 输入: nums = [0,1,1]
 * 输出: []
 */
static java.util.List<java.util.List<Integer>> threeSum_15(int[] nums) {
    // 本题有两种解法，一种是用哈希法，另一种是使用双指针
    // 哈希法
//    List<List<Integer>> result = new ArrayList<>();
//    Arrays.sort(nums);
//
//    for(int i = 0; i < nums.length; i++){
//        // 如果第一个元素大于零，不可能凑成三元组
//        if (nums[i] > 0) {
//            return result;
//        }
//        // 三元组元素a去重
//        if (i > 0 && nums[i] == nums[i - 1]) {
//            continue;
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        for(int j = i + 1; j < nums.length; j++){
//            if(j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2] ){
//                continue;
//            }
//            int c = - nums[i] - nums[j];
//            if(set.contains(c)){
//                result.add(Arrays.asList(nums[i],nums[j],c));
//                set.remove(c);
//            }else{
//                set.add(nums[j]);
//            }
//        }
//    }
//    return result;
    //双指针法
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    // a = nums[i], b = nums[left], c = nums[right]
    for(int i = 0; i < nums.length; i++){
        if(nums[i] > 0){
            return result;
        }
        if(i > 0 && nums[i] == nums[i - 1]){
            continue;
        }

        int left = i + 1;
        int right = nums.length - 1;
        while(right > left){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum > 0) {
                right--;
            }else if(sum < 0 ){
                left++;
            }else{
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                while(right > left && nums[right] == nums[right - 1]) right--;
                while(right > left && nums[left] == nums[left + 1]) left++;
                right--;
                left++;
            }
        }
    }
    return result;
}

public static void main(String[] args) {
    // --- 测试用例 1: 经典示例 ---
    int[] nums1 = {-1, 0, 1, 2, -1, -4};
    java.util.List<java.util.List<Integer>> expected1 = buildTriplets(new int[][]{
            {-1, -1, 2},
            {-1, 0, 1}
    });
    System.out.println("Test 1 (classic): " + (listOfListEqual(threeSum_15(nums1), expected1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: 无解 ---
    int[] nums2 = {0, 1, 1};
    java.util.List<java.util.List<Integer>> expected2 = new java.util.ArrayList<>();
    System.out.println("Test 2 (no solution): " + (listOfListEqual(threeSum_15(nums2), expected2) ? "PASS" : "FAIL"));

    // --- 测试用例 3: 全零 ---
    int[] nums3 = {0, 0, 0, 0};
    java.util.List<java.util.List<Integer>> expected3 = buildTriplets(new int[][]{
            {0, 0, 0}
    });
    System.out.println("Test 3 (all zero): " + (listOfListEqual(threeSum_15(nums3), expected3) ? "PASS" : "FAIL"));

    // --- 测试用例 4: 负数为主 ---
    int[] nums4 = {-2, 0, 1, 1, 2};
    java.util.List<java.util.List<Integer>> expected4 = buildTriplets(new int[][]{
            {-2, 0, 2},
            {-2, 1, 1}
    });
    System.out.println("Test 4 (mixed values): " + (listOfListEqual(threeSum_15(nums4), expected4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: 结果较多 ---
    int[] nums5 = {-4, -2, -1, 0, 1, 2, 3};
    java.util.List<java.util.List<Integer>> expected5 = buildTriplets(new int[][]{
            {-4, 1, 3},
            {-2, -1, 3},
            {-2, 0, 2},
            {-1, 0, 1}
    });
    System.out.println("Test 5 (multiple answers): " + (listOfListEqual(threeSum_15(nums5), expected5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: 边界短数组 ---
    int[] nums6 = {1, 2};
    java.util.List<java.util.List<Integer>> expected6 = new java.util.ArrayList<>();
    System.out.println("Test 6 (too short): " + (listOfListEqual(threeSum_15(nums6), expected6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: 重复元素 ---
    int[] nums7 = {-2, -2, 0, 0, 2, 2};
    java.util.List<java.util.List<Integer>> expected7 = buildTriplets(new int[][]{
            {-2, 0, 2}
    });
    System.out.println("Test 7 (duplicates): " + (listOfListEqual(threeSum_15(nums7), expected7) ? "PASS" : "FAIL"));
}

private static java.util.List<java.util.List<Integer>> buildTriplets(int[][] data) {
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    for (int[] triplet : data) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int num : triplet) {
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
    java.util.List<String> a = normalizeTriplets(actual);
    java.util.List<String> e = normalizeTriplets(expected);
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

private static java.util.List<String> normalizeTriplets(java.util.List<java.util.List<Integer>> list) {
    java.util.List<String> result = new java.util.ArrayList<>();
    for (java.util.List<Integer> triplet : list) {
        java.util.List<Integer> copy = new java.util.ArrayList<>(triplet);
        java.util.Collections.sort(copy);
        result.add(copy.toString());
    }
    java.util.Collections.sort(result);
    return result;
}
