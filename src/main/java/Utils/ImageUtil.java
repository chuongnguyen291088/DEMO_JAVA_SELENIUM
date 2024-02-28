package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.*;
import java.net.URL;

public class ImageUtil {
    public static boolean compareImage(File fileA, File fileB) {
        try {
            // take buffer data from both image files //
            BufferedImage biA = ImageIO.read(fileA);
            DataBuffer dbA = biA.getData().getDataBuffer();
            int sizeA = dbA.getSize();
            BufferedImage biB = ImageIO.read(fileB);
            DataBuffer dbB = biB.getData().getDataBuffer();
            int sizeB = dbB.getSize();
            // compare data-buffer objects //
            if (sizeA == sizeB) {
                for (int i = 0; i < sizeA; i++) {
                    if (dbA.getElem(i) != dbB.getElem(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Failed to compare image files ...");
            return false;
        }
    }

    public static void saveImageFromUrl(String imageUrl, String destination) {
        try {
            URL url = new URL(imageUrl);
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream(destination);
            fos.write(response);
            fos.close();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveImageFromUrl(boolean loginRequired, InputStream inputStream, String destination) {
        /*if (loginRequired) {
            (new ApiSteps()).login("valid");
        }
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = inputStream.read(buf))) {
                out.write(buf, 0, n);
            }
            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream(destination);
            fos.write(response);
            fos.close();
            out.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
