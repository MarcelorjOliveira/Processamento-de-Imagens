package processamentodeimagem1;

/***************************************************************************

  HistogramInfoPane.java   Version 1.1 [1999/06/30]

  This class extends JPanel to provide specialised facilities for
  displaying value and frequency information from a histogram.
  An instance of this class is used in the HistogramTool application.
  This application tracks mouse movement when the cursor is over a
  histogram and invokes the HistogramInfoPane's updateInfo method to
  display the value at the point under the cursor, together with
  the corresponding frequency / cumulative frequency.

  See the HistogramTool class for further information.


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
import java.awt.image.*;
import javax.swing.*;
import com.pearsoneduc.ip.op.Histogram;
import com.pearsoneduc.ip.util.StringTools;



public class HistogramInfoPane extends JPanel {


  /////////////////////////// INSTANCE VARIABLES ///////////////////////////


  private Histogram histogram;
  private JLabel greyLevel = new JLabel();
  private JLabel freq = new JLabel();
  private JLabel cumFreq = new JLabel();


  //////////////////////////////// METHODS /////////////////////////////////


  public HistogramInfoPane(Histogram theHistogram) {

    histogram = theHistogram;

    // Create a panel containing pixel value

    JPanel greyLevelPane = new JPanel();
    greyLevelPane.add(new JLabel("value"));
    Font fixedFont = new Font("Monospaced", Font.BOLD, 12);
    greyLevel.setFont(fixedFont);
    greyLevel.setForeground(Color.black);
    greyLevelPane.add(greyLevel);
    greyLevelPane.setBorder(BorderFactory.createEtchedBorder());
    add(greyLevelPane);

    // Create a panel containing frequency information

    JPanel frequencyPane = new JPanel();
    frequencyPane.add(new JLabel("freq"));
    freq.setFont(fixedFont);
    freq.setForeground(Color.black);
    frequencyPane.add(freq);
    frequencyPane.add(new JLabel("cum freq"));
    cumFreq.setFont(fixedFont);
    cumFreq.setForeground(Color.black);
    frequencyPane.add(cumFreq);
    frequencyPane.setBorder(BorderFactory.createEtchedBorder());
    add(frequencyPane);

    updateInfo(0, 0);

  }


  // Updates displayed information, given band and grey level value

  public void updateInfo(int band, int value) {
    greyLevel.setText(StringTools.rightJustify(value, 3));
    freq.setText(StringTools.rightJustify(
     histogram.getFrequency(band, value), 6));
    cumFreq.setText(StringTools.rightJustify(
     histogram.getCumulativeFrequency(band, value), 6));
  }


}
