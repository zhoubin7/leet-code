import sun.print.SunMinMaxPage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: AddTwoNumbers
 * @Description: 两数相加
 * @Author: pug
 * @Date: 2020/9/30 11:24
 * @Version: 1.0
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = l1;
        ListNode l3 = new ListNode(2);
        l3.next = l2;

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6);
        l5.next = l4;
        ListNode l6 = new ListNode(5);
        l6.next = l5;

        ListNode listNode = addTwoNumbers1(l3, l6);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = sum(l1);
        String s2 = sum(l2);
        int res = Integer.valueOf(s1) + Integer.valueOf(s2);
        StringBuilder sb = new StringBuilder();
        String s = sb.append(res).reverse().toString();
        ListNode r ;
        char[] chars = s.toCharArray();
        List<ListNode> list1 = new ArrayList<>();
        for (char aChar : chars) {
            list1.add(new ListNode(aChar));
        }

        return  null;
    }

    private static String sum (ListNode node){
        StringBuilder sb = new StringBuilder();
        while (node !=null && node.val >=0){
            sb.append(node.val);
            node = node.next;
        }
        return sb.reverse().toString();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
