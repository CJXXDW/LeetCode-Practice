import java.util.HashMap;

/**
 * 题目：四数相加 II (4Sum II)
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n 。
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 方法名：fourSumCount_454
 * 参数: int[] nums1  第一个数组
 * 参数: int[] nums2  第二个数组
 * 参数: int[] nums3  第三个数组
 * 参数: int[] nums4  第四个数组
 * 返回值: int        满足条件的元组个数
 *
 * 示例:
 * 输入: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出: 2
 *
 * 输入: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出: 1
 */
static int fourSumCount_454(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    // 请在此处实现你的代码
    int res = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    //统计两个数组中的元素之和，同时统计出现的次数，放入map
    for (int i : nums1) {
        for (int j : nums2) {
            int sum = i + j;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
    //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
    for (int i : nums3) {
        for (int j : nums4) {
            res += map.getOrDefault(0 - i - j, 0);
        }
    }
    return res;
}

public static void main(String[] args) {
    // --- 测试用例 1: 经典示例 ---
    int[] nums1_1 = {1, 2};
    int[] nums2_1 = {-2, -1};
    int[] nums3_1 = {-1, 2};
    int[] nums4_1 = {0, 2};
    System.out.println("Test 1 (example 1): " + (fourSumCount_454(nums1_1, nums2_1, nums3_1, nums4_1) == 2 ? "PASS" : "FAIL"));

    // --- 测试用例 2: 全零 ---
    int[] nums1_2 = {0};
    int[] nums2_2 = {0};
    int[] nums3_2 = {0};
    int[] nums4_2 = {0};
    System.out.println("Test 2 (all zero): " + (fourSumCount_454(nums1_2, nums2_2, nums3_2, nums4_2) == 1 ? "PASS" : "FAIL"));

    // --- 测试用例 3: 多组重复值 ---
    int[] nums1_3 = {1, 1};
    int[] nums2_3 = {-1, -1};
    int[] nums3_3 = {0, 0};
    int[] nums4_3 = {0, 0};
    System.out.println("Test 3 (duplicates): " + (fourSumCount_454(nums1_3, nums2_3, nums3_3, nums4_3) == 16 ? "PASS" : "FAIL"));

    // --- 测试用例 4: 无解 ---
    int[] nums1_4 = {1};
    int[] nums2_4 = {1};
    int[] nums3_4 = {1};
    int[] nums4_4 = {1};
    System.out.println("Test 4 (no solution): " + (fourSumCount_454(nums1_4, nums2_4, nums3_4, nums4_4) == 0 ? "PASS" : "FAIL"));

    // --- 测试用例 5: 含负数和正数 ---
    int[] nums1_5 = {-1, -1};
    int[] nums2_5 = {-1, 1};
    int[] nums3_5 = {-1, 1};
    int[] nums4_5 = {1, 1};
    System.out.println("Test 5 (mixed signs): " + (fourSumCount_454(nums1_5, nums2_5, nums3_5, nums4_5) == 8 ? "PASS" : "FAIL"));

    // --- 测试用例 6: 较大一些的组合 ---
    int[] nums1_6 = {0, 1, -1};
    int[] nums2_6 = {-1, 1, 0};
    int[] nums3_6 = {0, 0, 1};
    int[] nums4_6 = {-1, 1, 1};
    System.out.println("Test 6 (larger mix): " + (fourSumCount_454(nums1_6, nums2_6, nums3_6, nums4_6) == 17 ? "PASS" : "FAIL"));

    // --- 测试用例 7: 单元素非零 ---
    int[] nums1_7 = {2};
    int[] nums2_7 = {-2};
    int[] nums3_7 = {3};
    int[] nums4_7 = {-3};
    System.out.println("Test 7 (single exact zero): " + (fourSumCount_454(nums1_7, nums2_7, nums3_7, nums4_7) == 1 ? "PASS" : "FAIL"));
}
