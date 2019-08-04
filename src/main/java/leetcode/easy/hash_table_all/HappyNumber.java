package leetcode.easy.hash_table_all;

/****
 *
 *
 * 题目描述：给定一个整数n，判断这个数字是否符合happy数字的特征
 *
 * happy数字的特征是，将这个数拆分之后，每一部分的平方和会等于一个数，
 * 然后对这个数再次进行分解，如果最终能到每一个数字的平方和等于1，那么该数字
 * 就是happy数字，当然也会出现死循环，我们需要对这种情况做判断容错
 *
 *
 * 思路：对于给定的数字，计算当前每一个数字的平方和和，如果值==1，就返回true，
 * 其他的情况要判断是否有死循环，有就结束
 *
 *
 */
public class HappyNumber {

    public boolean isHappy(int n) {


        int x=n;
        int y=n;
        while (x>1){

            x=cal(x);//计算平方和
            if(x==1){//符合要求返回
                return true;
            }

            y=cal(cal(y));//计算下一个依赖路径

            if(x==y){//死循环退出
                return false;
            }

        }


        return true;


    }


    public int cal(int n){
        int x=n;
        int s=0;
        while (x>0){
            s=s+(x%10)*(x%10);
            x=x/10;
        }
        return s;
    }


}

