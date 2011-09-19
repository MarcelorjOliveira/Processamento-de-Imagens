/***************************************************************************

  ImageView.java

  Written by Nick Efford.

  Copyright (c) 2000, Pearson Education Ltd.  All rights reserved.

  THIS SOFTWARE IS PROVIDED BY THE AUTHOR "AS IS" AND ANY EXPRESS OR
  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE
  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
  BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

***************************************************************************/


package processamentodeimagem3;


import com.pearsoneduc.ip.op.EqualiseOp;
import com.pearsoneduc.ip.op.Histogram;
import com.pearsoneduc.ip.op.HistogramException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;


/**
 * A component that displays a BufferedImage.
 *
 * <p>ImageView is a version of JLabel that can display a BufferedImage
 * object, rather than an ImageIcon.  It implements the Scrollable
 * interface, and will therefore behave sensibly when embedded in a
 * JScrollPane.  An image processing operation can be specified that will
 * be applied to the image prior to display; if null is specified,
 * then no operation will be performed.</p>
 *
 * @author Nick Efford
 * @version 1.1 [1999/07/08]
 * @see JLabel
 * @see Scrollable
 * @see BufferedImage
 * @see BufferedImageOp
 */

public class ImageView extends JLabel implements Scrollable {


  //////////////////////////// CLASS CONSTANTS /////////////////////////////


  /** Default horizontal size for the viewer, when in a JScrollPane. */
  private static final int DEFAULT_VIEW_WIDTH = 256;

  /** Default vertical size for the viewer, when in a JScrollPane. */
  private static final int DEFAULT_VIEW_HEIGHT = 256;


  /////////////////////////// INSTANCE VARIABLES ///////////////////////////


  /** Image to be displayed. */
  private BufferedImage image;

  /** Operation performed on image prior to display. */
  private BufferedImageOp operation;

  /** Size of current view, if we are in a JScrollPane. */
  private Dimension viewSize;

  private int opcao;
  
  ///////////////////////////////// METHODS ////////////////////////////////


  /**
   * Constructs an ImageView to display the specified BufferedImage.
   * @param img image to be displayed
   */

  public ImageView(BufferedImage img) {
    this(img, null);
  }

  /**
   * Constructs an ImageView to display a processed BufferedImage.
   * @param img image to be displayed
   * @param op operation to be applied before display
   */

  public ImageView(BufferedImage img, BufferedImageOp op) {
    setImage(img);
    setOperation(op);
    viewSize = new Dimension(
     Math.min(DEFAULT_VIEW_WIDTH, image.getWidth()),
     Math.min(DEFAULT_VIEW_HEIGHT, image.getHeight()));
    setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
  }
  public ImageView(BufferedImage img, BufferedImageOp op,int opcao) {
    setImage(img);
    setOperation(op);
    viewSize = new Dimension(
     Math.min(DEFAULT_VIEW_WIDTH, image.getWidth()),
     Math.min(DEFAULT_VIEW_HEIGHT, image.getHeight()));
    setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    this.opcao = opcao;
  }


  /**
   * Changes the image being displayed.
   * @param img new image
   */

  public void setImage(BufferedImage img) {
    image = img;
  }


  /**
   * Changes the operation applied to an image.
   * @param op image processing operation
   */

  public void setOperation(BufferedImageOp op) {
    operation = op;
  }


  /**
   * Changes the viewport size.  This has an effect only when the
   * ImageView object is embedded in a JScrollPane.
   * @param newViewSize Dimension object defining the new viewport size
   */

  public void setViewSize(Dimension newViewSize) {
    viewSize.setSize(newViewSize);
  }


  /**
   * Displays the image associated with an ImageView object.
   * @param g graphics context for the ImageView object
   */

  public void paintComponent(Graphics g) {
    if (operation != null) {
      Graphics2D g2 = (Graphics2D) g;
      BufferedImage imagemOperacionalizada = operation.filter(image,null);
      
      if(opcao == 1)
      {
          try {
              
          Histogram histograma = new Histogram(imagemOperacionalizada);
          EqualiseOp equalise = new EqualiseOp(histograma);
          imagemOperacionalizada = equalise.filter(imagemOperacionalizada, null);        
          
          } catch (Exception e) {
                e.printStackTrace();
          }
          
      }
      g2.drawImage(imagemOperacionalizada,0,0,this);
    }
    else
    {
        g.drawImage(image, 0, 0, this);
    }
  }


  public Dimension getPreferredScrollableViewportSize() {
    return viewSize;
  }


  public int getScrollableUnitIncrement(Rectangle visibleRect,
   int orientation, int direction) {
    return 1;
  }


  public int getScrollableBlockIncrement(Rectangle visibleRect,
   int orientation, int direction) {
    if (orientation == SwingConstants.HORIZONTAL)
      return image.getWidth() / 10;
    else
      return image.getHeight() / 10;
  }


  public boolean getScrollableTracksViewportWidth() {
    return false;
  }


  public boolean getScrollableTracksViewportHeight() {
    return false;
  }

  public BufferedImage getBufferedImage()
  {
      return operation.filter(image,null);
  }

}
