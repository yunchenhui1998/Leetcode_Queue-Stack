package com.xupt.practice.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<matrix.length;i++){
            mark1:
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    Queue<int[]> queue=new LinkedList<>();
                    int resP=0;
                    int[] p=new int[]{i,j};
                    queue.offer(p);
                    while(!queue.isEmpty()){
                        resP++;
                        int size=queue.size();
                        for(int k=0;k<size;k++){
                            int[] tmp=queue.peek();
                            for(int[] dir:directions){
                                int x=tmp[0]+dir[0];
                                int y=tmp[1]+dir[1];
                                if(x<0||x>=matrix.length||y<0||y>=matrix[0].length){
                                    continue;
                                }
                                else if (matrix[x][y]==0){
                                    matrix[i][j]=resP;
                                    continue mark1;
                                }
                                else{
                                    queue.offer(new int[]{x,y});
                                }
                            }
                            queue.poll();
                        }
                    }
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args){
        int[][] matrix=new int[][]{{0,0,1},{0,0,1},{1,1,1}};
        int[][] result=new Matrix01().updateMatrix(matrix);
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
