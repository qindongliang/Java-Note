package leetcode.easy.hash_table_all;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*****
 *
 * 链接：https://leetcode.com/problems/powerful-integers/
 *
 * 给定两个整形数字x和y，并给出一个限定范围，
 * 现在让求出所有x^i + y^j的值，并且这个值小于等于我们设置的bound值
 *
 *
 */
public class PowerfulInteger {

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        //集合存储结果
        Set<Integer> seen=new HashSet<>();
        //使用类似笛卡尔的积的方式来双层遍历
        for (int i = 1; i <=bound ; i=i*x) {
            for (int j = 1; i+j <= bound; j=j*y) {
                seen.add(i+j);//存储计算后的结构
                if(y==1){
                    break;//做一层优化，提前退出
                }
            }

            if(x==1) break;//做一层优化，提前退出
        }
        //将最终的结果以list方法返回
        return new ArrayList<>(seen);
    }


    public static void main(String[] args) {

        System.out.println(powerfulIntegers(2,3,10));
    }

}
