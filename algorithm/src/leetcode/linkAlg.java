package leetcode;

import java.util.LinkedList;

/**
 * 反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Noby
 * @since 2022/9/30
 */
public class linkAlg {
    public static void main(String[] args) {
        ListNode listNode = new ListNode( 1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode( 3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        reverseList(listNode);
    }

    static public ListNode reverseList(ListNode head) {
        LinkedList<Integer> datas = new LinkedList<>();
        ListNode next = head;
        while (true) {
            try {
                datas.add(next.val);
                next = next.next;
            } catch (Exception e) {
                break;
            }
        }
        next = head;
        while (true) {
            try {
                next.val = datas.removeLast();
                next = next.next;
            } catch (Exception e) {
                break;
            }
        }
        return head;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//class ListNode {
//    private ListNode next;
//    private int data;
//
//    public ListNode(ListNode next, int data) {
//        this.next = next;
//        this.data = data;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
//
//    public int getData() {
//        return data;
//    }
//
//    public void setData(int data) {
//        this.data = data;
//    }
//}
