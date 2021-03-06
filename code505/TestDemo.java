package code505;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//--------------------------------------------
//思路：
// 将当前结点初始化为返回列表的哑结点。
//将进位 carrycarrycarry 初始化为 000。
//将 ppp 和 qqq 分别初始化为列表 l1l1l1 和 l2l2l2 的头部。
//遍历列表 l1l1l1 和 l2l2l2 直至到达它们的尾端。
//
//    将 xxx 设为结点 ppp 的值。如果 ppp 已经到达 l1l1l1 的末尾，则将其值设置为 000。
//    将 yyy 设为结点 qqq 的值。如果 qqq 已经到达 l2l2l2 的末尾，则将其值设置为 000。
//    设定 sum=x+y+carrysum = x + y + carrysum=x+y+carry。
//    更新进位的值，carry=sum/10carry = sum / 10carry=sum/10。
//    创建一个数值为 (sum mod 10)(sum \bmod 10)(summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
//    同时，将 ppp 和 qqq 前进到下一个结点。
//
//检查 carry=1carry = 1carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 111 的新结点。
//返回哑结点的下一个结点。

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class TestDemo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
