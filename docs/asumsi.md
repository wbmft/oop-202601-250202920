# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:

## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: (isi)
- Alasan: (isi)
- Dampak ke kode: (isi)
- Tes yang membuktikan: (isi)

## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.

## A-08: rumus denda progresif (minggu 5)
- Pertanyaan: Bagaimana denda dihitung agar makin berat bila makin lama terlambat, tetapi tetap memenuhi syarat
  minimal (0 hari = 0, tidak pernah lebih murah dari DendaFlat, tidak pernah turun, hari ke-30 lebih mahal dari flat)?
- Keputusan: 7 hari pertama dihitung sama dengan flat. Setiap hari setelah hari ke-7 dikenai tarif dua kali lipat.
  Rumus: `progresif(h) = flat(h) + flat(max(0, h - 7))`, dengan `flat(h) = aset.hitungDenda(h)`.
- Alasan: Keterlambatan singkat wajar diberi keringanan, sedangkan keterlambatan panjang perlu dibuat lebih mahal
  agar peminjam terdorong mengembalikan tepat waktu. Rumus ini mudah dijelaskan dan mudah dibuktikan memenuhi syarat:
  suku `flat(h)` sudah menjamin hasil tidak pernah lebih murah dari flat, dan kedua suku tidak pernah turun saat `h` naik.
  Multiplier jenis aset (Ruang 1x, Laptop 2x, AlatLab 4x) dan tarif varian ikut terhitung otomatis
  karena rumus memakai `aset.hitungDenda`.
- Dampak ke kode: `DendaProgresif.hitung`. Konstanta `HARI_RINGAN = 7`. Hari negatif ditolak
  (`IllegalArgumentException`) oleh `Aset.hitungDenda` di dalam perhitungan `flat`.
- Contoh (varian saya, tarif dasar Rp5.000/hari): Ruang 10 hari: flat Rp50.000, progresif Rp65.000.
  Laptop 10 hari: flat Rp100.000, progresif Rp130.000. Ruang 30 hari: flat Rp150.000, progresif Rp265.000.
- Tes yang membuktikan: `Minggu05AbstraksiTest.dendaProgresifMemenuhiSyaratMinimal` (tes dosen, syarat minimal).
  Tes buatan sendiri di folder `mahasiswa/` belum ditulis.

## A-09: perhitungan dasar denda dipindah ke metode terlindung (minggu 5)
- Pertanyaan: `Aset.hitungDenda` harus abstrak, tetapi `Ruang`, `Laptop`, dan `AlatLab` sebelumnya memanggil
  `super.hitungDenda(...)`. Bagaimana agar kode tetap dipakai ulang?
- Keputusan: Perhitungan dasar (hari x tarif varian, termasuk penolakan hari negatif) dipindah ke
  `protected final long dendaDasar(int)` di `Aset`. Tiap subclass memanggilnya lalu mengalikan dengan multiplier jenisnya.
- Alasan: Method abstrak tidak punya isi, sehingga `super.hitungDenda(...)` tidak bisa dikompilasi. Dengan
  `dendaDasar`, logika dasar tetap ada di satu tempat (tidak ditulis ulang tiga kali) dan hasil hitungan sama persis dengan minggu 4.
- Dampak ke kode: `Aset.dendaDasar`, `Ruang.hitungDenda`, `Laptop.hitungDenda`, `AlatLab.hitungDenda`.
- Tes yang membuktikan: `Minggu04PolimorfismeTest` (hasil denda tidak berubah) dan
  `Minggu05AbstraksiTest.dendaFlatSamaDenganHitungDendaAset`.