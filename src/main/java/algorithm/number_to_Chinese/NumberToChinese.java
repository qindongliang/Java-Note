package algorithm.number_to_Chinese;


import java.util.Stack;

public class NumberToChinese {
    private static final String[] CHINESE_NUMBERS = {"零", "一", "两", "三", "四", "五", "六", "七", "八", "九", "十"};
    private static final ChineseUnit[] CHINESE_UNIT = {
            ChineseUnit.zero, ChineseUnit.ten, ChineseUnit.hundred, ChineseUnit.thousand, ChineseUnit.ten_thousand, ChineseUnit.billion, ChineseUnit.million, ChineseUnit.ten_million,
            ChineseUnit.hundred_mullion,ChineseUnit.ten_billon,ChineseUnit.hundred_billon,ChineseUnit.thousand_billon,ChineseUnit.ten_thousand_billon};

    private static class BeanUnit{
        private ChineseUnit chineseUnit;

       private String strNum;

       private int orginNum;

        public ChineseUnit getChineseUnit() {
            return chineseUnit;
        }

        public void setChineseUnit(ChineseUnit chineseUnit) {
            this.chineseUnit = chineseUnit;
        }

        public String getStrNum() {
            return strNum;
        }

        public void setStrNum(String strNum) {
            this.strNum = strNum;
        }

        public int getOrginNum() {
            return orginNum;
        }

        public void setOrginNum(int orginNum) {
            this.orginNum = orginNum;
        }
    }


    private static String numberToChinese(long value){

        String strValue=String.valueOf(value);
        if(value<=10){
            return CHINESE_NUMBERS[(int)value];
        }


        Stack<BeanUnit> stack=new Stack<>();

        int index=0;

        for (int i =strValue.length()-1; i >=0 ; i--) {
            int currentNum=Integer.parseInt(strValue.charAt(i)+"");
            BeanUnit beanUnit=new BeanUnit();
            beanUnit.setStrNum(CHINESE_NUMBERS[currentNum]);
            beanUnit.setOrginNum(currentNum);
            beanUnit.setChineseUnit(CHINESE_UNIT[index]);
            stack.push(beanUnit);
            index++;
        }


        StringBuilder  sb=new StringBuilder();
        boolean onceOnly=true;
        while (!stack.empty()) {
            BeanUnit bean = stack.pop();
            BeanUnit nextNumber = null;
            if (!stack.isEmpty()) {
                nextNumber = stack.peek();
            }
            if (bean.orginNum > 0) {
                sb.append(bean.strNum);

                if (bean.chineseUnit != ChineseUnit.zero) {
                    sb.append(bean.chineseUnit.value);
                }


            } else if (bean.chineseUnit != ChineseUnit.zero) {

                if(nextNumber!=null&&nextNumber.orginNum != 0) {
                    sb.append(bean.strNum);
                }
            }
        }


        String filters[]=new String[]{"亿","万"};
        for (String filter:filters )
        while (sb.indexOf(filter)!=sb.lastIndexOf(filter)){
                sb.deleteCharAt(sb.indexOf(filter));
        }



    return  sb.toString();

    }



    public static void main(String[] args) {


//        System.out.println(numberToChinese(104040408));
        System.out.println(numberToChinese(100030));
        System.out.println(numberToChinese(1030000));
//        System.out.println(numberToChinese(301000010));
//        System.out.println(numberToChinese(200003));
//        System.out.println(numberToChinese(100029338));
//        System.out.println(numberToChinese(100209));
        System.out.println(numberToChinese(3000000008L));




    }


    static enum ChineseUnit {
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
