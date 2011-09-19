/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processamentodeimagem1;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author marcelo
 */
class ImageCanvas extends Canvas {

    BufferedImage image;

    public ImageCanvas(BufferedImage img)
    {
        image = img;
    }

    public void paint(Graphics g) {
        g.drawImage(image,0,0,this);
    }


}
