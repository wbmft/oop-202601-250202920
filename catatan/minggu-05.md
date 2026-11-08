# Catatan Minggu 05: Abstraction

## Yang saya kerjakan

Pada minggu 5 saya mengubah `Aset` menjadi kelas abstrak, mengisi `bisaDipinjam()` (true hanya jika status TERSEDIA
dan kondisi bukan RUSAK_BERAT), dan menjadikan `hitungDenda` abstrak sehingga `Ruang`, `Laptop`, dan `AlatLab`
wajib mengisinya sendiri. Saya juga mengimplementasikan interface `AturanDenda` dalam dua kelas: `DendaFlat`
(sama dengan `aset.hitungDenda(hari)`) dan `DendaProgresif` (7 hari pertama flat, hari berikutnya tarif dua kali lipat).

## Keputusan desain

- **Abstract class untuk `Aset`, interface untuk `AturanDenda`.** `Aset` punya state (kode, nama, status, kondisi) dan
  perilaku bersama, jadi cocok sebagai abstract class. `AturanDenda` hanya kontrak "cara menghitung denda" tanpa state,
  jadi cocok sebagai interface yang bisa diganti-ganti.
- **`dendaDasar()` di `Aset`.** Karena `hitungDenda` kini abstrak, subclass tidak bisa memanggil `super.hitungDenda()`.
  Perhitungan dasar saya pindah ke `protected final long dendaDasar(int)` agar tidak ditulis ulang di tiap subclass.
- **`getJenis()` tetap seperti aslinya.** Dokumen minggu 5 hanya meminta `hitungDenda` yang abstrak, jadi
  `getJenis()` tidak saya ubah.
- **Keterangan dosen saya pertahankan.** Javadoc dan komentar TODO dari dosen tetap ada. Saya hanya menghapus baris
  `throw new UnsupportedOperationException(...)` yang memang harus diganti implementasi.
- **Rumus progresif** dan alasannya saya catat di `docs/asumsi.md` (A-08), dan pemindahan perhitungan dasar di A-09.

## Kendala

- Setelah mengisi kode, tes minggu 5 masih gagal dengan `UnsupportedOperationException: TODO minggu 5: DendaFlat.hitung`.
  Dari stack trace saya melihat error ada di `DendaFlat.java` baris 11, yaitu baris `throw` bawaan dosen, artinya isi
  file yang baru belum tersimpan. Saya memperbaikinya dengan menyimpan isi file lalu menjalankan ulang tes.
- Saya sempat bingung kenapa `dendaProgresifMemenuhiSyaratMinimal` ikut gagal padahal yang gagal adalah `DendaFlat`.
  Ternyata tes itu membandingkan progresif dengan flat, jadi `DendaFlat` ikut dipanggil.
- Menjadikan `hitungDenda` abstrak membuat `super.hitungDenda()` di tiga subclass tidak bisa dikompilasi.
  Solusinya `dendaDasar()` seperti dijelaskan di atas.
- Hasil akhir tes: [isi, mis. "BUILD SUCCESS, 32 tes lolos" setelah kamu menjalankan ulang dan memastikannya].

## Penggunaan AI

- Alat yang dipakai: Claude.
- Bagian yang dibantu AI: `Aset` (abstrak, `bisaDipinjam`, `dendaDasar`), `hitungDenda` di `Ruang`/`Laptop`/`AlatLab`,
  `DendaFlat`, `DendaProgresif`, draf `docs/asumsi.md` dan draf catatan ini, serta membaca log error tes.
- Prompt utama:
  1. "bantu saya kerjakan week 5" (disertai seluruh isi repo sebagai konteks)
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Versi pertama AI membuat `getJenis()` menjadi abstrak dan
  menghapus komentar dosen. Saya minta dikembalikan karena itu di luar tugas minggu 5 dan keterangan dosen tidak boleh
  hilang dari repo hasil fork. [Tambahkan bila kamu mengubah rumus progresif atau hal lain dari saran AI.]
- Satu hal yang saya pahami lebih baik sekarang: [tulis dengan kalimatmu sendiri. Contoh arah: kapan memilih abstract
  class dan kapan interface, atau kenapa method abstrak tidak bisa dipanggil lewat `super`.]