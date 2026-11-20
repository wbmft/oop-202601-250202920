# Catatan Minggu 07: Koleksi

## Yang saya kerjakan

Pada minggu 7, saya melengkapi empat method di `JadwalPeminjaman`, yaitu `bentrok`, `semuaUrutMulai`, `perAset`, dan `hapus`. `bentrok` memeriksa apakah peminjaman baru menumpuk waktu dengan peminjaman lama pada aset yang sama. `semuaUrutMulai` mengurutkan peminjaman menurut waktu mulai memakai `Comparator`. `perAset` mengelompokkan peminjaman menurut kode aset menjadi `Map`. `hapus` menghapus peminjaman berdasarkan id. Saya juga menulis enam tes sendiri di `BatasBentrokTest` untuk perilaku di batas waktu, dan mengisi A-01 di `docs/asumsi.md`.

## Keputusan desain

- **Batas waktu bentrok (A-01).** Peminjaman 09:00-11:00 dan 11:00-13:00 pada aset yang sama saya putuskan **tidak bentrok**. Rentang waktu saya perlakukan setengah terbuka `[mulai, selesai)`, sehingga kondisinya memakai perbandingan ketat (`isBefore`). Alasannya, aset yang dikembalikan pukul 11:00 sudah bebas pukul 11:00 dan boleh langsung dipinjam orang berikutnya.
- **Struktur data internal.** Saya tetap memakai satu `List` dan tidak menambah `Map` sebagai indeks. Dua struktur data harus selalu sinkron, `daftarMutable()` memberi akses langsung ke list, dan datanya kecil. `Map` hanya dibuat sesaat di `perAset`.
- **Status peminjaman belum diperiksa.** Untuk sementara `bentrok` mengabaikan status, sehingga peminjaman DITOLAK atau DIBATALKAN masih dianggap menempati jadwal. Aturan ambigu nomor 7 akan saya putuskan di minggu 9.

## Kendala

- Saya sempat bingung menentukan tanda `<` atau `<=` pada pemeriksaan bentrok. Saya mengatasinya dengan menggambar garis waktu untuk kasus 09-11 dan 11-13, lalu menelusuri hasil tiap kondisi.
- Tes buatan saya awalnya tidak ikut berjalan lewat `scripts/uji`. Penyebabnya, skrip memakai filter `groups`, jadi tes tanpa `@Tag("week7")` dilewati. Saya menambahkan tag tersebut.
- [Tambahkan kendala lain yang Anda alami sendiri, bila ada.]

## Penggunaan AI

- Alat yang dipakai: Claude.
- Bagian yang dibantu AI: `bentrok`, `semuaUrutMulai`, `perAset`, `hapus` di `JadwalPeminjaman`, enam tes di `BatasBentrokTest`, draf entri A-01, dan berkas penjelasan materi.
- Prompt utama:
  1. "Bantu saya kerjakan week 7, sesuaikan dengan instruksi yang saya tuliskan."
  2. "Buat file penjelasan dari materi dan praktikum di week 7, jelaskan juga kode-kodenya."
- Yang saya ubah atau tolak dari saran AI, dan alasannya: saya memeriksa  keputusan batas waktu bentrok dan memastikan alasannya masuk akal untuk peminjaman aset kampus. Saya juga menelusuri kondisi bentrok dengan contoh angka sebelum menerimanya.
- Satu hal yang saya pahami lebih baik sekarang: dua rentang waktu bentrok bila `A.mulai < B.selesai` dan `B.mulai < A.selesai`. Pilihan antara `<` dan `<=` menentukan apakah rentang yang saling menempel di batas dianggap bentrok. [Ganti dengan pemahaman Anda sendiri bila ada yang lebih tepat.]