package j2ee.eTicket.util;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.util.ArrayList;

/**
 * 静态方法对文件的各种操作，包括保存，更新，删除，加载等
 */
@Component
public class FileUtil {

    private static int MAX_FILE_SIZE = 65535;
    private static String profilePath = "E:\\IDEA\\eTicket\\src\\main\\resources\\profile\\";
    private static String enviromentPath = "E:\\IDEA\\eTicket\\src\\main\\resources\\environment\\";

    //用户注册时使用默认头像
    public static byte[] getDefaultProfile(){
        File file = new File(profilePath + File.separator + "default.jpg");
        return saveImage(file);
    }
//
//    public static void save(File file, int userId){
//        String fileName = String.valueOf(userId) + ".jpg";
//        OutputStream outputStream = null;
//        try{
//            String path = profilePath + File.separator + fileName;
//            byte[] bs = new byte[1024];
//            // 读取到的数据长度
//            int len;
//            // 输出的文件流保存到本地文件
//
//            File tempFile = new File(profilePath);
//            if (!tempFile.exists()) {
//                tempFile.mkdirs();
//            }
//            outputStream = new FileOutputStream(path);
//            // 开始读取;
//            Image image = ImageIO.read(file);
//            image = resize(400,400,image);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 完毕，关闭所有链接
//            try {
//                outputStream.close();
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static String update(File file, int userId){
        return null;
    }

    public static void delete(int userId){

    }

    public static File load(int userId){
        return null;
    }

    public static ArrayList<File> load(int shopId, int userId){
        return null;
    }

    public static byte[] saveImage(File file){
        FileInputStream in = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ch;
        byte[] result = null;
        try {
            if (file.length() > MAX_FILE_SIZE){
                resize(400,400,file);
            }
            in  = new FileInputStream(file);
            while((ch=in.read())!=-1){
                byteArrayOutputStream.write(ch);
            }
            result = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public static File readImage(byte[] binary){
        return null;
    }
    private static Image resize(int weight, int height, File file)throws IOException{
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        BufferedImage tempImg = null;
        if (suffix.equals("png")||suffix.equals("PNG")){
            tempImg = new BufferedImage(weight,height,BufferedImage.TYPE_INT_ARGB);
        }else {
            tempImg = new BufferedImage(weight,height,BufferedImage.TYPE_INT_RGB);
        }
        tempImg.getGraphics().drawImage(ImageIO.read(file), 0, 0, weight, height, null);
        return tempImg;
    }
}
