/**
 * 题目：有效的字母异位词 (Valid Anagram)
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 方法名: isAnagram_242
 * 参数: String s  第一个字符串
 * 参数: String t  第二个字符串
 * 返回值: boolean  如果 t 是 s 的字母异位词返回 true，否则返回 false
 *
 * 示例:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public static boolean isAnagram_242(String s, String t) {
    // 请在此处实现你的代码
    int[] record = new int[26];
    for(int i = 0;i < s.length();i++){
        record[s.charAt(i) - 'a']++;
    }
    for(int i = 0;i < t.length();i++){
        record[t.charAt(i) - 'a']--;
    }
    for(int count : record){
        if(count != 0){
            return false;
        }
    }
    return true;
}

public static void main(String[] args) {
    // --- 测试用例 1: 标准字母异位词 ---
    System.out.println("Test 1 (anagram, nagaram): " +
            (isAnagram_242("anagram", "nagaram") == true ? "PASS" : "FAIL"));

    // --- 测试用例 2: 不是字母异位词 ---
    System.out.println("Test 2 (rat, car): " +
            (isAnagram_242("rat", "car") == false ? "PASS" : "FAIL"));

    // --- 测试用例 3: 空字符串 ---
    System.out.println("Test 3 (empty strings): " +
            (isAnagram_242("", "") == true ? "PASS" : "FAIL"));

    // --- 测试用例 4: 长度不同 ---
    System.out.println("Test 4 (different length): " +
            (isAnagram_242("a", "ab") == false ? "PASS" : "FAIL"));

    // --- 测试用例 5: 相同字符串 ---
    System.out.println("Test 5 (same string): " +
            (isAnagram_242("abc", "abc") == true ? "PASS" : "FAIL"));

    // --- 测试用例 6: 重复字符异位词 ---
    System.out.println("Test 6 (aacc, ccac): " +
            (isAnagram_242("aacc", "ccac") == false ? "PASS" : "FAIL"));

    // --- 测试用例 7: 长字符串异位词 ---
    String s7 = "abcdefghijklmnopqrstuvwxyz".repeat(1000);
    String t7 = "zyxwvutsrqponmlkjihgfedcba".repeat(1000);
    System.out.println("Test 7 (long anagram): " +
            (isAnagram_242(s7, t7) == true ? "PASS" : "FAIL"));

    // --- 测试用例 8: Unicode字符（进阶） ---
  //  System.out.println("Test 8 (Unicode - Chinese): " +
  //          (isAnagram_242("你好世界", "世界你好") == true ? "PASS" : "FAIL"));

    // --- 测试用例 9: 大小写敏感 ---
 //   System.out.println("Test 9 (case sensitive): " +
 //          (isAnagram_242("aBc", "cba") == false ? "PASS" : "FAIL"));
}