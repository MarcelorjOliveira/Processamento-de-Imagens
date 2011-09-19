package processamentodeimagem3;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import com.pearsoneduc.ip.op.Histogram;



public class HistogramView extends JLabel {


  //////////////////////////////// CONSTANTS ///////////////////////////////


  private static final int HIST_WIDTH = 296;
  private static final int HIST_HEIGHT = 140;
  private static final int TICK_INTERVAL = 50;
  private static final int TICK_SIZE = 4;


  /////////////////////////// INSTANCE VARIABLES ///////////////////////////


  private Histogram histogram;                    // histogram to be plotted
  private int band;                               // band to be plotted
  private int xOrigin = (HIST_WIDTH - 256) / 2;   // x coordinate of origin
  private int ySize = HIST_HEIGHT - 40;           // height of y axis
  private int yOrigin = ySize + 10;               // y coordinate of origin
  private Color histColor;                        // colour of plot
  private HistogramInfoPane infoPane;


  ///////////////////////////////// METHODS ////////////////////////////////


  // Creates a view of a histogram

  public HistogramView(Histogram theHistogram, int theBand,
   HistogramInfoPane theInfoPane) {
    histogram = theHistogram;
    band = theBand;
    infoPane = theInfoPane;
    setPreferredSize(new Dimension(HIST_WIDTH, HIST_HEIGHT));
    if (infoPane != null)
      addMouseMotionListener(
       new MouseMotionAdapter() {
            @Override
         public void mouseMoved(MouseEvent event) {
           infoPane.updateInfo(band, getValue(event.getPoint()));
         }
       });
  }

  public HistogramView(Histogram theHistogram, int theBand) {
    this(theHistogram, theBand, null);
  }

  public HistogramView(Histogram theHistogram, HistogramInfoPane info) {
    this(theHistogram, 0, info);
  }

  public HistogramView(Histogram theHistogram) {
    this(theHistogram, 0);
  }


  // Changes the histogram currently being viewed

  public void setHistogram(Histogram newHistogram, int newBand) {
    histogram = newHistogram;
    band = newBand;
    repaint();
  }

  public void setHistogram(Histogram newHistogram) {
    setHistogram(newHistogram, 0);
  }


  // Defines histogram colour

  public void setColor(Color theColor) {
    histColor = theColor;
  }


  // Returns an x-axis value, given cursor coordinates

  public int getValue(Point point) {
    return Math.min(Math.max(point.x - xOrigin, 0), 255);
  }


  // Draws the histogram

  public void paintComponent(Graphics graphics) {
    double scale = ((double) ySize) / histogram.getMaxFrequency(band);
    if (histColor != null)
      graphics.setColor(histColor);
    for (int x = 0; x < 256; ++x) {
      int y = (int) Math.round(scale*histogram.getFrequency(band, x));
      if (y > 0)
        graphics.drawLine(x+xOrigin, yOrigin, x+xOrigin, yOrigin-y);
    }
    drawAxis(graphics, xOrigin, yOrigin+1);
  }


  // Draws the histogram x axis

  public void drawAxis(Graphics graphics, int x, int y) {
    Color oldColor = graphics.getColor();
    graphics.setColor(Color.black);
    graphics.drawLine(x, y, x+255, y);
    for (int t = 0; t < 256; t += TICK_INTERVAL) {
      graphics.drawLine(x+t, y, x+t, y+TICK_SIZE);
      drawTickLabel(graphics, String.valueOf(t), x+t, y+TICK_SIZE+2);
    }
    graphics.setColor(oldColor);
  }


  // Draws a numeric label below an x axis tickmark

  public void drawTickLabel(Graphics graphics, String label, int x, int y) {
    FontMetrics metrics = graphics.getFontMetrics();
    Rectangle tempBox = new Rectangle(metrics.getWidths()[0],metrics.getHeight());
    //Rectangle box = (Rectangle) metrics.getStringBounds(label, graphics);
    graphics.drawString(label, x - tempBox.width/2, y + tempBox.height);
  }


}
