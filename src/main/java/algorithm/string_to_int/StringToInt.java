package algorithm.string_to_int;

/***
 * Convert string to integer number.
 */
public class StringToInt {

    private static int stringToInt(String s){
        //  Having one number at least.
        if(!s.matches("\\d+")){
            return  -1;
        }

        char []array=s.toCharArray();

        int lastIndex=array.length-1;
        int radix=0;
        int result=0;

        // right to left compute
        while (lastIndex>=0){
            int asciiToNumber= array[lastIndex] - 48;
            result += Math.pow(10,radix) * asciiToNumber ;
            radix++;
            lastIndex--;
        }

        return  result;


    }


    public static void main(String[] args) {

        System.out.println(stringToInt("1113"));



    }
}
