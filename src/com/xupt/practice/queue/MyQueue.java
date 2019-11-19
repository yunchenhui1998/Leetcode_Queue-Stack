package com.xupt.practice.queue;
//此代码为创建一个基本的先进先出的队列
import java.util.ArrayList;
import java.util.List;

class CreateMyQueue{
    private List<Integer> data;
    private int p_start;
    public CreateMyQueue(){
        data = new ArrayList<Integer>();
        p_start=0;
    }
    public boolean enQueue(int a){
        data.add(a);
        return true;
    }
    public boolean deQueue(){
        if(isEmpty()==true)
            return false;
        p_start++;
        return true;
    }
    public int Front(){
        return data.get(p_start);
    }
    public boolean isEmpty(){
        return p_start>=data.size();
    }
}
public class MyQueue {
    public static void main(String[] args){
        CreateMyQueue q=new CreateMyQueue();
        q.enQueue(1);
        q.enQueue(2);
        if (q.isEmpty()==false)
            System.out.println(q.Front());
        q.deQueue();
        if (q.isEmpty()==false)
            System.out.println(q.Front());
        q.deQueue();
        if (q.isEmpty()==false)
            System.out.println(q.Front());
    }
}
