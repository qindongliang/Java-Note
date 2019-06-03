package leetcode.easy.array_all;

import java.util.HashMap;
import java.util.Map;

/****
 *
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * 题目描述：
 *
 * 给定一个听歌曲时长的数组，求出里面的两个数组时长相加的和能被60整除的对数有多少。
 *
 * 比如，[30,20,150,100,40]
 * 如下：
 *
 * （ 30 + 150 ）% 60 =  0  count=1
 * （ 20 + 100 ）% 60 =  0  count=2
 * （ 20 + 40 ）% 60 =  0  count=3
 *
 *  从以上的形式总结规律，如果两个数相加的和%60等于0，
 *  那么这两个数分别%60后的值再加起来，同样%60等于0，如下
 *
 *  （1） {30%60=30 + 150%60=30}=60 % 60=0
 *   (2) {20%60=20 + 100%60=40}=60 % 60=0
 *   (3) {20%60=20 + 40%60=40}=60 % 60=0;
 *
 * 解题思路，类似于TwoSum的思路
 *
 */
public class PairsofSongs {


    public static int numPairsDivisibleBy603(int[] time) {
        int ans=0;
        if(time==null|time.length==0){
            return ans;
        }
        //map存储计数信息
        Map<Integer,Integer> map=new HashMap<>();
        //顺序遍历数组
        for (int i = 0; i < time.length; i++) {
            int rem=time[i]%60;//得到这个数的余数 [0..59]
            // 60 - [0..59] = [60..1]

            ans+=map.getOrDefault((60-rem)%60,0);
            //存储rem
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }




    public static int numPairsDivisibleBy602(int[] time) {
        int []count=new int[60];
        int songCnt=0;
        for (int num:time){
            //将结果映射到1..60这个数据范围上
            songCnt=songCnt+count[(60-num%60)%60];
            //如果发现重复，则加1
            count[num%60]=count[num%60]+1;
        }
        return songCnt;
    }

    public static void main(String[] args) {
//        int arr[]={30,20,150,100,40};
//        int arr[]={418,204,77,278,239,457,284,263,372,279,476,416,360,18};
        int arr[]={60,60,60};
        System.out.println(numPairsDivisibleBy603(arr));
    }
}
