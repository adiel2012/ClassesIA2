/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author LABORATORIO #3
 */
public class Histograma extends javax.swing.JFrame {

    /**
     * Creates new form Histograma
     */
    BufferedImage img;

    public Histograma() {

        try {
            img = ImageIO.read(new File("lena.png"));

        } catch (IOException ex) {
            Logger.getLogger(Umbral.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        setLayout(new GridLayout(2, 2));
        add(panelOriginal);
        add(panelOriginalR);
        add(panelOriginalG);
        add(panelOriginalB);

        final BufferedImage[] imgs = Utils.histogram3IMG(img);

        panelOriginal.addGraphicListener(new OwnPanel.GraphicListener() {

            @Override
            public void draw(Graphics g) {

                BufferedImage transformada = img;
                // BufferedImage transformada = Utils.to_gray_scale(img);

                g.drawImage(transformada, 0, 0, panelOriginal.getWidth(), panelOriginal.getHeight(), null);

            }
        }).addResizeListener(new OwnPanel.ResizeListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                panelOriginal.repaint();
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        panelOriginalR.addGraphicListener(new OwnPanel.GraphicListener() {

            @Override
            public void draw(Graphics g) {

                BufferedImage transformada = imgs[0];
                // BufferedImage transformada = Utils.to_gray_scale(img);

                g.drawImage(transformada, 0, 0, panelOriginalR.getWidth(), panelOriginalR.getHeight(), null);

            }
        }).addResizeListener(new OwnPanel.ResizeListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                panelOriginalR.repaint();
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        panelOriginalG.addGraphicListener(new OwnPanel.GraphicListener() {

            @Override
            public void draw(Graphics g) {

                BufferedImage transformada = imgs[1];
                // BufferedImage transformada = Utils.to_gray_scale(img);

                g.drawImage(transformada, 0, 0, panelOriginalG.getWidth(), panelOriginalG.getHeight(), null);

            }
        }).addResizeListener(new OwnPanel.ResizeListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                panelOriginalG.repaint();
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        panelOriginalB.addGraphicListener(new OwnPanel.GraphicListener() {

            @Override
            public void draw(Graphics g) {

                BufferedImage transformada = imgs[2];
                // BufferedImage transformada = Utils.to_gray_scale(img);

                g.drawImage(transformada, 0, 0, panelOriginalB.getWidth(), panelOriginalB.getHeight(), null);

            }
        }).addResizeListener(new OwnPanel.ResizeListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                panelOriginalB.repaint();
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
    }

    OwnPanel panelOriginal = new OwnPanel();
    OwnPanel panelOriginalR = new OwnPanel();
    OwnPanel panelOriginalG = new OwnPanel();
    OwnPanel panelOriginalB = new OwnPanel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Histograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Histograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Histograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Histograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Histograma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
