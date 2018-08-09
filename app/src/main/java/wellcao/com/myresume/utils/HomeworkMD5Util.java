package wellcao.com.myresume.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wellcao
 * @date 2018/7/18
 * class introduction:  只作为随堂测上传校验文件完整性用
 */
public class HomeworkMD5Util {

    private static HomeworkMD5Util mInstance;

    private static char hexDigits[] ={ '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    private MessageDigest messageDigest;

    private HomeworkMD5Util(){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public synchronized static HomeworkMD5Util getInstance(){
        if (mInstance == null) {
            mInstance = new HomeworkMD5Util();
        }
        return mInstance;
    }

    /**
     *  获取文件的MD5校验值
     * @return
     */
    public String getFileMD5String(File file) throws Exception {
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = fis.read(buffer)) > 0) {
            messageDigest.update(buffer, 0, numRead);
        }
        fis.close();


        return buffer2Hex(messageDigest.digest(),0,messageDigest.digest().length);
    }


    private String buffer2Hex(byte[] bytes, int m , int n){
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();

    }

    private void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
        stringbuffer.append(c0);
        stringbuffer.append(c1);

    }

    public void resetDigest(){
        messageDigest.reset();
    }

}
