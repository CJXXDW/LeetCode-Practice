import java.util.HashSet;
import java.util.Set;

/**
 * 题目：快乐数 (Happy Number)
 * 编写一个算法来判断一个数 n 是否是快乐数。
 *
 * 方法名：happyNumber_202
 * 参数: int n  待判断的整数
 * 返回值: boolean  如果 n 是快乐数返回 true，否则返回 false
 *
 * 说明:
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，或者它将无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 * 输入: n = 19
 * 输出: true
 *
 * 输入: n = 2
 * 输出: false
 */
static private int getnextnum(int n){
    int res = 0;
    while(n > 0){
        int temp = n % 10;
        res = res + temp * temp;
        n = n / 10;
    }
    return res;
}
static boolean happyNumber_202(int n) {
    // 请在此处实现你的代码
    Set<Integer> record = new HashSet<>();
    while(n != 1 && !record.contains(n)){
        record.add(n);
        n = getnextnum(n);
    }
    return n == 1;
}

public static void main(String[] args) {
    // --- 测试用例 1: 经典快乐数 ---
    System.out.println("Test 1 (19): " + (happyNumber_202(19) == true ? "PASS" : "FAIL"));

    // --- 测试用例 2: 非快乐数 ---
    System.out.println("Test 2 (2): " + (happyNumber_202(2) == false ? "PASS" : "FAIL"));

    // --- 测试用例 3: 最小正整数 ---
    System.out.println("Test 3 (1): " + (happyNumber_202(1) == true ? "PASS" : "FAIL"));

    // --- 测试用例 4: 循环进入的典型值 ---
    System.out.println("Test 4 (4): " + (happyNumber_202(4) == false ? "PASS" : "FAIL"));

    // --- 测试用例 5: 较大的快乐数 ---
    System.out.println("Test 5 (100): " + (happyNumber_202(100) == true ? "PASS" : "FAIL"));

    // --- 测试用例 6: 较大的非快乐数 ---
    System.out.println("Test 6 (116): " + (happyNumber_202(116) == false ? "PASS" : "FAIL"));

    // --- 测试用例 7: 多位数快乐数 ---
    System.out.println("Test 7 (7): " + (happyNumber_202(7) == true ? "PASS" : "FAIL"));
}
