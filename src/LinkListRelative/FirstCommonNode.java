package LinkListRelative;

/**
 * Created by renguifu on 2017/3/10.
 * 输入两个链表，找出它们的第一个公共结点
 */
public class FirstCommonNode {
    public LinkedNode FindFirstCommonNode(LinkedNode pHead1, LinkedNode pHead2) {
        if(pHead1 == null || pHead2 ==null){
            return null;
        }
        // 分别计算出两个链表的长度
        int len1 =getLength(pHead1);
        int len2 =getLength(pHead2);
        // 计算两个链表长度的差
        int nLengthDif = len1 - len2;
        LinkedNode longNode= pHead1;
        LinkedNode shortNode = pHead2;
        if(len1 < len2){
            nLengthDif = len2 -len1;
            longNode = pHead2;
            shortNode = pHead1;
        }
        // 长链表先提前走nlengthDif步
        for(int i=0;i<nLengthDif;i++){
            longNode =longNode.next;
        }
        // 此时两个链表的长度相同，同时往前走，
        while(longNode != null && shortNode !=null && longNode != shortNode){
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return shortNode;
    }
    public int getLength(LinkedNode node){
        LinkedNode temp = node;
        int count =0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
