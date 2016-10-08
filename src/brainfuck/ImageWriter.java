package brainfuck;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.List;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Build a bmp image from a list of instructions.
 *
 * @author Miaou
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html>BufferedImage</a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html">Graphics</a>
 * @see Translator
 */

class ImageWriter {
  /**
   * Image represented by a buffer.
   */
  private BufferedImage image;

  /**
   * Graphic which regroup all the squares.
   */
  private Graphics graph;

  /**
   * Instructions to represent in the image.
   */
  private List<Integer> colors;

  /**
   * Width and height of the image (number of pixels).
   */
  private int sizeImg;

  /**
   * Width and height of a square (number of pixels).
   */
  private static final int SIZE_SQUARE = 3;

  /**
   * Constructs an image and draws it.
   *
   * @param colors  list of the color of each pixel
   */
  public ImageWriter(List<Integer> colors) {
    this.colors = colors;
    sizeImg = 3*(int)Math.ceil(Math.sqrt(colors.size()));
    image = new BufferedImage(sizeImg, sizeImg, BufferedImage.TYPE_INT_RGB);
    graph = image.createGraphics();
    draw();
    writeBmp();
  }

  /**
   * Draw each square in the graphic.
   */
  public void draw() {
    int nbCol = sizeImg / SIZE_SQUARE;
    for (int i = 0; i < nbCol; i++) {
      for (int j = 0; j < nbCol; j++) {
        if ((i*nbCol+j) >= colors.size()) {
          graph.setColor(Color.BLACK);
        }
        else {
          graph.setColor(new Color(colors.get(i*nbCol+j)));
        }
        graph.fillRect(j*SIZE_SQUARE, i*SIZE_SQUARE, SIZE_SQUARE, SIZE_SQUARE);
      }
    }
  }

  /**
   * Create the file from the BufferedImage.
   */
  public void writeBmp() {
    try {
      ImageIO.write(image, "bmp", new File("./bfck.bmp"));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
