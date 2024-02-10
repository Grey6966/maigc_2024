package com.magic;

import java.util.ArrayList;

public class Magic {
    public static void main(String[] args) {
        //随机获取 4 张扑克牌
        ArrayList pokers = generatePoker(4);
        System.out.println("===========================================随机获取的 4 张扑克牌为:" + arrayToString(pokers));
        ArrayList<String> copyAndMergeList = copyAndMerge(pokers);
        System.out.println("=======================复制并和原ArrayList<String> 合并后的扑克牌为:" + arrayToString(copyAndMergeList));
        //生成 1-7 的随机数
        int n = (int) (Math.random() * 7) + 1;
        moveFirstToLast(copyAndMergeList, n);
        System.out.println("======================将第一个元素放到最后，重复 " + n + "(随机) 次后的扑克牌为:" + arrayToString(copyAndMergeList) + "  n为：" + n);

        insertFirstThreeElements(copyAndMergeList, 3);
        System.out.println("=======================================前三张放入剩下任意中间位置后：" + arrayToString(copyAndMergeList));

        String first = copyAndMergeList.get(0);
        //copyAndMergeList 删除第一个元素
        copyAndMergeList.remove(0);
        System.out.println("=================================================藏起来第一张牌 ：" + arrayToString(copyAndMergeList) + "  藏起来的牌为：" + first);

        //1-3 之间的随机数
        int m = (int) (Math.random() * 3) + 1;
        insertFirstThreeElements(copyAndMergeList, m);
        System.out.println("============================再次插入前m(随机)张牌到剩下任意中间位置后：" + arrayToString(copyAndMergeList) + "  m为：" + m);

        //取1-2 随机数
        int k = (int) (Math.random() * 2) + 1;

        //copyAndMergeList 删除前k个元素
        for (int i = 0; i < k; i++) {
            copyAndMergeList.remove(0);
        }
        System.out.println("============================================扔掉来前k(随机)张牌 ：" + arrayToString(copyAndMergeList) + "  k为：" + k);

        moveFirstToLast(copyAndMergeList, 7);
        System.out.println("=====(见证奇迹的时刻)======再次将第一个元素放到最后，重复 7 次后的扑克牌为:" + arrayToString(copyAndMergeList));

        System.out.println("===================好运留下来，烦恼丢出去环节=========================：");
        int i = 1;
        while (copyAndMergeList.size() > 1) {
            moveFirstToLast(copyAndMergeList, 1);
            copyAndMergeList.remove(0);
            System.out.println("第" + i + "次：" + arrayToString(copyAndMergeList));
            i++;
        }
    }

    //随机生成 n 张扑克牌，符号和数字放在【】内 ，返回 ArrayList,不能含有重复的牌
    public static ArrayList generatePoker(int n) {
        ArrayList<String> pokers = new ArrayList<>();
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        while (pokers.size() < n) {
            String poker = colors[(int) (Math.random() * 4)] + numbers[(int) (Math.random() * 13)];
            if (!pokers.contains(poker)) {
                pokers.add(poker);
            }
        }
        return pokers;
    }

    //String ArrayList转换为 String  字符串，每个元素使用  【】 包裹
    public static String arrayToString(ArrayList<String> arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append("【").append(s).append("】");
        }
        return sb.toString();
    }

    //接收 ArrayList<String>  ，将ArrayList<String> 复制并和原ArrayList<String> 合并
    public static ArrayList<String> copyAndMerge(ArrayList<String> arr) {
        ArrayList<String> arr2 = new ArrayList<>(arr);
        arr2.addAll(arr);
        return arr2;
    }

    //接收 ArrayList<String>  将ArrayList<String> 第一个元素放到最后，重复 n 次
    public static ArrayList<String> moveFirstToLast(ArrayList<String> arr, int n) {
        for (int i = 0; i < n; i++) {
            arr.add(arr.get(0));
            arr.remove(0);
        }
        return arr;
    }

    //接收 ArrayList<String>  将ArrayList<String> 前 N个元素取出，原顺序插入到剩下的元素的任意中间位置
    public static void insertFirstThreeElements(ArrayList<String> list, int n) {
        ArrayList<String> firstThree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            firstThree.add(list.get(0));
            list.remove(0);
        }
        //firstThree 插入到 list 的任意中间位置,只能是中间，不能是两边
        int index = (int) (Math.random() * (list.size() - 1)) + 1;
        list.addAll(index, firstThree);

    }


}
