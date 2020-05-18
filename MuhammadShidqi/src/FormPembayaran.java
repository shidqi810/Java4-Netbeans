
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JFrame;
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
public class FormPembayaran extends javax.swing.JFrame {

    /**
     * Creates new form FormPembayaran
     */
    public FormPembayaran() {
        initComponents();
        setLocation(500, 150);
        setTitle("Pembayaran Muhammad Shidqi");
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnHitung.setBackground(new java.awt.Color(80,78,3));
        btnHapus.setBackground(new java.awt.Color(80,78,3));
        btnKeluar.setBackground(new java.awt.Color(80,78,3));
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
        jLabel2 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKet = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Montserrat Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aplikasi Pembayaran");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 40, 0, 50);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Jumlah Barang");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 0, 0);
        getContentPane().add(txtJumlah, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Harga Barang");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 0, 0);
        getContentPane().add(txtHarga, gridBagConstraints);

        btnHitung.setIcon(new javax.swing.ImageIcon("D:\\D\\Java4 PBO\\NetBeansProjects\\MuhammadShidqi\\src\\gambarrr\\simpan2.png")); // NOI18N
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = -17;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 130, 0, 0);
        getContentPane().add(btnHitung, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Bayar + Pajak 10%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 50, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 8, 0, 0);
        getContentPane().add(txtBayar, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Keterangan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 50, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 8, 0, 0);
        getContentPane().add(txtKet, gridBagConstraints);

        btnHapus.setIcon(new javax.swing.ImageIcon("D:\\D\\Java4 PBO\\NetBeansProjects\\MuhammadShidqi\\src\\gambarrr\\Hapus2.png")); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = -13;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 50, 25, 0);
        getContentPane().add(btnHapus, gridBagConstraints);

        btnKeluar.setIcon(new javax.swing.ImageIcon("D:\\D\\Java4 PBO\\NetBeansProjects\\MuhammadShidqi\\src\\gambarrr\\keluar2.png")); // NOI18N
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = -13;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 28, 25, 0);
        getContentPane().add(btnKeluar, gridBagConstraints);

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

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        txtBayar.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtKet.setText("");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        int jawab = javax.swing.JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Menutup Sistem??", "Konfirmasi",
            javax.swing.JOptionPane.YES_NO_OPTION);
        
        if (jawab == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        int jumlah, harga, bayar, pajak;
        
        jumlah = Integer.parseInt(txtJumlah.getText());
        harga = Integer.parseInt(txtHarga.getText());
        
        pajak = (jumlah*harga) * 10/100;
        bayar = jumlah * harga + pajak;
        
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        String uang = String.valueOf(kursIndonesia.format(bayar));

        txtBayar.setText("" + uang);
        
        if (bayar > 500000) {
            txtKet.setText("Dapat Bonus");
        }
        else {
            txtKet.setText("Tidak Dapat Bonus");
        }
    }//GEN-LAST:event_btnHitungActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new FormMahasiswa().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        new FormLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null,
            "Apakah anda akan menutup system?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        // Menggunakan Sistem Yes No Option yang ada pada class JOoptionPane

        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        tema();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuItem menuBerat;
    private javax.swing.JMenuItem menuBiodata;
    private javax.swing.JMenuItem menuKalkulator;
    private javax.swing.JMenuItem menuPembayaran;
    private javax.swing.JMenuItem menuRumahMakan;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKet;
    // End of variables declaration//GEN-END:variables
}
