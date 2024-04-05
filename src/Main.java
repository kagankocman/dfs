import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

            Uygulama uygulama = new Uygulama();
            int boyut;
            JFrame frame;
                Scanner scan = new Scanner(System.in);
                System.out.println("Oluşturmak istediğiniz ızgaranın boyut bilgisini giriniz:");
                boyut= scan.nextInt();
                Btn[][] grid = new Btn[boyut+2][boyut+2];
                frame = new JFrame("Problem 2");
                frame.setSize(800,800);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(boyut+2,boyut+2));
                Izgara izgara = new Izgara();
                int[][] matris = izgara.izgaraOlustur(boyut);


                for(int satir = 0; satir < boyut+2; satir++)
                {
                    for(int sutun = 0; sutun< boyut+2; sutun++ )
                    {
                        Btn b = new Btn(satir, sutun);
                        frame.add(b);
                        grid[satir][sutun]=b;
                    }
                }
                for(int i=1;i< boyut+1;i++){
                    for(int j =1; j < boyut+1;j++){
                        if(matris[i-1][j-1] == 0){
                            grid[i][j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\" +
                                    "Masaüstü\\Problem2\\src\\image\\duvar.png"));
                        }
                    }
                }
            for(int i=0;i< grid.length;i++) {
            if (i == 0 || i == boyut+1) {
                for (int j = 0; grid[0].length > j; j++) {
                    grid[i][j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\" +
                            "Masaüstü\\Problem2\\src\\image\\graycolor.png"));
                }
            }
        }
            for(int j=0;j<grid[0].length;j++){
            if(j==0 || j== boyut+1){
                for (Btn[] btns : grid) {
                    btns[j].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                            "Problem2\\src\\image\\graycolor.png"));
                }
            }
        }

        Stack rota;
        Robot robot = new Robot();
        uygulama.setBaslamaZamani(System.currentTimeMillis());
        rota = robot.rotaOlustur(matris);

        while (!rota.isEmpty()) {
            String tut = (String) rota.pop();
            String[] bol = tut.split(",");
            int[] dizi = new int[2];
            dizi[0] = Integer.parseInt(bol[0]);
            dizi[1] = Integer.parseInt(bol[1]);
            grid[dizi[0] + 1][dizi[1] + 1].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                    "Problem2\\src\\image\\robot.png"));
            uygulama.setAdimSayisi(uygulama.getAdimSayisi() + 1);
        }

        grid[1][1].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
                "Problem2\\src\\image\\start.png"));
        grid[grid.length-2][grid.length-2].setIcon(new ImageIcon("C:\\Users\\aslid\\OneDrive\\Masaüstü\\" +
               "Problem2\\src\\image\\finish.png"));
        uygulama.setBitisZamani(System.currentTimeMillis());
        uygulama.setGecenSure((int) (uygulama.getBitisZamani() - uygulama.getBaslamaZamani()));
        uygulama.gecenSureyiGoster();
        uygulama.adimSayisiniGoster();
        frame.setVisible(true);
    }
}

