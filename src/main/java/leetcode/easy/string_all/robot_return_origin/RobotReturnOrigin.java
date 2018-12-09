package leetcode.easy.string_all.robot_return_origin;

/**
 * Created by qindongliang on 2018/12/9.
 */
public class RobotReturnOrigin {

    public static boolean judgeCircle(String moves) {

        int x=0;
        int y=0;

        for (char c:moves.toCharArray()){
            switch (c){
                case 'U':x++;
                    break;
                case 'D':x--;
                    break;
                case 'L':y++;
                    break;
                case 'R':y--;
                    break;
                default:
                    break;
            }
        }

        return x==0&&y==0;

    }


    public static boolean judgeCircle2(String moves) {

        char all[]=new char[128];

        for (char move:moves.toCharArray()){
          all[move]++;
        }

        return all['U']==all['D']&&all['L']==all['R'];

    }


    public static void main(String[] args) {

        System.out.println(judgeCircle("LLLUUUD"));
        System.out.println(judgeCircle2("UD"));

    }


}
