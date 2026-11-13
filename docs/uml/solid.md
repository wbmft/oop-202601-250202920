# Prinsip SOLID pada Aset-Pinjam

## 1. Open/Closed Principle (OCP): AturanDenda, DendaFlat, DendaProgresif

Interface `AturanDenda` mendefinisikan satu cara menghitung denda. `DendaFlat` dan
`DendaProgresif` mengimplementasikannya. Jika kelak ada aturan baru (misalnya denda
mingguan), cukup menambah kelas baru yang mengimplementasikan `AturanDenda`, tanpa
mengubah kelas yang sudah ada. Kelas terbuka untuk ekstensi tetapi tertutup untuk
modifikasi. Hal serupa terlihat pada hierarki `Aset`: `Ruang`, `Laptop`, dan `AlatLab`
masing-masing meng-override `hitungDenda`, sehingga jenis aset baru tidak mengubah kode
jenis lain.

## 2. Dependency Inversion Principle (DIP): LayananDenda dan AturanDenda

`LayananDenda` tidak membuat `DendaFlat` atau `DendaProgresif` sendiri. Ia menerima
`AturanDenda` lewat konstruktor, sehingga bergantung pada abstraksi, bukan implementasi
konkret. Akibatnya `LayananDenda` mudah diuji dengan strategi tiruan, misalnya lambda
yang selalu mengembalikan nilai tetap. Pola yang sama dipakai `JdbcPeminjamanDAO` yang
menerima `AsetDAO` (interface), bukan `JdbcAsetDAO`.

## 3. Single Responsibility Principle (SRP): pemisahan tanggung jawab

`JadwalPeminjaman` hanya mengurus aturan jadwal (bentrok dan kuota), `KatalogAset`
hanya mengurus pencarian aset, dan `Peminjaman` hanya mengurus data serta status
peminjaman. Akses database dipisah ke DAO sehingga perubahan SQL tidak menyentuh
logika bisnis.