/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPrincipal.java
 *
 * Created on 20/07/2011, 17:56:03
 */

package processamentodeimagem3;

import com.pearsoneduc.ip.op.*;
import com.sun.media.jai.widget.DisplayJAI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author marcelo
 */
public class TelaPrincipal extends javax.swing.JFrame implements JanelaBrilhoEContrasteObserver {

     //To select the path of image file
    private File file;
    //To load the image file
    public PlanarImage srcImage = null;
    //To display the image file
    private DisplayJAI srcdj = null;
    private KernelJAI kernel;
    private JScrollPane srcScrollPaneImage = null;
    //To choose file by browsing
    private JFileChooser FileChooser = new JFileChooser();
    //This flag will be set once image is loaded for the first time
    public boolean flag = false;
    private Histogram histograma;
    private HistogramView visualizacao;
    private HistogramInfoPane informacoesPainel;

    /** Creates new form TelaPrincipal */
    public TelaPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemAbrir = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();
        menuProcessamento = new javax.swing.JMenu();
        subMenuHistograma = new javax.swing.JMenu();
        histogramaEscaladeCinza = new javax.swing.JMenuItem();
        itemBrilhoeContraste = new javax.swing.JMenuItem();
        itemEqualizacao = new javax.swing.JMenuItem();
        submenuTransformadaFourier = new javax.swing.JMenu();
        itemPassaAlta = new javax.swing.JMenuItem();
        itemPassaBaixa = new javax.swing.JMenuItem();
        itemPassaBanda = new javax.swing.JMenuItem();
        menuDetectoresdeContorno = new javax.swing.JMenu();
        itemPrewitt = new javax.swing.JMenuItem();
        itemSobel = new javax.swing.JMenuItem();
        itemLaplaciano = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Processamento de Imagem 3");

        menuArquivo.setText("Arquivo");

        itemAbrir.setText("Abrir");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(itemAbrir);

        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        menuArquivo.add(itemSair);

        jMenuBar1.add(menuArquivo);

        menuProcessamento.setText("Processamento");

        subMenuHistograma.setText("Histograma");

        histogramaEscaladeCinza.setText("Escala de Cinza");
        histogramaEscaladeCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramaEscaladeCinzaActionPerformed(evt);
            }
        });
        subMenuHistograma.add(histogramaEscaladeCinza);

        menuProcessamento.add(subMenuHistograma);

        itemBrilhoeContraste.setText("Brilho e Contraste");
        itemBrilhoeContraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBrilhoeContrasteActionPerformed(evt);
            }
        });
        menuProcessamento.add(itemBrilhoeContraste);

        itemEqualizacao.setText("Equalização");
        itemEqualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEqualizacaoActionPerformed(evt);
            }
        });
        menuProcessamento.add(itemEqualizacao);

        submenuTransformadaFourier.setText("Transformada Fourier");

        itemPassaAlta.setText("Passa Alta");
        itemPassaAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPassaAltaActionPerformed(evt);
            }
        });
        submenuTransformadaFourier.add(itemPassaAlta);

        itemPassaBaixa.setText("Passa Baixa");
        itemPassaBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPassaBaixaActionPerformed(evt);
            }
        });
        submenuTransformadaFourier.add(itemPassaBaixa);

        itemPassaBanda.setText("Passa Banda");
        itemPassaBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPassaBandaActionPerformed(evt);
            }
        });
        submenuTransformadaFourier.add(itemPassaBanda);

        menuProcessamento.add(submenuTransformadaFourier);

        menuDetectoresdeContorno.setText("Detectores de Contorno");

        itemPrewitt.setText("Prewitt");
        itemPrewitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPrewittActionPerformed(evt);
            }
        });
        menuDetectoresdeContorno.add(itemPrewitt);

        itemSobel.setText("Sobel");
        itemSobel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobelActionPerformed(evt);
            }
        });
        menuDetectoresdeContorno.add(itemSobel);

        itemLaplaciano.setText("Laplaciano");
        itemLaplaciano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLaplacianoActionPerformed(evt);
            }
        });
        menuDetectoresdeContorno.add(itemLaplaciano);

        menuProcessamento.add(menuDetectoresdeContorno);

        jMenuBar1.add(menuProcessamento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        int returnVal = FileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            //Initialise file object
            file = FileChooser.getSelectedFile();
            //Display the image
            displayImage(file);
        }
    }//GEN-LAST:event_itemAbrirActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSairActionPerformed

    public void atualizar(PlanarImage srcImageBrilhoEContraste)
    {
        srcImage = srcImageBrilhoEContraste;
        srcdj.set(srcImage);
    }
    
    private void histogramaEscaladeCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histogramaEscaladeCinzaActionPerformed
        try {
            JanelaHistograma janela = new JanelaHistograma();
            histograma = new Histogram(srcImage.getAsBufferedImage());
            informacoesPainel = new HistogramInfoPane(histograma);
            
            JPanel painel = new JPanel(new BorderLayout()); 
            visualizacao = new HistogramView(histograma,informacoesPainel);
            painel.add(visualizacao, BorderLayout.CENTER);
            painel.add(informacoesPainel, BorderLayout.SOUTH);
            
            janela.add(painel);
            janela.setContentPane(painel);
            janela.pack();
            janela.setVisible(true);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_histogramaEscaladeCinzaActionPerformed

    private void itemBrilhoeContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBrilhoeContrasteActionPerformed
        JanelaBrilhoEContraste janela = new JanelaBrilhoEContraste(srcImage,this);
        janela.setVisible(true);
    }//GEN-LAST:event_itemBrilhoeContrasteActionPerformed

    private void itemEqualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEqualizacaoActionPerformed
        try {
            histograma = new Histogram(srcImage.getAsBufferedImage());
            EqualiseOp equalise = new EqualiseOp(histograma);
            BufferedImage imagemEqualisada = equalise.filter(srcImage.getAsBufferedImage(), null);
            srcImage = PlanarImage.wrapRenderedImage(imagemEqualisada);
            srcdj.set(srcImage);
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemEqualizacaoActionPerformed

private void itemPassaAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPassaAltaActionPerformed
    try {
            ImageFFT fft = new ImageFFT(srcImage.getAsBufferedImage());
            fft.transform();
            fft.idealHighPassFilter(0.02);
            BufferedImage imagemBufferizada = fft.getSpectrum();
            fft.transform();
            
            JFrame janela = new JFrame("Passa Alta");
            janela.add(new JScrollPane(new ImageView(imagemBufferizada)));
            janela.pack();
            janela.setVisible(true);
            
            srcImage = PlanarImage.wrapRenderedImage(fft.toImage(null));
            srcdj.set(srcImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_itemPassaAltaActionPerformed

private void itemPassaBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPassaBaixaActionPerformed
    try {
            ImageFFT fft = new ImageFFT(srcImage.getAsBufferedImage());
            fft.transform();
            fft.idealLowPassFilter(0.2);
            BufferedImage imagemBufferizada = fft.getSpectrum();
            fft.transform();
            
            JFrame janela = new JFrame("Passa Baixa");
            janela.add(new JScrollPane(new ImageView(imagemBufferizada)));
            janela.pack();
            janela.setVisible(true);
            
            srcImage = PlanarImage.wrapRenderedImage(fft.toImage(null));
            srcdj.set(srcImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_itemPassaBaixaActionPerformed

private void itemPassaBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPassaBandaActionPerformed
    try {
            ImageFFT fft = new ImageFFT(srcImage.getAsBufferedImage());
            fft.transform();
            fft.idealBandPassFilter(0.1, 0.1);
            BufferedImage imagemBufferizada = fft.getSpectrum();
            fft.transform();
            
            JFrame janela = new JFrame("Passa banda");
            janela.add(new JScrollPane(new ImageView(imagemBufferizada)));
            janela.pack();
            janela.setVisible(true);
            
            srcImage = PlanarImage.wrapRenderedImage(fft.toImage(null));
            srcdj.set(srcImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_itemPassaBandaActionPerformed

private void itemPrewittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPrewittActionPerformed
    float[] kernelPrewittHorizontal = { -1.0F, 0.0F , 1.0F,
                        -1.0F, 0.0F, 1.0F,
                        -1.0F, 0.0F, 1.0F};
            kernel = new KernelJAI(3,3,1,1,kernelPrewittHorizontal);
            
            //create the convolve operation.
            srcImage = JAI.create("convolve" , srcImage, kernel);
            
   float[] kernelPrewittVertical = { -1.0F, -1.0F , -1.0F,
                        0.0F, 0.0F, 0.0F,
                        1.0F, 1.0F, 1.0F};
            kernel = new KernelJAI(3,3,1,1,kernelPrewittVertical);
            
            //create the convolve operation.
            srcImage = JAI.create("convolve" , srcImage, kernel);
            srcdj.set(srcImage);
}//GEN-LAST:event_itemPrewittActionPerformed

private void itemSobelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobelActionPerformed
    float[] kernelSobelHorizontal = { -1.0F, 0.0F , 1.0F,
                        -2.0F, 0.0F, 2.0F,
                        -1.0F, 0.0F, 1.0F};
            kernel = new KernelJAI(3,3,1,1,kernelSobelHorizontal);
            
            //create the convolve operation.
            srcImage = JAI.create("convolve" , srcImage, kernel);
            
   float[] kernelSobelVertical = { -1.0F, -2.0F , -1.0F,
                        0.0F, 0.0F, 0.0F,
                        1.0F, 2.0F, 1.0F};
            kernel = new KernelJAI(3,3,1,1,kernelSobelVertical);
            
            //create the convolve operation.
            srcImage = JAI.create("convolve" , srcImage, kernel);
            srcdj.set(srcImage);
}//GEN-LAST:event_itemSobelActionPerformed

private void itemLaplacianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLaplacianoActionPerformed
 float[] kernelLaplaciano = { 0.0F, -1.0F , 0.0F,
                        -1.0F, 4.0F, -1.0F,
                        0.0F, -1.0F, 0.0F};
            kernel = new KernelJAI(3,3,1,1,kernelLaplaciano);
            
            //create the convolve operation.
            srcImage = JAI.create("convolve" , srcImage, kernel);
            srcdj.set(srcImage);
}//GEN-LAST:event_itemLaplacianoActionPerformed

    public void displayImage (File path)
    {
        //Load the image which file name was passed as the first argument to the application
        srcImage = JAI.create("fileload", path.getPath());
        
        //When image is loaded for the first time
        if (flag == false)
        {
            // Get the JFrame's ContentPane.
            Container contentPane = this.getContentPane();
            contentPane.setLayout(new BorderLayout());
            //Create an instance of DisplayJAI.
            srcdj = new DisplayJAI(srcImage);
            //Add to the JFrame's ContentPane an instance of JScrollPane containing
            //the DisplayJAI instance.
            srcScrollPaneImage = new JScrollPane(srcdj);
            //scrScrollPaneImage
            contentPane.add(srcScrollPaneImage,BorderLayout.CENTER);
            this.setVisible(true);
            //O que é
            this.validate();
            flag = true;
        }
        else
        {
            srcdj.set(srcImage);
        }
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
                new TelaPrincipal().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem histogramaEscaladeCinza;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemBrilhoeContraste;
    private javax.swing.JMenuItem itemEqualizacao;
    private javax.swing.JMenuItem itemLaplaciano;
    private javax.swing.JMenuItem itemPassaAlta;
    private javax.swing.JMenuItem itemPassaBaixa;
    private javax.swing.JMenuItem itemPassaBanda;
    private javax.swing.JMenuItem itemPrewitt;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSobel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuDetectoresdeContorno;
    private javax.swing.JMenu menuProcessamento;
    private javax.swing.JMenu subMenuHistograma;
    private javax.swing.JMenu submenuTransformadaFourier;
    // End of variables declaration//GEN-END:variables

}
