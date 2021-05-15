package paper.test.keywords;

import paper.test.tool.MACCoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

import static paper.test.keywords.transform_Index.hexStr2BinStr;

public class keywordSet {

    public static void keywordSet__ciphertext_Gen(String oldfilePath, String newfilePath, String secretKey) {
        File oldFile = new File(oldfilePath);
        File newFile = new File(newfilePath);

        //从给定的字节数组构造一个秘密密钥
        byte[] key = secretKey.getBytes();

        //判断文件存在并且是文件
        Boolean boo = oldFile.exists() && oldFile.isFile();
        boolean poo = newFile.exists() && oldFile.isFile();
        System.out.println(boo);
        if (boo && poo) {
            BufferedReader bufferedReader = null;
            try {
                //构造一个BufferedReader类来读取文件
                bufferedReader = new BufferedReader(new FileReader(oldFile));
                String linetxt = null;

                // 使用HmacSHA256自动生成密钥
//                byte[] keyHmacSHA256 = MACCoder.initHmacSHA256Key();
                SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(signingKey);

                //result用来存储文件内容
                StringBuilder result = new StringBuilder();
                //按使用readLine方法，一次读一行
                while ((linetxt = bufferedReader.readLine()) != null) {
                    System.out.println(linetxt);
//                    String lineTex_ciphertext = MACCoder.encodeHmacSHA256(linetxt.getBytes(), keyHmacSHA256);
                    String lineTex_ciphertext = new String(mac.doFinal(linetxt.getBytes()));

                    String newconttent = linetxt.replace(linetxt, strTo16(lineTex_ciphertext));//替换
                    result.append(newconttent);
                    File newfile = new File(newfilePath);
                    PrintStream ps = new PrintStream(new FileOutputStream(newfile, true));
                    ps.println(newconttent);// 往aim.txt文件里写入字符串

                }
                //输出读出的所有数据（StringBuilder类型）
//                System.out.println(result);
                //对文件内容操作


            } catch (Exception e) {
                System.out.println("读取文件内容出错");
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            System.out.println("找不到指定的文件");
        }
    }

    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }


    public static void main(String argv[]) {
        String oldfilePath = "D:\\Document\\data_set\\keywordSet.txt";
        String newfilePath = "D:\\Document\\data_set\\keywordSet__ciphertext.txt";
        keywordSet__ciphertext_Gen(oldfilePath, newfilePath, "123456");
    }
}
