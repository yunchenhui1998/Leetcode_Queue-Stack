package com.xupt.practice.bfs;

import java.util.LinkedList;
import java.util.Queue;

//开始尝试自主独立完成岛屿数量一题
public class Practice1 {
    public int solution(char[][] grid){
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0)
            return 0;
        Queue<int[]> queue=new LinkedList<int[]>();
        int rows=grid.length;
        int cols=grid[0].length;
        int step=0;
        int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    step++;
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int size=queue.size();
                        for (int k=0;k<size;k++){
                            int[] nums=queue.peek();
                            for(int[] dir:directions){
                                int x=nums[0]+dir[0];
                                int y=nums[1]+dir[1];
                                if(x>=0&&x<rows&&y>=0&&y<cols&&grid[x][y]=='1') {
                                    grid[x][y]='0';
                                    queue.add(new int[]{x, y});
                                }
                            }
                            queue.poll();
                        }
                    }
                }
                else
                    continue;
            }
        }
        return step;
    }
}
