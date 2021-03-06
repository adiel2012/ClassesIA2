/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.awt.Color;
import java.awt.Graphics;
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
 * @author acastano
 */
public class Degradado extends javax.swing.JFrame {

    /**
     * Creates new form Degradado
     */
    BufferedImage img1, img2, res;

    public Degradado() {
        initComponents();
        
        try {
            img1 = ImageIO.read(new File("paisaje-800x6002.jpg"));
            img2 = ImageIO.read(new File("paisaje-de-flores.jpg"));

            res = new BufferedImage(img1.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_ARGB);

            merge(img1, img2, res);
        } catch (IOException ex) {
            Logger.getLogger(Degradado.class.getName()).log(Level.SEVERE, null, ex);
        }

        ownPanel2.addGraphicListener(new OwnPanel.GraphicListener() {

            @Override
            public void draw(Graphics g) {
                g.drawImage(res, 0, 0,ownPanel2.getWidth(),ownPanel2.getHeight(), null);
//                double d = (double) (jSlider1.getValue() - jSlider1.getMinimum()) / (jSlider1.getMaximum() - jSlider1.getMinimum());
//                BufferedImage transformada = Utils.umbralizar(gris, d);
//
//                g.drawImage(transformada, 0, 0, null);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }).addResizeListener(new OwnPanel.ResizeListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                ownPanel2.repaint();
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        ownPanel2 = new vision.OwnPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Imagen 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Imagen 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Degradado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout ownPanel2Layout = new javax.swing.GroupLayout(ownPanel2);
        ownPanel2.setLayout(ownPanel2Layout);
        ownPanel2Layout.setHorizontalGroup(
            ownPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ownPanel2Layout.setVerticalGroup(
            ownPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(33, 33, 33)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ownPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ownPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Graphics g = ownPanel2.getGraphics();
        g.drawImage(img1, 0, 0,ownPanel2.getWidth(),ownPanel2.getHeight(), null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Graphics g = ownPanel2.getGraphics();
        g.drawImage(img2, 0, 0,ownPanel2.getWidth(),ownPanel2.getHeight(), null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        visualiza();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:

        merge(img1, img2, res);
        visualiza();
    }//GEN-LAST:event_jSlider1StateChanged

    public void visualiza() {
        Graphics g = ownPanel2.getGraphics();
        g.drawImage(res, 0, 0,ownPanel2.getWidth(),ownPanel2.getHeight(), null);
    }

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
            java.util.logging.Logger.getLogger(Degradado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Degradado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Degradado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Degradado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Degradado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JSlider jSlider1;
    private vision.OwnPanel ownPanel2;
    // End of variables declaration//GEN-END:variables

    private void merge(BufferedImage img1, BufferedImage img2, BufferedImage res) {

        int height = img1.getHeight();
        int width = img2.getWidth();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c1 = new Color(img1.getRGB(i, j));
                Color c2 = new Color(img2.getRGB(i, j));
                double coef1 = (double) i / width;
                //coef1 = coef1>0.5?Math.pow(coef1, 2):Math.pow(coef1, 0.5);

                coef1 = sigm(coef1);

                Color c3 = new Color((int) ((coef1) * c1.getRed() + (1 - coef1) * c2.getRed()), (int) ((coef1) * c1.getGreen() + (1 - coef1) * c2.getGreen()), (int) ((coef1) * c1.getBlue() + (1 - coef1) * c2.getBlue()));
                res.setRGB(i, j, c3.getRGB());
            }
        }

        res = img1;
    }

    private double sigm(double coef1) {
        int max = jSlider1.getMaximum();
        int min = jSlider1.getMinimum();

        double coef = (double) (jSlider1.getValue() - min) / (max - min);
        return 1d / (1 + Math.exp(-((coef1 - 0.45) * 10 / coef)));
    }
}
