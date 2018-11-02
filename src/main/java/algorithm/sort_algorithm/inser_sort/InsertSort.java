package algorithm.sort_algorithm.inser_sort;

import java.util.Arrays;

/****
 * 10,9,8,7,6
 *
 *
 */

public class InsertSort {

    public static void sort(int[] numbers){
        for (int i = 1; i < numbers.length; i++) {
            //取遍历的每一个元素
            int currentNumber = numbers[i];
            int j = i - 1;
            //
            while (j >= 0 && numbers[j] > currentNumber) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = currentNumber;
            System.out.println(Arrays.toString(numbers));
        }
    }

    public static void main(String[] args) {

        int a[]={10,9,8,7,6};

        sort(a);

        System.out.println(Arrays.toString(a));


    }

}
