package com.xupt.practice.stack;

import java.util.*;

public class MyStackCreatedByQueues {
    Queue<Integer> queueA=new LinkedList<>();
    Queue<Integer> queueB=new LinkedList<>();
    public MyStackCreatedByQueues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queueA.isEmpty()){
            while(!queueA.isEmpty()){
                queueB.offer(queueA.poll());
            }
            queueA.offer(x);
            while(!queueB.isEmpty()){
                queueA.offer(queueB.poll());
            }
        }
        else
            queueA.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queueA.poll();
    }

    /** Get the top element. */
    public int top() {
        return queueA.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty();
    }
}
