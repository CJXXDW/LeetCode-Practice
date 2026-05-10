/**
 * 题目：两两交换链表中的节点 (Swap Nodes in Pairs)
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部值的情况下完成本题（即，只能进行节点交换）。
 *
 * 方法名: swapPairs_24
 * 参数: ListNode head  单链表的头节点
 * 返回值: ListNode      两两交换后链表的头节点
 *
 * 示例:
 * 输入: head = [1,2,3,4]
 * 输出: [2,1,4,3]
 *
 * 输入: head = []
 * 输出: []
 *
 * 输入: head = [1]
 * 输出: [1]
 *
 * 输入: head = [1,2,3]
 * 输出: [2,1,3]
 */
public static class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public static ListNode swapPairs_24(ListNode head) {
    // 请在此处实现你的代码
    if(head == null || head.next == null) return head;
    ListNode next = head.next;
    ListNode continuelist = swapPairs_24(next.next);
    next.next = head;
    head.next =continuelist;
    return next;
}

public static void main(String[] args) {
    // --- 测试用例 1: 1->2->3->4 ---
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    n1.next = n2; n2.next = n3; n3.next = n4;

    ListNode e1 = new ListNode(2);
    e1.next = new ListNode(1);
    e1.next.next = new ListNode(4);
    e1.next.next.next = new ListNode(3);

    ListNode r1 = swapPairs_24(n1);
    System.out.println("Test 1 (4 nodes): " + (listEqual(r1, e1) ? "PASS" : "FAIL"));

    // --- 测试用例 2: 空链表 ---
    ListNode r2 = swapPairs_24(null);
    System.out.println("Test 2 (empty): " + (r2 == null ? "PASS" : "FAIL"));

    // --- 测试用例 3: 单节点链表 1 ---
    ListNode s1 = new ListNode(1);
    ListNode e3 = new ListNode(1);
    ListNode r3 = swapPairs_24(s1);
    System.out.println("Test 3 (single node): " + (listEqual(r3, e3) ? "PASS" : "FAIL"));

    // --- 测试用例 4: 1->2->3 (奇数个节点) ---
    ListNode o1 = new ListNode(1);
    ListNode o2 = new ListNode(2);
    ListNode o3 = new ListNode(3);
    o1.next = o2; o2.next = o3;

    ListNode e4 = new ListNode(2);
    e4.next = new ListNode(1);
    e4.next.next = new ListNode(3);

    ListNode r4 = swapPairs_24(o1);
    System.out.println("Test 4 (3 nodes): " + (listEqual(r4, e4) ? "PASS" : "FAIL"));

    // --- 测试用例 5: 1->2 (两个节点) ---
    ListNode t1 = new ListNode(1);
    t1.next = new ListNode(2);

    ListNode e5 = new ListNode(2);
    e5.next = new ListNode(1);

    ListNode r5 = swapPairs_24(t1);
    System.out.println("Test 5 (2 nodes): " + (listEqual(r5, e5) ? "PASS" : "FAIL"));

    // --- 测试用例 6: 1->2->3->4->5->6 (6个节点) ---
    ListNode[] nodes6 = new ListNode[6];
    for (int i = 0; i < 6; i++) {
        nodes6[i] = new ListNode(i + 1);
    }
    for (int i = 0; i < 5; i++) {
        nodes6[i].next = nodes6[i + 1];
    }

    ListNode e6 = new ListNode(2);
    e6.next = new ListNode(1);
    e6.next.next = new ListNode(4);
    e6.next.next.next = new ListNode(3);
    e6.next.next.next.next = new ListNode(6);
    e6.next.next.next.next.next = new ListNode(5);

    ListNode r6 = swapPairs_24(nodes6[0]);
    System.out.println("Test 6 (6 nodes): " + (listEqual(r6, e6) ? "PASS" : "FAIL"));

    // --- 测试用例 7: 包含负数和零 -1->0->2->-3->4 ---
    ListNode v1 = new ListNode(-1);
    ListNode v2 = new ListNode(0);
    ListNode v3 = new ListNode(2);
    ListNode v4 = new ListNode(-3);
    ListNode v5 = new ListNode(4);
    v1.next = v2; v2.next = v3; v3.next = v4; v4.next = v5;

    ListNode e7 = new ListNode(0);
    e7.next = new ListNode(-1);
    e7.next.next = new ListNode(-3);
    e7.next.next.next = new ListNode(2);
    e7.next.next.next.next = new ListNode(4);

    ListNode r7 = swapPairs_24(v1);
    System.out.println("Test 7 (negative values, 5 nodes): " + (listEqual(r7, e7) ? "PASS" : "FAIL"));
}

private static boolean listEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
        if (l1.val != l2.val) return false;
        l1 = l1.next;
        l2 = l2.next;
    }
    return l1 == null && l2 == null;
}