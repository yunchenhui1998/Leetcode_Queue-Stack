package com.xupt.practice.bfs;

import java.util.*;

public class LadderLength {
    public int ladderLengthSolution(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> set=new HashSet<>();
        int res=1;
        char[] beginwords=beginWord.toCharArray();
        Queue<char[]> queue=new LinkedList<>();
        queue.offer(beginwords);
        set.add(beginWord);
        while(!queue.isEmpty()){
            res++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                for(int j=0;j< beginwords.length;j++){
                    for(int k=0;k<26;k++){
                        char[] tmp1=queue.peek();
                        char[] tmp= Arrays.copyOf(tmp1,tmp1.length);
                        tmp[j]=(char)(97+k);
                        String tmpWord=new String(tmp);
                        System.out.println(tmpWord);
                        if(wordList.contains(tmpWord)&&!set.contains(tmpWord)){

                            if(tmpWord.equals(endWord)){
                                return res;
                            }
                            set.add(tmpWord);
                            queue.offer(tmp);
                        }
                    }
                }
                queue.poll();
            }
        }
        return 0;
    }
    public static void main(String[] args){
        String begin="hit";
        String end="cog";
        List<String> list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        LadderLength l=new LadderLength();
        System.out.println(l.ladderLengthSolution(begin,end,list));
    }
}
