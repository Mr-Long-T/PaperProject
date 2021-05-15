package paper.test.key_test;

import paper.test.keyGen.RSAAlgorithm;
import paper.test.tool.Prop;
import paper.test.tool.PropUtil;

public class RSA {
    public static void main(String[] args) throws Exception {
        Prop prop = PropUtil.use("key_pk_sk.properties");
        String pk = prop.get("pk");
        String sk = prop.get("sk");
        System.out.println("pk = " + pk);
        System.out.println("sk = " + sk);

        String str = new String("computer");
        String strEnc = RSAAlgorithm.encrypt(str,pk);
        System.out.println(str + "加密后：" + strEnc);
        String strDec = RSAAlgorithm.decrypt(strEnc,sk);
        System.out.println(strDec + "解密后：" + strDec);
    }
}
