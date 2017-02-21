package LinkListRelative;

/**
 * Created by renguifu on 2017/2/14.
 * 问题：输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthNode {
    // 解法一：
    public LinkedNode FindKthToTail(LinkedNode head,int k) {
        if(k<0){
            throw new RuntimeException("the k is erro");
        }
        if(head ==null){
            return null;
        }
        int len = lengthOfLinkList(head);
        if(len<k){
            return null;
        }
        if(len ==k){
            return head;
        }
        int index = len - k +1;
        LinkedNode node = head;
        while(index >1){
            node = node.next;
            index --;
        }
        return node;
    }
    public int lengthOfLinkList(LinkedNode head){
        if(head == null){
            return 0;
        }
        int count =1;
        LinkedNode node = head;
        while(node.next != null){
            node = node.next;
            count ++;
        }
        return count;
    }
    // 解法二;使用两个指针
    public LinkedNode FindKthToTail1(LinkedNode head,int k) {
        if(head ==null || k<= 0){
            return null;
        }
        LinkedNode pre = head;
        LinkedNode last = head;
        for(int i =1;i < k;i++){
            if(pre.next != null){
                pre = pre.next;
            }else{
                return null;
            }
        }
        while(pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

}
