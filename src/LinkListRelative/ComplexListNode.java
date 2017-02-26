package LinkListRelative;

/**
 * Created by renguifu on 2017/2/22.
 * 问题：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ComplexListNode {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        clone(pHead);
        connectRandomNodes(pHead);
        return splitNodes(pHead);
    }
    // 复制原始节点任意结点N,并创建新结点N',再把N'链接到N的后面
    public void clone(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode !=null){
            RandomListNode cloneNode= new RandomListNode(pNode.label);
            cloneNode.next = pNode.next;
            cloneNode.random = null;
            pNode.next =cloneNode;
            pNode = cloneNode.next;
        }
    }
    // 复制的节点N'指向节点N的random结点的下一个结点。
    public void connectRandomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode !=null){
            RandomListNode cloneNode = pNode.next;
            if(pNode.random !=null){
                cloneNode.random = pNode.random.next;
            }
            pNode = cloneNode.next;
        }
    }
    // 分离复制的结点，奇数的节点是原始结点，偶数结点是复制后的结点
    public RandomListNode splitNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode cloneNode = null;
        RandomListNode cloneHead = null;
        if(pNode != null){
            cloneNode = cloneHead = pNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        while(pNode != null){
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode =pNode.next;
        }
        return cloneHead;
    }
}
