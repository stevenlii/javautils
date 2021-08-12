package com.paymoon.demo.Ztest;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Byte转换工具
 *
 * @author yangle
 */
public class ByteUtils {

    /**
     * 十六进制字符串转byte[]
     *
     * @param hex 十六进制字符串
     * @return byte[]
     */
    public static byte[] hexStr2Byte(String hex) {
        if (hex == null) {
            return new byte[]{};
        }

        // 奇数位补0
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }

        int length = hex.length();
        ByteBuffer buffer = ByteBuffer.allocate(length / 2);
        for (int i = 0; i < length; i++) {
            String hexStr = hex.charAt(i) + "";
            i++;
            hexStr += hex.charAt(i);
            byte b = (byte) Integer.parseInt(hexStr, 16);
            buffer.put(b);
        }
        return buffer.array();
    }

    //hextstring 转bytes
    public static byte[] HexStringToBytes(String s) {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    /**
     * byte[]转十六进制字符串
     *
     * @param array byte[]
     * @return 十六进制字符串
     */
    public static String byteArrayToHexString(byte[] array) {
        if (array == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            buffer.append(byteToHex(array[i]));
        }
        return buffer.toString();
    }

    /**
     * byte转十六进制字符
     *
     * @param b byte
     * @return 十六进制字符
     */
    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        return hex.toUpperCase(Locale.getDefault());
    }

    //按位异或
    public static int CheckSum(String s) {
        String ss = s.substring(1, s.indexOf("*"));
        byte[] bt = ss.getBytes();
        int checksum = bt[0];
        for (int i = 1; i < bt.length; i++) {
            checksum ^= bt[i];
        }
        return checksum;
    }

    //16进制转换为string字符串
    public static String fromHexString(String hexString) throws Exception {
        //用于接收接收结果
        String result = "";
        //转大写
        hexString = hexString.toUpperCase();
        //16进制字符
        String hexDigital = "0123456789ABCDEF";
        //将16进制字符串转换为char数组
        char[] hexs = hexString.toCharArray();
        //能被16整除，肯定可以被2整除
        byte[] bytes = new byte[hexString.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = hexDigital.indexOf(hexs[2 * i]) * 16 + hexDigital.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        //byte[]-->string
        result = new String(bytes, "utf-8");
        return result;
    }

    //string字符串转换为16进制
    public static String toHexString(String fsnr) throws Exception {
        byte[] msg = null;
        try {
            msg = fsnr.getBytes(Charset.defaultCharset());
        } catch (Exception e) {
        }
        String bdmessage = "A4";
        //把汉字转成两个字节用hexstring 表示
        for (int j = 0; j < msg.length; j++
        ) {
            String tempStr = Integer.toHexString(msg[j]);
            if (tempStr.length() > 2) {//如果是汉字
                tempStr = tempStr.substring(tempStr.length() - 2);//取最后两位
            }
            bdmessage += tempStr;
        }
        bdmessage = bdmessage.toUpperCase();
        return bdmessage;
    }
    /**
     * 字符串转换成十六进制字符串
     *
     * @param String str 待转换的ASCII字符串
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {
 
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
 
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
    /**
     * 字符串转换成Nginx十六进制字符串
     *
     * @param String str 待转换的ASCII字符串
     * @return String 每个Byte之间/x分隔，如: \x61\x6C\x6B]
     */
    public static String str2HexStrNginx(String str) {
    	
    	char[] chars = "0123456789ABCDEF".toCharArray();
    	StringBuilder sb = new StringBuilder("\\x");
    	byte[] bs = str.getBytes();
    	int bit;
    	
    	for (int i = 0; i < bs.length; i++) {
    		bit = (bs[i] & 0x0f0) >> 4;
    	sb.append(chars[bit]);
    	bit = bs[i] & 0x0f;
    	sb.append(chars[bit]);
    	if (i < bs.length -1) {
    		sb.append("\\x");
		}
    	}
    	return sb.toString().trim();
    }

   
}
