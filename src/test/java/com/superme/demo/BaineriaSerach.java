package com.superme.demo;

/**
 * description:<二分查找法>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/2 9:36
 */
public class BaineriaSerach {

    public static void main(String[] args) {
        int[] intArr = {6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
        int key = 6;
        int rank = rank(key, intArr);
        System.out.println(key + "处于数组中第" + (rank + 1) + "位");
    }


    private static int rank(int key, int[] intArr) {
        int start = 0;
        int end = intArr.length - 1;
        // 未查找到返回值返回-1
        int find = -1;
        while (start <= end) {
            // 求中间值, 起始索引+一半的数量等于二分的节点
            int mind = start + (end - start) / 2;
            // 中间值如果>key, 证明需要查找的数在左边
            if (intArr[mind] > key) {
                end = mind - 1;
            }
            // 中间值如果<key, 证明需要查找的数在右边
            else if (intArr[mind] < key) {
                end = mind + 1;
            } else {
                return mind;
            }
        }
        return find;
    }


}
