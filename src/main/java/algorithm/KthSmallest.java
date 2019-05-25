package algorithm;

/****
 *
 * 一道算法题：
 *
 * 题目：给定一个无序数组，查找第K小的值。
 *
 * 几种思路：
 *
 * （1）直接使用快排，堆排，归并排，排序之后取数组的k-1索引的值即可，时间复杂度为O(nLogn)
 *
 * （2）用大小为k的数组存前k个数，然后找出这里面最大的值kmax，耗时O(K)， 遍历剩余的数，如果有小于
 *  里面最大的数，就放进去替换掉当前最大的，依次遍历至结束，每次比较前都得找出kmax，故总的时间复杂度为：O(NK)
 *
 * （3）使用大顶堆，初始化为k个值，然后后面从k+1开始，依次读取每个值，判断当前的值是否比
 *  堆顶的值小，如果小就移除堆顶的值，新增这个小的值，依次处理完整个数组，取堆顶的值就得到第k小的值。
 *  时间复杂度为：建堆的时间为O(K)，每次调整最大堆结构时间为O(lgK)，从而总的时间复杂度为O(K + (N-K)lgK)
 *
 * （4）利用快排找基准的原理，可以在平均时间复杂度O（N）级别完成，当然最坏的情况下是O（n2）与快排的最坏情况一样
 *  原理，如下：
 *  根据题目描述，如果是第k小的值，那就说明在升序排序后，这个值一定在数组的k-1的下标处，如果在k-1处，也就是说只要找到像这样的左边有k个数比k小（可以是无序的，只要小就可以了），那么这个下标的值
 *  就是我们要找的值，利用这个思想我们就可以使用快排的思想，来快速的找基准值的index（数组下标从0开始），如果恰好碰到了基准值的下标index+1=k，那就说明，当基准值index，所在下标的值
 *  就是我们要找的结果。
 *
 *  下面的代码就是基于第四种思路来实现的，其他的方式各种有兴趣可以自己研究一下。
 *
 *  注意，这道题如果解决了，那么该题目的变形题，如给定一个无序数组，查找最小的k个数，或者叫前k小的所有数
 *  就非常容易解决了，思路是一样，只不过在最后返回的时候，要把k左边的所有的数返回即可。
 *
 *  同理把最小换成最大，前k小换成前k大都一样的思路。
 *
 */

public class KthSmallest {

    public static  int quickSortFindRaidx(int a[],int left ,int right){

        int pivot=a[left];
        int i=left;
        int j=right;

        while (i!=j){
            //找右边第一个小于基准点的数字
            while (a[j]>=pivot&&i<j) j--;
            //做右边第一个大于基准点的数字
            while (a[i]<=pivot&&i<j) i++;

            if(i<j){//进行交换
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }

        }
        //基准归位
        a[left]=a[i];
        a[i]=pivot;

        return i;
    }




    public static int findKthSmall(int a[], int left, int right , int k){
            if(k<=0||k>a.length){
                return -1;//超出查询范围，直接返回-1
            }
            //返回基准点的下标，从0开始
            int pivotIndex = quickSortFindRaidx(a, left, right);
            //包含基准点在内的左边的数字个数
            int leftNumCount = pivotIndex + 1;

            //说明当前基准下标的值就是我们要找的
            if (leftNumCount == k) {
                return a[pivotIndex];
            }
            //说明要找的数，在基准点的左边，继续在左边部分递归查找
            if (leftNumCount > k) {
                return findKthSmall(a, left, pivotIndex, k);
            }else {//说明要找的数，在基准点的右边，继续在右边部分递归查找
                return findKthSmall(a, pivotIndex + 1, right, k);

            }

    }


    public static void findMoreHalfNum(int arr[]){
        int num=findKthSmall(arr,0,arr.length-1,arr.length/2+1);//因为这个方法是按index查找，所以中位数的index应该向右移
        System.out.println(num);
    }


    public static void main(String[] args) {

        int [] arr={12, 3, 5, 7, 4, 19, 26};
        int kthMin = findKthSmall(arr,0,arr.length-1,1);
        System.out.println(kthMin);

        //find num which more than half in array
        int [] brr={4,2,3,4};
        findMoreHalfNum(brr);



    }

}
