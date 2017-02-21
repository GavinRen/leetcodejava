package LinkListRelative;

/**
 * Created by renguifu on 2017/2/14.
 * 问题：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoLinkedList {
    // 采用循环的方式解决
    public LinkedNode Merge(LinkedNode list1,LinkedNode list2) {
        if(list1==null && list2 ==null){
            return null;
        }
        if(list1 ==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        LinkedNode head = null;
        LinkedNode result = null;
        if(list1.value <= list2.value){
            head=list1;
            list1 = list1.next;
            result = head;
        }else{
            head =list2;
            list2 = list2.next;
            result = head;
        }
        while(list1 !=null || list2 != null ){
            if(list1 ==null){
                head.next = list2;
                break;
            }
            if(list2 == null){
                head.next =list1;
                break;
            }
            if(list1.value<=list2.value){
                head.next =list1;
                list1 =list1.next;
            }else{
                head.next =list2;
                list2=list2.next;
            }
            head = head.next;
        }
        return result;
    }
    // 采用递归的方法
    public LinkedNode Merge1(LinkedNode list1,LinkedNode list2) {
        if(list1 ==null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        LinkedNode mergeHead = null;
        if(list1.value <=list2.value){
            mergeHead = list1;
            mergeHead.next = Merge1(list1.next,list2);
        }else {
            mergeHead = list2;
            mergeHead.next = Merge1(list1,list2.next);
        }
        return mergeHead;
    }
}
