package sokoban;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Program implements ActionListener {
    public static String graf = "grafika1";
    private int grafuse=0;

    private int x;
    private int y;
    private int[][] tablica;
    private int[][] tablica2;
    private Opcje op;
    private FSok sok;
    private String txt;
    private Grafika grafika;

    public Program(){
        opcje();
    }
    private void maps(String txt) throws FileNotFoundException{
        int x=0,y=0,xx=0;
        File plik=new File(txt);
        Scanner odczyt =new Scanner(new BufferedReader(new FileReader(plik)));
        String s="";
        while(odczyt.hasNextLine()){
            s = odczyt.nextLine();
            x++;
        }
        y=s.length();
        int [][] tab = new int[x][y];
        int [][] tab2 = new int[x][y];
        odczyt =new Scanner(new BufferedReader(new FileReader(plik)));
        while(odczyt.hasNextLine()){
            s = odczyt.nextLine();
            for(int z=0;z<y;z++){
                int temp = Integer.parseInt(s.substring(z,z+1));
                tab[xx][z]=temp;
                tab2[xx][z]=temp;
            }
            xx++;
        }
        odczyt.close();
        this.x=x;
        this.y=y;
        tablica=tab;
        tablica2=tab2;
    }
    private void opcje(){
        op = new Opcje();
        op.getmap1().addActionListener(this);
        op.getmap2().addActionListener(this);
        op.getmap3().addActionListener(this);
        op.getmap4().addActionListener(this);
        op.getmap5().addActionListener(this);
        op.getmap6().addActionListener(this);
        op.getmap7().addActionListener(this);
        op.getmap8().addActionListener(this);
        op.getmap9().addActionListener(this);
        op.getgraf().addActionListener(this);
    }
    private void start(){
        try {
            maps(txt);
            op.setVisible(false);
            sok = new FSok(tablica,x,y);
            sok.addKeyListener(new AdapterQ());
            new Game(sok,tablica2);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == op.getmap1()){
            txt="src/maps/mapa1.txt";
            start();
        }
        if (e.getSource() == op.getmap2()){
            txt="src/maps/mapa2.txt";
            start();
        }
        if (e.getSource() == op.getmap3()){
            txt="src/maps/mapa3.txt";
            start();
        }
        if (e.getSource() == op.getmap4()){
            txt="src/maps/mapa4.txt";
            start();
        }
        if (e.getSource() == op.getmap5()){
            txt="src/maps/mapa5.txt";
            start();
        }
        if (e.getSource() == op.getmap6()){
            txt="src/maps/mapa6.txt";
            start();
        }
        if (e.getSource() == op.getmap7()){
            txt="src/maps/mapa7.txt";
            start();
        }
        if (e.getSource() == op.getmap8()){
            txt="src/maps/mapa8.txt";
            start();
        }
        if (e.getSource() == op.getmap9()){
            txt="src/maps/mapa9.txt";
            start();
        }
        if(e.getSource() == op.getgraf()){
            op.dispose();
            grafika = new Grafika();
            grafuse=1;
            grafika.getgraf1().addActionListener(this);
            grafika.getgraf2().addActionListener(this);
        }
        if(grafuse == 1){
            if(e.getSource() == grafika.getgraf1()){
                graf = "grafika1";
                grafuse=0;
                grafika.dispose();
                opcje();
            }
            if(e.getSource() == grafika.getgraf2()){
                graf = "grafika2";
                grafuse=0;
                grafika.dispose();
                opcje();
            }
        }
    }
    private class AdapterQ extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_Q){
                sok.dispose();
                op.setVisible(true);
            }
        }
    }
}