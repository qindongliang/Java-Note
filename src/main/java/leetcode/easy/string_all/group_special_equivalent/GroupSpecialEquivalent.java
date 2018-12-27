package leetcode.easy.string_all.group_special_equivalent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * 给定一个字符串数组，根据特定规则去重计数
 * 每个字符串的偶数位数上的字符串，和位置没有关系，只要都包含即可
 * 每个字符串的奇数位数上的字符串，和位置没有关系，只要都包含即可
 *
 * 比如abc cba 可以认为是相等的，acb和bac是相等的
 * 比如abcd cadb是相等的
 * 比如abcde ebcda是相等的
 */
public class GroupSpecialEquivalent {


    public static int numSpecialEquivGroups(String[] A) {
        Set<String> set=new HashSet<>();
        for(String s:A){
            int [] map1=new int[256];
            int [] map2=new int[256];
            for (int i = 0; i < s.length(); i++) {
                char c=s.charAt(i);
//                System.out.println(c+"  "+ (int)(c) );
                if(i%2==0){
                    map1[s.charAt(i)]++;
                }else{
                    map2[s.charAt(i)]++;
                }
            }
            int hashCode= (Arrays.toString(map1) + " " + Arrays.toString(map2)).hashCode();
            set.add(hashCode+"");
        }
    return set.size();
    }

    public static void main(String[] args) {

//        String array[]=new String[]{"a","b","c","a","c","c"};
//        String array[]=new String[]{"aa","bb","ab","ba"};
//        String array[]=new String[]{"abc","acb","bac","bca","cab","cba"};
//        String array[]=new String[]{"abcd","cdab","adcb","cbad"};
        String array[]=new String[]{"abcde","ebcda"};
        numSpecialEquivGroups(array);




    }

}
