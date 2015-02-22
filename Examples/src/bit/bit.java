package bit;

import java.util.*;
public class bit {
    public static void main(String[] args) throws Throwable {
        byte[] data = new byte[12]; //��������׼��������LZ��˵�Ĵ��Ǳ�����byte������
        data[0] = Integer.valueOf("00011101", 2).byteValue(); //ͷ3��������LZ����������
        data[1] = Integer.valueOf("11000011", 2).byteValue();
        data[2] = Integer.valueOf("11000011", 2).byteValue();
        for (int i=3; i<data.length; i++) { //�й��ɵ����ݷ������������ȷ��
            data[i] = (i%2 == 0) ? (byte)0x00 : (byte)0xff;
        }

        System.out.println("test data:"); //�������ݴ�ӡ
        for (int i=0; i<data.length; i++) {
            System.out.printf("%s ", bitString((byte)data[i]));
        }
        System.out.println();
        
        byte key = Integer.valueOf("01110111", 2).byteValue(); //��bit�������ҵ���key
        System.out.println("key:");
        System.out.printf("key=%s\n", bitString(key));

        //Ϊ�˼�����򣬳����ж���ÿ����λ�Լ�ȡ���ݺ����˴�ӡ����
        System.out.println("--------test start--------"); //���Կ�ʼ
        byte b = 0;
        for (int i=0, bit=0; i<data.length; i++) {
            if (i == 0) {
                b = data[i]; //��һ������ֱ��ȡbyte��ֵ
            } else {
                System.out.printf("before bit offset:b=%s\n", bitString(b));
                if (bit > 0) { //���������λ�����Ҳ����ƶ�����byte��ʱ��
                    b <<= bit; //ȡ��һ��byteǰbitλ���ֲ���һ��byte���������
                    b |= (data[i] >> (8-bit)) & (0x00ff >> (8-bit));
                    System.out.printf("%d bit offset:b=%s\n", bit, bitString(b));
                    if (b == key) break;
                }
                for (int j=bit; j<8; j++) { //����һ�����ݵ�bitλ��ʼѭ��
                    b <<= 1; //�ϴ���������1λ
                    b |= ((data[i] >> (8-j-1)) & 1); //����һ�����ݵ�1λ�������ϴ����ݵĺ�1λ
                    System.out.printf("1 bit offset:b=%s\n", bitString(b));
                    if (b == key) { //����ҵ�key�����˳�ѭ�����������ƶ���bit��
                        bit = (j+1)%8;
                        break;
                    }
                    if (j == 7 && bit > 0) bit = 0;
                }
            }
            if (b == key) { //����ҵ�key
                System.out.printf("find key=%s\n", bitString(b));
                char[] c = new char[4]; //ȡ64λ��Ϣ���浽�ַ�������
        
                for (int j=i, k=0, cnt=0; j<i+9 && j<data.length; j++) { //�ӵ�ǰ��byte��ʼѭ��8��byteȡ64λ����
                    if (j==i) {
                        b = data[j]; //��һ��byte����ֱ�ӱ���
                    } else {
                        if (bit > 0) { //�����������λ����������byte��ʱ��
                            b <<= bit; //��һ��byte����bitλ
                            b |= (data[j] >> (8-bit)) & (0x00ff >> (8-bit)); //����һ����ǰbitλ������һ�����ݵĺ�bitλ
                        }
                        if (cnt == 0) { //��һ��byte��ʱ��
                            c[k] = (char)b; //���浽�ַ������У������ַ�����8λ���൱���ַ��ĸ�8λ����
                            c[k] <<= 8;
                            cnt++;
                        } else if (cnt == 1) { //�ڶ���byte��ʱ�򣬱����ַ��ĵ�8λ
                            c[k] |= b;
                            k++;
                            cnt = 0;
                        }
                        b = data[j];
                    }
                }

                for (int j=0; j<c.length; j++) { //��ӡ64 bit�Ľ��
                    System.out.printf("char data = %s\n", bitString(c[j]));
                }
                i += 8;
                if (i < data.length) b = data[i];
            }
        } 
        System.out.println("--------test end--------");
    }

    public static String bitString(byte b) { //��ȡbyte�Ķ�������Ϣ
        StringBuilder buf = new StringBuilder(Integer.toBinaryString(b & 0x000000ff));
        while (buf.length() < 8) {
            buf.insert(0, "0");
        }
        return buf.toString();
    }

    public static String bitString(char c) {//��ȡchar�Ķ�������Ϣ
        StringBuilder buf = new StringBuilder(Integer.toBinaryString(c & 0x0000ffff));
        while (buf.length() < 16) {
            buf.insert(0, "0");
        }
        return buf.toString();
    }
}
/*
�򵥲�����һ�£��������

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


