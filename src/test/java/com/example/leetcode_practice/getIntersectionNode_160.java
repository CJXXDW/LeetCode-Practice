/**
 * 题目：相交链表 (Intersection of Two Linked Lists)
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * 题目数据保证整个链式结构中不存在环。
 * 函数返回结果后，链表必须保持其原始结构。
 *
 * 方法名: getIntersectionNode_160
 * 参数: ListNode headA  链表A的头节点
 * 参数: ListNode headB  链表B的头节点
 * 返回值: ListNode       相交的起始节点，如果不相交则返回 null
 *
 * 示例:
 * 输入: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出: 节点 8
 *
 * 输入: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出: 节点 2
 *
 * 输入: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出: null
 */
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public static ListNode getIntersectionNode_160(ListNode headA, ListNode headB) {
    // 请在此处实现你的代码
    ListNode up = headA;
    ListNode down = headB;
    while(up != down){
        if(up == null) up = headB;
        else up = up.next;
        if(down == null) down = headA;
        else down =down.next;
    }
    return up;
}

public static void main(String[] args) {
    // --- 测试用例 1: 相交链表，相交节点值为8 ---
    // A: 4 -> 1 -> 8 -> 4 -> 5
    // B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
    ListNode common1 = new ListNode(8);
    common1.next = new ListNode(4);
    common1.next.next = new ListNode(5);

    ListNode a1 = new ListNode(4);
    a1.next = new ListNode(1);
    a1.next.next = common1;

    ListNode b1 = new ListNode(5);
    b1.next = new ListNode(6);
    b1.next.next = new ListNode(1);
    b1.next.next.next = common1;

    ListNode r1 = getIntersectionNode_160(a1, b1);
    System.out.println("Test 1 (intersect at 8): " + (r1 != null && r1.val == 8 ? "PASS" : "FAIL"));

    // --- 测试用例 2: 相交链表，相交节点值为2 ---
    // A: 1 -> 9 -> 1 -> 2 -> 4
    // B: 3 -> 2 -> 4
    ListNode common2 = new ListNode(2);
    common2.next = new ListNode(4);

    ListNode a2 = new ListNode(1);
    a2.next = new ListNode(9);
    a2.next.next = new ListNode(1);
    a2.next.next.next = common2;

    ListNode b2 = new ListNode(3);
    b2.next = common2;

    ListNode r2 = getIntersectionNode_160(a2, b2);
    System.out.println("Test 2 (intersect at 2): " + (r2 != null && r2.val == 2 ? "PASS" : "FAIL"));

    // --- 测试用例 3: 不相交 ---
    // A: 2 -> 6 -> 4
    // B: 1 -> 5
    ListNode a3 = new ListNode(2);
    a3.next = new ListNode(6);
    a3.next.next = new ListNode(4);

    ListNode b3 = new ListNode(1);
    b3.next = new ListNode(5);

    ListNode r3 = getIntersectionNode_160(a3, b3);
    System.out.println("Test 3 (no intersection): " + (r3 == null ? "PASS" : "FAIL"));

    // --- 测试用例 4: 其中一个链表为空 ---
    ListNode a4 = new ListNode(1);
    a4.next = new ListNode(2);

    ListNode r4 = getIntersectionNode_160(a4, null);
    System.out.println("Test 4 (B is null): " + (r4 == null ? "PASS" : "FAIL"));

    // --- 测试用例 5: 两个链表都为空 ---
    ListNode r5 = getIntersectionNode_160(null, null);
    System.out.println("Test 5 (both null): " + (r5 == null ? "PASS" : "FAIL"));

    // --- 测试用例 6: 从第一个节点就开始相交 ---
    // A: 1 -> 2 -> 3
    // B: 1 -> 2 -> 3
    ListNode common6 = new ListNode(1);
    common6.next = new ListNode(2);
    common6.next.next = new ListNode(3);

    ListNode r6 = getIntersectionNode_160(common6, common6);
    System.out.println("Test 6 (same list): " + (r6 != null && r6.val == 1 ? "PASS" : "FAIL"));

    // --- 测试用例 7: 相交在最后一个节点 ---
    // A: 1 -> 2 -> 3 -> 4
    // B: 5 -> 6 -> 4
    ListNode common7 = new ListNode(4);

    ListNode a7 = new ListNode(1);
    a7.next = new ListNode(2);
    a7.next.next = new ListNode(3);
    a7.next.next.next = common7;

    ListNode b7 = new ListNode(5);
    b7.next = new ListNode(6);
    b7.next.next = common7;

    ListNode r7 = getIntersectionNode_160(a7, b7);
    System.out.println("Test 7 (intersect at last node 4): " + (r7 != null && r7.val == 4 ? "PASS" : "FAIL"));

    // --- 测试用例 8: 长度相同但不相交 ---
    ListNode a8 = new ListNode(1);
    a8.next = new ListNode(2);
    a8.next.next = new ListNode(3);

    ListNode b8 = new ListNode(4);
    b8.next = new ListNode(5);
    b8.next.next = new ListNode(6);

    ListNode r8 = getIntersectionNode_160(a8, b8);
    System.out.println("Test 8 (same length, no intersection): " + (r8 == null ? "PASS" : "FAIL"));

    // --- 测试用例 9: 包含负数的相交链表 ---
    ListNode common9 = new ListNode(-1);
    common9.next = new ListNode(2);

    ListNode a9 = new ListNode(-3);
    a9.next = new ListNode(0);
    a9.next.next = common9;

    ListNode b9 = new ListNode(5);
    b9.next = new ListNode(-4);
    b9.next.next = new ListNode(7);
    b9.next.next.next = common9;

    ListNode r9 = getIntersectionNode_160(a9, b9);
    System.out.println("Test 9 (negative values, intersect at -1): " + (r9 != null && r9.val == -1 ? "PASS" : "FAIL"));
}