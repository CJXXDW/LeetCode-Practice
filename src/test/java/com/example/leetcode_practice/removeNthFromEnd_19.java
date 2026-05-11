/**
 * 题目：删除链表的倒数第 N 个结点 (Remove Nth Node From End of List)
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 方法名: removeNthFromEnd_19
 * 参数: ListNode head  单链表的头节点
 * 参数: int n          倒数第 n 个节点 (1 <= n <= 链表长度)
 * 返回值: ListNode      删除节点后链表的头节点
 *
 * 示例:
 * 输入: head = [1,2,3,4,5], n = 2
 * 输出: [1,2,3,5]
 *
 * 输入: head = [1], n = 1
 * 输出: []
 *
 * 输入: head = [1,2], n = 1
 * 输出: [1]
 *
 * 输入: head = [1,2], n = 2
 * 输出: [2]
 */
public static class ListNode {
   int val;
   ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public static ListNode removeNthFromEnd_19(ListNode head, int n) {
    // 请在此处实现你的代码
    ListNode dummyhead = new ListNode();
    dummyhead.next = head;
    ListNode fast = dummyhead;
    ListNode slow = dummyhead;
    while(n-- > 0 && fast.next != null){
        fast =fast.next;
    }
    while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
    }
    slow.next =slow.next.next;
    return dummyhead.next;
}

public static void main(String[] args) {
    // --- 测试用例 1: [1,2,3,4,5], n=2 ---
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

    ListNode e1 = new ListNode(1);
    e1.next = new ListNode(2);
    e1.next.next = new ListNode(3);
    e1.next.next.next = new ListNode(5);

    ListNode r1 = removeNthFromEnd_19(n1, 2);
    System.out.println("Test 1 (5 nodes, n=2): " + (listEqual(r1, e1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: [1], n=1 (删除唯一节点) ---
    ListNode s1 = new ListNode(1);
    ListNode r2 = removeNthFromEnd_19(s1, 1);
    System.out.println("Test 2 (single node, n=1): " + (r2 == null ? "PASS" : "FAIL"));

    // --- 测试用例 3: [1,2], n=1 (删除最后一个节点) ---
    ListNode t1 = new ListNode(1);
    t1.next = new ListNode(2);

    ListNode e3 = new ListNode(1);
    ListNode r3 = removeNthFromEnd_19(t1, 1);
    System.out.println("Test 3 (2 nodes, n=1): " + (listEqual(r3, e3) ? "PASS" : "FAIL"));

    // --- 测试用例 4: [1,2], n=2 (删除第一个节点) ---
    ListNode u1 = new ListNode(1);
    u1.next = new ListNode(2);

    ListNode e4 = new ListNode(2);
    ListNode r4 = removeNthFromEnd_19(u1, 2);
    System.out.println("Test 4 (2 nodes, n=2): " + (listEqual(r4, e4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: [1,2,3,4,5,6,7,8,9,10], n=10 (删除第一个节点) ---
    ListNode[] nodes5 = new ListNode[10];
    for (int i = 0; i < 10; i++) {
        nodes5[i] = new ListNode(i + 1);
    }
    for (int i = 0; i < 9; i++) {
        nodes5[i].next = nodes5[i + 1];
    }

    ListNode e5 = new ListNode(2);
    ListNode curr = e5;
    for (int i = 3; i <= 10; i++) {
        curr.next = new ListNode(i);
        curr = curr.next;
    }

    ListNode r5 = removeNthFromEnd_19(nodes5[0], 10);
    System.out.println("Test 5 (10 nodes, n=10): " + (listEqual(r5, e5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: [1,2,3,4,5,6,7,8,9,10], n=5 (删除中间节点) ---
    ListNode[] nodes6 = new ListNode[10];
    for (int i = 0; i < 10; i++) {
        nodes6[i] = new ListNode(i + 1);
    }
    for (int i = 0; i < 9; i++) {
        nodes6[i].next = nodes6[i + 1];
    }

    ListNode e6 = new ListNode(1);
    curr = e6;
    for (int i = 2; i <= 10; i++) {
        if (i == 6) continue; // 跳过倒数第5个，即正数第6个
        curr.next = new ListNode(i);
        curr = curr.next;
    }

    ListNode r6 = removeNthFromEnd_19(nodes6[0], 5);
    System.out.println("Test 6 (10 nodes, n=5): " + (listEqual(r6, e6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: [-1,0,2,-3,4], n=3 ---
    ListNode v1 = new ListNode(-1);
    ListNode v2 = new ListNode(0);
    ListNode v3 = new ListNode(2);
    ListNode v4 = new ListNode(-3);
    ListNode v5 = new ListNode(4);
    v1.next = v2; v2.next = v3; v3.next = v4; v4.next = v5;

    ListNode e7 = new ListNode(-1);
    e7.next = new ListNode(0);
    e7.next.next = new ListNode(-3);
    e7.next.next.next = new ListNode(4);

    ListNode r7 = removeNthFromEnd_19(v1, 3);
    System.out.println("Test 7 (negative values, n=3): " + (listEqual(r7, e7) ? "PASS" : "FAIL"));
}

private static boolean listEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
        if (l1.val != l2.val) return false;
        l1 = l1.next;
        l2 = l2.next;
    }
    return l1 == null && l2 == null;
}