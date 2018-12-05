package algorithm.reservoir_sample;

import java.util.Arrays;
import java.util.Random;

/***
 * 水塘采样算 从包含N个项目的集合S中随机选取k个样本，其中N为一很大、未知的数量，以至于不能把所有N个项目都存放到主内存。要求只对N遍历一次
 * 应用场景:
 * （1）对象为无法在内存中放下的数据, 如不间断数据流, 或者巨大的文件, 数组等.
 * （2）样本集的大小为k, 并且要求每个样本的取样概率相等.
 * （3）取样概率可以通过添加权重(weight)来改变取样概率.
 *
 *
 *
 */
public class ReservoirSample {


    /***
     *
     * @param input 模拟的原始数组
     * @param k 采样的的个数
     * @return  返回采样的数据
     */
    public static int[]  sample(int []input,int k){
        Random random=new Random();
        int []ret=new int[k];

        for (int i = 0; i <input.length ; i++) {
            if(i<k){
                ret[i]=input[i]; //先取，前k个数字放在数组里面
            }else{//如果i>k，在1-i之间，取一个随机数字，如果这个随机数字小于k，就替换数组，否则就继续遍历，知道结束
               int rand=random.nextInt(i);//
               if(rand<k){
                   ret[rand]=input[i];
               }
            }
        }
     return  ret;
    }





    public static void main(String[] args) {


        int input[]=new int[1000];
        for (int i = 0; i <input.length ; i++) {
            input[i]=i;
        }
        //进行采样
        int []result= sample(input,10);

        System.out.println(Arrays.toString(result));


    }


}
