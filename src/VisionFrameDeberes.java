/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import vision.*;
import UtilsVision.Util;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Adiel
 */
public class VisionFrameDeberes extends javax.swing.JFrame {

    private String ruta;
    private BufferedImage imagen;
    private BufferedImage imagen_procesada;

    /**
     * Creates new form VisionFrame
     */
    public VisionFrameDeberes() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        canvas1 = new vision.canvas();
        canvas3 = new vision.canvas();
        jButton11 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Contraste:");

        jButton2.setText("+");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("-");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Brillo:");

        jButton4.setText("+");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("-");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Escala de grises");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Unmbralizar");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Histograma");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Border Laplace");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Border Sobel");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout canvas1Layout = new javax.swing.GroupLayout(canvas1);
        canvas1.setLayout(canvas1Layout);
        canvas1Layout.setHorizontalGroup(
            canvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        canvas1Layout.setVerticalGroup(
            canvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout canvas3Layout = new javax.swing.GroupLayout(canvas3);
        canvas3.setLayout(canvas3Layout);
        canvas3Layout.setHorizontalGroup(
            canvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        canvas3Layout.setVerticalGroup(
            canvas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        jButton11.setText("suavizar");
        jButton11.setEnabled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9)
                            .addComponent(jButton10))
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton7)
                    .addComponent(jButton11)
                    .addComponent(jButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser fch = new JFileChooser();
        fch.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif"));

//        System.out.println(fch.showOpenDialog(this)==0);
        if (fch.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            activarbotones();
            final File file = fch.getSelectedFile();
            ruta = file.getPath();
            // imagen = Toolkit.getDefaultToolkit().getImage(ruta);

            canvas1.setImgprovider(new canvas.IImageProvider() {

                @Override
                public BufferedImage getImage() {
                    // File file = new File("C:\\lena.png"); //fch.getSelectedFile();
                    ruta = file.getPath();
                    try {
                        // imagen = Toolkit.getDefaultToolkit().getImage(ruta);
                        imagen = ImageIO.read(file);
                    } catch (IOException ex) {
                        Logger.getLogger(VisionFrameDeberes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return imagen;
                }
            });

        }

//        if(fch.showOpenDialog(this)==){
//        
//        }
//        Dimension tamanio = getSize();
//ImageIcon fondo = new ImageIcon(getClass().getResource("imagenes/Bienvenida.png"));
//g.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
//setOpaque(false);
//super.paintComponent(g);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = aumentarcontraste(imagen);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = disminuircontraste(imagen);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = aumentarBrillo(imagen);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = disminuirBrillo(imagen);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = escaladegrises(imagen);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = umbralizar(imagen_procesada, 0.5d);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = histograma(imagen_procesada);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = Laplace(imagen_procesada);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = sobel(imagen_procesada);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        imagen_procesada = suavizar(imagen);
        mostarresultado(imagen_procesada);
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(VisionFrameDeberes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisionFrameDeberes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisionFrameDeberes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisionFrameDeberes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisionFrameDeberes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vision.canvas canvas1;
    private vision.canvas canvas3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private BufferedImage aumentarcontraste(BufferedImage imagen) {

        contrastFunction f = new contrastFunction() {

            @Override
            public double getvalue(float x) {
                float e = 1.3f;
                return (x < 0.5) ? (float) Math.pow(x, e) : (float) Math.pow(x, 1f / e);
            }
        };

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color p = new Color(imageActual.getRGB(i, j));
                p = new Color((int) (f.getvalue((float) p.getRed() / 255) * 255), (int) (f.getvalue((float) p.getGreen() / 255) * 255),
                        (int) (f.getvalue((float) p.getBlue() / 255) * 255));
                res.setRGB(i, j, p.getRGB());
            }
        }
        return res;

    }

    private void mostarresultado(final BufferedImage img) {
        canvas3.setImgprovider(new canvas.IImageProvider() {

            @Override
            public BufferedImage getImage() {
                System.out.println("pase");
                return img;
            }
        });
        canvas3.repaint();
    }

    private BufferedImage disminuircontraste(BufferedImage imagen) {
        contrastFunction f = new contrastFunction() {

            @Override
            public double getvalue(float x) {
                float e = 1.3f;
                return (x > 0.5) ? (float) Math.pow(x, e) : (float) Math.pow(x, 1f / e);
            }
        };

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

//        Bitmap use = (Bitmap)bmp.Clone();
        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color p = new Color(imageActual.getRGB(i, j));
                p = new Color((int) (f.getvalue((float) p.getRed() / 255) * 255), (int) (f.getvalue((float) p.getGreen() / 255) * 255), (int) (f.getvalue((float) p.getBlue() / 255) * 255));
                res.setRGB(i, j, p.getRGB());
            }
        }

        return res;
    }

    private BufferedImage aumentarBrillo(BufferedImage imagen) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());
        double m = 1.5f;

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color c = new Color(imageActual.getRGB(i, j));
                c = new Color(Math.min(255, (int) (m * c.getRed())), Math.min(255, (int) (m * c.getGreen())), 
                        Math.min(255, (int) (m * c.getBlue())));
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    private BufferedImage escaladegrises(BufferedImage imagen) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

       

        return res;

    }

    private BufferedImage umbralizar(BufferedImage imagen_procesada, double d) {
        BufferedImage imageActual = imagen_procesada;
//        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {

                Color c = new Color(imageActual.getRGB(i, j));
                int gris = (c.getRed() > d * 256) ? 255 : 0;
                c = new Color(gris, gris, gris);// Color.FromArgb(gris, gris, gris);
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    private BufferedImage histograma(BufferedImage imagen_procesada) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        int width = imageActual.getWidth();
        int heigth = imageActual.getHeight();
        int[] data = gethistogram(imagen_procesada);

        float w = (float) (width - 2) / data.length;

        int max = -1;
        int pos = -1;
        for (int i = 0; i < data.length; i++) {
            pos = max < data[ i] ? i : pos;
            max = max < data[ i] ? data[i] : max;

        }

        float h = (float) heigth / max;

        Graphics g = res.getGraphics();
        for (int i = 0; i < data.length; i++) {
            //g.DrawRectangle(new Pen(barColor), 1 + (int) (w * i), heigth - (int) (data[i] * h), (int) w, (int) (data[i] * h));

            g.fillRect(1 + (int) (w * i), heigth - (int) (data[i] * h), (int) w, (int) (data[i] * h));
        }
        return res;

    }

    private BufferedImage Laplace(BufferedImage imagen_procesada) {

        float[][] data = Util.getData(imagen_procesada);
        float[][] datax = Util.Convolute(data, new float[][]{{0, 1, 0}, {1, -4, 1}, {0, 1, 0}});
        return Util.BitmapFromData(Util.Contract(datax));

    }

    private BufferedImage sobel(BufferedImage imagen_procesada) {

        float[][] data = Util.getData(imagen_procesada);

        float[][] datax = Util.Differentiate(data, new int[][]{{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}});
        float[][] datay = Util.Differentiate(data, new int[][]{{2, 1, 0}, {1, 0, -1}, {0, -2, -2}});
        float[][] datahipotenusa = Util.hipotenusa(datax, datay);
        
        umbralizar(Util.BitmapFromData(Util.Contract(datahipotenusa)), 0.8);
        
        BufferedImage nuevo =  umbralizar(Util.BitmapFromData(Util.Contract(datahipotenusa)), 0.2);
        //nuevo = Util.BitmapFromData(Util.Contract(datax));
        
        return nuevo;

    }

    private int[] gethistogram(BufferedImage img) {
        int[] res = new int[256];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                res[(new Color(img.getRGB(i, j))).getRed()]++;
            }
        }

        return res;
    }

    private BufferedImage disminuirBrillo(BufferedImage imagen) {
        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());
        double m = 0.7f;

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color c = new Color(imageActual.getRGB(i, j));
                c = new Color(Math.min(255, (int) (m * c.getRed())), Math.min(255, (int) (m * c.getGreen())), Math.min(255, (int) (m * c.getBlue())));
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    private BufferedImage suavizar(BufferedImage imagen) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        //img = Bitmap.FromFile("piratas.jpg");
        Graphics gr = res.getGraphics();

//            bmp = (Bitmap)img;
//            Bitmap bmpnew = (Bitmap)bmp.Clone();
        int ventana = 5;
        int div = (1 + 2 * ventana) * (1 + 2 * ventana);

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {

                Color c = new Color(imageActual.getRGB(i, j));
                int sumaR = 0, sumaG = 0, sumaB = 0;
                for (int k = Math.max(0, i - ventana); k < Math.min(imageActual.getWidth(), i + ventana); k++) {
                    for (int l = Math.max(0, j - ventana); l < Math.min(imageActual.getHeight(), j + ventana); l++) {
                        Color ctemp = new Color(imageActual.getRGB(k, l));//bmp.GetPixel(k, l);
                        sumaR += ctemp.getRed();
                        sumaG += ctemp.getGreen();
                        sumaB += ctemp.getBlue();

                    }
                }

                res.setRGB(i, j, (new Color(sumaR / div, sumaG / div, sumaB / div)).getRGB());//.SetPixel(i, j, Color.FromArgb(sumaR/div,sumaG/div,sumaB/div));

            }
        }

        return res;

    }

    private void activarbotones() {
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        jButton10.setEnabled(true);
        jButton11.setEnabled(true);
    }

    public interface contrastFunction {

        public double getvalue(float d);
    }
}
