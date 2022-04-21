package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Bitmap {

    private String originalFileName;
    public void seeBMPImage(String BMPFileName) throws IOException {
        this.originalFileName = "./src/main/resources/" + BMPFileName + ".bmp";
        BufferedImage image = ImageIO.read(getClass().getResource(originalFileName));
        int[][] array2D = new int[image.getWidth()][image.getHeight()];
        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixels = 0; yPixels < image.getWidth(); yPixels++) {
                int color = image.getRGB(yPixels, xPixel); //*
                if (color == Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixels] = 1;
                } else {
                    array2D[xPixel][yPixels] = 0; // ?
                }

                System.out.print(array2D[xPixel][yPixels]);

            }
        }

    }

    public void  halfSizeIt() throws IOException {
        File input = new File(originalFileName);
        BufferedImage image = ImageIO.read(input);
        int[][] array2D = new int[image.getWidth() / 2][image.getHeight() / 2];
        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixels = 0; yPixels < image.getWidth(); yPixels++) {
                int color = image.getRGB(yPixels, xPixel); //*
                if (color == Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixels] = 1;
                } else {
                    array2D[xPixel][yPixels] = 0; // ?
                }
                System.out.print(array2D[xPixel][yPixels]);
            }
        }
    }

    public void changeBackgroundColor() throws IOException {
        File input = new File(originalFileName);
        BufferedImage image = ImageIO.read(input);

        int[][] array2D = new int[image.getWidth() / 2][image.getHeight() / 2];
        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixels = 0; yPixels < image.getWidth(); yPixels++) {
                int color = image.getRGB(yPixels, xPixel); //*
                if (color == Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixels] = 1;
                } else {
                    array2D[xPixel][yPixels] = 0; //
                    image.setRGB(xPixel, yPixels, 255);//green
                }

                System.out.print(array2D[xPixel][yPixels]);

            }
        }
    }

public void flipImage() throws IOException{
        int temp;
    File input = new File(originalFileName);
    BufferedImage image = ImageIO.read(input);

    int[][] array2D = new int[image.getWidth() / 2][image.getHeight() / 2];
    for (int i = 0; i < array2D.length; i++)
    {
        for (int j = 0; j < array2D[i].length / 2; j++)
        {
            temp = array2D[i][j];
            array2D[i][j] = array2D[array2D.length - 1 - i][j];
            array2D[array2D.length - 1 - i][j] = temp;
        }
    }


}
}
