package bit;

import java.util.*;
public class bit {
    public static void main(String[] args) throws Throwable {
        byte[] data = new byte[12]; //测试数据准备，假设LZ所说的串是保存在byte数组中
        data[0] = Integer.valueOf("00011101", 2).byteValue(); //头3个数据用LZ的例子数据
        data[1] = Integer.valueOf("11000011", 2).byteValue();
        data[2] = Integer.valueOf("11000011", 2).byteValue();
        for (int i=3; i<data.length; i++) { //有规律的数据方便检验程序的正确性
            data[i] = (i%2 == 0) ? (byte)0x00 : (byte)0xff;
        }

        System.out.println("test data:"); //测试数据打印
        for (int i=0; i<data.length; i++) {
            System.out.printf("%s ", bitString((byte)data[i]));
        }
        System.out.println();
        
        byte key = Integer.valueOf("01110111", 2).byteValue(); //在bit数据中找到的key
        System.out.println("key:");
        System.out.printf("key=%s\n", bitString(key));

        //为了检验程序，程序中对于每次移位以及取数据后做了打印处理
        System.out.println("--------test start--------"); //测试开始
        byte b = 0;
        for (int i=0, bit=0; i<data.length; i++) {
            if (i == 0) {
                b = data[i]; //第一个数据直接取byte的值
            } else {
                System.out.printf("before bit offset:b=%s\n", bitString(b));
                if (bit > 0) { //如果发生移位，并且不是移动整个byte的时候
                    b <<= bit; //取下一个byte前bit位来弥补上一个byte不足的数据
                    b |= (data[i] >> (8-bit)) & (0x00ff >> (8-bit));
                    System.out.printf("%d bit offset:b=%s\n", bit, bitString(b));
                    if (b == key) break;
                }
                for (int j=bit; j<8; j++) { //从下一个数据的bit位开始循环
                    b <<= 1; //上次数据左移1位
                    b |= ((data[i] >> (8-j-1)) & 1); //用下一个数据的1位来补到上次数据的后1位
                    System.out.printf("1 bit offset:b=%s\n", bitString(b));
                    if (b == key) { //如果找到key，则退出循环，并保存移动的bit数
                        bit = (j+1)%8;
                        break;
                    }
                    if (j == 7 && bit > 0) bit = 0;
                }
            }
            if (b == key) { //如果找到key
                System.out.printf("find key=%s\n", bitString(b));
                char[] c = new char[4]; //取64位信息保存到字符数组中
        
                for (int j=i, k=0, cnt=0; j<i+9 && j<data.length; j++) { //从当前的byte开始循环8个byte取64位数据
                    if (j==i) {
                        b = data[j]; //第一个byte数据直接保存
                    } else {
                        if (bit > 0) { //如果发生了移位，即不是整byte的时候
                            b <<= bit; //上一个byte左移bit位
                            b |= (data[j] >> (8-bit)) & (0x00ff >> (8-bit)); //用下一个的前bit位补到上一个数据的后bit位
                        }
                        if (cnt == 0) { //第一个byte的时候
                            c[k] = (char)b; //保存到字符数组中，并让字符左移8位，相当于字符的高8位保存
                            c[k] <<= 8;
                            cnt++;
                        } else if (cnt == 1) { //第二个byte的时候，保存字符的低8位
                            c[k] |= b;
                            k++;
                            cnt = 0;
                        }
                        b = data[j];
                    }
                }

                for (int j=0; j<c.length; j++) { //打印64 bit的结果
                    System.out.printf("char data = %s\n", bitString(c[j]));
                }
                i += 8;
                if (i < data.length) b = data[i];
            }
        } 
        System.out.println("--------test end--------");
    }

    public static String bitString(byte b) { //获取byte的二进制信息
        StringBuilder buf = new StringBuilder(Integer.toBinaryString(b & 0x000000ff));
        while (buf.length() < 8) {
            buf.insert(0, "0");
        }
        return buf.toString();
    }

    public static String bitString(char c) {//获取char的二进制信息
        StringBuilder buf = new StringBuilder(Integer.toBinaryString(c & 0x0000ffff));
        while (buf.length() < 16) {
            buf.insert(0, "0");
        }
        return buf.toString();
    }
}
/*
简单测试了一下，结果如下

test data:
00011101 11000011 11000011 11111111 00000000 11111111 00000000 11111111 00000000
 11111111 00000000 11111111
key:
key=01110111
--------test start--------
before bit offset:b=00011101
1 bit offset:b=00111011
1 bit offset:b=01110111
find key=01110111
char data = 0000111100001111
char data = 1111110000000011
char data = 1111110000000011
char data = 1111110000000011
before bit offset:b=11111111
2 bit offset:b=11111100
1 bit offset:b=11111000
1 bit offset:b=11110000
1 bit offset:b=11100000
1 bit offset:b=11000000
1 bit offset:b=10000000
1 bit offset:b=00000000
before bit offset:b=00000000
1 bit offset:b=00000001
1 bit offset:b=00000011
1 bit offset:b=00000111
1 bit offset:b=00001111
1 bit offset:b=00011111
1 bit offset:b=00111111
1 bit offset:b=01111111
1 bit offset:b=11111111
--------test end--------
*/


