import java.util.HashSet;
import java.util.Set;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: LinkedListCycleII
 * @Description: 环形链表II
 * @Author: pug
 * @Date: 2020/10/10 16:03
 * @Version: 1.0
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4;
        l4.next = l2;
        ListNode listNode = detectCycle1(l3);
        System.out.println(listNode);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode ln = head;
        Set<ListNode> set = new HashSet<>();
        while (ln != null){
            if (set.contains(ln)){
                return ln;
            }else {
                set.add(ln);
            }
            ln = ln.next;
        }
        return null;
    }

    public static ListNode detectCycle1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode s = head, f = head;
        while (f != null){
            s = s.next;
            if (f.next!=null){
                f = f.next.next;
            }else {
                return null;
            }
            if (s == f){
                ListNode l = head;
                while (l != s){
                    l = l.next;
                    s = s.next;
                }
                return l;
            }
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            //如果快指针走到头了
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //两个点相遇，得到快慢指针相差的距离
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
