package leetcode.easy.hash_table_all;

import java.util.HashMap;
import java.util.Map;

public class NumberofBoomerangs {


    public int numberOfBoomerangs(int[][] points) {

        int count=0;
        Map<Integer,Integer> map=new HashMap<>(points.length);
        for(int []i :points){
            for (int []j:points){
                int dx=i[0]-j[0];
                int dy=i[1]-j[1];
                int d=dx*dx+dy*dy;
                Integer v=map.get(d);
                if(v!=null){
                    count+=2*v;
                    map.put(d,v+1);
                }else{
                    map.put(d,1);
                }
            }
            map.clear();
        }


        return count;
    }



}
