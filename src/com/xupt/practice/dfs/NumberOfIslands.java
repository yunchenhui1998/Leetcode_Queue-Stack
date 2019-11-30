package com.xupt.practice.dfs;

public class NumberOfIslands {
    public int solution(char[][] grid){
        int res=0;
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0)
            return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                  res++;
                  dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    private void dfs(int i,int j,char[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid.length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
