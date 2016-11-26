/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Dominik
 */
public class Apka extends javax.swing.JFrame {

    /**
     * Creates new form Apka
     */
    public Apka() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Tekst = new javax.swing.JTextArea();
        Otworz = new javax.swing.JButton();
        Zamknij = new javax.swing.JButton();
        Sciezka = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Analiza = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tekst.setEditable(false);
        Tekst.setColumns(20);
        Tekst.setRows(5);
        jScrollPane1.setViewportView(Tekst);

        Otworz.setText("Otworz");
        Otworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtworzActionPerformed(evt);
            }
        });

        Zamknij.setText("Zamknij");
        Zamknij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZamknijActionPerformed(evt);
            }
        });

        Sciezka.setEditable(false);

        Analiza.setEditable(false);
        Analiza.setColumns(20);
        Analiza.setRows(5);
        jScrollPane2.setViewportView(Analiza);

        jLabel1.setText("Tekst z pliku");

        jLabel2.setText("Analiza znaków");

        jRadioButton1.setText("Bez uwzględniania wielkości liter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sciezka)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Otworz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Zamknij)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Otworz)
                    .addComponent(Zamknij)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sciezka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OtworzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtworzActionPerformed

        String plik, zdanie;
        List<Character> litera = new ArrayList();
        List<Integer> ilosc = new ArrayList();
        boolean warunek = false;
        
        Tekst.setText("");
        Analiza.setText("");
        
        FileDialog fd =new FileDialog(this,"Wczytaj",FileDialog.LOAD);
        fd.setVisible(true);

        plik = fd.getDirectory()+fd.getFile();
        plik = plik.replace('\\', '/');
        Sciezka.setText(plik);
        PrintWriter pw;
            try{
                File file = new File(plik);
                Scanner in = new Scanner(file);
                
                while (in.hasNext()) {
                    
                    zdanie = in.nextLine();
                    Tekst.append(zdanie+"\n");
                    zdanie = zdanie.toUpperCase();
                    
                    for (int i=0; i<zdanie.length(); i++) {
                        
                        for (int j=0; j<litera.size(); j++) {
                            if (zdanie.charAt(i)==litera.get(j)) {
                                ilosc.set(j, ilosc.get(j)+1);
                                warunek = true;
                                break;
                            }
                        }
                        
                        if (warunek==false) {
                            litera.add(zdanie.charAt(i));
                            ilosc.add(1);                                                        
                        }
                        warunek = false;
                    }
                                        
                }
                
                Analiza.append("Ilość poszczególnych liter:\n");
                for (int i=0; i<ilosc.size(); i++) {
                    Analiza.append(litera.get(i) + " - " + ilosc.get(i) + "\n");
                }
                
                System.out.println(ilosc);
                System.out.println(litera);

            } catch (IOException ex) {
                System.out.println ("Brak pliku");
            }
    }//GEN-LAST:event_OtworzActionPerformed

    private void ZamknijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZamknijActionPerformed
        //zamykam xd
    }//GEN-LAST:event_ZamknijActionPerformed

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
            java.util.logging.Logger.getLogger(Apka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Analiza;
    private javax.swing.JButton Otworz;
    private javax.swing.JTextField Sciezka;
    private javax.swing.JTextArea Tekst;
    private javax.swing.JButton Zamknij;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
