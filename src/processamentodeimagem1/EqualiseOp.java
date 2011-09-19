/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamentodeimagem1;

import com.pearsoneduc.ip.op.GreyMapOp;
import com.pearsoneduc.ip.op.Histogram;
import com.pearsoneduc.ip.op.HistogramException;

/**
 *
 * @author marcelo
 */
public class EqualiseOp extends GreyMapOp {
    public EqualiseOp(Histogram hist) throws HistogramException {
        javax.swing.JOptionPane.showMessageDialog(null, hist.getNumBands());
        float scale = 255.0f / hist.getNumSamples();
        for(int i = 0 ; i < 256 ; ++i)
            table[i] = (byte) Math.round(scale*hist.getCumulativeFrequency(i));
    }

    public void computeMapping(int low, int high) {
        //Does nothing - limits are meaningless in histogram equalisation
    }
}
