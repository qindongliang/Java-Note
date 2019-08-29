package leetcode.easy.hash_table_all;

import java.util.Arrays;

/****
 *
 *
 *
 *
 */
public class FindGoodWords {

    public static int countCharacters(String[] words, String chars) {

        int count=0;
        int []seen=new int[26];

        //统计每个字符出现的次数
        for (char c:chars.toCharArray()){
            seen[c-'a']++;
        }

        for (String word:words){
            int []tseen= Arrays.copyOf(seen,seen.length);
            int tcount=0;
            for (char c:word.toCharArray()){
                if(tseen[c-'a']>0){
                    tseen[c-'a']--;
                    tcount++;
                }
            }

            if(tcount==word.length()){
                count+=tcount;
            }
        }


        return count;

    }

    public static void main(String[] args) {


//       String[] words=new String[]  {"hello","world","leetcode"};
       String[] words=new String[]  {"cat","bt","hat","tree"};
//       String chars = "welldonehoneyr";
       String chars = "atach";


        System.out.println(countCharacters(words,chars));


    }
}
