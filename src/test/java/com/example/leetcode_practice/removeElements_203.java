/**
 * 203. 移除链表元素
 *
 * 给你一个链表的头节点 head 和一个整数 val，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 * - 列表中的节点数目在范围 [0, 10^4] 内
 * - 1 <= Node.val <= 50
 * - 0 <= val <= 50
 */
public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// 辅助方法：构建链表
public static ListNode build(int[] arr) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (int n : arr) {
        cur.next = new ListNode(n);
        cur = cur.next;
    }
    return dummy.next;
}

// 辅助方法：打印链表
public static void print(ListNode head) {
    ListNode cur = head;
    while (cur != null) {
        System.out.print(cur.val);
        if (cur.next != null) System.out.print(" -> ");
        cur = cur.next;
    }
    System.out.println();
}

public static ListNode removeElements_203(ListNode head, int val) {
/*两种方法，一种原链表删除元素，一种虚拟头节点*/
    //第一种
//    ListNode current = head;
//    while(head != null && head.val == val){
//        head = head.next;
//    }
//    while(current != null && current.next != null){
//        if(current.next.val == val){
//            current.next = current.next.next;
//        }else{
//            current = current.next;
//        }
//
//    }
//    return head;
    //第二种
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null) {
        if (current.next.val == val) {
            current.next = current.next.next;
        }else  {
            current = current.next;
        }
    }
    return dummy.next;
}

public static void main(String[] args) {
    ListNode head1 = build(new int[]{1,2,6,3,4,5,6});
    print(removeElements_203(head1, 6)); // 期望: 1 -> 2 -> 3 -> 4 -> 5

    ListNode head2 = build(new int[]{});
    print(removeElements_203(head2, 1)); // 期望: 空

    ListNode head3 = build(new int[]{7,7,7,7});
    print(removeElements_203(head3, 7)); // 期望: 空

    ListNode head4 = build(new int[]{1,2,3,4});
    print(removeElements_203(head4, 5)); // 期望: 1 -> 2 -> 3 -> 4

    ListNode head5 = build(new int[]{6,6,1,2,6});
    print(removeElements_203(head5, 6)); // 期望: 1 -> 2
}
