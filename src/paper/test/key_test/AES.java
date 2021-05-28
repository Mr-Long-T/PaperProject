package paper.test.key_test;

import paper.test.keyGen.AESAlgorithm;
import paper.test.tool.Prop;
import paper.test.tool.PropUtil;
import sun.misc.BASE64Encoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {
    public static void main(String[] args) {
        Prop prop = PropUtil.use("key_sk.properties");
        String sk = prop.get("sk");

        byte[] decodedKey = Base64.getDecoder().decode(sk);
        SecretKey SK = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        String str = new String("A rising trend in market termed as “Cloud computing” has greatly metamorphosed the way organizations interacts with their customers, vendors and employees. Various internet services like Google, YouTube have modified the way people communicate, shop, educate, and much more. Services offered by cloud are: Software as a Service.Platform as a Service , and Infrastructure as a Service (Mell and Grance, 2011). As infrastructure, cloud provides a remote storage location, other than user's computer's hard drive or any other local and private storage infrastructure for keeping data and is maintained by cloud itself. Thus the pressure of keeping the data safe and dealing with daily increasing needs of organizations and indivi- duals for storage is handled by cloud provider. Access to data is facilitated via an Internet connection through a web based interface or some special Application Programming Interface.");
        byte[] strEnc = null;
        String strDec = "";
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            strEnc = AESAlgorithm.encrypt(str, SK);
            System.out.println("加密后：" + encoder.encode(strEnc));

            strDec = AESAlgorithm.decrypt(strEnc,SK);
            System.out.println("解密后：" + strDec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
