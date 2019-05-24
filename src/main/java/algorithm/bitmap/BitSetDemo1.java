package algorithm.bitmap;

import java.util.*;

public class BitSetDemo1 {


    public static Set<Integer>  findDuplicateNum(int []arr,int brr[]){
        // store result
        Set<Integer> result=new HashSet<>();
        if(null==arr||null==brr){
            return result;
        }
        BitSet map=new BitSet();

        // set status
        for(int num:arr){
            map.set(num,true);
        }

        //check number
        for(int num:brr){
            if(map.get(num)){
                result.add(num);
            }
        }

        return result;
    }



    public static List<Integer>  findDuplicateNum2(int []arr,int brr[]){
//        int C[]=new
        // store result
//        Set<Integer> result=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        if(null==arr||null==brr){
            return result;
        }

        int i=0;
        int j=0;
        while(i<arr.length&&j<brr.length){
            int tempA=arr[i];
            int tempB=brr[j];

            if(tempA==tempB){
                result.add(tempA);
                i++;
                j++;
            }else if(tempA<tempB){
                i++;
            }else{
                j++;
            }
        }

        return result;
    }



    //
    public static int  findDuplicateNum3(int []arr,int brr[]){
        // 如果不知道数组的递增还递减，可通过访问单个数组首尾元素进行判断
        // 计数
        int count=0;
        if(null==arr||null==brr){
            return count;
        }
        int C[]=new int[Math.min(arr.length,brr.length)];


        int i=0;
        int j=0;
        while(i<arr.length&&j<brr.length){
            if(arr[i]== brr[j]){

                if(count==0){
                    C[count++]=arr[i];
                }else{
                    if(C[count-1]!=arr[i]){
                        C[count++]=arr[i];
                    }
                }

                i++;
                j++;
            }else if(arr[i]< brr[j]){
                i++;
            }else{
                j++;
            }

        }

        System.out.println(Arrays.toString(C));
        return count;
    }


    public static void main(String[] args) {


        BitSet map=new BitSet();

//        System.out.println(map.size());

        int a[]={1,2,2,3,3,3,5,10,88,99};

        int b[]={2,2,3,3,3,4,8,10};


//        System.out.println(findDuplicateNum2(a,b));
        System.out.println(findDuplicateNum3(a,b));

        //赋值
//        for(int num:a){
//            map.set(num,true);
//        }
//
//        for(int num:b){
//            if(map.get(num)){
//                System.out.println(num);
//            }
//        }

//        for (int i = 0; i < map.size(); i++) {
//            if(map.get(i)){
//                System.out.print(i+" ");
//            }
//        }




    }

}
