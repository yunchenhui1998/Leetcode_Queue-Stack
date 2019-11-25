package com.xupt.practice.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquare {
    public int numSquares(int n){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(n);
        int step=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            step++;
            for(int i=0;i<size;i++){
                int sqrt= (int) Math.sqrt(queue.peek());
                for(int j=1;j<=sqrt;j++){
                    if((queue.peek()-j*j)==0)
                        return step;
                    queue.offer(queue.peek()-j*j);
                }
                queue.poll();
            }
        }
        return -1;
    }
}
