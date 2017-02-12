/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

/**
 *
 * @author Adiel
 */
public class OwnPanel extends javax.swing.JPanel  implements ComponentListener{

    /**
     * Creates new form OwnPanel
     */
    public OwnPanel() {
        initComponents();
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (GraphicListener listener : listeners) {
            listener.draw(g);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        
        for (ResizeListener listener : listenersResize) {
            listener.componentResized(e);
        }
//        repaint();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentMoved(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public interface GraphicListener{
       public void draw(Graphics g);
      
    }
    
    public interface ResizeListener{
       public void componentResized(ComponentEvent e);
      
    }
    
    public OwnPanel addGraphicListener(GraphicListener listener){
       listeners.add(listener);
       return this;
    }
    
    public OwnPanel addResizeListener(ResizeListener listener){
       listenersResize.add(listener);
       return this;
    }
    
    
    ArrayList<GraphicListener> listeners = new ArrayList<>();
    ArrayList<ResizeListener> listenersResize = new ArrayList<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}