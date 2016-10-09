package brainfuck;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.List;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

/**
 * Build a bmp image from a list of instructions'color.
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
   * Graphic which regroups all the squares.
   */
  private Graphics graph;

  /**
   * Instructions to represent in the image.
   */
  private List<Integer> colors;

  /**
   * Number of cells by column (or by line).
   */
  private int nbCol;

  /**
   * Destination of the image.
   */
  private static final String PATH = "./bfck.bmp";

  /**
   * Width and height of a square (number of pixels).
   */
  private static final int SIZE_SQUARE = 3;

  /**
   * Constructs an image and draws it.
   * nbCol figures out how many cells that a column (or a line) has to contain.
   * Then, a BufferedImage is created with the good dimensions.
   * The graphic is used to represent easily forms like squares in the image.
   *
   * @param colors  list of the color of each pixel
   */
  public ImageWriter(List<Integer> colors) {
    this.colors = colors;
    nbCol = (int)Math.ceil(Math.sqrt(colors.size()));
    image = new BufferedImage(SIZE_SQUARE*nbCol, SIZE_SQUARE*nbCol, BufferedImage. TYPE_INT_RGB);
    graph = image.createGraphics();
    draw();
    writeBmp();
  }

  /**
   * Add each square in the graphic.
   */
  private void draw() {
    for (int i = 0; i < nbCol*nbCol; i++) {
      if (i >= colors.size()) {
        graph.setColor(Color.BLACK);
      }
      else {
        graph.setColor(new Color(colors.get(i)));
      }
      graph.fillRect(SIZE_SQUARE*(i%nbCol), SIZE_SQUARE*(i/nbCol), SIZE_SQUARE, SIZE_SQUARE);
    }
  }

  /**
   * Create the file from the BufferedImage.
   */
  private void writeBmp() {
    try {
      ImageIO.write(image, "bmp", new File(PATH));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
