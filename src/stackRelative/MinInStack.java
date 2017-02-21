package stackRelative;
import java.util.Stack;
/**
 * Created by renguifu on 2017/2/19.
 * 问题：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：采用两个栈来解决，一个栈是数据栈，一个栈是最小值栈
 */
public class MinInStack {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> minData = new Stack<Integer>();

    public void push(int node) {
        data.push(node);
        if(minData.size()==0){
            minData.push(node);
        }else{
            if(node >= minData.peek()){
                minData.push(minData.peek());
            }else{
                minData.push(node);
            }
        }
    }

    public void pop() {
        data.pop();
        minData.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minData.peek();
    }
}
