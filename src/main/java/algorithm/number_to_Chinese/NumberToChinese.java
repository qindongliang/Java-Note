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

        while (!stack.empty()) {
            BeanUnit bean = stack.pop();
            if (bean.orginNum > 0) {
                sb.append(bean.strNum);

                if (bean.chineseUnit != ChineseUnit.zero) {
                    sb.append(bean.chineseUnit.value);
                }


            } else if (bean.chineseUnit != ChineseUnit.zero) {
                BeanUnit nextNumber = stack.peek();
                if(nextNumber!=null&&nextNumber.orginNum != 0) {
//                    switch (bean.chineseUnit){
//                        case hundred_mullion:
//                        case ten_billon:
//                        case hundred_billon:
//                        case thousand_billon:
//                        case ten_thousand_billon:
//                            break;
//                        default:
//                                sb.append(bean.strNum);
//                                break;
//                    }
                    sb.append(bean.strNum);
                }

            }
        }

//        System.out.println(sb.toString());
        String filters[]=new String[]{"亿","万"};
        for (String filter:filters )
        while (sb.indexOf(filter)!=sb.lastIndexOf(filter)){
                sb.deleteCharAt(sb.indexOf(filter));
        }





    return  sb.toString();

    }



    public static void main(String[] args) {


//        System.out.println(numberToChinese(104040408));//一亿零四百零四万零四百零八
//        System.out.println(numberToChinese(100030));//一十万零三十
//        System.out.println(numberToChinese(1030000));//一百零三万
//        System.out.println(numberToChinese(301000010));//三亿零一百万零一十
//        System.out.println(numberToChinese(200003));//两十万零三
//        System.out.println(numberToChinese(100029338));//一亿零两万九千三百三十八
//        System.out.println(numberToChinese(100209));//一十万零两百零九
//        System.out.println(numberToChinese(33000000008L));//三百三十亿零八
//        System.out.println(numberToChinese(8877666555L));//八十八亿七千七百六十六万六千五百五十五
//        System.out.println(numberToChinese(302050406L));//三亿零两百零五万零四百零六
        System.out.println(numberToChinese(3020504060L));//三十亿两千零五十万零四千零六十
//        System.out.println(numberToChinese(30020504060L));//三百亿两千零五十万零四千零六十
        System.out.println(numberToChinese(504060));//五十万零四千零六十
        System.out.println(numberToChinese(500460));//五十万零四百六十
        System.out.println(numberToChinese(50460));//五万零四百六十
        System.out.println(numberToChinese(332114));//三十三万两千一百一十四
        System.out.println(numberToChinese(54123));//五万四千一百两十三
        System.out.println(numberToChinese(5004));//五万四千一百两十三


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
