package paper.test.keywords;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class transform_Index {
    public static String HMACSHA256(String a,String b) throws UnsupportedEncodingException
    {
        byte[] data = a.getBytes();
        byte[] key = b.getBytes();
        System.out.println("key:" + Arrays.toString(key));
        try  {
            //从给定的字节数组构造一个秘密密钥。
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            //System.out.println(Arrays.toString(mac.doFinal(data)));
            return byte2hex(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        //经过Hmac_SHA256产生的64位16进制数
        String tempString = hs.toString().toUpperCase();
        //System.out.println(tempString);

        //二进制字符串
        //System.out.println(hexStr2BinStr(tempString));
        //System.out.println(hexStr2BinStr(tempString).length());
        return hexStr2BinStr(tempString);

    }

    private static String hexStr = "0123456789ABCDEF";
    private static String[] binaryArray = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
            "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
    /**
     *
     * @param
     * @return 二进制数组转换为二进制字符串 2-2
     */
    public static String bytes2BinStr(byte[] bArray) {

        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            // 高四位
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            // 低四位
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;
    }

    /**
     *
     * @param bytes
     * @return 将二进制数组转换为十六进制字符串 2-16
     */
    public static String bin2HexStr(byte[] bytes) {

        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            // 字节高4位
            hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
            // 字节低4位
            hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
            result += hex; // +" "
        }
        return result;
    }

    /**
     *
     * @param hexString
     * @return 将十六进制转换为二进制字节数组 16-2
     */
    public static byte[] hexStr2BinArr(String hexString) {
        // hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;// 字节高四位
        byte low = 0;// 字节低四位
        for (int i = 0; i < len; i++) {
            // 右移四位得到高位
            high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
            bytes[i] = (byte) (high | low);// 高地位做或运算
        }
        return bytes;
    }

    /**
     *
     * @param hexString
     * @return 将十六进制转换为二进制字符串 16-2
     */
    public static String hexStr2BinStr(String hexString) {
        return bytes2BinStr(hexStr2BinArr(hexString));
    }


    public static void main(String[] args) throws Exception {
        System.out.println(HMACSHA256("computer", "999999"));
//        System.out.println(HMACSHA256("nc", "123456"));
//        System.out.println(HMACSHA256("cr", "123456"));
//        System.out.println("///");
//        System.out.println(HMACSHA256("ry", "123456"));
//        System.out.println(HMACSHA256("ri", "123456"));
//        System.out.println("///");
//        System.out.println(HMACSHA256("yp", "123456"));
//        System.out.println(HMACSHA256("ip", "123456"));
//        System.out.println("///");
//        System.out.println(HMACSHA256("pt", "123456"));
    }
}