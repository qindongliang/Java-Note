package leetcode.easy.math;

/****
 *
 * 链接：https://leetcode.com/problems/di-string-match/
 *
 * 给定一个字符串，里面仅仅包含两个字母I和D，现在让返回整个集合任何相关的变形
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 * 如：
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 *
 * 思路：
 *
 * 使用数组的双指针法，对于遇到I的，进行从左到右赋值，否则则从右向左赋值，依次遍历结束
 * 数组的最后一位，等于最左边的left的偏移量值
 *
 *
 */
public class DIStringMatch {

    public int[] diStringMatch(String S) {

        int n=S.length();
        int left=0;
        int right=n;
        int []res=new int[n+1];
        for (int i = 0; i < n; i++) {
            res[i]=S.charAt(i)=='I'?left++:right--;
        }

        res[n]=left;

        return res;
    }

}
