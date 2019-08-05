package leetcode.easy.hash_table_all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/****
 *
 * https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * 题目描述：
 *
 * 给定一个字符串数组，让求出，通过前缀累增上来的最大的那个单词，如果
 * 最大的单词长度相等，那么就取按字母序的第一个。
 *
 *
 */
public class LongestWordinDictionary {



    public static String longestWord(String[] words) {
        //按字母升序
        Arrays.sort(words);
        //保留曾经出现过的单词列表
        Set<String> built=new HashSet<String>();
        //记录上一次出现符合规则的按此
        String res="";
        for (String w:words){
            //判断单词的长度如果等于1，直接添加，否则就截取前缀判断是否曾经出现，对出现的在继续操作
            if(w.length()==1||built.contains(w.substring(0,w.length()-1))){
              res=w.length()>res.length()?w:res;//如果新的长度大于旧的就取新的，否则保持，然后添加这个前缀保存起来
              built.add(w);
            }
        }

    //返回最终要找的数据
    return res;
    }


    public static void main(String[] args) {


//        String[] words=new String[]{"w","wo","wor","worl", "world"};
        String[] words=new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};

        System.out.println(longestWord(words));


    }


}
