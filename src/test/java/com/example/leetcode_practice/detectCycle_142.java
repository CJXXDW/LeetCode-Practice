/**
 * 题目：环形链表 II (Linked List Cycle II)
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改链表。
 *
 * 方法名: detectCycle_142
 * 参数: ListNode head  单链表的头节点
 * 返回值: ListNode      入环的第一个节点，如果无环则返回 null
 *
 * 示例:
 * 输入: head = [3,2,0,-4], pos = 1
 * 输出: 节点 2 (索引为 1)
 *
 * 输入: head = [1,2], pos = 0
 * 输出: 节点 1 (索引为 0)
 *
 * 输入: head = [1], pos = -1
 * 输出: null
 */
public static class  ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
public static ListNode detectCycle_142(ListNode head) {
    // 请在此处实现你的代码
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(fast == slow){
            ListNode index1 = head;
            ListNode index2 = fast;
            while(index1 != index2){
                index1 = index1.next;
                index2 = index2.next;
            }
            return index1;
        }
    }
    return null;
}

public static void main(String[] args) {
    // --- 测试用例 1: 有环，环入口为节点2 ---
    // 3 -> 2 -> 0 -> -4
    //      ^           |
    //      |___________|
    ListNode n1_1 = new ListNode(3);
    ListNode n1_2 = new ListNode(2);
    ListNode n1_3 = new ListNode(0);
    ListNode n1_4 = new ListNode(-4);
    n1_1.next = n1_2; n1_2.next = n1_3; n1_3.next = n1_4; n1_4.next = n1_2;

    ListNode r1 = detectCycle_142(n1_1);
    System.out.println("Test 1 (cycle at node 2): " + (r1 != null && r1.val == 2 ? "PASS" : "FAIL"));

    // --- 测试用例 2: 有环，环入口为节点1 ---
    // 1 -> 2
    // ^    |
    // |____|
    ListNode n2_1 = new ListNode(1);
    ListNode n2_2 = new ListNode(2);
    n2_1.next = n2_2; n2_2.next = n2_1;

    ListNode r2 = detectCycle_142(n2_1);
    System.out.println("Test 2 (cycle at node 1): " + (r2 != null && r2.val == 1 ? "PASS" : "FAIL"));

    // --- 测试用例 3: 无环 ---
    // 1
    ListNode n3_1 = new ListNode(1);
    ListNode r3 = detectCycle_142(n3_1);
    System.out.println("Test 3 (single node, no cycle): " + (r3 == null ? "PASS" : "FAIL"));

    // --- 测试用例 4: 空链表 ---
    ListNode r4 = detectCycle_142(null);
    System.out.println("Test 4 (empty list): " + (r4 == null ? "PASS" : "FAIL"));

    // --- 测试用例 5: 无环，多节点 ---
    // 1 -> 2 -> 3 -> 4 -> 5
    ListNode n5_1 = new ListNode(1);
    ListNode n5_2 = new ListNode(2);
    ListNode n5_3 = new ListNode(3);
    ListNode n5_4 = new ListNode(4);
    ListNode n5_5 = new ListNode(5);
    n5_1.next = n5_2; n5_2.next = n5_3; n5_3.next = n5_4; n5_4.next = n5_5;

    ListNode r5 = detectCycle_142(n5_1);
    System.out.println("Test 5 (5 nodes, no cycle): " + (r5 == null ? "PASS" : "FAIL"));

    // --- 测试用例 6: 环在中间节点 ---
    // 1 -> 2 -> 3 -> 4 -> 5
    //           ^         |
    //           |_________|
    ListNode n6_1 = new ListNode(1);
    ListNode n6_2 = new ListNode(2);
    ListNode n6_3 = new ListNode(3);
    ListNode n6_4 = new ListNode(4);
    ListNode n6_5 = new ListNode(5);
    n6_1.next = n6_2; n6_2.next = n6_3; n6_3.next = n6_4; n6_4.next = n6_5; n6_5.next = n6_3;

    ListNode r6 = detectCycle_142(n6_1);
    System.out.println("Test 6 (cycle at node 3): " + (r6 != null && r6.val == 3 ? "PASS" : "FAIL"));

    // --- 测试用例 7: 环在最后一个节点（自环） ---
    // 1 -> 2 -> 3 -> 4
    //                ^
    //                |___|
    ListNode n7_1 = new ListNode(1);
    ListNode n7_2 = new ListNode(2);
    ListNode n7_3 = new ListNode(3);
    ListNode n7_4 = new ListNode(4);
    n7_1.next = n7_2; n7_2.next = n7_3; n7_3.next = n7_4; n7_4.next = n7_4;

    ListNode r7 = detectCycle_142(n7_1);
    System.out.println("Test 7 (self cycle at node 4): " + (r7 != null && r7.val == 4 ? "PASS" : "FAIL"));

    // --- 测试用例 8: 包含负数的环 ---
    // -5 -> -3 -> 0 -> 2 -> -1
    //            ^           |
    //            |___________|
    ListNode n8_1 = new ListNode(-5);
    ListNode n8_2 = new ListNode(-3);
    ListNode n8_3 = new ListNode(0);
    ListNode n8_4 = new ListNode(2);
    ListNode n8_5 = new ListNode(-1);
    n8_1.next = n8_2; n8_2.next = n8_3; n8_3.next = n8_4; n8_4.next = n8_5; n8_5.next = n8_3;

    ListNode r8 = detectCycle_142(n8_1);
    System.out.println("Test 8 (negative values, cycle at node 0): " + (r8 != null && r8.val == 0 ? "PASS" : "FAIL"));

    // --- 测试用例 9: 长链表，环在中间 ---
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
    //                     ^                        |
    //                     |________________________|
    ListNode[] nodes9 = new ListNode[10];
    for (int i = 0; i < 10; i++) {
        nodes9[i] = new ListNode(i + 1);
    }
    for (int i = 0; i < 9; i++) {
        nodes9[i].next = nodes9[i + 1];
    }
    nodes9[9].next = nodes9[4]; // 10 -> 5

    ListNode r9 = detectCycle_142(nodes9[0]);
    System.out.println("Test 9 (10 nodes, cycle at node 5): " + (r9 != null && r9.val == 5 ? "PASS" : "FAIL"));
}