/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rental1;
import java.util.Scanner;

/**
 *
 * @author tengk
 */

public class Rental {
    int hari;
    int sewa;
    double mobil;
    
    public Rental(int sewa){
        this.sewa = sewa;
        System.out.println("Sewa per hari : " + sewa);
    }
    
    public Rental(int mobil, int hasil){
        this.mobil = mobil;
        this.hari = hari;
        int byr = mobil * hari;
        System.out.println("Sewa per hari : " + byr);
    }
    
    public static void pilihan(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Roda 2 ");
        System.out.println("2. Roda 4 ");
        System.out.println("Silakan  pilih kendaraan : ");
        
        int pilih = input.nextInt();
        switch(pilih){
            case 1 -> Rental.roda2();
            case 2 -> Rental.roda4();
        }

    }
    
    public static void roda2(){
        Scanner input = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("Pilih Jenis Motor");
        System.out.println("============================");
        System.out.println("1. Honda Vario");
        System.out.println("2. Honda Beat");
        System.out.println("3. Yamaha NMAX");
        System.out.println("4. Yamaha Mio");
        System.out.println("Masukkan Pilihan: ");
        
        int pilih1 = input.nextInt();
        switch(pilih1){
            case 1->{
                Rental vario = new Rental(80000);
                vario.tampilroda2();
            }
            
            case 2->{
                Rental beat = new Rental(70000);
                beat.tampilroda2();
            }
            
            case 3->{
                Rental nmax = new Rental(100000);
                nmax.tampilroda2();
            }
            
            case 4->{
                Rental mio = new Rental(100000);
                mio.tampilroda2();
            }
        }
    }
    
    public static void roda4(){
        Scanner input = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("Pilih Jenis Mobil");
        System.out.println("============================");
        System.out.println("1. Avanza");
        System.out.println("2. Xenia");
        System.out.println("3. Jazz");
        System.out.println("4. Yaris");
        System.out.println("Masukkan Pilihan: ");
        
        int pilih2 = input.nextInt();
        switch(pilih2){
            case 1->{
                Rental avanza = new Rental(400000, 1);
                avanza.tampilroda4();
            }
            
            case 2->{
                Rental xenia = new Rental(300000, 1);
                xenia.tampilroda4();
            }
            
            case 3->{
                Rental jazz = new Rental(350000, 1);
                jazz.tampilroda4();
            }
            
            case 4->{
                Rental yaris = new Rental(100000, 1);
                yaris.tampilroda4();
            }
        }
    }
    
    void tampilroda2(){
        int jumlahHariR2;
        Scanner input = new Scanner(System.in);
        System.out.println("Lama Sewa: ");
        int jmhari = input.nextInt();
        jumlahHariR2 = jmhari * sewa;
        System.out.println("Anda memilih motor");
        System.out.println("Dengan harga sewa: " + jumlahHariR2);

    }
    
    void tampilroda4(){
        int jumlahHariR4;
        Scanner input = new Scanner(System.in);
        System.out.println("Lama Sewa: ");
        int jmhari = input.nextInt();
        jumlahHariR4 = jmhari * sewa;
        System.out.println("Anda memilih motor");
        System.out.println("Dengan harga sewa: " + jumlahHariR4);

    }
}
