import java.util.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.*;

import javax.swing.*;
import javax.swing.event.*;

public class MyKeyBoardEvent extends KeyAdapter {
    int count = 0;
    // int[][] mm;
    GameMap mj;

    MyKeyBoardEvent(GameMap mj) {
        super();
        this.mj = mj;
        // this.mm = mj.mm;
    }

    @Override
    public void keyPressed(KeyEvent k) {
        //System.out.println("Keyboard in");
        super.keyPressed(k);
        if (k.getKeyChar() == 'w') {
            count++;
            // System.out.println("Keyboard in w");
            validMoveUp();
            mj.repaint();
            isWin();
        } else if (k.getKeyChar() == 'a') {
            count++;
            // System.out.println("Keyboard in a");
            validMoveLeft();
            mj.repaint();
            isWin();
        } else if (k.getKeyChar() == 's') {
            count++;
            // System.out.println("Keyboard in s");
            validMoveDown();
            mj.repaint();
            isWin();
        } else if (k.getKeyChar() == 'd') {
            count++;
            // System.out.println("Keyboard in d");
            validMoveRight();
            mj.repaint();
            isWin();
        } else if (k.getKeyChar() == 'q') {
            isLose();
        }

        return;
    }

    public void validMoveUp() {
        searchUp:
        for (int i = 0; i < mj.mm[0].length; i++) {
            for (int j = 0; j < mj.mm.length; j++) {
                if (mj.mm[j][i] == 3) {
                    if (j == 1) {
                        if (mj.mm[j - 1][i] == 0) {
                            mj.mm[j - 1][i] = 3;
                            mj.mm[j][i] = 0;
                        } else if (mj.mm[j - 1][i] == 2) {
                            mj.mm[j - 1][i] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if (j >= 2) {
                        if (mj.mm[j - 1][i] == 0) {
                            mj.mm[j - 1][i] = 3;
                            mj.mm[j][i] = 0;
                        } else if (mj.mm[j - 1][i] == 2) {
                            mj.mm[j - 1][i] = 4;
                            mj.mm[j][i] = 0;
                        } else if (mj.mm[j - 1][i] == 1 && mj.mm[j - 2][i] != 1) {
                            mj.mm[j - 1][i] = 3;
                            mj.mm[j][i] = 0;
                            if (mj.mm[j - 2][i] == 0) {
                                mj.mm[j - 2][i] = 1;
                            } else if (mj.mm[j - 2][i] == 2) {
                                mj.mm[j - 2][i] = 5;
                            }
                        } else if (mj.mm[j - 1][i] == 5 && mj.mm[j - 2][i] != 1) {
                            mj.mm[j - 1][i] = 4;
                            mj.mm[j][i] = 0;
                            if (mj.mm[j - 2][i] == 0) {
                                mj.mm[j - 2][i] = 1;
                            } else if (mj.mm[j - 2][i] == 2) {
                                mj.mm[j - 2][i] = 5;
                            }
                        }
                    }
                    break searchUp;
                } else if (mj.mm[j][i] == 4) {
                    if (j == 1) {
                        if (mj.mm[j - 1][i] == 0) {
                            mj.mm[j - 1][i] = 3;
                            mj.mm[j][i] = 2;
                        } else if (mj.mm[j - 1][i] == 2) {
                            mj.mm[j - 1][i] = 4;
                            mj.mm[j][i] = 2;
                        }
                    } else if (j >= 2) {
                        if (mj.mm[j - 1][i] == 0) {
                            mj.mm[j - 1][i] = 3;
                            mj.mm[j][i] = 2;
                        } else if (mj.mm[j - 1][i] == 2) {
                            mj.mm[j - 1][i] = 4;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j - 1][i] == 5 && mj.mm[j - 2][i] != 1 && mj.mm[j - 2][i] != 5){
                            mj.mm[j - 1][i] = 4;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j - 2][i] == 0){
                                mj.mm[j - 2][i] = 1;
                            } else if(mj.mm[j - 2][i] == 2){
                                mj.mm[j - 2][i] = 5;
                            }
                        } else if (mj.mm[j - 1][i] == 1 && mj.mm[j - 2][i] != 1) {
                            mj.mm[j - 1][i] = 3;
                            mj.mm[j][i] = 2;
                            if (mj.mm[j - 2][i] == 0) {
                                mj.mm[j - 2][i] = 1;
                            } else if (mj.mm[j - 2][i] == 2) {
                                mj.mm[j - 2][i] = 5;
                            }
                        }
                    }
                    break searchUp;
                }
            }
        }
    }

    public void validMoveLeft(){
        searchLeft:
        for(int i = 0; i < mj.mm[0].length; i++){
            for(int j = 0; j < mj.mm.length; j++){
                if(mj.mm[j][i] == 3){
                    if(i == 1){
                        if(mj.mm[j][i - 1] == 0){
                            mj.mm[j][i - 1] = 3;
                            mj.mm[j][i] = 0;
                        } else if(mj.mm[j][i - 1] == 2){
                            mj.mm[j][i - 1] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if(i >= 2){
                        if(mj.mm[j][i - 1] == 0){
                            mj.mm[j][i - 1] = 3;
                            mj.mm[j][i] = 0;
                        } else if(mj.mm[j][i - 1] == 2){
                            mj.mm[j][i - 1] = 4;
                            mj.mm[j][i] = 0;
                        } else if(mj.mm[j][i - 1] == 1 && mj.mm[j][i - 2] != 1){
                            mj.mm[j][i - 1] = 3;
                            mj.mm[j][i] = 0;
                            if(mj.mm[j][i - 2] == 0){
                                mj.mm[j][i - 2] = 1;
                            } else if(mj.mm[j][i - 2] == 2){
                                mj.mm[j][i - 2] = 5;
                            }
                        } else if(mj.mm[j][i - 1] == 5 && mj.mm[j][i - 2] != 1){
                            mj.mm[j][i - 1] = 4;
                            mj.mm[j][i] = 0;
                            if(mj.mm[j][i - 2] == 0){
                                mj.mm[j][i - 2] = 1;
                            } else if(mj.mm[j][i - 2] == 2){
                                mj.mm[j][i - 2] = 5;
                            }
                        }
                    }
                    break searchLeft;
                } else if(mj.mm[j][i] == 4){
                    if(i == 1){
                        if(mj.mm[j][i - 1] == 0){
                            mj.mm[j][i - 1] = 3;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i - 1] == 2){
                            mj.mm[j][i - 1] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if(i >= 2){
                        if(mj.mm[j][i - 1] == 0){
                            mj.mm[j][i - 1] = 3;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i - 1] == 2){
                            mj.mm[j][i - 1] = 4;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i - 1] == 5 && mj.mm[j][i - 2] != 1 && mj.mm[j][i - 2] != 5){
                            mj.mm[j][i - 1] = 4;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j][i - 2] == 0){
                                mj.mm[j][i - 2] = 1;
                            } else if(mj.mm[j][i - 2] == 2){
                                mj.mm[j][i - 2] = 5;
                            }
                        } else if(mj.mm[j][i - 1] == 1 && mj.mm[j][i - 2] != 1 && mj.mm[j][i - 2] != 5){
                            mj.mm[j][i - 1] = 3;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j][i - 2] == 0){
                                mj.mm[j][i - 2] = 1;
                            } else if(mj.mm[j][i - 2] == 2){
                                mj.mm[j][i - 2] = 5;
                            }
                        }
                    }
                    break searchLeft;
                }
            }
        }
    }

    public void validMoveRight(){
        searchRight:
        for(int i = 0; i < mj.mm[0].length; i++){
            for(int j = 0; j < mj.mm.length; j++){
                if(mj.mm[j][i] == 3){
                    if(i == mj.mm[0].length - 2){
                        if(mj.mm[j][i + 1] == 0){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 0;
                        } else if(mj.mm[j][i + 1] == 2){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if(i <= mj.mm[0].length - 3){
                        if(mj.mm[j][i + 1] == 0){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 0;
                        } else if(mj.mm[j][i + 1] == 2){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 0;
                        } else if(mj.mm[j][i + 1] == 1 && mj.mm[j][i + 2] != 1){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 0;
                            if(mj.mm[j][i + 2] == 0){
                                mj.mm[j][i + 2] = 1;
                            } else if(mj.mm[j][i + 2] == 2){
                                mj.mm[j][i + 2] = 5;
                            }
                        } else if(mj.mm[j][i + 1] == 5 && mj.mm[j][i + 2] != 1){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 0;
                            if(mj.mm[j][i + 2] == 0){
                                mj.mm[j][i + 2] = 1;
                            } else if(mj.mm[j][i + 2] == 2){
                                mj.mm[j][i + 2] = 5;
                            }
                        }
                    }
                    break searchRight;
                } else if(mj.mm[j][i] == 4){
                    if(i == mj.mm[0].length -2){
                        if(mj.mm[j][i + 1] == 0){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i + 1] == 2){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if(i <= mj.mm[0].length -3){
                        if(mj.mm[j][i + 1] == 0){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i + 1] == 2){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i + 1] == 5 && mj.mm[j][i + 2] != 1 && mj.mm[j][i + 2] != 5){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j][i + 2] == 0){
                                mj.mm[j][i + 2] = 1;
                            } else if(mj.mm[j][i + 2] == 2){
                                mj.mm[j][i + 2] = 5;
                            }
                        } else if(mj.mm[j][i + 1] == 1 && mj.mm[j][i + 2] != 1 && mj.mm[j][i + 2] != 5){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j][i + 2] == 0){
                                mj.mm[j][i + 2] = 1;
                            } else if(mj.mm[j][i + 2] == 2){
                                mj.mm[j][i + 2] = 5;
                            }
                        }
                    }
                    break searchRight;
                }
            }
        }
    }

    public void validMoveDown(){
        searchDown:
        for (int i = 0; i < mj.mm[0].length; i++) {
            for (int j = 0; j < mj.mm.length; j++) {
                if (mj.mm[j][i] == 3) {
                    if (j == mj.mm.length - 2) {
                        if (mj.mm[j + 1][i] == 0) {
                            mj.mm[j + 1][i] = 3;
                            mj.mm[j][i] = 0;
                        } else if (mj.mm[j + 1][i] == 2) {
                            mj.mm[j + 1][i] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if (j <= mj.mm.length - 3) {
                        if (mj.mm[j + 1][i] == 0) {
                            mj.mm[j + 1][i] = 3;
                            mj.mm[j][i] = 0;
                        } else if (mj.mm[j + 1][i] == 2) {
                            mj.mm[j + 1][i] = 4;
                            mj.mm[j][i] = 0;
                        } else if (mj.mm[j + 1][i] == 1 && mj.mm[j + 2][i] != 1) {
                            mj.mm[j + 1][i] = 3;
                            mj.mm[j][i] = 0;
                            if (mj.mm[j + 2][i] == 0) {
                                mj.mm[j + 2][i] = 1;
                            } else if (mj.mm[j + 2][i] == 2) {
                                mj.mm[j + 2][i] = 5;
                            }
                        } else if (mj.mm[j + 1][i] == 5 && mj.mm[j + 2][i] != 1) {
                            mj.mm[j + 1][i] = 4;
                            mj.mm[j][i] = 0;
                            if (mj.mm[j + 2][i] == 0) {
                                mj.mm[j + 2][i] = 1;
                            } else if (mj.mm[j + 2][i] == 2) {
                                mj.mm[j + 2][i] = 5;
                            }
                        }
                    }
                    break searchDown;
                } else if (mj.mm[j][i] == 4) {
                    if (j == mj.mm.length - 2) {
                        if (mj.mm[j + 1][i] == 0) {
                            mj.mm[j + 1][i] = 3;
                            mj.mm[j][i] = 2;
                        } else if (mj.mm[j + 1][i] == 2) {
                            mj.mm[j + 1][i] = 4;
                            mj.mm[j][i] = 0;
                        }
                    } else if (j <= mj.mm.length - 3) {
                        if (mj.mm[j + 1][i] == 0) {
                            mj.mm[j + 1][i] = 3;
                            mj.mm[j][i] = 2;
                        } else if (mj.mm[j + 1][i] == 2) {
                            mj.mm[j + 1][i] = 4;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j + 1][i] == 5 && mj.mm[j + 2][i] != 1 && mj.mm[j + 2][i] != 5){
                            mj.mm[j + 1][i] = 4;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j + 2][i] == 0){
                                mj.mm[j + 2][i] = 1;
                            } else if(mj.mm[j + 2][i] == 2){
                                mj.mm[j + 2][i] = 5;
                            }
                        } else if (mj.mm[j + 1][i] == 1 && mj.mm[j + 2][i] != 1 && mj.mm[j + 1][i] != 5) {
                            mj.mm[j + 1][i] = 3;
                            mj.mm[j][i] = 2;
                            if (mj.mm[j + 2][i] == 0) {
                                mj.mm[j + 2][i] = 1;
                            } else if (mj.mm[j + 2][i] == 2) {
                                mj.mm[j + 2][i] = 5;
                            }
                        }
                    }
                    break searchDown;
                }
            }
        }
    }

    public void isWin(){
        int flag = 0;
        searchThrough:
        for(int i = 0; i < mj.mm[0].length; i++){
            for(int j = 0; j < mj.mm.length; j++){
                if(mj.mm[j][i] == 1){
                    flag = 1;
                    break searchThrough;
                }
            }
        }
        mj.showTime.setText("You have used " + count + " steps");
        if(flag == 0){
            System.out.println("You win ! You have spent " + count + " steps.");
            System.exit(0);
        }
    }

    public void isLose(){
        System.out.println("You lose ! You have spent " + count + " steps.");
        System.exit(0);
    }
}