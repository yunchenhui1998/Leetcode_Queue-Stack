package com.xupt.practice.bfs;

import java.util.LinkedList;

//  岛屿数量
//          给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向
//          或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
//          示例 1:
//
//          输入:
//          11110
//          11010
//          11000
//          00000
//
//          输出: 1
//          示例 2:
//
//          输入:
//          11000
//          11000
//          00100
//          00011
//
//          输出: 3
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0)
            return 0;
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        LinkedList<int[]> queue=new LinkedList<int[]>();
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] dir : directions) {
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
