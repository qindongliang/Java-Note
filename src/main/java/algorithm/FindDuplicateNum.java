package algorithm;

/****
 *
 * 描述：
 * 这个题限制条件比较多，不能具有通用性，如下：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内，数组中的某些数字是重复的，但不知道有几个数字是重复的
 * 也不知道了重复了几次，请找出数组中任意一个重复的数字，如输入长度为7的数组{2,3,1,0,2,5,3}，那么对应
 * 输出重复的是2或者3。
 *
 * 思路：
 *
 * 假设数组{2,3,1,0,2,5,3}，使用下面的方法来找到重复数字的步骤，
 * 遍历每一个数字，然后对比该下面是否与该数字的值是否相等，
 * 如果相等则继续向后扫描，如果不相等，则取出该index的值，然后再使用该值，去取这个值下标的数据，
 * 然后判断，这两个值是否相等，如果相等就重复，否则，就交换这两个值的位值，一直遍历结束即可
 *
 *
 */
public class FindDuplicateNum {


    public static void findDuplicateNum(int arr[]){

        int i=0;
        while (i<arr.length){
            if(arr[i]>=arr.length){
                System.out.println("不合法元素，元素取值范围0到n-1，当前是"+arr[i]);
                return;
            }
            if(i!=arr[i]){
                int temp=arr[arr[i]];
                if(temp==arr[i]){
                    System.out.println("重复"+temp);
                    return;
                }else {
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }else {
                i++;
            }
        }

        System.out.println("没有找到重复的值");

    }



    public static void main(String[] args) {


        int []arr={5,2,5,1,4,3};
        findDuplicateNum(arr);

        int []arr1={1,2,3,4,5};
        findDuplicateNum(arr1);


    }


}
