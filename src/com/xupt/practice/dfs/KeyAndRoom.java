package com.xupt.practice.dfs;

import java.util.List;

public class KeyAndRoom {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] res=new boolean[rooms.size()];
        dfs(rooms,0,res);
        for(boolean b:res){
            if(!b){
                return false;
            }
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms,int room,boolean[] res){
        if(res[room]==true)
            return;
        res[room]=true;
        for(int i:rooms.get(room)){
            dfs(rooms,i,res);
        }
    }
}
