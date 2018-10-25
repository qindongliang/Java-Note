package algorithm.bitmap;

import java.util.BitSet;

public class BitSetDemo1 {

    public static void main(String[] args) {


        BitSet map=new BitSet();

        System.out.println(map.size());

        int a[]={2,3,14,7,0};

        //赋值
        for(int num:a){
            map.set(num,true);
        }
        //排序

        for (int i = 0; i < map.size(); i++) {
            if(map.get(i)){
                System.out.print(i+" ");
            }
        }




    }

}
