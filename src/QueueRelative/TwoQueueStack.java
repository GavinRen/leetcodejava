package QueueRelative;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by renguifu on 2017/2/4.
 * 问题：用两个队列实现栈，并实现push 和pop操作
 */
public class TwoQueueStack {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    public void push(int data){
        queue1.add(data);
    }
    public int pop(){
        int data;
        if(queue1.size()==0){
            throw new RuntimeException("the stack is empty");
        }
        if(queue1.size()==1){
            return queue1.poll();
        }
        while(queue1.size()!=1){
            queue2.add(queue1.poll());
        }
        data =queue1.poll();
        while(queue2.size()!=0){
            queue1.add(queue2.poll());
        }
        return data;
    }
    public static void main(String[] args){
        TwoQueueStack tqs = new TwoQueueStack();
        tqs.push(1);
        tqs.push(2);
        tqs.push(3);
        System.out.println(tqs.pop());
    }
}
