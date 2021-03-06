/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmServer.java
 *
 * Created on May 21, 2012, 5:44:19 PM
 */
package forma.server;

import domen.Zaposleni;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;
import kolekcija.ListaUlogovanih;
import kontroler.Kontroler;
import nit.NitServer;
import nit.sat.NitSat;
import table.model.ListaKlijenataTableModel;

/**
 *
 * @author Rus
 */
public class FrmServer extends javax.swing.JFrame {

    /** Creates new form FrmServer */
    public FrmServer() {
        initComponents();
        srediFormu();
        pokreniSat();
        prikaziSveKonektovaneKlijente();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtPokreniServer = new javax.swing.JButton();
        jbtZatvori = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblListaKlijenata = new javax.swing.JTable();
        jtfSat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jbtPokreniServer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jbtPokreniServer.setText("Pokreni server");
        jbtPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPokreniServerActionPerformed(evt);
            }
        });

        jbtZatvori.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jbtZatvori.setText("Zatvori");
        jbtZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtZatvoriActionPerformed(evt);
            }
        });

        jtblListaKlijenata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblListaKlijenata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblListaKlijenataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblListaKlijenata);

        jtfSat.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jtfSat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtZatvori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfSat)
                    .addComponent(jbtPokreniServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jbtPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jtfSat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(719, 394));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPokreniServerActionPerformed
        try {
            NitServer nit = new NitServer(jtblListaKlijenata);
            nit.start();
            JOptionPane.showMessageDialog(this, "Server je pokrenut i spreman za rad!", "Server", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("slike/ok50.png"));
            jbtPokreniServer.setEnabled(false);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("slike/info50.png"));
        }
        

    }//GEN-LAST:event_jbtPokreniServerActionPerformed

    private void jbtZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtZatvoriActionPerformed

        System.exit(0);

    }//GEN-LAST:event_jbtZatvoriActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
       try {
            
            ArrayList<Zaposleni> listaKlijenata = Kontroler.vratiInstancu().vratiListuZaposlenih();
            ListaKlijenataTableModel l = new ListaKlijenataTableModel(listaKlijenata);
            jtblListaKlijenata.setModel(l);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("slike/info50.png"));
        }
        
    }//GEN-LAST:event_formWindowActivated

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

         
        
    }//GEN-LAST:event_formWindowStateChanged

    private void jtblListaKlijenataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblListaKlijenataMousePressed

        
        
    }//GEN-LAST:event_jtblListaKlijenataMousePressed

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
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmServer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtPokreniServer;
    private javax.swing.JButton jbtZatvori;
    private javax.swing.JTable jtblListaKlijenata;
    private javax.swing.JTextField jtfSat;
    // End of variables declaration//GEN-END:variables

    private void pokreniSat() {
        NitSat sat = new NitSat(jtfSat);
        sat.start();
    }

    private void srediFormu() {
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        jtfSat.setEditable(false);
        jtfSat.setBackground(Color.CYAN);
        this.setTitle("Server");

    }

    private void prikaziSveKonektovaneKlijente() {

        postaviPrazanModelTabele();

        try {

            ArrayList<Zaposleni> lz = Kontroler.vratiInstancu().vratiListuZaposlenih();
            ListaKlijenataTableModel l = new ListaKlijenataTableModel(lz);
            jtblListaKlijenata.setModel(l);
            
            for (int i = 0; i < lz.size(); i++) {
                    Zaposleni zaposleni = lz.get(i);
                    ArrayList<Zaposleni> ulogovani = ListaUlogovanih.vratiInstancu().vratiListuUlogovanih();
                    for (int j = 0; j < ulogovani.size(); j++) {
                        Zaposleni zap = ulogovani.get(j);
                        if (zap.getUsername().equals(zaposleni.getUsername())) {
                            final int red = i;
                            System.out.println(red);
                            System.out.println(j);
                            System.out.println(i);
                            jtblListaKlijenata = new JTable(){
                                
                                @Override
                                public void tableChanged(TableModelEvent e) {
                                    super.tableChanged(e);
    //                                red = e.getFirstRow();
                                    repaint();
                                }

                                @Override
                                public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                                    Component c = super.prepareRenderer(renderer, row, column);
                                    if (row == red) {
                                        c.setBackground(Color.GREEN);
                                    }else{
                                        c.setBackground(getBackground());
                                    }
                                    return c;
                                }
                                
                                
                                
                            };
                        }
                    }
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("slike/info50.png"));
        }

    }

    private void postaviPrazanModelTabele() {

        jtblListaKlijenata.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}));

    }
}
