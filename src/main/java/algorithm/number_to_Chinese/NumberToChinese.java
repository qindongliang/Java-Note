package algorithm.number_to_Chinese;


import java.util.Stack;

public class NumberToChinese {
    private static  String[] cnNum = {"零", "一", "两", "三", "四", "五", "六", "七", "八", "九"};
    private static  ChineseUnit[] cnUnit = {
            ChineseUnit.zero, ChineseUnit.ten, ChineseUnit.hundred, ChineseUnit.thousand, ChineseUnit.ten_thousand, ChineseUnit.billion, ChineseUnit.million, ChineseUnit.ten_million,
            ChineseUnit.hundred_mullion,ChineseUnit.ten_billon,ChineseUnit.hundred_billon,ChineseUnit.thousand_billon,ChineseUnit.ten_thousand_billon};

    private static class BeanUnit{
        public ChineseUnit cnUnit;
        public String cnNum;
        public int num;


    }


    private static String numberToChinese(long value){

        String strValue=String.valueOf(value);
        if(value<=10){
            return cnNum[(int)value];
        }

        Stack<BeanUnit> stack=new Stack<>();

        //从右向左入栈
        int index=0;
        for (int i =strValue.length()-1; i >=0 ; i--) {
            int currentNum=Integer.parseInt(strValue.charAt(i)+"");
            BeanUnit beanUnit=new BeanUnit();
            beanUnit.cnNum=cnNum[currentNum];
            beanUnit.num=currentNum;
            beanUnit.cnUnit=cnUnit[index];
            stack.push(beanUnit);
            index++;
        }


        StringBuilder  sb=new StringBuilder();

        //从左到右出栈
        while (!stack.empty()) {
            BeanUnit bean = stack.pop();
            if (bean.num > 0) {
                sb.append(bean.cnNum);
               if(bean.cnUnit!=ChineseUnit.zero){
                   sb.append(bean.cnUnit.value);
               }
            } else if (bean.cnUnit != ChineseUnit.zero) {//忽略个位上数字操作
                BeanUnit nextNumber = stack.peek();
                //按照中文大写RMB的习惯，多个0情况下只留一个就可以了
                if(nextNumber!=null&&nextNumber.num != 0) {
                    sb.append(bean.cnNum);
                }

            }
        }
        //在最终的结果里面，对亿和万只保留最小位置的单位就可以
        String filters[]=new String[]{"亿","万"};
        for (String filter:filters )
        while (sb.indexOf(filter)!=sb.lastIndexOf(filter)){
                sb.deleteCharAt(sb.indexOf(filter));
        }


    return  sb.toString();

    }



    public static void main(String[] args) {

//        System.out.println(numberToChinese(104001));
        System.out.println(numberToChinese(111));//一百一十一
        System.out.println(numberToChinese(194000004));//一亿九千四百万零四
        System.out.println(numberToChinese(107000));//一十万零七千



    }


     enum ChineseUnit {
        /**
         *
         */
        zero("零"),
        ten("十"),
        hundred("百"),
        thousand("千"),
        ten_thousand("万"),
        billion("十万"),
        million("百万"),
        ten_million("千万"),
        hundred_mullion("亿"),
        ten_billon("十亿"),
        hundred_billon("百亿"),
        thousand_billon("千亿"),
        ten_thousand_billon("万亿");
        private String value;

        ChineseUnit(String value) {
            this.value = value;
        }

        /**
         * Getter method for property <tt>value</tt>.
         *
         * @return property value of value
         */
        public String getValue() {
            return value;
        }

        /**
         * Setter method for property <tt>value</tt>.
         *
         * @param value value to be assigned to property value
         */
        public void setValue(String value) {
            this.value = value;
        }

    }


}
