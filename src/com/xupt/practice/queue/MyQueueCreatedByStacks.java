package com.xupt.practice.queue;

import java.util.Stack;

public class MyQueueCreatedByStacks {
    Stack<Integer> stackA=new Stack<>();
    Stack<Integer> stackB=new Stack<>();
    public MyQueueCreatedByStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                return -1;
            }
            fetchFromStackA();
        }
        return stackB.pop();
    }
    private void fetchFromStackA(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                return -1;
            }
            fetchFromStackA();
        }
        return stackB.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackA.isEmpty())
            if(stackB.isEmpty())
                return true;
        return false;
    }
}
