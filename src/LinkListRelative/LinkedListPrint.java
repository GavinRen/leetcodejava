package LinkListRelative;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by renguifu on 2017/2/3.
 * 问题：输入一个链表，从尾到头打印链表每个节点的值。
 */
public class LinkedListPrint {
//    使用栈的思想解决
    ArrayList<Integer> result1 =new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead1(LinkedNode linkedHead){
        Stack<Integer> stack = new Stack<Integer>();
        LinkedNode linkedNode = linkedHead;
        while(linkedNode != null){
              stack.push(linkedNode.value);
              linkedNode = linkedNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
    // 采用递归的思想
    public ArrayList<Integer> printListFromTailToHead2(LinkedNode linkedHead){
        if(linkedHead != null){
            printListFromTailToHead2(linkedHead.next);
            result1.add(linkedHead.value);
        }
        return result1;
    }
}
