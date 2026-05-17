/**
 * 题目：两个数组的交集 (Intersection of Two Arrays)
 * 给定两个整数数组 nums1 和 nums2，返回它们的交集。
 * 结果中的每个元素一定是唯一的，且可以按任意顺序返回。
 *
 * 方法名：intersection_349
 * 参数: int[] nums1  第一个整数数组
 * 参数: int[] nums2  第二个整数数组
 * 返回值: int[]      两个数组的交集，元素唯一，顺序不限
 *
 * 示例:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
import java.util.HashSet;
import java.util.Set;
static int[] intersection_349(int[] nums1, int[] nums2) {
    // 请在此处实现你的代码
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
        return new int[0];
    }
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> reset = new HashSet<>();
    for(int i :nums1){
        set1.add(i);
    }
    for(int i :nums2){
        if(set1.contains(i)){
            reset.add(i);
        }
    }
    return reset.stream().mapToInt(Integer::intValue).toArray();
}

public static void main(String[] args) {
    // --- 测试用例 1: 典型重复元素 ---
    int[] nums1_1 = {1, 2, 2, 1};
    int[] nums2_1 = {2, 2};
    int[] expected1 = {2};
    int[] result1 = intersection_349(nums1_1, nums2_1);
    System.out.println("Test 1 (simple duplicate): " + (arrayEqual(result1, expected1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: 交集顺序无要求 ---
    int[] nums1_2 = {4, 9, 5};
    int[] nums2_2 = {9, 4, 9, 8, 4};
    int[] expected2 = {4, 9};
    int[] result2 = intersection_349(nums1_2, nums2_2);
    System.out.println("Test 2 (order free): " + (arrayEqual(result2, expected2) ? "PASS" : "FAIL"));

    // --- 测试用例 3: 无交集 ---
    int[] nums1_3 = {1, 3, 5};
    int[] nums2_3 = {2, 4, 6};
    int[] expected3 = {};
    int[] result3 = intersection_349(nums1_3, nums2_3);
    System.out.println("Test 3 (no intersection): " + (arrayEqual(result3, expected3) ? "PASS" : "FAIL"));

    // --- 测试用例 4: 一边为空数组 ---
    int[] nums1_4 = {};
    int[] nums2_4 = {1, 2, 3};
    int[] expected4 = {};
    int[] result4 = intersection_349(nums1_4, nums2_4);
    System.out.println("Test 4 (empty first array): " + (arrayEqual(result4, expected4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: 两边都为空数组 ---
    int[] nums1_5 = {};
    int[] nums2_5 = {};
    int[] expected5 = {};
    int[] result5 = intersection_349(nums1_5, nums2_5);
    System.out.println("Test 5 (both empty): " + (arrayEqual(result5, expected5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: 大量重复元素 ---
    int[] nums1_6 = {1, 1, 1, 1, 2, 2, 3, 3, 4};
    int[] nums2_6 = {1, 1, 2, 2, 2, 4, 4, 6};
    int[] expected6 = {1, 2, 4};
    int[] result6 = intersection_349(nums1_6, nums2_6);
    System.out.println("Test 6 (many duplicates): " + (arrayEqual(result6, expected6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: 含负数 ---
    int[] nums1_7 = {-3, -2, -1, 0, 1};
    int[] nums2_7 = {-1, 0, 2, 3};
    int[] expected7 = {-1, 0};
    int[] result7 = intersection_349(nums1_7, nums2_7);
    System.out.println("Test 7 (negative values): " + (arrayEqual(result7, expected7) ? "PASS" : "FAIL"));

    // --- 测试用例 8: 长数组 ---
    int[] nums1_8 = new int[100];
    int[] nums2_8 = new int[100];
    for (int i = 0; i < 100; i++) {
        nums1_8[i] = i % 10;
        nums2_8[i] = (i + 5) % 10;
    }
    int[] expected8 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] result8 = intersection_349(nums1_8, nums2_8);
    System.out.println("Test 8 (long arrays): " + (arrayEqual(result8, expected8) ? "PASS" : "FAIL"));
}

private static boolean arrayEqual(int[] arr1, int[] arr2) {
    if (arr1 == null || arr2 == null) {
        return arr1 == arr2;
    }
    if (arr1.length != arr2.length) {
        return false;
    }
    int[] copy1 = arr1.clone();
    int[] copy2 = arr2.clone();
    java.util.Arrays.sort(copy1);
    java.util.Arrays.sort(copy2);
    for (int i = 0; i < copy1.length; i++) {
        if (copy1[i] != copy2[i]) {
            return false;
        }
    }
    return true;
}
