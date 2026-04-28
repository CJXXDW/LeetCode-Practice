/**
 * 707. 设计链表
 *
 * 设计你的链表实现。你可以选择使用单链表或双链表。
 *
 * 实现 MyLinkedList_707 类：
 *
 * int get(int index) 获取链表中第 index 个节点的值。如果索引无效，则返回 -1。
 *
 * void addAtHead(int val) 在链表的第一个元素之前添加一个值为 val 的节点。
 *
 * void addAtTail(int val) 将值为 val 的节点追加到链表的最后一个元素。
 *
 * void addAtIndex(int index, int val)
 * 在链表中的第 index 个节点之前添加值为 val 的节点。
 *
 * void deleteAtIndex(int index) 删除第 index 个节点（如果存在）。
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
static class MyLinkedList_707 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val=val;
        }
    }
    int size;
    ListNode head;

    public MyLinkedList_707() {
        this.head = new ListNode(0);
        this.size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode curr = head;//由于是虚拟头节点所以要从0开始
        for(int i = 0;i <= index;i++){
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode newnode = new ListNode(val);
        newnode.next = head.next;
        head.next = newnode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newnode =new ListNode(val);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newnode;
        size++;
    }
    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            //这里index可以大于长度是因为可以视为在尾节点插入
            return;
        }
        ListNode newnode = new ListNode(val);
        ListNode pre = head;
        for(int i = 0;i < index;i++){
            pre = pre.next;
        }
        newnode.next = pre.next;
        pre.next = newnode;
        size++;
    }

    public void deleteAtIndex(int index) {
        //需要注意这里index不能大于长度
        if(index < 0 || index >= size){
            return;
        }
        ListNode pre = head;
        for(int i = 0;i < index;i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }
}

public static void main(String[] args) {

    MyLinkedList_707 list = new MyLinkedList_707();

    list.addAtHead(1);
    list.addAtTail(3);
    list.addAtIndex(1, 2);   // 1 -> 2 -> 3

    System.out.println(list.get(1)); // 期望: 2

    list.deleteAtIndex(1);           // 1 -> 3
    System.out.println(list.get(1)); // 期望: 3

    list.addAtHead(5);              // 5 -> 1 -> 3
    System.out.println(list.get(0)); // 期望: 5

    list.addAtTail(7);              // 5 -> 1 -> 3 -> 7
    System.out.println(list.get(3)); // 期望: 7

    list.deleteAtIndex(0);          // 1 -> 3 -> 7
    System.out.println(list.get(0)); // 期望: 1

    list.deleteAtIndex(10);         // 无效操作
    System.out.println(list.get(2)); // 期望: 7
}