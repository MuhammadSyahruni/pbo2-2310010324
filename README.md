# P07 - Tabel dan Menu (Aplikasi Daftar Kontak)

**NPM:** 2310010324  
**Repository:** pbo2-2310010324

Proyek Maven `p07-tabel-dan-menu`, package `id.ac.uniska.pbo2.p07`.
Berisi `Kategori`, `Kontak`, `KontakTableModel`, `DialogKontak` (JDialog Form), dan `AplikasiKontak` (JFrame Form).

## Jawaban Eksperimen Praktikum 5

> Catatan: jalankan setiap eksperimen sendiri, amati hasilnya, lalu kembalikan kode seperti semula.
> Sesuaikan jawaban di bawah dengan apa yang benar-benar Anda amati.

**1. Baris `fireTableRowsInserted(baris, baris);` dijadikan komentar, lalu menambah kontak baru.**
Tabel tidak langsung berubah. Data sudah masuk ke `List`, tetapi `JTable` tidak diberi tahu bahwa ada baris baru, sehingga tidak menggambar ulang.

**2. `barisTerpilih()` diganti `return kontakTable.getSelectedRow();`, cari "ah", pilih Ahmad Fauzi, klik Hapus lalu pilih No.**
Dialog konfirmasi menampilkan **"Hapus kontak Budi Santoso?"**. Ahmad Fauzi berada di baris tampilan 1, tetapi baris 1 di model adalah Budi Santoso. Tanpa `convertRowIndexToModel`, nomor baris tampilan dipakai langsung sebagai nomor baris model.

**3. `super(pemilik, judul, true)` diubah menjadi `false`.**
Dialog tidak lagi modal. `setVisible(true)` langsung kembali tanpa menunggu dialog ditutup, sehingga `tampilkan()` mengembalikan `hasil` yang masih `null` dan kontak tidak pernah ditambahkan. Jendela utama juga tetap bisa diklik saat dialog terbuka.

**4. Ctrl+N, Ctrl+E, Ctrl+D.**
Ctrl+N selalu bekerja. Ctrl+E dan Ctrl+D tidak bekerja saat tidak ada baris dipilih karena `perbaruiTombol()` memanggil `setEnabled(false)` pada `ubahItem` dan `hapusItem`; item menu yang nonaktif tidak menjalankan aksinya, termasuk lewat accelerator.

**5. Accelerator `hapusItem` diubah menjadi tombol Delete tanpa Ctrl.**
Baris `hapusItem.setAccelerator(...)` di `initComponents()` berubah dari `KeyEvent.VK_D` dengan `InputEvent.CTRL_DOWN_MASK` menjadi `KeyEvent.VK_DELETE` dengan modifier `0`.

**6. Atribut diubah menjadi `private KontakTableModel model;` dan diisi setelah `initComponents()`.**
Muncul `IllegalArgumentException: Cannot set a null TableModel`. `initComponents()` dipanggil di awal konstruktor dan menjalankan `kontakTable.setModel(model)` saat `model` masih `null`. (Modifier `final` harus dilepas dulu agar kode dapat dikompilasi.)

## Jawaban Pertanyaan Refleksi (opsional)

1. **JTable tidak menyimpan data**: JTable hanya menggambar; data ada di `TableModel` (di sini `List<Kontak>`), dan JTable bertanya ke model setiap kali menggambar.
2. **Model lupa memanggil `fire...`**: data berubah tetapi tampilan tabel tidak diperbarui.
3. **Mnemonic vs accelerator**: mnemonic (Alt + huruf) membuka menu dan memilih item; accelerator (misalnya Ctrl+N) menjalankan aksi langsung tanpa membuka menu.
4. **Dialog modal**: mengunci jendela utama dan membuat `setVisible(true)` menunggu, sehingga hasil isian langsung dapat dibaca.
5. **Tanpa `convertRowIndexToModel`**: lihat eksperimen 2; memilih Ahmad Fauzi saat tabel disaring menghapus Budi Santoso.
6. **Model harus dibuat sebelum `initComponents()`**: Custom code `setModel(model)` dijalankan di dalamnya; jika `model` masih `null`, terjadi error.
