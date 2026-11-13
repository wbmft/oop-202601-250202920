# Catatan Minggu 06: UML dan SOLID

## Yang saya kerjakan
Saya membuat Class Diagram dari kode core (atribut, method, tipe, visibility, relasi, multiplicity,
dan paket), Sequence Diagram pengajuan peminjaman dengan fragmen `alt` untuk skenario sukses dan
bentrok, serta `solid.md` yang menjelaskan prinsip OCP, DIP, dan SRP pada kode saya.

## Keputusan desain
- Relasi `JadwalPeminjaman` ke `Peminjaman` saya gambar sebagai agregasi karena peminjaman tetap
  ada walau dihapus dari jadwal.
- `LayananDenda` ke `AturanDenda` saya gambar sebagai agregasi karena aturan disuntikkan dari luar.
- Sequence Diagram saya ambil dari alur `JadwalPeminjaman.ajukan` agar sesuai dengan kode.
- Prinsip SOLID yang saya pilih: OCP, DIP, dan SRP (lihat docs/uml/solid.md).

## Kendala
- [Isi kendala nyata Anda, misalnya: bingung membedakan agregasi dan komposisi, atau cara render PlantUML.]
- [Cara Anda mengatasinya.]

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: draf kode PlantUML Class Diagram dan Sequence Diagram, serta draf solid.md
- Prompt utama:
  1. "Bantu saya kerjakan week 6 sesuai docs/minggu-06.md ... jelaskan konsep dan file yang perlu di-push."
- Yang saya ubah atau tolak dari saran AI, dan alasannya: [isi, misalnya: saya mencocokkan diagram dengan kode asli, dan menulis ulang solid.md dengan kata-kata sendiri]
- Satu hal yang saya pahami lebih baik sekarang: [isi dengan pemahaman Anda sendiri]