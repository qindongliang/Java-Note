package leetcode.easy.array_all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/positions-of-large-groups/
 * 题目描述：给定一个小写字符串，找出里面连续出现大于等于3次的所有字符
 * 并记录开始出现的index，和结束的index，存进一个list里面返回。
 *
 *思路：
 *
 * 采用双指针法进行遍历，如果当i和start的value不等的时候，就判断是否符合条件
 * 然后重置start的位置，用来记录新的字符
 */
public class LargeGroups {
    public static List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> result=new ArrayList<>();
        int start=0;
        for (int i = 1; i <= s.length(); i++) {
            if(i==s.length()||s.charAt(i)!=s.charAt(start)){
                if(i-start>=3){
                    result.add(Arrays.asList(start,i-1));
                }
                start=i;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String test="abcdddeeeeaabbbcd";

        System.out.println(largeGroupPositions(test));

    }
}
