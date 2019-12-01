package com.xupt.practice.dfs;

public class TargetSum {
    int res=0;
    public int solution(int[] nums,int target){
        dfs(nums,target,0);
        return res;
    }
    public void dfs(int[] nums,int t,int p){
        if(p>=nums.length){
            if(t==0)
                res++;
            return;
        }
        dfs(nums,t-nums[p],p+1);
        dfs(nums,t+nums[p],p+1);
    }

}
