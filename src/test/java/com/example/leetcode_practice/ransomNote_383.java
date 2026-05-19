import java.util.HashMap;
import java.util.Map;
/**
 * 题目：赎金信 (Ransom Note)
 * 给你两个字符串：ransomNote 和 magazine。
 * 判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true；否则返回 false。
 *
 * 方法名：ransomNote_383
 * 参数: String ransomNote  赎金信字符串
 * 参数: String magazine    杂志字符串
 * 返回值: boolean          是否可以构成
 *
 * 示例:
 * 输入: ransomNote = "a", magazine = "b"
 * 输出: false
 *
 * 输入: ransomNote = "aa", magazine = "ab"
 * 输出: false
 *
 * 输入: ransomNote = "aa", magazine = "aab"
 * 输出: true
 */
static boolean ransomNote_383(String ransomNote, String magazine) {
    // 本题当中由于只有小写字母，所以直接建造数组要比直接使用map更省空间
    if(ransomNote.length() > magazine.length()){//先判断后处理和创建变量会更加省时间，处理速度更快
        return false;
    }
    int[] record = new int[26];//可以直接用int类型做数组，对应的位置正好对应26个字母
    for(char c : magazine.toCharArray()){//记住常用for特殊循环
        record[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()){
        record[c - 'a']--;
        if(record[c - 'a'] < 0){
            return false;
        }
    }
    return true;
}

public static void main(String[] args) {
    // --- 测试用例 1: 无法构成 ---
    System.out.println("Test 1 (a, b): " + (!ransomNote_383("a", "b") ? "PASS" : "FAIL"));

    // --- 测试用例 2: 字符数量不足 ---
    System.out.println("Test 2 (aa, ab): " + (!ransomNote_383("aa", "ab") ? "PASS" : "FAIL"));

    // --- 测试用例 3: 可以构成 ---
    System.out.println("Test 3 (aa, aab): " + (ransomNote_383("aa", "aab") ? "PASS" : "FAIL"));

    // --- 测试用例 4: 空赎金信 ---
    System.out.println("Test 4 (empty ransomNote): " + (ransomNote_383("", "anything") ? "PASS" : "FAIL"));

    // --- 测试用例 5: magazine 为空 ---
    System.out.println("Test 5 (empty magazine): " + (!ransomNote_383("a", "") ? "PASS" : "FAIL"));

    // --- 测试用例 6: 完全相同字符串 ---
    System.out.println("Test 6 (same strings): " + (ransomNote_383("abc", "abc") ? "PASS" : "FAIL"));

    // --- 测试用例 7: 重复字符 ---
    System.out.println("Test 7 (repeated chars): " + (ransomNote_383("aab", "baa") ? "PASS" : "FAIL"));

//    // --- 测试用例 8: 大写小写区分 ---
//    System.out.println("Test 8 (case sensitive): " + (!ransomNote_383("Aa", "aA") ? "PASS" : "FAIL"));
}
