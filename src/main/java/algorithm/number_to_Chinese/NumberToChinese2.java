package algorithm.number_to_Chinese;


import java.util.Stack;

public class NumberToChinese2 {
    private static final String[] cns = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    static String[] units={"个","十","百","千","万","十","百","千","亿","十","百","千","万"};



    private static String numberToChinese(long value){

        if(value<10){
            return cns[(int)value];
        }

        char array[]=String.valueOf(value).toCharArray();
//        System.out.println(Arrays.toString(array));
        if(array.length>units.length){
            System.out.println("超出目前计算的阈值");
        }

        int unitStep=4;
        int unitInc=0;
        Stack<String> stack=new Stack<>();
        // 用来处理连续二个0出现在进制位的情况下
        boolean lastUnit=false;
        //从个位开始迭代处理
        int end=array.length-1;
        //从后向前遍历
        for(int i=end;i>=0;i--){

            char ch=array[i];
            boolean isCurrentZero=ch=='0';
            int num=ch-'0'; //当前小写数字
            String cnNum=cns[num];//当前小写数字对应的中文大写
            String cnUnits=units[unitInc];//当前数字对应的进制（个，十，百....）
            boolean isUnit=unitInc>=unitStep&&unitInc%4==0;

            //后一位是否为0
            boolean lastFindZero = (i+1<=end && array[i+1]=='0');

            //当前是0, 并处于进制位时，仅仅保留进制单位
            if(isUnit){
                if(lastUnit) {//出现连续多进位，移除小进制单位
                    stack.pop();
                }
                if(isCurrentZero) {// 零的情况下，只追加单位
                    stack.push(cnUnits);
                    lastUnit=isUnit;//记录发生了进位情况
                }else { //非零的情况下，即追加大写又追加单位
                    stack.push(cnNum+cnUnits);//属于正常进制，不需要记录进位情况
                }
                unitInc++;
                continue;
            }
            //当前是0，并且后一位不是0的情况下，保留一位0
            if(isCurrentZero&&!lastFindZero){
                stack.push(cnNum);
            }

            //非零情况下，直接添加数字+进制单位
            if(!isCurrentZero){
                stack.push(cnNum+cnUnits);
                lastUnit=false;
            }

            unitInc++;
        }


        StringBuilder sb=new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        char lastChar=sb.charAt(sb.length()-1);
        if(lastChar=='零'||lastChar=='个'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();

    }



    public static void main(String[] args) {


        System.out.println(numberToChinese(111104558).equals("一亿一千一百一十万四千五百五十八"));
        System.out.println(numberToChinese(104040408).equals("一亿零四百零四万零四百零八"));
        System.out.println(numberToChinese(100030).equals("一十万零三十"));//
        System.out.println(numberToChinese(104001).equals("一十万四千零一"));//
        System.out.println(numberToChinese(1030000).equals("一百零三万"));//
        System.out.println(numberToChinese(301000010).equals("三亿零一百万零一十"));//
        System.out.println(numberToChinese(200003).equals("二十万零三"));//
        System.out.println(numberToChinese(100029338).equals("一亿零二万九千三百三十八"));//
        System.out.println(numberToChinese(100209).equals("一十万零二百零九"));//
        System.out.println(numberToChinese(33000050008L).equals("三百三十亿零五万零八"));//
        System.out.println(numberToChinese(33000000008L).equals("三百三十亿零八"));//
        System.out.println(numberToChinese(8877666555L).equals("八十八亿七千七百六十六万六千五百五十五"));//
        System.out.println(numberToChinese(302050406L).equals("三亿零二百零五万零四百零六"));//
        System.out.println(numberToChinese(3020504060L).equals("三十亿二千零五十万四千零六十"));//
        System.out.println(numberToChinese(30020504060L).equals("三百亿二千零五十万四千零六十"));//
        System.out.println(numberToChinese(504060).equals("五十万四千零六十"));
        System.out.println(numberToChinese(500460).equals("五十万零四百六十"));
        System.out.println(numberToChinese(50460).equals("五万零四百六十"));
        System.out.println(numberToChinese(332114).equals("三十三万二千一百一十四"));//
        System.out.println(numberToChinese(5004).equals("五千零四"));
        System.out.println(numberToChinese(3050000000l).equals("三十亿五千万"));//
        System.out.println(numberToChinese(300034302l).equals("三亿零三万四千三百零二"));//
        System.out.println(numberToChinese(300004302l).equals("三亿四千三百零二"));
        System.out.println(numberToChinese(3005060708001l).equals("三万零五十亿六千零七十万八千零一"));
        System.out.println(numberToChinese(100000000000l).equals("一千亿"));


    }



}
