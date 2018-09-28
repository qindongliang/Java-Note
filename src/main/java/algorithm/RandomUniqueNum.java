package algorithm;

import java.util.Arrays;
import java.util.Random;

public class RandomUniqueNum {

    private static int range=10;
    private static int[] result;

    public static void main(String[] args) {

        int a1[]=new int[range];
        int a2[]=new int[range];

        for (int i = 0; i < range; i++) {
            a1[i]=i;//初始化放入N个不重复的数
        }

        Random random=new Random();
        int end=range-1;

        for (int j = 0; j <10 ; j++) {

            int num=random.nextInt(end+1); //随机数的范围是1-100
            a2[j]=a1[num];//从数组1里面取出来随机数，放在数组2里面
            a1[num]=a1[end];//把取过的数，放在最后一位
            end--;

        }

        System.out.println(Arrays.toString(a2));

    }

}
