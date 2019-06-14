package leetcode.easy.array_all;

/****
 * 题目连接：https://leetcode.com/problems/height-checker/
 * 题目描述：
 * 给定一个int数组代表一个班的学生，希望是按照学生的身高来从低到高排序，现在站的队形可能是不对的
 * 让求出有多少个站的位置是不对的，返回统计的人数。
 * 解题思路：
 * 这道题其实很容易，最简单的思路就是对数组进行排序，然后对比新数组与原数组位置上数字不同的个数
 * 有多少个，当然排序这个我们可以借助计数排序来实现。
 *
 */
public class HeightChecker {

    public static int heightChecker(int[] heights) {

        int []heightToFreq=new int[101];
        for (int height:heights){
            heightToFreq[height]++;
        }

        int result=0;
        int curHeight=0;
        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight]==0){
                curHeight++;
            }

            if(curHeight!=heights[i]){
                result++;
            }

            heightToFreq[curHeight]--;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={1,1,4,2,1,3};
        System.out.println(heightChecker(arr));
    }

}
