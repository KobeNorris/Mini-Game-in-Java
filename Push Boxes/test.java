public class test{
    public static void main(String[] args){
        MyTest mt = new MyTest();
        mt.validMoveRight();
        for(int i = 0; i < mt.y; i++){
            for(int j = 0; j < mt.x; j++)
                System.out.print(mt.mj.mm[i][j]);
            System.out.println();
        }
    }
}

class Ha{
    int[][] mm = {
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,3,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0}
    };
}

class MyTest{
    int x = 5;
    int y = 5;
    Ha mj = new Ha();

    public void validMoveRight(){
        search:
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
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j][i + 2] == 0){
                                mj.mm[j][i + 2] = 1;
                            } else if(mj.mm[j][i + 2] == 2){
                                mj.mm[j][i + 2] = 5;
                            }
                        }
                    }
                    break search;
                } else if(mj.mm[j][i] == 4){
                    if(i == mj.mm[0].length -2){
                        if(mj.mm[j][i + 1] == 0){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i + 1] == 2){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 2;
                        }
                    } else if(i <= mj.mm[0].length -3){
                        if(mj.mm[j][i + 1] == 0){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i + 1] == 2){
                            mj.mm[j][i + 1] = 4;
                            mj.mm[j][i] = 2;
                        } else if(mj.mm[j][i + 1] == 1 && mj.mm[j][i + 2] != 1){
                            mj.mm[j][i + 1] = 3;
                            mj.mm[j][i] = 2;
                            if(mj.mm[j][i + 2] == 0){
                                mj.mm[j][i + 2] = 1;
                            } else if(mj.mm[j][i + 2] == 2){
                                mj.mm[j][i + 2] = 5;
                            }
                        }
                    }
                    break search;
                }
            }
        }
    }

}