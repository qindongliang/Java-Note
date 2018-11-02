package algorithm.sort_algorithm.shell_sort;

import java.util.Arrays;

/**
 * 希尔排序思想：
 *
 * 希尔排序是插入排序算法的优化版本，
 * 插入排序交换元素是两两比较交换的，即一次只能移动交换一个元素
 * 改进后的希尔排序可以根据步长每次移动交换两个元素，大大减少
 * 不必要的交换，最终步长等于1时，彻底退化为插入排序
 * 但这时，交换的次数会大大减少。
 *
 * 平均时间复杂度：O(nlog^2 n)
 * 平均空间复杂度：O(1)
 * 稳定性： 不稳定
 *
 */
public class ShellSort {

    public static void sort(int array[]){
        //初始化步长
        int number = array.length / 2;
        //只要步长大于1，就继续排序
        while (number >= 1) {
            //遍历从步长开始的位置元素
            for (int i = number; i < array.length; i++) {
                //取出来当前遍历的元素
                int temp = array[i];
                //得到当前位置减去步长后的下标
                int j = i - number;
                //比较当前值与步长值的大小
                while (j >= 0 && array[j] > temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                //赋值交换
                array[j + number] = temp;
                System.out.println(Arrays.toString(array));
            }
            //步长继续缩小，最终一定是1，整个算法退化成插入排序
            number = number / 2;
        }



    }

    public static void main(String[] args) {
        int a[]={10,9,8,7,6};

        sort(a);

    }


}
