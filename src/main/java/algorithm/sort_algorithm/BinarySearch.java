package algorithm.sort_algorithm;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        //必须要求数组是排好序的，否则就结果就有问题
        int a[]={66,3,77,6,8,};

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int searchKey=27;
        int start=0;
        int end=a.length-1;

        while (start<=end){

//            int mid=(start+end)/2;
            int mid=(start+end)>>>1;

            int midVal=a[mid];

            if(midVal<searchKey){
                start=mid+1;
            }else if(midVal>searchKey){
                end=mid-1;
            }else{
                System.out.println(" 找到数据，数组下标："+mid);
                return;
            }


        }
        System.out.println("没有找到数据..");



    }
}
