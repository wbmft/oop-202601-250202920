package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresifnya KEPUTUSAN ANDA (catat di docs/asumsi.md). Syarat minimal yang diuji:
 * 0 hari = 0; tidak pernah lebih murah dari DendaFlat; tidak pernah turun saat hari bertambah.
 *
 * <p>Rumus yang dipakai: 7 hari pertama dihitung flat, setiap hari setelah hari ke-7
 * dikenai tarif dua kali lipat (flat ditambah flat untuk hari lebihnya).
 * Contoh: hari ke-10 = flat(10) + flat(3).
 */
public class DendaProgresif implements AturanDenda {

    /** Jumlah hari pertama yang masih dihitung flat. */
    private static final int HARI_RINGAN = 7;

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        long flat = aset.hitungDenda(hariTerlambat); // hari negatif ditolak di sini
        long tambahan = aset.hitungDenda(Math.max(0, hariTerlambat - HARI_RINGAN));
        return flat + tambahan;
    }
}