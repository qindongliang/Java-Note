package algorithm.cache_algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes)
 */
public class LruCache {
    //设置的虚拟头节点
    Node head = new Node(0, 0);
    //设置的虚拟尾部节点
    Node tail = new Node(0, 0);

    //使用map来提升查询性能
    Map<Integer, Node> map = new HashMap<>();
    int capacity;//缓存保存数据的大小

    public LruCache(int capacity) {
        this.capacity = capacity;
        //初始化
        head.next = tail;
        tail.prev = head;
    }

    //查询数据
    public int get(int key) {
        //判断是否存在该条数据
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            //如果存在，就直接返回，并把该条数据从原来的位置移除，放入链表的头部
            return node.value;
        } else {
            //不存在就返回-1
            return -1;
        }
    }


    public void put(int key, int value) {
        //如果该节点已经存在，就删除该节点
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        //判断缓存容量是否达到上限
        if (map.size() == capacity) {
            remove(tail.prev);//如果达到上限就移除链表最后的节点
        }
        //插入新节点
        insert(new Node(key, value));
    }

    //移除无效的node
    public void remove(Node node) {
        map.remove(node.key);//移除目标节点
        //建立双向链表关系
        //目标节点的前置指向目标节点的后置
        node.prev.next = node.next;
        //目标节点的后置指向目标节点的前置
        node.next.prev = node.prev;
    }

    //插入一个节点
    private void insert(Node node) {
        //将数据，放入map中，加速查询
        map.put(node.key, node);
        //将新插入的数据，放在链表的头部，这里使用头插法，性能O（1）
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }


    //定义一个双向链表
    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
