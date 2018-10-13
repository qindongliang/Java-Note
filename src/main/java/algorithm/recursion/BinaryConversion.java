package algorithm.recursion;

/**
 * 十进制转换大于2进制的任意进制
 * Created by qindongliang on 2018/10/13.
 */
public class BinaryConversion {

      static char item[]="0123456789ABCDEF".toCharArray();

    /***
     *
     * @param sb 输出结果
     * @param n  要转换的10进制数字
     * @param digit 要转的进制
     * @return
     */
    private static StringBuilder conversion(StringBuilder sb,int n,int digit){

        if(digit<2){
            digit=2;
        }

        if(n<=0){
            return sb.append("");
        }
        StringBuilder reuslt=conversion(sb,n/digit,digit);
        return  reuslt.append(item[n%digit]);

    }


    public static void main(String[] args) {

        System.out.println(conversion(new StringBuilder(),10,2));

    }



}
