package brainfuck;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.List;

/**
 * Build a bmp image from a list of instructions.
 *
 * @author Miaou
 * @see https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
 * @see Translator
 */

class ImageWriter {
  /**
   * Size of the image (number of pixels)
   */
  private int width;
  private int height;

  /**
   * Image represented by a buffer
   */
  private BufferedImage image;

  /**
   * Constructs a BufferedImage and writes it
   *
   * @param colors    list of the color of each pixel
   */
  public ImageWriter(List<Integer> colors) {
    this(colors, 9, 9);
  }

  /**
   * Constructs a BufferedImage and writes it
   *
   * @param colors    list of the color of each pixel
   * @param width     width of the image
   * @param height    height of the image
   */
  public ImageWriter(List<Integer> colors, int width, int height) {
    this.width = width;
    this.height = height;
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    draw(colors);
    writeBmp("./bfck.bmp");
  }

  public void draw(List<Integer> colors) {
    for (int y = 0; y < width; y+=3) {
      for (int i = 0; i < 3; i++) {
        drawLine(colors, y+i, i);
      }
    }
  }

  public void drawLine(List<Integer> colors, int line, int j) {
    for (int x = 0; x < width; x+=3) {
      for (int i = 0; i < 3; i++) {
        if ((x/3+(line-j)) >= colors.size()) {
          image.setRGB(x+i, line, 0x000000);
        }
        else {
          image.setRGB(x+i, line, colors.get(x/3+(line-j)));
        }
      }
    }
  }

  public void writeBmp(String path) {
    try {
      RenderedImage rendImage = image;
      ImageIO.write(rendImage, "bmp", new File(path));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
