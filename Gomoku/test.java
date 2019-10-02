
public class test{
    public static void main(String[] args){
        int map [][] = {
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        int x = 3, y = 3;
        isWin(x, y, map);
    }

    protected static void isWin(int x, int y, int[][] map){
        int count = 0;
        int flag = 0;

        for(int i = y - 4, j = x; i < y + 5; i++) {//Vertical line
            System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(i < 0 || i > 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                System.out.println("Yes1 " + count);
                if(count >= 5){
                    flag = 1;
                    break;
                }
            }
        }
        count = 0;
        System.out.println();

        for(int i = y, j = x - 4; j < x + 5; j++) {//Horizontal line
            System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(flag == 1)
                break;
            else if(j < 0 || j > 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                System.out.println("Yes2 " + count);
                if(count >= 5){
                    flag = 1;
                    break;
                }
            }
        }
        count = 0;
        System.out.println();

        for(int i = y - 4, j = x + 4; j > x - 5; j--, i++) {//Leftup 2 rightbutt line :)
            System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(flag == 1)
                break;
            else if(i < 0 || i > 15 || j < 0 || j > 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                System.out.println("Yes3 " + count);
                if(count >= 5){
                    flag = 1;
                    break;
                }
            }
        }
        count = 0;
        System.out.println();

        for(int i = y + 4, j = x + 4; j > x - 5; j--, i--) {//Leftbutt 2 rightup line :)
            System.out.print("(" + i + "," + j + ")--(" + x + "," + y + ")");

            if(flag == 1)
                break;
            else if(i < 0 || i > 15 || j < 0 || j > 15){
                count = 0;
                continue;
            }else if(map[i][j] != map[y][x]){
                count = 0;
                continue;
            }else{
                count++;
                System.out.println("Yes4 " + count);
                if(count >= 5){
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 1){
            System.out.println("Wins");
        }else{
            System.out.println("lose");
        }
    }
}