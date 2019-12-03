package com.xupt.practice.dfs;

public class FloodFill {
    public int[][] solution(int[][] image,int sr,int sc,int newColor){
        int startColor=image[sr][sc];
        dfs(image,sr,sc,newColor,startColor);
        return image;
    }
    private void dfs(int[][] image,int sr,int sc,int newColor,int startColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor||image[sr][sc] != startColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, startColor);
        dfs(image, sr - 1, sc, newColor, startColor);
        dfs(image, sr, sc + 1, newColor, startColor);
        dfs(image, sr, sc - 1, newColor, startColor);
    }
    public static void main(String[] args){
        FloodFill f=new FloodFill();
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        f.solution(image,1,1,2);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
