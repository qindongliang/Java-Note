package algorithm.number_to_Chinese;


import java.util.Arrays;
import java.util.Stack;

public class NumberToChinese2 {
    private static final String[] cns = {"零", "一", "两", "三", "四", "五", "六", "七", "八", "九"};

    static String[] units={"","十","百","千","万","十","百","千","亿","十","百","千","万"};



    private static String numberToChinese(long value){

        if(value<10){
            return cns[(int)value];
        }

        char array[]=String.valueOf(value).toCharArray();
        System.out.println(Arrays.toString(array));
        if(array.length>units.length){
            System.out.println("超出目前计算的阈值");
        }

        int unitStep=4;
        int unitInc=0;
        Stack<String> stack=new Stack<>();
        //从个位开始迭代处理
        for(int i=array.length-1;i>=0;i--){

            char ch=array[i];
            boolean isZero=ch=='0';
            String desc=cns[ch-'0']+units[unitInc];
            boolean isUnit=unitInc>=unitStep&&unitInc%4==0;
            if(isUnit || !isZero){//判断是不是进位的时候
               if(isZero){//如果进位时候的数字是0，就放弃0，保留单位
                   desc=units[unitInc];
               }
            }


            System.out.println(desc);
            stack.push(desc);
            unitInc++;
        }


        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }








        return "";

    }



    public static void main(String[] args) {


//        System.out.println(numberToChinese(111104558));//一亿一千一百一十万四千五百五十八
//        System.out.println(numberToChinese(104040408));//一亿零四百零四万零四百零八
//        System.out.println(numberToChinese(100030));//一十万零三十
//        System.out.println(numberToChinese(400));//一十万零三十
//        System.out.println(numberToChinese(1030000));//一百零三万
//        System.out.println(numberToChinese(301000010));//三亿零一百万零一十
//        System.out.println(numberToChinese(200003));//两十万零三
//        System.out.println(numberToChinese(100029338));//一亿零两万九千三百三十八
//        System.out.println(numberToChinese(100209));//一十万零两百零九
//        System.out.println(numberToChinese(33000000008L));//三百三十亿零八
//        System.out.println(numberToChinese(8877666555L));//八十八亿七千七百六十六万六千五百五十五
//        System.out.println(numberToChinese(302050406L));//三亿零两百零五万零四百零六
//        System.out.println(numberToChinese(3020504060L));//三十亿两千零五十万零四千零六十
//        System.out.println(numberToChinese(30020504060L));//三百亿两千零五十万零四千零六十
//        System.out.println(numberToChinese(504060));//五十万零四千零六十
//        System.out.println(numberToChinese(500460));//五十万零四百六十
//        System.out.println(numberToChinese(50460));//五万零四百六十
//        System.out.println(numberToChinese(332114));//三十三万两千一百一十四
//        System.out.println(numberToChinese(54123));//五万四千一百两十三
//        System.out.println(numberToChinese(5004));//五万四千一百两十三
//        System.out.println(numberToChinese(3050000000l));//五万四千一百两十三
//        System.out.println(numberToChinese(300034302l));//五万四千一百两十三'
//        System.out.println(numberToChinese(300004302l));//五万四千一百两十三


    }



}
