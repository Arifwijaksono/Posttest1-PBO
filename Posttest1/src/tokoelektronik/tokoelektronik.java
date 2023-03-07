package tokoelektronik;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class tokoelektronik {
    private final String kodeBrg = "Brg";
    private long noKodeBrg;
    protected String namaBrg;
    public int stokAwal,stokMasuk,stokKeluar,hargaBeli,hargaJual;
    
    tokoelektronik(String namaBrg, int stokAwal, int stokMasuk, int stokKeluar, int hargaBeli, int hargaJual, long noKodeBrg){
        this.namaBrg = namaBrg;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stokAwal = stokAwal;
        this.stokMasuk = stokMasuk;
        this.stokKeluar = stokKeluar;
    
    }
    
    tokoelektronik() {
        //UNTUK MENGATASI EROR DI MAIN
    }
     public String getKodeBrg() {
        return kodeBrg;
    }
     public long getNoKodeBrg(){
         return noKodeBrg;
     }
    public String getNamaBrg() {
        return namaBrg;
    }

    public int getStokAwal() {
        return stokAwal;
    }
    public int getStokMasuk() {
        return stokMasuk;
    }
    public int getStokKeluar() {
        return stokKeluar;
    }

    
    public int getHargaBeli() {
        return hargaBeli;
    }
    public int getHargaJual() {
        return hargaJual;
    }

    public tokoelektronik getBrg() {
        return Brg;
    }

    public ArrayList<tokoelektronik> getBrgList() {
        return BrgList;
    }

    public Scanner getInp() {
        return inp;
    }

    public Scanner getInputInt() {
        return inputInt;
    }
    
    tokoelektronik Brg;
    ArrayList<tokoelektronik> BrgList = new ArrayList<>();
    InputStreamReader isr = new InputStreamReader (System.in);
    BufferedReader br = new BufferedReader(isr);
    Scanner inp = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    protected void tambahBarang () throws IOException{
        boolean ulang=true;
        System.out.println("\nMenambahkan Barang Elektronik\n");
        System.out.print("Nama Alat Elektronik : ");
        namaBrg = inp.nextLine();
        System.out.print("Stok Awal  : ");
        stokAwal = Integer.parseInt(br.readLine());
        System.out.print("Stok Masuk  : ");
        stokMasuk = Integer.parseInt(br.readLine());
        System.out.print("Stok Keluar  : ");
        stokKeluar = Integer.parseInt(br.readLine());

        while(ulang){
            System.out.print("Harga Beli Barang : ");
            String strHargaBeli=inp.nextLine();
            System.out.print("Harga Jual Barang : ");
            String strHargaJual=inp.nextLine();
            if (strHargaJual.equals("0")){
                System.err.println("Data Ini Tidak Boleh Bernilai 0");
            }else if(strHargaBeli.equals("0")){
                System.err.println("Data Ini Tidak Boleh Bernilai 0");
            }
            else{
                try{
                    hargaBeli = (Integer.parseInt(strHargaBeli));
                    hargaJual = (Integer.parseInt(strHargaJual));
                    noKodeBrg++;
                    System.out.println ("No Kode Brang : " + kodeBrg + noKodeBrg);
                    Brg = new tokoelektronik(namaBrg,stokAwal, stokMasuk, stokKeluar, hargaBeli, hargaJual, noKodeBrg); // OBJEK ke - 1
                    BrgList.add(Brg);
                    System.out.println("\n>> Tambah Data Barang Elektronik Berhasil <<");
                    ulang=false;
                }catch(NumberFormatException e){
                    System.err.println("Data Yang anda masukkan tidak sesuai");
                }
            }
        }
    }
    
    protected void tampilBarang(){
        System.out.println("\nMenampilkan Barang Elektronik \n");
        for (int i=0; i<BrgList.size(); i++){
            System.out.println("Kode Barang : " + kodeBrg + BrgList.get(i).getKodeBrg());
            System.out.println("Nama Barang : " + BrgList.get(i).getNamaBrg());
            System.out.println("Stok Awal : " + BrgList.get(i).getStokAwal());
            System.out.println("Stok Masuk : " + BrgList.get(i).getStokMasuk());
            System.out.println("Stok Keluar : " + BrgList.get(i).getStokKeluar());
            System.out.println("Stok Akhir : " + (BrgList.get(i).getStokAwal()+BrgList.get(i).getStokMasuk()-BrgList.get(i).getStokKeluar()));
            System.out.println("Harga Beli Barang : Rp" + BrgList.get(i).hargaBeli);
            System.out.println("Harga Jual Barang : Rp" + BrgList.get(i).hargaJual);
            System.out.println(" ");
        }
    }
    
    public ArrayList<tokoelektronik> ubahBarang(ArrayList<tokoelektronik> Brglist) {
        int ubah;
        System.out.println("\nMengubah Data Barang Elektronik\n");
        for (int i=0; i<BrgList.size(); i++){
            System.out.println("No Kode Barang : " + kodeBrg +
            BrgList.get(i).getKodeBrg());
            System.out.println("Nama Peralatan : " + BrgList.get(i).getNamaBrg());
            System.out.println(" ");
        }
        if (BrgList.size() == 1){
            ubah = 0;
        } else {
            System.out.print("\nInput No Kode untuk Mengubah Data [Input Angka Saja] : ");
            ubah = inputInt.nextInt();
            ubah--;
        }
        
        System.out.print("\nUbah Nama Barang : ");
        BrgList.get(ubah).namaBrg = (inp.nextLine());
        System.out.print("Ubah Stok Awal : ");
        BrgList.get(ubah).stokAwal = inputInt.nextInt();
        System.out.print("Ubah Stok Masuk : ");
        BrgList.get(ubah).stokMasuk = inputInt.nextInt();
         System.out.print("Ubah Stok Keluar : ");
        BrgList.get(ubah).stokKeluar = inputInt.nextInt();
        System.out.print("Ubah Harga Beli Barang : ");
        BrgList.get(ubah).hargaBeli = inputInt.nextInt();
        System.out.print("Ubah Harga Jual Barang : ");
        BrgList.get(ubah).hargaJual = inputInt.nextInt();
        System.out.println("\n>> Data Barang Elektronik Berhasil Di Ubah <<\n");

        return BrgList;
    }
    
    public void hapusBarang() {
        System.out.println("\nMenghapus Barang Elektronik\n");
        for (int i=0; i<BrgList.size(); i++){
            System.out.println("No Kode Barang : " + kodeBrg +
            BrgList.get(i). getNoKodeBrg ());
            System.out.println("Nama Barang : " + BrgList.get(i).getNamaBrg());
            System.out.println(" ");
        }
        int hapus;
        System.out.print("\nMasukan No Kode untuk Hapus Barang [Input Angka Belakang] : ");
        hapus = inputInt.nextInt();
        hapus--;
        BrgList.remove(hapus);
        System.out.println("\n>> Barang Elektronik Berhasil di Hapus <<\n");
    }


    
    
}
