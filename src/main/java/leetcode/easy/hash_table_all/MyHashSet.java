package leetcode.easy.hash_table_all;

import java.util.Arrays;

/****
 *
 * https://leetcode.com/problems/design-hashset/
 *
 * 实现一个hashset结构
 *
 *
 */
public class MyHashSet {

    boolean []arr=new boolean[100];

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {

        if(key>=arr.length){
            extend(key);
        }
        arr[key]=true;

    }

    public void remove(int key) {
        if(key<arr.length){
            arr[key]=false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key>=arr.length){
            return false;
        }

        return arr[key];
    }


    public void extend(int key){
        arr= Arrays.copyOf(arr,key+2);
    }


}
