package leetcode.easy.array_all;

/****
 *
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 * 这道题的关键在于读懂题目描述，如下：
 *
 * 给定一个A数组，然后给定一个queries[i][j]的查询的映射二维数组，这个二维数组里面的第一个值是
 * 查询的value，第二个值是查询的索引值，这个索引值是A数组里面对应的下标。
 *
 * 现在题目要求对于queries这个二维数组，遍历每一个元素，如果这个元素的value加到A数组里面对应的index的值上，
 * 然后求出当前这个A数组里面，所有偶数元素的和，作为对应输出的一个元素，依次类推知道遍历完整个二维数组。
 * 最终得到所有的值，放到一个数组里面返回，就得到结果了。
 *
 * 下面的类里面给出了两种解法：
 *
 * 解法一：容易理解，但效率比较低是 m * n 的复杂度
 *
 * 解法二：相对不容易理解，但效率比较高 m + n的复杂度
 *
 */
public class SumEvenNumber {


    //容易理解但不高效
    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {

        int []op=new int[A.length];
        for (int i = 0; i <queries.length ; i++) {
            int sum=0;
            A[queries[i][1]]=A[queries[i][1]]+queries[i][0];
            for (int j = 0; j <A.length ; j++) {
                if(A[j]%2==0){
                    sum+=A[j];
                }
            }
            op[i]=sum;

        }

        return op;

    }


    //高效但不太容易理解
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        //先把原来所有的偶数值求和，作为初始化值
        int sumEven=0;
        for (int num:A){
            if( num%2==0) sumEven+=num;
        }


        int []ans=new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index=queries[i][1];
            int value=queries[i][0];

            //如果原数据组的值是偶数，新的kv的值也是偶数，那就直接加value
            if(A[index]%2==0){ // A[index] even
                if(value%2==0){ //原来是偶数，现在也是偶数，原来的偶数在程序开头已经加和了，现在只需要加上现在的偶数即可
                    sumEven+=value; //even value
                }else {//原来是偶数，现在是奇数，结果必为奇数，相当于原来多加了，所以减去
                    sumEven-=A[index]; // odd value
                }
            }else{    // A[index] odd  如果原来是奇数

                if(value%2==0){  //原来是奇数+现在是偶数 ，新增的kv是偶数，那么结果是奇数+偶数=奇数，因为原来是奇数也没加，所以不做处理

                }else{//原来是奇数+现在是奇数，奇数+奇数=偶数，原来没加，现在没加，所以要把两个都加上
                    sumEven+=A[index]+value; // odd value
                }

            }
            ans[i]=sumEven;//把结果放入数组中
            A[index]+=value;//更新A数组里面对应位置的值

        }


        return ans;
    }



}
