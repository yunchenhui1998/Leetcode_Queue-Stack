package com.xupt.practice.stack;

import java.util.Stack;

public class DecodeString {
    public String solution(String s){
        StringBuilder res=new StringBuilder();
        int multi=0;
        char[] ch=s.toCharArray();
        Stack<String> stackStr=new Stack<>();
        Stack<Integer> stackInt=new Stack<>();
        for(Character c:ch){
            if(c=='['){
                stackStr.push(res.toString());
                stackInt.push(multi);
                res=new StringBuilder();
                multi=0;
            }
            else if(c==']'){
                StringBuilder tmp=new StringBuilder();
                int curInt=stackInt.pop();
                for(int i=0;i<curInt;i++){
                    tmp.append(res);
                }
                res=new StringBuilder(stackStr.pop()+tmp);
            }
            else if(c>='0'&&c<='9') multi=multi*10+Integer.parseInt(c+"");
            else
                res.append(c);
        }
        return res.toString();
    }
    public static void main(String[] args){
        String s="3[a]2[bc]";
        DecodeString obj=new DecodeString();
        System.out.println(obj.solution(s));
    }
}
