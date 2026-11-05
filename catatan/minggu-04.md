# Catatan Minggu 04: Polymorphism

## Yang saya kerjakan

Pada minggu keempat, saya mempelajari dan menerapkan konsep polymorphism dalam Java, khususnya overriding, overloading, dan dynamic binding. Saya menerapkannya pada method `hitungDenda()` di class Aset beserta tiga turunannya, yaitu Ruang, Laptop, dan AlatLab. Selain itu, saya juga membuat dua bentuk method `cari()` pada KatalogAset, yaitu pencarian berdasarkan nama aset saja dan pencarian berdasarkan nama sekaligus jenis aset.

## Keputusan desain

- Perhitungan denda dasar dan pengecekan jumlah hari peminjaman saya tempatkan di class Aset agar tidak perlu menulis ulang bagian yang sama di setiap subclass.
- Setiap jenis aset memiliki pengali denda yang berbeda. Ruang menggunakan pengali 1, Laptop 2, dan AlatLab 4. Tarif denda tetap mengambil nilai dari Varian.
- Method `hitungDenda()` pada Ruang, Laptop, dan AlatLab menggunakan overriding agar setiap jenis aset dapat memiliki perhitungan denda masing-masing.
- Pencarian aset dibuat tidak membedakan huruf besar dan kecil agar lebih mudah digunakan. Untuk pencarian berdasarkan jenis, hasil pencarian nama terlebih dahulu disaring sesuai jenis aset yang dipilih.
- Input pencarian yang bernilai null ditolak agar kesalahan dapat diketahui sejak awal.

## Kendala

Saya sempat mengalami kesulitan dalam memahami perbedaan overriding dan overloading karena keduanya menggunakan nama method yang sama. Saya juga perlu memahami bagaimana dynamic binding bekerja ketika variabel bertipe Aset menyimpan objek dari subclass. Untuk mengatasinya, saya mempelajari kembali materi polymorphism dan melihat penerapannya pada kode yang dibuat. Setelah menjalankan pengujian, hasilnya menunjukkan `BUILD SUKSES`.

## Penggunaan AI

- `Alat yang dipakai`: Claude.
- `Bagian yang dibantu AI`: Pembuatan dan penjelasan kode pada class Aset, Ruang, Laptop, AlatLab, dan KatalogAset, khususnya pada method `hitungDenda()` dan `cari()`.
- Prompt utama:
  1. "Berikan penjelasan materi minggu 04 tentang polymorphism beserta penerapannya pada tugas Aset-Pinjam."
  2. "Bantu saya menerapkan overriding, overloading, dan dynamic binding sesuai ketentuan tugas minggu 04."
- `Yang saya ubah atau tolak dari saran AI, dan alasannya`: Saya tidak menambahkan perubahan atau klaim yang belum saya pahami. Saya tetap menyesuaikan kode dengan ketentuan tugas dari dosen.
- `Satu hal yang saya pahami lebih baik sekarang`: Overriding digunakan ketika subclass memiliki method dengan nama dan parameter yang sama seperti class induknya, sedangkan overloading menggunakan nama method yang sama dengan parameter berbeda. Saya juga memahami bahwa dynamic binding memungkinkan Java menjalankan method sesuai objek sebenarnya, meskipun variabelnya menggunakan tipe class induk.