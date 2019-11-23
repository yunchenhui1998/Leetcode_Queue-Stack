package com.xupt.practicec.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OpenLock {
    public int openLockSolution(String[] deadends, String target) {
        int step=0;
        int length=deadends.length;
        int[] direction={1,-1};
        String init="0000";
        LinkedList<String> queue=new LinkedList<String>();
        queue.add(init);
        Set<String> seen=new HashSet<>();
        seen.add("0000");
        for(int i=0;i<length;i++){
            if(deadends[i].equals("0000"))
                return -1;
        }
        while(!queue.isEmpty()) {
            step=step+1;
            //System.out.print('x');
            int qlength=queue.size();
            for (int i = 0; i < qlength; i++) {
                String start = queue.peek();
                int first = (start.charAt(0) - 48);
                int second = (start.charAt(1) - 48);
                int third = (start.charAt(2) - 48);
                int forth = (start.charAt(3) - 48);
                for (int j = 0; j < 4; j++) {
                    mark1:
                    for (int dir : direction) {
                        int[] nextNumber = {first, second, third, forth};
                        //System.out.print(dir+" ");
                        nextNumber[j] = (nextNumber[j] + 10 + dir) % 10;
                        String nextNum = ""+nextNumber[0] + nextNumber[1]+ nextNumber[2] + nextNumber[3];
                        //System.out.print(nextNum + " ");
                        if (nextNum.equals(target)) {
                            return step;
                        }
                        for(int k=0;k<length;k++){
                            if(deadends[k].equals(nextNum)){
                                continue mark1;
                            }
                        }
                        if (!seen.contains(nextNum)) {
                            seen.add(nextNum);
                            queue.add(nextNum);
                            //System.out.print(nextNum+" ");
                        }
                    }
                }
                queue.poll();

            }
        }
        return -1;
    }
    public static void main(String[] args){
        String[] deadends={"0201","0101","0102","1212","2002"};
        String target="0202";
        OpenLock solution=new OpenLock();
        int step=solution.openLockSolution(deadends,target);
        System.out.println(step);
    }
}
