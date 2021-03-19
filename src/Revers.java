/**
 * @Package: PACKAGE_NAME
 * @ClassName: Revers
 * @Description: TODO(用一句话描述该文件做什么)
 * @Author: pug
 * @Date: 2021/3/14 15:24
 * @Version: 1.0
 */
public class Revers {
    //1->2->3
    //3<-2<-1

    static class ListNode {
        int e;
        ListNode next;

        public ListNode() {
        }
        public ListNode(int e) {
            this.e = e;
        }

        public ListNode(int e, ListNode next) {
            this.e = e;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(3,null);
        ListNode n2 = new ListNode(2,n3);
        ListNode head = new ListNode(1,n2);
        ListNode revers = revers(head);
        System.out.println(revers);
    }

    public static ListNode revers(ListNode head){
        ListNode p =null;
        ListNode c = head;

        while (c!=null){
            ListNode temp = c.next;
            c.next = p;
            p = c;
            c = temp;
        }
        return p;

    }

}
