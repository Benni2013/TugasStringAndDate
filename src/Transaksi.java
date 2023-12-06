import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi extends Barang implements TotalBayar{

    private String namaPelanggan;
    private String nomorHp;
    private String alamat;
    private Integer jumlahBeli;
    private Date waktuSekarang = new Date(); //deklarasi variabel bertipe Date
    private String kasir;

    public Transaksi(String namaPelanggan, String nomorHp, String alamat, String kodeBarang, String namaBarang, Double hargaBarang, Integer jumlahBeli, String kasir) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.namaPelanggan = namaPelanggan;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
        this.jumlahBeli = jumlahBeli;
        this.kasir = kasir;
    }

    public Double hitungTotalBayar(Double harga, Integer jumlah) {
        return harga * jumlah;
    }

    //method untuk mendapatkan data tanggal
    public String getTanggal(Date waktuSekarang) {
        SimpleDateFormat tgl = new SimpleDateFormat("E, dd/MM/yyyy");
        String tanggal = tgl.format(waktuSekarang);
        return tanggal;
    }

    //method untuk mendapatkan data jam
    public String getJam(Date waktuSekarang) {
        SimpleDateFormat jam = new SimpleDateFormat("HH:mm:ss zzz");
        String waktu = jam.format(waktuSekarang);
        return waktu;
    }

    //method untuk menampilkan struk transaksi
    public void tampilkanTransaksi() {
        System.out.println("\tBenni's Market");
        System.out.println("Tanggal : " + getTanggal(waktuSekarang));
        System.out.println("Waktu\t: " + getJam(waktuSekarang));
        System.out.println("=========================");
        System.out.println("DATA PELANGGAN");
        System.out.println("--------------");
        System.out.println("Nama Pelanggan\t: " + namaPelanggan);
        System.out.println("No. HP\t\t: " + nomorHp);
        System.out.println("Alamat\t\t: " + alamat);
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("DATA PEMBELIAN BARANG");
        System.out.println("---------------------");
        System.out.println("Kode Barang\t: " + getKodeBarang());
        System.out.println("Nama Barang\t: " + getNamaBarang());
        System.out.println("Harga Barang\t: " + getHargaBarang());
        System.out.println("Jumlah Beli\t: " + jumlahBeli);
        System.out.println("TOTAL BAYAR\t: " + hitungTotalBayar(getHargaBarang(), jumlahBeli));
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("Kasir\t: " + kasir + "\n");

    }
     
}
