package sort_algorithm.radix_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleRadixSort {


    public static void radixSort(){

        String arr[]={"20","1","1000","15","34"};

        //最大数字的字符个数，后面要根据这个数，做补白对齐
        int max=arr[0].length();
        for(String i : arr){
            max=Math.max(i.length(),max);
        }
        System.out.println("排序前："+Arrays.toString(arr));
        System.out.println("最大的数字几位数字组成："+max);

        String []format=new String[arr.length];

        for(int i=0;i<arr.length;i++){
            format[i]=String.format("%0"+max+"d",Integer.parseInt(arr[i]));
        }

        //数字组成10位
        int radix=10;

        List<String>[] store=new ArrayList[radix];
        //初始化数组
        for (int i = 0; i <radix ; i++) {
            store[i]=new ArrayList<String>();
        }



        //使用LSD从后向前，遍历计算
        for(int j=max-1;j>=0;j--) {

            for (int i = 0; i < format.length; i++) {
                String substr = format[i].substring(j,j+1);
                int digit = Integer.parseInt(substr);
                store[digit].add(format[i]);//根据位数分桶
            }

            int ndx=0;
            for (int i=0;i<store.length;i++){//到出数字
                if(!store[i].isEmpty()){
                    //将集合数字，重新归位到数组里面
                    for (String element:store[i]){
                        format[ndx]=element;
                        ndx++;
                    }
                    store[i].clear();//清空List的数据，等待下一轮计算

                }

            }



        }


        System.out.println("排序完成：");

        for(String number:format){
            System.out.println(Integer.parseInt(number));
        }








    }


    public static void main(String[] args) {

        radixSort();


    }

}
