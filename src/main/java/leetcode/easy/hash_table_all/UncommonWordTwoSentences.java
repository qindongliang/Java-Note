package leetcode.easy.hash_table_all;

import java.util.*;

/****
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 *
 * 题目描述：给出两个句子，求出在这两个句子里面仅仅出现一次word
 *
 */
public class UncommonWordTwoSentences {

    public static String[] uncommonFromSentences(String A, String B) {


        String all=A+" "+B;
        HashMap<String,Integer> map=new HashMap<>();
        for(String word:all.split(" ")){
           map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> result=new ArrayList<>();
        for (Map.Entry<String,Integer> kv:map.entrySet()){
            if(kv.getValue()==1){
                result.add(kv.getKey());
            }
        }
//        System.out.println(result);
     return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

      String   A = "this apple is sweet", B = "this apple is sour";

      uncommonFromSentences(A,B);


    }




}
