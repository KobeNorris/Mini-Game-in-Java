import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 *
 * @author Ping_QC
 */
public class mineClearance extends JFrame implements ActionListener, Runnable,
    MouseListener {
  // private static final long serialVersionUID = -2417758397965039613L;
  private final int EMPTY     = 0;
  private final int MINE     = 1;
  private final int CHECKED    = 2;
  int MINE_COUNT  = 10;
  // private final int MINE_COUNT  = 10;  // Number of mines
  private final int BUTTON_BORDER = 50;  // Point's size
  int MINE_SIZE = 10;
  // private final int MINE_SIZE   = 10;  // Border boundary, 20x20
  private final int START_X    = 25;  // initial x
  private final int START_Y    = 70;  // initial y
  private boolean flag;
  private JButton[][] jb;
  // private JLabel blankLine;
  private JLabel showTime;
  private int[][] map;

  /**
   * scan the number of mines arround the point
   */
  private int[][] mv = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
      { 1, -1 }, { 0, -1 }, { -1, -1 } };

  /**
   * Randomly generates the number of mines
   */
  public void makeMine() {
    int i = 0, tx, ty;
    for (; i < MINE_COUNT;) {
      tx = (int) (Math.random() * MINE_SIZE);
      ty = (int) (Math.random() * MINE_SIZE);
      if (map[tx][ty] == EMPTY) {
        map[tx][ty] = MINE;
        i++;
      }
    }
  }

  /**
   * Put the buttons onto the array
   */
  public void makeButton() {
    for (int i = 0; i < MINE_SIZE; i++) {
      for (int j = 0; j < MINE_SIZE; j++) {
        jb[i][j] = new JButton();
        // if (map[i][j] == MINE)
        // jb[i][j].setText(i+","+j);
        // listener add
        jb[i][j].addActionListener(this);
        jb[i][j].addMouseListener(this);
        jb[i][j].setName(i + "_" + j);
        // Font font = new Font(Font.SERIF, Font.BOLD, 10);
        // jb[i][j].setFont(font);
        // jb[i][j].setText(i+","+j);
        jb[i][j].setBounds(j * BUTTON_BORDER + START_X, i
            * BUTTON_BORDER + START_Y, BUTTON_BORDER, BUTTON_BORDER);
        this.add(jb[i][j]);
      }
    }
  }

  public void init() {
    flag = false;
    Font mf = new Font("Arial",Font.BOLD, 20);
    showTime.setFont(mf);
    showTime.setText("Spend time: 0 s");
    showTime.setBounds( 20, 20, 300, 30);
    this.add(showTime);

    // mf = new Font("Arial",Font.BOLD, 20);
    // blankLine.setFont(mf);
    // blankLine.setText("-------------------");
    // blankLine.setBounds( 20, 50, 300, 10);
    // this.add(blankLine);

    makeMine();
    makeButton();
    this.setSize((MINE_SIZE + 1) * 50, (MINE_SIZE + 2) * 50 + 30);
    this.setLocation(700, 100);
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public mineClearance(String title) {
    super(title);
    
    Scanner input = new Scanner(System.in);
    System.out.print("Please input the mine number: ");
    this.MINE_COUNT = input.nextInt();
    System.out.print("Please input the board bound: ");
    this.MINE_SIZE = input.nextInt();
    input.close();

    this.setLayout(null);  // Do not use display methods
    jb = new JButton[MINE_SIZE][MINE_SIZE];
    // blankLine = new JLabel();
    showTime = new JLabel();
    map = new int[MINE_SIZE][MINE_SIZE]; // Function the botton to array
  }

  public static void main(String[] args) {
    mineClearance test = new mineClearance("Kobe's Mine Game");
    test.init();
    test.run();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    int x, y;
    if ((obj instanceof JButton) == false) {
      showMessage("Error", "Inter error");
      return;
    }
    String[] tmp_str = ((JButton) obj).getName().split("_"); // Transtype Object to JButton
    x = Integer.parseInt(tmp_str[0]);
    y = Integer.parseInt(tmp_str[1]);
    if ("^".equals(jb[x][y].getText())) {
      return;
    }
    if (map[x][y] == MINE) {
      showMessage("Death", "You have steped on a mine~~~");
      flag = true;
      showMine();
      return;
    }
    dfs(x, y);
    checkSuccess();
  }

  /**
   * To evaluate whether mines have been found out, to check the positon of enable
   */
  private void checkSuccess() {
    int cnt = 0;
    for (int i = 0; i < MINE_SIZE; i++) {
      for (int j = 0; j < MINE_SIZE; j++) {
        if (jb[i][j].isEnabled()) {
          cnt++;
        }
      }
    }
    if (cnt == MINE_COUNT) {
      String tmp_str = showTime.getText();
      tmp_str = tmp_str.replaceAll("[^0-9]", "");
      showMessage("Success", "This turn's time spend: " + tmp_str + " s");
      flag = true;
      showMine();
    }
  }

  private int dfs(int x, int y) {
    map[x][y] = CHECKED;
    int i, tx, ty, cnt = 0;
    for (i = 0; i < 8; i++) {
      tx = x + mv[i][0];
      ty = y + mv[i][1];
      if (tx >= 0 && tx < MINE_SIZE && ty >= 0 && ty < MINE_SIZE) {
        if (map[tx][ty] == MINE) {
          cnt++;
        } else if (map[tx][ty] == EMPTY) {
          ;
        } else if (map[tx][ty] == CHECKED) {
          ;
        }
      }
    }
    if (cnt == 0) {
      for (i = 0; i < 8; i++) {
        tx = x + mv[i][0];
        ty = y + mv[i][1];
        if (tx >= 0 && tx < MINE_SIZE && ty >= 0 && ty < MINE_SIZE
            && map[tx][ty] != CHECKED) {
          dfs(tx, ty); // What dose d do?
        }
      }
    } else {
      Font mf = new Font("Arial",Font.BOLD, 28);
      jb[x][y].setFont(mf);
      jb[x][y].setText(cnt + "");
      jb[x][y].setForeground(Color.blue);
    }
    jb[x][y].setEnabled(false);
    return cnt;
  }

  /**
   * 
   *
   * @param title
   * @param info
   */
  private void showMessage(String title, String info) {
    showTime.setText(info);
    System.out.println("in functino showMessage() : " + info);
  }

  public void run() {
    int t = 0;
    while (true) {
      if (flag) {
        break;
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      t++;
      showTime.setText("Time spent: " + t + " s");
    }
    // showMine();
  }

  private void showMine() {
//   Icon iconMine = new ImageIcon("e:/mine.jpg");
    for (int i = 0; i < MINE_SIZE; i++) {
      for (int j = 0; j < MINE_SIZE; j++) {
        if (map[i][j] == MINE) {
          Font mf = new Font("Arial",Font.BOLD, 35);
          jb[i][j].setFont(mf);
          jb[i][j].setText("*");
          jb[i][j].setForeground(Color.red);
//         jb[i][j].setIcon(iconMine);
        }
      }
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getButton() == 3) {
      Object obj = e.getSource();
      if ((obj instanceof JButton) == false) {
        showMessage("Error", "Inner error");
        return;
      }
      String[] tmp_str = ((JButton) obj).getName().split("_");
      int x = Integer.parseInt(tmp_str[0]);
      int y = Integer.parseInt(tmp_str[1]);
      // switch (jb[x][y].getText()) {
      //   case "^":
      //     jb[x][y].setText("");
      //     break;

      //   case ""
      // }


      if ("^".equals(jb[x][y].getText())) {
        jb[x][y].setText("");
        return;
      } else if ("".equals(jb[x][y].getText())) {
        Font mf = new Font("Arial",Font.BOLD, 28);
        jb[x][y].setFont(mf);
        jb[x][y].setText("^");
        jb[x][y].setForeground(Color.blue);
        return;
      }
  /*   if(jb[x][y].getIcon() == null){
        jb[x][y].setIcon(new ImageIcon("e:/flag.jpg"));
      }else{
        jb[x][y].setIcon(null);
      }*/
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
  }
  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
  }
  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
  }
  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
  }
}