package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
public class Bitmap {

    private String originalFileName;
    private String newFileName;
    private String transformation;

    public Bitmap(String originalFileName, String newFileName, String transformation) {

        this.originalFileName = "./src/main/resources/"+ originalFileName + ".bmp";
        this.newFileName = "./src/main/resources/"+ newFileName + ".bmp";
        if (transformation.equals("convert")){
            convert();
        } else if (transformation.equals("flipImage")){
            flipImage();
        } else if (transformation.equals("halfSizeIt")){
            halfSizeIt();
        } else {
            System.out.println("The method you requested does not exist. Please use either convert, flipImage, or halfSizeIt.");
        }
    }

    public void copyfile(String src, String dest) throws IOException{
//        create copy of each image automagicaly
        File source = new File(src);
        File destination = new File(dest);
        Files.copy(source.toPath(), destination.toPath());
    }

    public void convert(){
        try {
            File input = new File(originalFileName);
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);
            graphic.dispose();

            File output = new File(newFileName);
            ImageIO.write(result, "bmp", output);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void flipImage(){
        try {
            File input = new File(originalFileName);
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, image.getHeight(), image.getWidth(), 0, 0, 0, image.getWidth(), image.getHeight(), null);
            graphic.dispose();

            File output = new File(newFileName);
            ImageIO.write(result, "bmp", output);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void halfSizeIt(){
        try {
            File input = new File(originalFileName);
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0,  0, image.getWidth()/2, image.getHeight()/2,  null);
            graphic.dispose();

            File output = new File(newFileName);
            ImageIO.write(result, "bmp", output);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
