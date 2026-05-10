/**
 * 题目：反转链表 (Reverse Linked List)
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 方法名: reverseList_206
 * 参数: ListNode head  单链表的头节点
 * 返回值: ListNode      反转后链表的头节点
 *
 * 示例:
 * 输入: head = [1,2,3,4,5]
 * 输出: [5,4,3,2,1]
 *
 * 输入: head = [1,2]
 * 输出: [2,1]
 *
 * 输入: head = []
 * 输出: []
 */
public static class ListNode {
  int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public static ListNode reverse(ListNode pre,ListNode cur){
    if(cur == null) return pre;
    ListNode temp = cur.next;
    cur.next = pre;
    // pre = cur;
    // cur = temp;
    return reverse(cur,temp);
}
public static ListNode reverseList_206(ListNode head) {
    // 请在此处实现你的代码
//    ListNode cur = head;
//    ListNode pre = null;
//    ListNode temp = cur;
//    while(cur != null){
//        temp = cur.next;
//        cur.next = pre;
//        pre = cur;
//        cur = temp;
//    }
//    return pre;
    ListNode cur = head;
    ListNode pre = null;
    return reverse(pre,cur);
}

public static void main(String[] args) {
    // --- 测试用例 1: 1->2->3->4->5 ---
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

    ListNode e1 = new ListNode(5);
    e1.next = new ListNode(4);
    e1.next.next = new ListNode(3);
    e1.next.next.next = new ListNode(2);
    e1.next.next.next.next = new ListNode(1);

    ListNode r1 = reverseList_206(n1);
    System.out.println("Test 1 (5 nodes): " + (listEqual(r1, e1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: 1->2 ---
    ListNode a1 = new ListNode(1);
    a1.next = new ListNode(2);

    ListNode e2 = new ListNode(2);
    e2.next = new ListNode(1);

    ListNode r2 = reverseList_206(a1);
    System.out.println("Test 2 (2 nodes): " + (listEqual(r2, e2) ? "PASS" : "FAIL"));

    // --- 测试用例 3: 空链表 ---
    ListNode r3 = reverseList_206(null);
    System.out.println("Test 3 (empty): " + (r3 == null ? "PASS" : "FAIL"));

    // --- 测试用例 4: 单节点链表 42 ---
    ListNode s1 = new ListNode(42);
    ListNode e4 = new ListNode(42);
    ListNode r4 = reverseList_206(s1);
    System.out.println("Test 4 (single node): " + (listEqual(r4, e4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: 包含负数 -3->0->7->-1 ---
    ListNode m1 = new ListNode(-3);
    ListNode m2 = new ListNode(0);
    ListNode m3 = new ListNode(7);
    ListNode m4 = new ListNode(-1);
    m1.next = m2; m2.next = m3; m3.next = m4;

    ListNode e5 = new ListNode(-1);
    e5.next = new ListNode(7);
    e5.next.next = new ListNode(0);
    e5.next.next.next = new ListNode(-3);

    ListNode r5 = reverseList_206(m1);
    System.out.println("Test 5 (negative values): " + (listEqual(r5, e5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: 较长链表 1->2->3->4->5->6->7->8->9->10 ---
    ListNode[] nodes6 = new ListNode[10];
    for (int i = 0; i < 10; i++) {
        nodes6[i] = new ListNode(i + 1);
    }
    for (int i = 0; i < 9; i++) {
        nodes6[i].next = nodes6[i + 1];
    }

    ListNode e6 = new ListNode(10);
    ListNode curr = e6;
    for (int i = 9; i >= 2; i--) {
        curr.next = new ListNode(i);
        curr = curr.next;
    }
    curr.next = new ListNode(1);

    ListNode r6 = reverseList_206(nodes6[0]);
    System.out.println("Test 6 (10 nodes): " + (listEqual(r6, e6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: 两个相同值节点 7->7 ---
    ListNode d1 = new ListNode(7);
    d1.next = new ListNode(7);

    ListNode e7 = new ListNode(7);
    e7.next = new ListNode(7);

    ListNode r7 = reverseList_206(d1);
    System.out.println("Test 7 (duplicate values): " + (listEqual(r7, e7) ? "PASS" : "FAIL"));
}

private static boolean listEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
        if (l1.val != l2.val) return false;
        l1 = l1.next;
        l2 = l2.next;
    }
    return l1 == null && l2 == null;
}