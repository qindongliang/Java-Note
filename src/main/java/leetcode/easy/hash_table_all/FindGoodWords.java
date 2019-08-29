package leetcode.easy.hash_table_all;

import java.util.Arrays;

/****
 *https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * 给定一个字符串数组，然后给定一个字符串。
 *
 * 让统计出，如果数组里面的字符串，可以通过这个字符串构成，那么就记录这个字符串的长度，如果
 * 有多个符合条件的字符串，就累加长度即可。
 *
 *
 * 思路：
 *
 * 将chars字符串，给映射到数组里面，然后遍历字符串数组，
 *
 * 使用每一个seen状态来检测，字符串数组里面的每一个字符串是否符合要求，注意
 * seen状态维护我们这里用的是copy过来的状态数组，意味着其值的修改不影响原始的数组，
 *
 *最后通过判断长度，如果相等则证明可以推断出来，最后记录累加即可
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
            //拷贝状态数组，不影响原始数组
            int []tseen= Arrays.copyOf(seen,seen.length);
            int tcount=0;
            for (char c:word.toCharArray()){
                if(tseen[c-'a']>0){
                    tseen[c-'a']--;
                    tcount++;
                }else {
                    break;//如果不满足条件，就不继续循环，算是一个优化条件
                }
            }

            //如果计数器和字符串长度相等则计数
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
