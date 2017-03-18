package sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game implements ActionListener {

    private FSok sok;
    private int robotx;
    private int roboty;
    private int liczend;
    private int end=0;
    private int ir=0;

    private int[][] tab;
    //0 puste pola
    //1 sciany
    //2 podloga
    //3 pola endu
    //4 skrzynki
    //5 robot

    public Game(FSok sokoban, int[][] tablica){
        sok=sokoban;
        robotx=sok.getrobot().get_x();
        roboty=sok.getrobot().get_y();
        tab=tablica;
        tab[robotx][roboty]=2;
        liczend=0;

        sok.addKeyListener(new Adapter());
        sok.getUpButton().addActionListener(this);
        sok.getDownButton().addActionListener(this);
        sok.getLeftButton().addActionListener(this);
        sok.getRightButton().addActionListener(this);
    }

    private int jakibox(int x, int y){
        int ret=-1;
        for(int z=0;z<sok.getliczbox();z++){
            if(sok.getbox(z).get_x()==x && sok.getbox(z).get_y()==y){
                ret=z;
                break;
            }
        }
        return ret;
    }
    private void endgame(){
        if(liczend==sok.getliczendfloor()){
            end=1;
            sok.setWin();
        }
    }

    private void up(){
        if(tab[robotx-1][roboty]==2 || tab[robotx-1][roboty]==3){
            robotup();
        }else{
            if(tab[robotx-1][roboty]==4){
                if(tab[robotx-2][roboty]==2 /*|| tab[robotx-2][roboty]==3*/){
                    int box=jakibox(robotx-1,roboty);
                    if(sok.getmapelement(robotx-1,roboty)==3){liczend--;}
                    tab[robotx-2][roboty]=4;
                    tab[robotx-1][roboty]=2;
                    robotup();
                    boxup(box);
                }else{
                    if(tab[robotx-2][roboty]==3){
                        if(sok.getmapelement(robotx-1,roboty)==2){
                            liczend++;
                            int box=jakibox(robotx-1,roboty);
                            tab[robotx-2][roboty]=4;
                            tab[robotx-1][roboty]=2;
                            robotup();
                            boxup(box);
                        }else{
                            int box=jakibox(robotx-1,roboty);
                            tab[robotx-2][roboty]=4;
                            tab[robotx-1][roboty]=3;
                            robotup();
                            boxup(box);
                        }
                    }
                }
            }
        }
    }
    private void down(){
        if(tab[robotx+1][roboty]==2 || tab[robotx+1][roboty]==3){
            robotdown();
        }else{
            if(tab[robotx+1][roboty]==4){
                if(tab[robotx+2][roboty]==2 /*|| tab[robotx-2][roboty]==3*/){
                    int box=jakibox(robotx+1,roboty);
                    if(sok.getmapelement(robotx+1,roboty)==3){liczend--;}
                    tab[robotx+2][roboty]=4;
                    tab[robotx+1][roboty]=2;
                    robotdown();
                    boxdown(box);
                }else{
                    if(tab[robotx+2][roboty]==3){
                        if(sok.getmapelement(robotx+1,roboty)==2){
                            liczend++;
                            int box=jakibox(robotx+1,roboty);
                            tab[robotx+2][roboty]=4;
                            tab[robotx+1][roboty]=2;
                            robotdown();
                            boxdown(box);
                        }else{
                            int box=jakibox(robotx+1,roboty);
                            tab[robotx+2][roboty]=4;
                            tab[robotx+1][roboty]=3;
                            robotdown();
                            boxdown(box);
                        }
                    }
                }
            }
        }
    }
    private void left(){
        if(tab[robotx][roboty-1]==2 || tab[robotx][roboty-1]==3){
            robotleft();
        }else{
            if(tab[robotx][roboty-1]==4){
                if(tab[robotx][roboty-2]==2 /*|| tab[robotx-2][roboty]==3*/){
                    int box=jakibox(robotx,roboty-1);
                    if(sok.getmapelement(robotx,roboty-1)==3){liczend--;}
                    tab[robotx][roboty-2]=4;
                    tab[robotx][roboty-1]=2;
                    robotleft();
                    boxleft(box);
                }else{
                    if(tab[robotx][roboty-2]==3){
                        if(sok.getmapelement(robotx,roboty-1)==2){
                            liczend++;
                            int box=jakibox(robotx,roboty-1);
                            tab[robotx][roboty-2]=4;
                            tab[robotx][roboty-1]=2;
                            robotleft();
                            boxleft(box);
                        }else{
                            int box=jakibox(robotx,roboty-1);
                            tab[robotx][roboty-2]=4;
                            tab[robotx][roboty-1]=3;
                            robotleft();
                            boxleft(box);
                        }
                    }
                }
            }
        }
    }
    private void right(){
        if(tab[robotx][roboty+1]==2 || tab[robotx][roboty+1]==3){
            robotright();
        }else{
            if(tab[robotx][roboty+1]==4){
                if(tab[robotx][roboty+2]==2 /*|| tab[robotx-2][roboty]==3*/){
                    int box=jakibox(robotx,roboty+1);
                    if(sok.getmapelement(robotx,roboty+1)==3){liczend--;}
                    tab[robotx][roboty+2]=4;
                    tab[robotx][roboty+1]=2;
                    robotright();
                    boxright(box);
                }else{
                    if(tab[robotx][roboty+2]==3){
                        if(sok.getmapelement(robotx,roboty+1)==2){
                            liczend++;
                            int box=jakibox(robotx,roboty+1);
                            tab[robotx][roboty+2]=4;
                            tab[robotx][roboty+1]=2;
                            robotright();
                            boxright(box);
                        }else{
                            int box=jakibox(robotx,roboty+1);
                            tab[robotx][roboty+2]=4;
                            tab[robotx][roboty+1]=3;
                            robotright();
                            boxright(box);
                        }
                    }
                }
            }
        }
    }

    private void robotup(){
        robotx--;
        sok.getrobot().up();
        ir++;
    }
    private void robotdown(){
        robotx++;
        sok.getrobot().down();
        ir++;
    }
    private void robotleft(){
        roboty--;
        sok.getrobot().left();
        ir++;
    }
    private void robotright(){
        roboty++;
        sok.getrobot().right();
        ir++;
    }

    private void boxup(int b){
        sok.getbox(b).up();
    }
    private void boxdown(int b){
        sok.getbox(b).down();
    }
    private void boxleft(int b){
        sok.getbox(b).left();
    }
    private void boxright(int b){
        sok.getbox(b).right();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(end==0){
            if (e.getSource() == sok.getUpButton()){
                up();
            }
            if (e.getSource() == sok.getDownButton()){
                down();
            }
            if (e.getSource() == sok.getLeftButton()){
                left();
            }
            if (e.getSource() == sok.getRightButton()){
                right();
            }
        }
        endgame();
        sok.setIloscRuchow(ir);
    }

    private class Adapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(end==0){
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    up();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    down();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    left();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    right();
                }
            }
            endgame();
            sok.setIloscRuchow(ir);
        }
    }

}
