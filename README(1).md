# P07 - Mini Proyek: Katalog Buku Perpustakaan

**NPM:** 2310010324  
**Repository:** pbo2-2310010324

Proyek Maven `p07-mini-proyek`, package `id.ac.uniska.pbo2.p07`.

## Struktur Kelas

| Kelas | Jenis | Keterangan |
|---|---|---|
| `StatusBuku` | Enum | Tersedia / Dipinjam |
| `Buku` | Record | kode, judul, penulis, tahun, status |
| `BukuTableModel` | AbstractTableModel | Model tabel, `fire...` setelah tambah/ubah/hapus |
| `DialogBuku` | JDialog Form (modal) | Tambah dan ubah buku, dengan validasi |
| `AplikasiBuku` | JFrame Form | Jendela utama: tabel, menu, pencarian, status |

## Fitur

- Tabel buku (kode, judul, penulis, tahun terbit, status), 5 data contoh saat dibuka
- Tambah dan ubah lewat JDialog Form modal; kode dan judul wajib diisi; tahun angka 1900 sampai tahun sekarang
- Hapus dengan konfirmasi, memakai `convertRowIndexToModel`
- Menu Bar: File (mnemonic F) dan Buku (mnemonic B), accelerator Ctrl+N (Tambah), Ctrl+E (Ubah), Ctrl+D (Hapus)
- Pencarian berdasarkan kode, judul, atau penulis
- Label status: jumlah buku ditampilkan dan jumlah buku tersedia
- Tombol dan menu Ubah/Hapus aktif hanya jika ada baris dipilih

## Peta Event

| Komponen | Event | Memanggil |
|---|---|---|
| tambahButton, tambahItem (Ctrl+N) | actionPerformed | `tambah()` |
| ubahButton, ubahItem (Ctrl+E) | actionPerformed | `ubah()` |
| hapusButton, hapusItem (Ctrl+D) | actionPerformed | `hapus()` |
| cariField | keyReleased | `saring()` |
| bukuTable | mouseClicked (klik dua kali) | `ubah()` |
| bukuTable (selection model) | ListSelectionListener (di konstruktor) | `perbaruiTombol()` |
| keluarItem | actionPerformed | `dispose()` |
| tentangItem | actionPerformed | dialog informasi |
| batalButton (dialog) | actionPerformed | `dispose()` |
| simpanButton (dialog) | actionPerformed | `simpan()` |

## Video Demo

Tautan video (maksimal 3 menit): **ISI_TAUTAN_VIDEO_DI_SINI**

Video memperlihatkan semua fitur pada tabel bagian D, termasuk sekilas tab Design dan jendela Navigator.

## Deklarasi Penggunaan AI

**ISI SESUAI KENYATAAN.** Pilih salah satu:

- Alat yang dipakai: ______ (misalnya Claude). Keperluan: ______ (misalnya membantu menyusun contoh kode kelas model dan draf README; seluruh tampilan Design dan pengujian saya kerjakan sendiri).
- *atau* Saya tidak memakai AI dalam mengerjakan proyek ini.
