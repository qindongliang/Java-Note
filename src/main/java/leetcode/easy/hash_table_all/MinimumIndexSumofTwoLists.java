package leetcode.easy.hash_table_all;

import java.util.*;

/*****
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 *
 * 题目介绍：本题的意思是给定两个字符串数组，让找出其中字符串相等的，并且他们的在
 * 数组里面各自的下标之和，加起来是最小的，如果出现了多个，就输出多个答案即可。
 *
 * 解题思路：
 *
 * 使用一个map用来保存数组，k=第一个数组的每一个字符串，v=每一个字符串的index
 *
 * 先遍历第一个数组，将其数组放入map里面，然后遍历第二个数组，看是否能遇到同样相等的字符串
 * 如果遇到了就取他们的index之和遇当前最小的sum进行比较，如果和最小，就清空结果的list存储
 * 并把最小的字符串放进去，然后更新当前最小值，同样如果和相等就都保持即可，最后对结果转成string数组
 * 返回即可。
 *
 */

public class MinimumIndexSumofTwoLists {

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String,Integer> map=new HashMap<>();

        List<String> res=new ArrayList<>();
        //遍历每一个元素，放入map里面，k=字符串本身，v=该字符串在数组里面的下标
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }

        int minSum=Integer.MAX_VALUE;
        //遍历list2
        for (int i = 0; i < list2.length; i++) {
            //判断如果map包含第二个数组里面的元素时
            if(map.containsKey(list2[i])){
                int sum=map.get(list2[i])+i;//求和
                if(sum<minSum){//如果和小于当前记录的minSum，就清空集合记录更小的，
                    res.clear();
                    res.add(list2[i]);
                    minSum=sum;//更新记录小的值，为当前sum
                }else if(sum==minSum){//如果有相等的，就继续记录
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);//将结果转成数组输出
    }

    public static void main(String[] args) {
        String l1[]=new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String l2[]=new String[]{"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(l1,l2)));



    }

}
