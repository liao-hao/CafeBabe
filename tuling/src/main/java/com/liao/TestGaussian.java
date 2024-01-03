package com.liao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>在Java中，我们可以使用java.util.Random类的nextGaussian()方法来生成正态分布的随机数。这个方法返回的是一个以0为均值，1为标准差的正态分布随机数。我们可以通过调整均值和标准差来得到我们需要的范围。  以下是一个生成0-100范围内正态分布随机数的示例：
 */
public class TestGaussian {
    static Random random = new Random();

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        int times = 1000;
        for (int i = 0; i < times; i++) {

            int number = getGaussian();
            // 把number输出的结果范围用Map统计一下

            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }


        // 验证一下正态分布的均值和方差
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = -100; i < 200; i++) {
            Integer i1 = map.get(i);
            if (i1 != null) {
                sum += i1 * i;
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }

        // 把数字出现的次数打印成直方图
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                System.out.print(i + "\t");
                for (int j = 0; j < map.get(i); j++) {
                    System.out.print("|");
                }
                System.out.println();
            } else {
                System.out.println(i + "\t");
            }
        }


        // 打印方差 均值英文是mean, 方差英文是variance
        double mean = sum * 1.0 / times;
        double variance = 0;

        for (int i = -100; i < 200; i++) {
            Integer i1 = map.get(i);
            if (i1 != null) {
                variance += i1 * Math.pow(i - mean, 2);
            }
        }
        System.out.println("均值: " + mean);

        System.out.println("方差: " + variance / times);
        // 打印标准差
        System.out.println("标准差: " + Math.sqrt(variance / times));

    }

    private static int getGaussian() {
        double mean = 50.0; // 均值
        double stdDev = 10.0; // 标准差，使得大部分长度在[]之间
        int number = (int) Math.round(mean + stdDev * random.nextGaussian());
//        int number = (int) (mean + stdDev * random.nextGaussian());
        // 确保生成的数字在0-100之间, 如果不在这个范围, 就重新生成
        if (number < -100 || number > 200) {
            number = getGaussian();
        }
        return number;
    }
}
