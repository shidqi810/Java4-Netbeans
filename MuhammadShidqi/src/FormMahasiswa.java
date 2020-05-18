/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.awt.event.*;
import javax.swing.*;
import com.mysql.jdbc.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shidqi
 */
public class FormMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form FormMahasiswa
     */
    public FormMahasiswa() {
        initComponents();
        setTitle("Form Data Mahasiswa By Muhammad Shidqi");
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Koneksi_db.openConnection();
        
        nonAktif();
        
        fillTanggal();
        fillTahun();
        fillFakultas();
    }
    
    public void nonAktif() {
        txtNim.setEnabled(false);
        txtNama.setEnabled(false);

        radioLaki.setEnabled(false);
        radioPerempuan.setEnabled(false);

        cmbLahir.setEnabled(false);
        cmbTanggal.setEnabled(false);
        cmbBulan.setEnabled(false);
        cmbTahun.setEnabled(false);

        txtAlamat.setEnabled(false);

        cmbFakultas.setEnabled(false);
        cmbJurusan.setEnabled(false);
        txtNilai.setEnabled(false);
        
        btnSimpan.setEnabled(false);
        btnEdit.setEnabled(false);
        btnClear.setEnabled(false);
        btnSelesai.setEnabled(false);
    }
    
    public void aktif() {
        txtNim.setEnabled(true);
        txtNama.setEnabled(true);

        radioLaki.setEnabled(true);
        radioPerempuan.setEnabled(true);

        cmbLahir.setEnabled(true);
        cmbTanggal.setEnabled(true);
        cmbBulan.setEnabled(true);
        cmbTahun.setEnabled(true);

        txtAlamat.setEnabled(true);

        cmbFakultas.setEnabled(true);
        cmbJurusan.setEnabled(true);
        txtNilai.setEnabled(true);
        
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(true);
        btnClear.setEnabled(true);
        btnSelesai.setEnabled(true);
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
    
    static String fakultas[] = {
        "Syariah dan Hukum", "Tarbiyah", "Ushuluddin Dan Pemikiran Islam", "Adab Dan Humaniora",
        "Dakwah Dan Komunikasi", "Ekonomi Dan Bisnis Islam", "Ilmu Sosial Dan Ilmu Politik",
        "Psikologi", "Sains Dan Teknologi"
    };
    
    // Variabel Global jurusan 2 Dimensi di dalam class BiodataSaya
    static String jurusan[][] = {
        {
            "Jinayah Siyasah / Pidana dan politik",
            "Perbandingan Mazhab dan Hukum",
            "Zakat dan Wakaf",
            "Mu’amalah / Perdata dan Niaga",
            "Al-Akhwal al-Syakhsiyah / Hukum Keluarga"
        },
        {
            "Manajemen Pendidikan Islam",
            "Pendidikan Bahasa Arab",
            "Pendidikan Guru Madrasah Ibtidaiyah",
            "Pendidikan Bahasa Inggris",
            "Pendidikan Guru Raudhatul Athfal",
            "Pendidikan Biologi",
            "Pendidikan Matematika",
            "Pendidikan Kimia",
            "Pendidikan Fisika",
            "Pendidikan Agama Islam"
        },
        {
            "Aqidah Filsafat Islam",
            "Ilmu Hadist",
            "Tasawuf dan Psikoterapi",
            "Ilmu Al-Qur’an dan Tafsir",
            "Studi Agama-Agama"
        },
        {
            "Sejarah dan Kebudayaan Islam",
            "Bahasa dan Sastra Arab",
            "Ilmu Perpustakaan",
            "Politik Islam"
        },
        {
            "Jurnalistik",
            "Bimbingan dan Penyuluhan Islam",
            "Pengembangan Masyarakat Islam",
            "Manajemen Dakwah",
            "Komunikasi dan Penyiaran Islam"
        },
        {
            "D3 Perbankan Syari ah",
            "Perbankan Syari ah",
            "Ekonomi Islam"
        },
        {
            "Ilmu Komunikasi",
            "Ilmu Politik"
        },
        {
            "Psikologi Islam"
        },
        {
            "Sistem Informasi",
            "Kimia",
            "Biologi"
        }
    };
    
    public void fillTanggal() {
        for (int i = 1; i <= 30; i++) {
            cmbTanggal.addItem(i);
        }
    }
    
    public void fillTahun() {
        for (int j = 1940; j <= 2020; j++) {
            cmbTahun.addItem(j);
        }
    }
    
    public void fillFakultas() {
        for (int i = 0; i < fakultas.length; i++) {
            cmbFakultas.addItem(fakultas[i]);
        }
    }
    
    public void fillJurusan(int index) {
        // menghapus seluruh isi combo box jurusan
        cmbJurusan.removeAllItems();
        
        // hanya mengambil data dari index yang di kirimkan oleh fakultas
                                // index merupakan pemilih untuk golongan fakultas di jurusan
        for (int i = 0; i < jurusan[index].length; i++) {
            cmbJurusan.addItem(jurusan[index][i]);
        }
    }
    
    void simpan() {
        String sql = "INSERT INTO data_mhs values(?,?,?,?,?,?,?,?,?,?)";
        String jKel= null;
        
        try {
            PreparedStatement st = (com.mysql.jdbc.PreparedStatement) Koneksi_db.conn.prepareStatement(sql);
            
            st.setInt(1, Integer.parseInt(txtNim.getText()));
            st.setString(2,txtNama.getText());
            if (radioLaki.isSelected()) {
                jKel = "Laki Laki";
            }
            else {
                jKel = "Perempuan";
            }
            
            st.setString(3, jKel);
            st.setString(4, cmbLahir.getSelectedItem().toString());
            
            String tanggal = String.valueOf(cmbTanggal.getSelectedItem());
            String bulan = String.valueOf(cmbBulan.getSelectedItem());
            String tahun = String.valueOf(cmbTahun.getSelectedItem());
            st.setString(5, tanggal + " - " + bulan + " - " + tahun);
            st.setString(6, txtAlamat.getText());
            
            st.setString(7, cmbFakultas.getSelectedItem().toString());
            st.setString(8, cmbJurusan.getSelectedItem().toString());
            
            double nilai = Double.parseDouble(txtNilai.getText());
            st.setDouble(9, nilai);
            
            if (nilai > 0 && nilai <= 50) {
                st.setString(10, "E");
            }
            else if (nilai > 50 && nilai <= 60) {
                st.setString(10, "D");
            }
            else if (nilai > 60 && nilai <= 70) {
                st.setString(10, "C");
            }
            else if (nilai > 70 && nilai <= 80) {
                st.setString(10, "B");
            }
            else if (nilai > 80 && nilai <= 100) {
                st.setString(10, "A");
            }
            
            st.execute();
            
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil disimpan");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal disimpan");
        }
    }
    
    void edit() {
        String sql = "UPDATE data_mhs set nim=?, nama=?, kelamin=?, tmpt_lahir=?, tanggal_lahir=?, alamat=?, fakultas=?, jurusan=?, nilai_akhir=?, bobot=?"
                + "WHERE nim = " + txtNim.getText();
        String jKel= null;
        
        try {
            PreparedStatement st = (com.mysql.jdbc.PreparedStatement) Koneksi_db.conn.prepareStatement(sql);
            
            st.setInt(1, Integer.parseInt(txtNim.getText()));
            st.setString(2,txtNama.getText());
            if (radioLaki.isSelected()) {
                jKel = "Laki Laki";
            }
            else {
                jKel = "Perempuan";
            }
            
            st.setString(3, jKel);
            st.setString(4, cmbLahir.getSelectedItem().toString());
            
            String tanggal = String.valueOf(cmbTanggal.getSelectedItem());
            String bulan = String.valueOf(cmbBulan.getSelectedItem());
            String tahun = String.valueOf(cmbTahun.getSelectedItem());
            st.setString(5, tanggal + " - " + bulan + " - " + tahun);
            st.setString(6, txtAlamat.getText());
            
            st.setString(7, cmbFakultas.getSelectedItem().toString());
            st.setString(8, cmbJurusan.getSelectedItem().toString());
            
            double nilai = Double.parseDouble(txtNilai.getText());
            st.setDouble(9, nilai);
            
            if (nilai > 0 && nilai <= 50) {
                st.setString(10, "E");
            }
            else if (nilai > 50 && nilai <= 60) {
                st.setString(10, "D");
            }
            else if (nilai > 60 && nilai <= 70) {
                st.setString(10, "C");
            }
            else if (nilai > 70 && nilai <= 80) {
                st.setString(10, "B");
            }
            else if (nilai > 80 && nilai <= 100) {
                st.setString(10, "A");
            }
            
            st.execute();
            
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil disimpan");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal disimpan");
        }
    }
    
    void hapus(String nim) {
        String sql = "DELETE FROM data_mhs WHERE nim = " + nim;
        Statement st;
        try {
            st = (com.mysql.jdbc.PreparedStatement) Koneksi_db.conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NIM Yang anda masukkan tidak ada!");
        }
    }
    
    void tampil(String NIM) {
        // objek untuk sql
        Statement st;
        // utk menyimpan hasil query select
        java.sql.ResultSet rs;
        
        try {
            st = (Statement) Koneksi_db.conn.createStatement();
            // tidak msalah NIM nya bertipe String, krn jika tidak di beri petik
            // di query sql, maka akan tetap menjadi integer
            String sql = "SELECT * FROM data_mhs WHERE nim = " + NIM;
            st.execute(sql);
            rs = st.getResultSet();
            int baris = 0;
            
            rs.beforeFirst();
            while (rs.next()) {
                baris = rs.getRow();
            }
            
            if (baris > 0) {
                // menentukan header Jtabel
                rs.beforeFirst();
                rs.next();
                
                txtNim.setText(rs.getString("nim"));
                txtNama.setText(rs.getString("nama"));
                
                if (rs.getString("kelamin").equals("Laki Laki")) {
                    radioLaki.setSelected(true);
                }
                else {
                    radioPerempuan.setSelected(true);
                }
                
                cmbLahir.setSelectedItem(rs.getString("tmpt_lahir"));
                
                String date = rs.getString("tanggal_lahir");
                String date2[] = date.split(" - ");
                
                fillTanggal();
                fillTahun();
                cmbTanggal.setSelectedItem(Integer.parseInt(date2[0]));
                cmbBulan.setSelectedItem(date2[1]);
                cmbTahun.setSelectedItem(Integer.parseInt(date2[2]));
                
                txtAlamat.setText(rs.getString("alamat"));
                
                cmbFakultas.setSelectedItem(rs.getString("fakultas"));
                cmbJurusan.setSelectedItem(rs.getString("jurusan"));
                txtNilai.setText(rs.getString("nilai_akhir"));
                
                JOptionPane.showMessageDialog(null, "Data Ditemukan");
                aktif();
                txtNim.setEnabled(false);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }
    }
    
    void refresh() {
        Statement st;
        java.sql.ResultSet rs;
        try {
            st = (Statement) Koneksi_db.conn.createStatement();
            String sql = "SELECT * FROM data_mhs ORDER BY nim ASC";
            st.execute(sql);
            
            rs = st.getResultSet();
            // Memberi nama di header
            String header[] = {"NIM", "Nama Mahasiswa", "Jenis Kelamin", "Tempat Kelahiran", "Tanggal Lahir",
                "Alamat", "Fakultas", "Jurusan", "Nilai Akhir", "Bobot"
            };
            
            int baris = 0;
            rs.beforeFirst();
            while (rs.next()) {                
                baris = rs.getRow();
            }
            
            Object data[][] = new Object[baris][10];
            rs.beforeFirst();
            int baris2 = 0;
            
            while (rs.next()) {                
                data[baris2][0] = rs.getString("nim");
                data[baris2][1] = rs.getString("nama");
                data[baris2][2] = rs.getString("kelamin");
                data[baris2][3] = rs.getString("tmpt_lahir");
                data[baris2][4] = rs.getString("tanggal_lahir");
                data[baris2][5] = rs.getString("alamat");
                data[baris2][6] = rs.getString("fakultas");
                data[baris2][7] = rs.getString("jurusan");
                data[baris2][8] = rs.getString("nilai_akhir");
                data[baris2][9] = rs.getString("bobot");
                baris2++;
            }
            tableMhs.setModel(new DefaultTableModel(data, header));
        }
        catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    void clear() {
        txtNim.setText("");
        txtNama.setText("");
        bgJK.clearSelection();
        cmbLahir.setSelectedIndex(-1);
        
        cmbTanggal.setSelectedIndex(-1);
        cmbBulan.setSelectedIndex(-1);
        cmbTahun.setSelectedIndex(-1);
        
        txtAlamat.setText("");
        txtNilai.setText("");

        cmbFakultas.setSelectedIndex(0);
        cmbJurusan.setSelectedIndex(0);
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

        bgJK = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        radioLaki = new javax.swing.JRadioButton();
        radioPerempuan = new javax.swing.JRadioButton();
        cmbLahir = new javax.swing.JComboBox<>();
        cmbTanggal = new javax.swing.JComboBox<>();
        cmbBulan = new javax.swing.JComboBox<>();
        cmbTahun = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMhs = new javax.swing.JTable();
        cmbFakultas = new javax.swing.JComboBox<>();
        cmbJurusan = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNilai = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        btnTampil = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Form Data Mahasiswa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 110, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NIM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Mhasiswa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tempat Lahir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tanggal Lahir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Alamat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 90, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nilai Akhir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 90, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Jurusan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 90, 0, 0);
        getContentPane().add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 9, 0, 0);
        getContentPane().add(txtNim, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 9, 0, 0);
        getContentPane().add(txtNama, gridBagConstraints);

        bgJK.add(radioLaki);
        radioLaki.setText("Laki Laki");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 9, 0, 0);
        getContentPane().add(radioLaki, gridBagConstraints);

        bgJK.add(radioPerempuan);
        radioPerempuan.setText("Perempuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 20, 0, 0);
        getContentPane().add(radioPerempuan, gridBagConstraints);

        cmbLahir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Palembang", "Jakarta", "Padang", "Medan", "Aceh", "Pagaralam", "Yogyakarta", "Bandung", "Bogor" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 9, 0, 0);
        getContentPane().add(cmbLahir, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 9, 0, 0);
        getContentPane().add(cmbTanggal, gridBagConstraints);

        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 23, 0, 0);
        getContentPane().add(cmbBulan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 17, 0, 0);
        getContentPane().add(cmbTahun, gridBagConstraints);

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 187;
        gridBagConstraints.ipady = 57;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 47, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        tableMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama Mahasiswa", "Jenis Kelamin", "Tempat Kelahiran", "Tanggal Lahir", "Alamat", "Fakultas", "Jurusan", "Nilai Akhir", "Bobot"
            }
        ));
        jScrollPane2.setViewportView(tableMhs);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1197;
        gridBagConstraints.ipady = 71;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 43, 13);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        cmbFakultas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFakultasItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 47, 0, 0);
        getContentPane().add(cmbFakultas, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 47, 0, 0);
        getContentPane().add(cmbJurusan, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Fakultas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 90, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 193;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 47, 0, 0);
        getContentPane().add(txtNilai, gridBagConstraints);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 100, 0, 0);
        getContentPane().add(btnTambah, gridBagConstraints);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 100, 0, 0);
        getContentPane().add(btnSimpan, gridBagConstraints);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 100, 0, 0);
        getContentPane().add(btnHapus, gridBagConstraints);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 49, 0, 0);
        getContentPane().add(btnCari, gridBagConstraints);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 49, 0, 0);
        getContentPane().add(btnEdit, gridBagConstraints);

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 49, 0, 0);
        getContentPane().add(btnKeluar, gridBagConstraints);

        btnClear.setText("Clear Field");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 29;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 40, 0, 0);
        getContentPane().add(btnClear, gridBagConstraints);

        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 29;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 40, 0, 0);
        getContentPane().add(btnSelesai, gridBagConstraints);

        btnTampil.setText("Tampil Data");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 29;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 30, 0, 0);
        getContentPane().add(btnTampil, gridBagConstraints);

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

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        aktif();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("Masukkan NIM Yang Akan di Hapus = ");
        
        if (!input.isEmpty()) {
            int jawab = JOptionPane.showConfirmDialog(null, "Ingin Hapus Data Ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                hapus(input);
                refresh();
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak jadi di hapus!");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Masukkan NIM!");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("Masukkan NIM Yang ingin di cari = ");
        tampil(input);
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan();
        refresh();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        edit();
        refresh();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cmbFakultasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFakultasItemStateChanged
        // TODO add your handling code here:
        fillJurusan(cmbFakultas.getSelectedIndex());
    }//GEN-LAST:event_cmbFakultasItemStateChanged

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null,
        "Apakah anda akan menutup system?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
                                         // Menggunakan Sistem Yes No Option yang ada pada class JOoptionPane

        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        nonAktif();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnTampilActionPerformed

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
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        tema();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgJK;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTampil;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JComboBox<String> cmbFakultas;
    private javax.swing.JComboBox<String> cmbJurusan;
    private javax.swing.JComboBox<String> cmbLahir;
    private javax.swing.JComboBox<Integer> cmbTahun;
    private javax.swing.JComboBox<Integer> cmbTanggal;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuItem menuBerat;
    private javax.swing.JMenuItem menuBiodata;
    private javax.swing.JMenuItem menuKalkulator;
    private javax.swing.JMenuItem menuPembayaran;
    private javax.swing.JMenuItem menuRumahMakan;
    private javax.swing.JRadioButton radioLaki;
    private javax.swing.JRadioButton radioPerempuan;
    private javax.swing.JTable tableMhs;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNilai;
    private javax.swing.JTextField txtNim;
    // End of variables declaration//GEN-END:variables
}
