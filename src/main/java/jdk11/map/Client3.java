package jdk11.map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Client3 {

    private static final Logger logger = LogManager.getLogger(Client3.class);


    @Test
    public void t1(){
        // (h = key.hashCode()) ^ (h >>> 16)
        System.out.println(1000*1000 ^ (1000 >> 16));

        System.out.println(1111000000&15);
        System.out.println(1000100000&15);
    }

    public static void main(String[] args) {
        logger.info("(e.hash & oldCap) == 0");
        int hash = 0;
        int result = 0;
        int oldCap = 16;
        for (int i = 0; i < 10; i++) {
            result = hash & oldCap;
            logger.info("hash:" +hash + ", oldCap:" +oldCap + ", result:" + result);
            hash++;
        }


        logger.info(Integer.toBinaryString(128));
        logger.info(1 % 2);
        logger.info(1 / 2);


        logger.info(base10to2(8));
        logger.info(base10to2(0));
        logger.info(base10to2(1));
        logger.info(base10to2(10));
        logger.info(base10to2(128));
        logger.info(base10to2(100));
        printArr(base10to2(8));
        printArr(base10to2(0));
        printArr(base10to2(100));
        printArr(base10to2(128));
        printArr(base10to2(1));
        printArr(base10to2(131));


        logger.info(base2to10("00000000000000000000000000001000"));
        logger.info(base2to10("00000000000000000000000000000000"));
        logger.info(base2to10("00000000000000000000000001100100"));
        logger.info(base2to10("00000000000000000000000010000000"));
        logger.info(base2to10("00000000000000000000000000000001"));
        logger.info(base2to10("00000000000000000000000010000011"));

        int a = 1;
        System.out.println(a << 32);
        System.out.println(-1 % 32);
    }

    static void printArr(int[] arr){
        for (int i = 0, len = arr.length; i < len; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    // 与运算 &
    static int op_and(int a, int b){
        // 统一转成二进制
        int[] aArr = base10to2(a);
        int[] bArr = base10to2(b);
        int[] resultArr = new int[aArr.length];
        int result;

        // 都为1，则为1；否则为0
        for (int i = 0, len = aArr.length; i < len; i++) {
            if(aArr[i] == 1 && bArr[i] == 1){
                resultArr[i] = 1;
            }else{
                resultArr[i] = 0;
            }
        }
        result = base2to10(resultArr);
        return result;
    }

    // 或运算 |
    static int op_or(int a, int b){
        int[] aArr = base10to2(a);
        int[] bArr = base10to2(b);
        int[] resultArr = new int[aArr.length];
        int result;

        // 只要有1，则为1；否则为0
        for (int i = 0, len = aArr.length; i < len; i++) {
            if(aArr[i] == 1 || bArr[i] == 1){
                resultArr[i] = 1;
            }else{
                resultArr[i] = 0;
            }
        }
        result = base2to10(resultArr);
        return result;
    }

    // 异或运算 ^
    static int op_xor(int a, int b){
        int[] aArr = base10to2(a);
        int[] bArr = base10to2(b);
        int[] resultArr = new int[aArr.length];
        int result;

        // 只要a != b 就为1，否则为0
        for (int i = 0, len = aArr.length; i < len; i++) {
            if(aArr[i] != bArr[i]){
                resultArr[i] = 1;
            }else{
                resultArr[i] = 0;
            }
        }
        result = base2to10(resultArr);
        return result;
    }

    // 非运算 ~
    static int op_un(int a){
        int[] aArr = base10to2(a);
        int[] resultArr = new int[aArr.length];
        int result;

        // 将二进制的值取反
        for (int i = 0, len = aArr.length; i < len; i++) {
            if(aArr[i] == 1){
                resultArr[i] = 0;
            }else{
                resultArr[i] = 1;
            }
        }
        result = base2to10(resultArr);
        return result;
    }

    // 左移几位
    static int op_move_left(int a, int step){

        // 对32进行取余
        if(step < 0){
            step = step % 32 + 1;
        }else if(step >= 32){
            step %= 32;
        }

        int[] aArr = base10to2(a);

        int arrLen = aArr.length;

        // 左移几位
        for (int i = 0, len = arrLen - step; i < len; i++) {
            aArr[i] = aArr[i + step];
        }

        // 补0，即右边置0
        for (int i = 0; i < step; i++) {
            aArr[arrLen - 1 - i] = 0;
        }

        return base2to10(aArr);

    }

    // 右移几位
    static int op_move_right(int a, int step){

        // 对32进行取余
        if(step < 0){
            step = step % 32 + 1;
        }else if(step >= 32){
            step %= 32;
        }

        int[] aArr = base10to2(a);
        //

        int arrLen = aArr.length;


        for (int i = 0, len = arrLen - step; i < len; i++) {
            aArr[arrLen - 1 - i] = aArr[arrLen - 1 - step - i];
        }

        return base2to10(aArr);

    }

    // 无符号右移几位
    static int op_move_right_unsign(int a, int step){

        // 对32进行取余
        if(step < 0){
            step = step % 32 + 1;
        }else if(step >= 32){
            step %= 32;
        }

        int[] aArr = base10to2(a);
        //

        int arrLen = aArr.length;


        for (int i = 0, len = arrLen - step; i < len; i++) {
            aArr[arrLen - 1 - i] = aArr[arrLen - 1 - step - i];
        }

        return base2to10(aArr);

    }

    static int base2to10(String str){
        // 先转成 int[]
        int[] arr = new int[str.length()];
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            arr[i] = c - 48;
        }
        return base2to10(arr);
    }

    static int base2to10(int[] arr){
        // 最终累加的结果
        int result = 0;
        int tmp;

        for (int i = 0, len = arr.length; i < len; i++) {
            tmp = arr[len - 1 - i];
            if(tmp == 1){
                result += plus2_ntimes(i);
            }
        }
        return result;
    }

    // index 从又数起，首位为0
    static int plus2_ntimes(int index){
        int result = 1;
        for (int i = 0; i < index; i++) {
           result *= 2;
        }
        return result;
    }



    static int[] base10to2(int num){
        // 被除数
        int dividend = num;
        // 除数
        int divisor = 2;
        // 余数
        int tmpRemainder;
        // 商
        int tmpResult;


        // 余数列表，从上到下装
        List<Integer> remainderList = new ArrayList<>();

        do {
            tmpResult = dividend / 2;
            tmpRemainder = dividend % 2;
            remainderList.add(tmpRemainder);
            dividend = tmpResult;
        }while (tmpResult != 0);


        return align32(remainderList);
    }

    // 补齐32位
    static int[] align32(List<Integer> remainderList){
        //获取一个元素初始化为0的32容量的数组
        int[] arr = getInstanceInit32arr();
        for (int i = 0, len = remainderList.size(); i < len; i++) {
            arr[32 - 1 - i] = remainderList.get(i);
        }
        return arr;

    }

    static int[] getInstanceInit32arr() {
        int[] arr = new int[32];
        for (int i = 0; i < 32; i++) {
            arr[i] = 0;
        }
        return arr;
    }


}
