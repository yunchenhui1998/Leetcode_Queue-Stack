package com.xupt.practice.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isvalid(String s){
        char[] parentheses=s.toCharArray();
        Stack<Character> stack=new Stack<Character>();
        for(char ch:parentheses){
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }
            if(ch==')'||ch==']'||ch=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                String str=""+stack.peek()+ch;
                if(!str.equals("()")&&!str.equals("[]")&&!str.equals("{}")){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
