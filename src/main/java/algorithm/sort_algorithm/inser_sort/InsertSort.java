package algorithm.sort_algorithm.inser_sort;

import java.util.Arrays;

/****
 * 算法思想：
 * 遍历数组中每一个元素，每一个元素都会和前面所有的已经有序的集合元素
 * 进行比较，从而确定每一个元素的位置，这里故意拿一个
 * 降序好的例子，来做升序排序，比较典型的反映这种算法的思想。
 * 平均时间复杂度：O(n^2)
 * 平均空间复杂度：O(n)
 * 是否稳定：是稳定排序算法
 *
 */

public class InsertSort {

    public static void sort(int[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            //取遍历的每一个元素
            int currentNumber = numbers[i];
            int j = i - 1;
            //每一个元素，都会与前面所有的有序元素集合进行比较
            //从而交换自己的位置
            while (j >= 0 && numbers[j] > currentNumber) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            //找到当前元素的位置，然后交换。
            numbers[j + 1] = currentNumber;
            System.out.println(Arrays.toString(numbers));
        }
    }

    public static void main(String[] args) {

        int a[]={10,9,8,7,6};

        sort(a);//排序



    }

}
