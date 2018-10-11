package sort_algorithm.bucket_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * 桶排序，适合整体数字分布比较均匀的场景
 * 平均时间复杂度：O(n*k)
 */
public class SimpleBucketSort {


    private static void bucketSort(){

        int arr[]={1,28,29,29,289,89,30,100,43,-2,36,57,58};

        int max=arr[0],min=arr[0];

        for(int i:arr){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }

        System.out.println("范围：["+min+"->"+max+"]");

        int bucketSize=5;

        int divider= (int)Math.ceil( (max+1)/bucketSize);

        System.out.println(" 桶的个数："+bucketSize+" 每个桶的范围："+divider);

        List<Integer>[] storeResults=new ArrayList[bucketSize];

        for (int i = 0; i <arr.length ; i++) {
              int findIndex=(int)Math.floor(arr[i]/divider);
              if(storeResults[findIndex]==null){
                  storeResults[findIndex]=new ArrayList<Integer>();
              }
              storeResults[findIndex].add(arr[i]);
        }

        int ndx=0;
        for(List bucket:storeResults){
            if(bucket==null) continue;
            //每个桶的数据，可以采用不同的排序方式，这里用Java内置的集合排序
            Collections.sort(bucket);
            //排序完的数据，即可归并
            for (Object i:bucket){
                 arr[ndx]=(int)i;
                 ndx++;
            }
        }

        System.out.println("排序后："+ Arrays.toString(arr));
    }


    public static void main(String[] args) {

        bucketSort();

    }
}
