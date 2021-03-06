
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shidqi
 */
public class Menu_Utama extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Utama
     */
    public Menu_Utama() {
        initComponents();
        //untuk membuat frame menjadi maximize
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void tema(){
        try{
            /*
             * Pada UIManager kalian bisa memilih jenis tema
             * apa yang digunakan, sebagai contoh saya
             * menggunakan tema BernsteinLookAndFeel
            */
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        }catch(UnsupportedLookAndFeelException ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKalkulator = new javax.swing.JMenuItem();
        menuBerat = new javax.swing.JMenuItem();
        menuBiodata = new javax.swing.JMenuItem();
        menuRumahMakan = new javax.swing.JMenuItem();
        menuPembayaran = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jLabel1.setText("Selamat Datang Di Aplikasi Muhammad Shidqi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 110, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\D\\Java4 PBO\\NetBeansProjects\\MuhammadShidqi\\src\\gambarrr\\icon2.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 40, 32, 32);
        getContentPane().add(jLabel3, gridBagConstraints);

        jMenu1.setText("File");

        menuKalkulator.setText("Kalkulator Sederhana");
        menuKalkulator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKalkulatorActionPerformed(evt);
            }
        });
        jMenu1.add(menuKalkulator);

        menuBerat.setText("Berat Badan Ideal");
        menuBerat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBeratActionPerformed(evt);
            }
        });
        jMenu1.add(menuBerat);

        menuBiodata.setText("Biodata");
        menuBiodata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBiodataActionPerformed(evt);
            }
        });
        jMenu1.add(menuBiodata);

        menuRumahMakan.setText("Rumah Makan");
        menuRumahMakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRumahMakanActionPerformed(evt);
            }
        });
        jMenu1.add(menuRumahMakan);

        menuPembayaran.setText("Pembayaran");
        menuPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPembayaranActionPerformed(evt);
            }
        });
        jMenu1.add(menuPembayaran);

        jMenuItem1.setText("Form Mahasiswa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        logOut.setText("Logout");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        jMenu1.add(logOut);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuKalkulatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKalkulatorActionPerformed
        // TODO add your handling code here:
        new FormKalkulator().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuKalkulatorActionPerformed

    private void menuBeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBeratActionPerformed
        // TODO add your handling code here:
        new FormBeratBadan().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBeratActionPerformed

    private void menuBiodataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBiodataActionPerformed
        // TODO add your handling code here:
        new BiodataSaya().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBiodataActionPerformed

    private void menuRumahMakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRumahMakanActionPerformed
        // TODO add your handling code here:
        new RumahMakanAntiGalau().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuRumahMakanActionPerformed

    private void menuPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPembayaranActionPerformed
        // TODO add your handling code here:
        new FormPembayaran().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuPembayaranActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null,
            "Apakah anda akan menutup system?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        // Menggunakan Sistem Yes No Option yang ada pada class JOoptionPane

        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        new FormLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new FormMahasiswa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        tema();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuItem menuBerat;
    private javax.swing.JMenuItem menuBiodata;
    private javax.swing.JMenuItem menuKalkulator;
    private javax.swing.JMenuItem menuPembayaran;
    private javax.swing.JMenuItem menuRumahMakan;
    // End of variables declaration//GEN-END:variables
}
