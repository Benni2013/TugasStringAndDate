import java.util.InputMismatchException;
import java.util.Scanner;

public class App {    
    public static void main(String[] args) {
        //membuat scanner
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerDou = new Scanner(System.in);

        //INPUT DATA
        System.out.print("\nInput Nama Kasir: ");
        String kasir = scannerStr.nextLine();

        System.out.println("--------------------------");
        System.out.println("INPUT DATA PELANGGAN");
        
        System.out.print("Input Nama Pelanggan: ");
        String namaPelanggan = scannerStr.nextLine();

        System.out.print("Input No. HP: ");
        String nomorHp = scannerStr.nextLine();

        System.out.print("Input Alamat: ");
        String alamat = scannerStr.nextLine();

        System.out.println("--------------------------");
        System.out.println("INPUT DATA BARANG");

        System.out.print("Input Kode Barang: ");
        String kodeBarang = scannerStr.nextLine();

        System.out.print("Input Nama Barang: ");
        String namaBarang = scannerStr.nextLine();

        //input harga barang + exception handling jika harga barang tidak valid
        Boolean inputHargaValid = true;
        Double hargaBarang = 0.0;
        while (inputHargaValid) {
            try {
                System.out.print("Input Harga Barang: ");
                hargaBarang = scannerDou.nextDouble();
                if (hargaBarang < 0) {
                    throw new ArithmeticException("Harga barang tidak boleh minus.");
                }
                inputHargaValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harga barang tidak valid. Silakan coba lagi.");
                scannerDou.next(); 
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        //input jumlah beli + exception handling jika jumlah beli tidak valid
        Boolean inputJumlahValid = true;
        Integer jumlahBeli = 0;
        while (inputJumlahValid) {
            try {
                System.out.print("Input Jumlah Beli: ");
                jumlahBeli = scannerInt.nextInt();
                if (jumlahBeli <= 0) {
                    throw new ArithmeticException("Jumlah barang harus lebih dari 0.");
                }
                inputJumlahValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Input jumlah barang tidak valid. Silakan coba lagi.");
                scannerInt.next();
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("--------------------------\n");

        //membuat objek transaksi bertipe Barang (polimorphysme)
        Barang transaksi = new Transaksi(namaPelanggan, nomorHp, alamat, kodeBarang, namaBarang, hargaBarang, jumlahBeli, kasir);
        
        /* menampilkan detail transaksi dengan melakukan downcasting terlebih dahulu 
        agar dapat menggunakan method tampilkanTransaksi() */
        ((Transaksi) transaksi).tampilkanTransaksi(); //polimorphysme
        
        //tutup scanner
        scannerStr.close();
        scannerInt.close();
        scannerDou.close();
    }
    
}
