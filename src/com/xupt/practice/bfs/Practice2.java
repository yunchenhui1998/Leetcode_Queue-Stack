package com.xupt.practice.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//开始尝试独立自主完成打开算盘锁一题
public class Practice2 {
    public int openLock(String[] deadends, String target) {
        int[] init={0,0,0,0};
        int[] directions={1,-1};
        int step=0;
        LinkedList<int[]> queue=new LinkedList<int[]>();
        Set<String> set=new HashSet<String>();
        set.add("0000");
        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);
        }
        if(set.contains(target)){
            return -1;
        }
        queue.add(init);
        while(!queue.isEmpty()){
            step++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] node=queue.peek();
                for(int j=0;j<4;j++){
                    for(int direction:directions){
                        String nextStr="";
                        int[] nextInt=new int[]{node[0],node[1],node[2],node[3]};
                        nextInt[j]=(nextInt[j]+direction+10)%10;
                        for(int k=0;k<4;k++){
                            nextStr+=nextInt[k];
                        }
                        System.out.println(nextStr);
                        if(nextStr.equals(target))
                            return step;
                        if(set.contains(nextStr))
                            continue;
                        set.add(nextStr);
                        queue.add(nextInt);
                    }
                }
                queue.poll();
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String[] deadmends={"0002"};
        String target="0001";
        Practice2 p=new Practice2();
        System.out.println(p.openLock(deadmends,target));
    }
}
