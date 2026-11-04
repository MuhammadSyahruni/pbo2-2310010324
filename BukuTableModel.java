package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/** Menghubungkan daftar Buku dengan JTable. */
public class BukuTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {"Kode", "Judul", "Penulis", "Tahun", "Status"};
    private final List<Buku> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    /** Kolom Tahun bertipe Integer agar terurut sebagai angka, bukan teks. */
    @Override
    public Class<?> getColumnClass(int kolom) {
        return kolom == 3 ? Integer.class : Object.class;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku b = daftar.get(baris);
        return switch (kolom) {
            case 0 -> b.kode();
            case 1 -> b.judul();
            case 2 -> b.penulis();
            case 3 -> b.tahun();
            default -> b.status();
        };
    }

    public Buku get(int baris) {
        return daftar.get(baris);
    }

    public void tambah(Buku buku) {
        daftar.add(buku);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public void ubah(int baris, Buku buku) {
        daftar.set(baris, buku);
        fireTableRowsUpdated(baris, baris);
    }

    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }

    /** Jumlah buku berstatus Tersedia, untuk label status. */
    public long jumlahTersedia() {
        return daftar.stream().filter(b -> b.status() == StatusBuku.TERSEDIA).count();
    }
}
