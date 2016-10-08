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
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html>BufferedImage</a>
 * @see Translator
 */

class ImageWriter {
  /**
   * Image represented by a buffer.
   */
  private BufferedImage image;

  /**
   * Instructions to represent in the image.
   */
  private List<Integer> colors;

  /**
   * Width and height of the image (number of pixels).
   */
  private int size;

  /**
   * Size of a square.
   */
  private static final int SIZE = 3;

  /**
   * Number of cases in a column or a line.
   */
  private int nbCol;

  /**
   * Constructs a BufferedImage and writes it.
   *
   * @param colors  list of the color of each pixel
   */
  public ImageWriter(List<Integer> colors) {
    this.colors = colors;
    size = 3*(int)Math.ceil(Math.sqrt(colors.size()));
    nbCol = size/SIZE;
    image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
    draw();
    writeBmp("./bfck.bmp");
  }

  /**
   * Draw each square of the image.
   */
  public void draw() {
    for (int y = 0; y < nbCol; y++) {
      for (int x = 0; x < nbCol; x++) {
        drawSquare(x, y);
      }
    }
  }

  /**
   * Draw each square of the image.
   */
  public void drawSquare(int col, int line) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (col+line*nbCol >= colors.size()) {
          image.setRGB(col*SIZE+i, line*SIZE+j, 0x000000);
        }
        else {
          image.setRGB(col*SIZE+i, line*SIZE+j, colors.get(col+line*nbCol));
        }
      }
    }
  }

  /**
   * Print the image.
   *
   * @param path  path of the destination of the image
   */
  public void writeBmp(String path) {
    try {
      RenderedImage rendImage = image;
      ImageIO.write(rendImage, "bmp", new File(path));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
