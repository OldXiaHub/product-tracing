package org.taru.producttracing.util;

import com.google.zxing.WriterException;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * 徐大伟2019.8.21
 * 二维码工厂
 */
public class QRFactory {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    public static void creteQRFile(String batchId)
    {
        String info = String.format("http://127.0.0.1/Api/querybatch?batchId=%s",batchId);
        String destPath = "E:\\QRcodefile\\"+batchId;
        try {
            QRCode.encode(info, null, destPath, true);
            String resultStr = QRCode.decode("E:\\QRcodefile\\"+batchId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片转换为字节
     * @param batchId
     * @return
     */
    public static String getImageBinary(String batchId) {
        File f = new File("E:\\QRcodefile\\"+batchId);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
