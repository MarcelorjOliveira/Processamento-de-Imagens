package processamentodeimagem1;

/***************************************************************************

  GreyMapView.java   Version 1.0 [1999/07/08]

  This class extends JLabel to provide specialised facilities for
  visualising a mapping of grey levels.  An instance of GreyMapView
  forms part of GreyMapPanel, which is used in the GreyMapTool
  application.


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



import java.awt.*;
import java.awt.geom.*;
import javax.swing.JLabel;
import com.pearsoneduc.ip.op.GreyMapOp;



public class GreyMapView extends JLabel {


  /////////////////////////// INSTANCE VARIABLES ///////////////////////////


  int axisOffset = 15;                   // offset from edge of component
  int axisLength = 150;                  // size of axes (~2.1 inches)
  double scaling = axisLength / 255.0;   // scales 0-255 to axis length
  int arrowWidth = 6;                    // width of axis arrow (unscaled)
  int arrowLength = 10;                  // length of axis arrow (unscaled)
  GreyMapOp operation;                   // operation to be plotted
  Shape axes;                            // path representing axes
  Shape mapping;                         // path representing mapping fn.


  //////////////////////////////// METHODS /////////////////////////////////


  // Constructs a view of the specified remapping operation

  public GreyMapView(GreyMapOp op) {
    operation = op;
    axes = createAxes();
    mapping = createMapping();
  }


  // Creates a path representing the x and y axes of the plot

  public Shape createAxes() {

    GeneralPath path = new GeneralPath();

    // Axes

    path.moveTo(0, 0);
    path.lineTo(255, 0);
    path.moveTo(0, 0);
    path.lineTo(0, 255);

    // Arrowheads

    path.moveTo(255, 0);
    path.lineTo(255-arrowLength, -arrowWidth);
    path.moveTo(255, 0);
    path.lineTo(255-arrowLength, arrowWidth);
    path.moveTo(0, 255);
    path.lineTo(-arrowWidth, 255-arrowLength);
    path.moveTo(0, 255);
    path.lineTo(arrowWidth, 255-arrowLength);

    return path;

  }


  // Creates a path representing the mapping function

  public Shape createMapping() {
    GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO, 512);
    path.moveTo(0, operation.getTableEntry(0));
    for (int i = 1; i < 256; ++i)
      path.lineTo(i, operation.getTableEntry(i));
    return path;
  }


  // Recreates a plot of the mapping function and repaints the view

  public void updateView() {
    mapping = createMapping();
    repaint();
  }

  public void updateView(GreyMapOp op) {
    operation = op;
    updateView();
  }


  public void paintComponent(Graphics g) {

    // Set up antialiasing and transformation of user space

    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
     RenderingHints.VALUE_ANTIALIAS_ON);
    g2.translate(axisOffset, axisOffset+axisLength);
    g2.scale(scaling, -scaling);

    // Plot x and y axes

    g2.setStroke(new BasicStroke(1.5f));
    g2.setPaint(Color.black);
    g2.draw(axes);

    // Plot mapping function

    g2.setStroke(new BasicStroke(2.0f));
    g2.setPaint(Color.red);
    g2.draw(mapping);

  }


  public Dimension getPreferredSize() {
    return new Dimension(axisLength+2*axisOffset, axisLength+2*axisOffset);
  }


}
