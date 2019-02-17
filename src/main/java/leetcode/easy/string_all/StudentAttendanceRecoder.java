package leetcode.easy.string_all;

public class StudentAttendanceRecoder {


    public static boolean checkRecord(String s) {
        if(!s.contains("LLL")&&(s.indexOf("A")==s.lastIndexOf("A"))){
            return true;
        }
      return false;
    }


    public static boolean checkRecord2(String s) {
         return  !s.matches(".*LLL.*|.*A.*A.*");
    }



    public static void main(String[] args) {


        System.out.println(checkRecord("PPALLL"));

    }


}
