import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class LaserMain{

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            uiui();
         }
      });
   
   }
  
   public static void uiui(){
      
      JFrame f = new JFrame("LaserMaze");
      f.add(new UI());
      f.setSize(730, 430);
      f.setVisible(true);
      f.setResizable(false);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}
class UI extends JPanel{
   Block[] block;
   int Clickedblock;
   int superx, supery;
   int clickedx, clickedy;
   int onTargetLaser = 0;

   JButton btn_Action = new JButton("Action");
   ActionListener btn_Ac = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
         onTargetLaser = 0;
         int blockSize =4;
         int blockNum = 16;
         int blockNum2 = 18;
         int blockNum3 = 20;
         int blockNum4 = 19;
         int blockNum5 = 17;
         int blockNum6 = 23;
         int blockNum7 = 22;
         int blockNum8 = 23;
         int blockNum9 = 24;
         int blockNum10 = 19;
         int blockNum11 = 21;
         int blockNum12 = 17;
         
         
         switch(blockSize) {
         case 1:
            for (int a = 0; a < 5; a++) {
               for (int b = 0; b < 5; b++) {
                  if (BoardArray[a][b] != 0) {
                     continue;
                  }
      
                  // block ��ġ ����
                  blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                  BoardMapping();
                  LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                  LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                  findTarget();
                  repaint();
      
                  // target ��� �����ϸ� ���� return , ���� ���
                  if (onTarget()) {
                     System.out.println("Success");
                     return;
                  } else {
                     System.out.println("Fail");
                     // ���� �������� block ���ڸ���
                     blockPosChange(blockNum, blocksPosition[blockNum][0], blocksPosition[blockNum][1]);
                     BoardMapping();
                  }
               }
            }
            repaint();
            break;
         case 2: 
            for (int a = 0; a < 5; a++) {
               for (int b = 0; b < 5; b++) {
                  for (int c = 0; c < 5; c++) {
                     for (int d = 0; d < 5; d++) {
                        if (a==c && b==d) {
                           continue;
                        }
                        if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0) {
                           continue;
                        }

                        // block ��ġ ����
                        blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                        blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                        BoardMapping();
                        LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                        LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                        findTarget();
                        repaint();

                        // target ��� �����ϸ� ���� return , ���� ���
                        if (onTarget()) {
                           System.out.println("Success");
                           return;
                        } else {
                           System.out.println("Fail");
                           // ���� �������� block ���ڸ���
                           blockPosChange(blockNum, blocksPosition[blockNum][0], blocksPosition[blockNum][1]);
                           blockPosChange(blockNum2, blocksPosition[blockNum2][0], blocksPosition[blockNum2][1]);
                           BoardMapping();
                        }
                     }
                  }
               }
            }
            repaint();
            break;
         case 3:
            for (int a = 0; a < 5; a++) {
               for (int b = 0; b < 5; b++) {
                  for (int c = 0; c < 5; c++) {
                     for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                           for (int f = 0; f < 5; f++) {
                              if ((a == c && b == d) || (c == e && d == f) || (a == e && b == f)) {
                                 continue;
                              }
                              if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0) {
                                 continue;
                              }

                              // block ��ġ ����
                              blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                              blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                              blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                              BoardMapping();
                              LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                              LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                              findTarget();
                              repaint();

                              // target ��� �����ϸ� ���� return , ���� ���
                              if (onTarget()) {
                                 System.out.println("Success");
                                 return;
                              } else {
                                 System.out.println("Fail");
                                 // ���� �������� block ���ڸ���
                                 blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                 blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                 blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                 BoardMapping();
                              }
                           }
                        }
                     }
                  }
               }
            }
            repaint();
            break;
         case 4:
            for (int a = 0; a < 5; a++) {
               for (int b = 0; b < 5; b++) {
                  for (int c = 0; c < 5; c++) {
                     for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                           for (int f = 0; f < 5; f++) {
                              for (int g = 0; g < 5; g++) {
                                 for (int h = 0; h < 5; h++) {
                                    if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                          || (c == e && d == f) || (c == g && d == h) || (e == g && f == h) ) {
                                       continue;
                                    }
                                    if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0) {
                                       continue;
                                    }

                                    // block ��ġ ����
                                    blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                    blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                    blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                    blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                    BoardMapping();
                                    LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                    LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                    findTarget();
                                    repaint();

                                    // target ��� �����ϸ� ���� return , ���� ���
                                    if (onTarget()) {
                                       System.out.println("Success");
                                       return;
                                    } else {
                                       System.out.println("Fail");
                                       // ���� �������� block ���ڸ���
                                       blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                       blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                       blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                       blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                       BoardMapping();
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
            repaint();
            break;
         case 5:
             for (int a = 0; a < 5; a++) {
                  for (int b = 0; b < 5; b++) {
                     for (int c = 0; c < 5; c++) {
                        for (int d = 0; d < 5; d++) {
                           for (int e = 0; e < 5; e++) {
                              for (int f = 0; f < 5; f++) {
                                 for (int g = 0; g < 5; g++) {
                                    for (int h = 0; h < 5; h++){
                                       for(int i =0; i < 5; i++){
                                          for(int j=0; j < 5; j++){                                                                  
                                             if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h) || (c == e && d == f)
                                                   || (c == g && d == h) || (e == g && f == h) || (g == i && h == j )|| (i == a && j == b)){
                                          continue;
                                             }
                                                if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0 || BoardArray[i][j] != 0) {
                                                   continue;
                                                }
                                                blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                                blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                                blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                                blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                                blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                                BoardMapping();
                                                LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                                LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                                findTarget();
                                                repaint();
                                                if (onTarget()) {
                                                    System.out.println("Success");
                                                    return;
                                                 } else {
                                                    System.out.println("Fail");
                                                    // ���� �������� block ���ڸ���
                                                    blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                                    blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                                    blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                                    blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                                    blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]); 
                                                    BoardMapping();
                                                 }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
             }
             repaint();
              break;
          case 6:
              for (int a = 0; a < 5; a++) {
                 for (int b = 0; b < 5; b++) {
                    for (int c = 0; c < 5; c++) {
                       for (int d = 0; d < 5; d++) {
                          for (int e = 0; e < 5; e++) {
                             for (int f = 0; f < 5; f++) {
                                for (int g = 0; g < 5; g++) {
                                   for (int h = 0; h < 5; h++) {
                                     for (int i = 0; i < 5; i++) {
                                       for (int j = 0; j < 5; j++) {
                                          for (int k = 0; k < 5; k++) {
                                             for (int l = 0; l < 5; l++) {
                                           if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                            || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                            || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                            || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                            || (e == k && f == l) || (g == k && h == l) || (i == k && j == l)) {
                                         continue;
                                      }
                                      if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0) {
                                          continue;
                                      }

                                      // block ��ġ ����
                                      blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                      blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                      blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                      blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                      blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                      blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                      BoardMapping();
                                      LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                      LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                      findTarget();
                                      repaint();

                                      // target ��� �����ϸ� ���� return , ���� ���
                                      if (onTarget()) {
                                         System.out.println("Success");
                                         return;
                                      } else {
                                         System.out.println("Fail");
                                         // ���� �������� block ���ڸ���
                                         blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                         blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                         blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                         blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                         blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                         blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                         BoardMapping();
                                      }
                                   }
                                }
                             }
                          }
                       }
                    }
                 }
              }
                       }
                    }
                 }
              }
              repaint();
              break;
          case 7:
              for (int a = 0; a < 5; a++) {
                 for (int b = 0; b < 5; b++) {
                    for (int c = 0; c < 5; c++) {
                       for (int d = 0; d < 5; d++) {
                          for (int e = 0; e < 5; e++) {
                             for (int f = 0; f < 5; f++) {
                                for (int g = 0; g < 5; g++) {
                                   for (int h = 0; h < 5; h++) {
                                     for (int i = 0; i < 5; i++) {
                                       for (int j = 0; j < 5; j++) {
                                          for (int k = 0; k < 5; k++) {
                                             for (int l = 0; l < 5; l++) {
                                                for (int m = 0; m < 5; m++) {
                                                     for (int n = 0; n < 5; n++) {
                                          if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                            || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                            || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                            || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                            || (e == k && f == l) || (g == k && h == l) || (i == k && j == l) || (a == m && b == n)|| (c == m && d == n)|| (e == m && f== n)|| (g == m && h == n)|| (i == m && j == n)|| (k == m &&l == n)) {
                                         continue;
                                      }
                                      if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0 || BoardArray[m][n] != 0) {
                                          continue;
                                      }

                                      // block ��ġ ����
                                      blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                      blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                      blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                      blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                      blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                      blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                      blockPosChange(blockNum7, n * 60 + 10, m * 60 + 10);
                                      BoardMapping();
                                      LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                      LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                      findTarget();
                                      repaint();

                                      // target ��� �����ϸ� ���� return , ���� ���
                                      if (onTarget()) {
                                         System.out.println("Success");
                                         return;
                                      } else {
                                         System.out.println("Fail");
                                         // ���� �������� block ���ڸ���
                                         blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                         blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                         blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                         blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                         blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                         blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                         blockPosChange(blockNum7, blocksPosition[blockNum7][0],blocksPosition[blockNum7][1]);
                                         BoardMapping();
                                      }}
                                   }}
                                }}
                             }
                          }
                       }
                    }
                 }
              }}}
              }
              repaint();
              break;
                 case 8:
                                for (int a = 0; a < 5; a++) {
                                    for (int b = 0; b < 5; b++) {
                                       for (int c = 0; c < 5; c++) {
                                          for (int d = 0; d < 5; d++) {
                                             for (int e = 0; e < 5; e++) {
                                                for (int f = 0; f < 5; f++) {
                                                   for (int g = 0; g < 5; g++) {
                                                      for (int h = 0; h < 5; h++) {
                                                        for (int i = 0; i < 5; i++) {
                                                          for (int j = 0; j < 5; j++) {
                                                             for (int k = 0; k < 5; k++) {
                                                                for (int l = 0; l < 5; l++) {
                                                                   for (int m = 0; m < 5; m++) {
                                                                        for (int n = 0; n < 5; n++) {
                                                                           for (int o = 0; o < 5; o++) {
                                                                                for (int p = 0; p < 5; p++) {                                                                                                                      
                                                         if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                                               || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                                               || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                                               || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                                               || (e == k && f == l) || (g == k && h == l) || (i == k && j == l) || (a == m && b == n)|| (c == m && d == n)|| (e == m && f== n)|| (g == m && h == n)|| (i == m && j == n)|| (k == m &&l == n)
                                                               || (a == o &&b == p) || (c == o &&d == p) || (e == o &&f == p) || (g == o &&h == p) || (i == o &&j == p) || (k == o &&l == p) || (m == o &&n == p)) {
                                                            continue;
                                                         }
                                                         if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0 || BoardArray[m][n] != 0 || BoardArray[o][p] != 0){
                                                             continue;
                                                         }

                                                         // block ��ġ ����
                                                         blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                                         blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                                         blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                                         blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                                         blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                                         blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                                         blockPosChange(blockNum7, n * 60 + 10, m * 60 + 10);
                                                         blockPosChange(blockNum8, p * 60 + 10, o * 60 + 10);
                                                         BoardMapping();
                                                         LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                                         LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                                         findTarget();
                                                         repaint();

                                                         // target ��� �����ϸ� ���� return , ���� ���
                                                         if (onTarget()) {
                                                            System.out.println("Success");
                                                            return;
                                                         } else {
                                                            System.out.println("Fail");
                                                            // ���� �������� block ���ڸ���
                                                            blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                                            blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                                            blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                                            blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                                            blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                                            blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                                            blockPosChange(blockNum7, blocksPosition[blockNum7][0],blocksPosition[blockNum7][1]);
                                                            blockPosChange(blockNum8, blocksPosition[blockNum8][0],blocksPosition[blockNum8][1]);
                                                            BoardMapping();
                                                         }
                                                      }
                                                                           }
                                                                        }
                                                                   }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                                             }
                                          }
                                       }
                                    }
                                }
                                 repaint();
                                 break;
                 case 9:
                     for (int a = 0; a < 5; a++) {
                         for (int b = 0; b < 5; b++) {
                            for (int c = 0; c < 5; c++) {
                               for (int d = 0; d < 5; d++) {
                                  for (int e = 0; e < 5; e++) {
                                     for (int f = 0; f < 5; f++) {
                                        for (int g = 0; g < 5; g++) {
                                           for (int h = 0; h < 5; h++) {
                                             for (int i = 0; i < 5; i++) {
                                               for (int j = 0; j < 5; j++) {
                                                  for (int k = 0; k < 5; k++) {
                                                     for (int l = 0; l < 5; l++) {
                                                        for (int m = 0; m < 5; m++) {
                                                             for (int n = 0; n < 5; n++) {
                                                                for (int o = 0; o < 5; o++) {
                                                                     for (int p = 0; p < 5; p++) {     
                                                                    	 for (int q = 0; q < 5; q++) {
                                                                             for (int r = 0; r < 5; r++) {
                                              if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                                    || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                                    || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                                    || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                                    || (e == k && f == l) || (g == k && h == l) || (i == k && j == l) || (a == m && b == n)|| (c == m && d == n)|| (e == m && f== n)|| (g == m && h == n)|| (i == m && j == n)|| (k == m &&l == n)
                                                    || (a == o &&b == p) || (c == o &&d == p) || (e == o &&f == p) || (g == o &&h == p) || (i == o &&j == p) || (k == o &&l == p) || (m == o &&n == p)
                                                    || (a == q &&b == r)|| (c == q &&d == r)|| (e == q &&f == r)|| (g == q &&h == r)|| (i == q &&j == r)|| (k == q &&l == r)|| (m == q &&n == r)|| (o == q &&p == r)  ) {
                                                 continue;
                                              }
                                              if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0 || BoardArray[m][n] != 0 || BoardArray[o][p] != 0
                                            		  || BoardArray[q][r] != 0){
                                                  continue;
                                              }

                                              // block ��ġ ����
                                              blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                              blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                              blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                              blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                              blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                              blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                              blockPosChange(blockNum7, n * 60 + 10, m * 60 + 10);
                                              blockPosChange(blockNum8, p * 60 + 10, o * 60 + 10);
                                              blockPosChange(blockNum9, r * 60 + 10, q * 60 + 10);
                                              BoardMapping();
                                              LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                              LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                              findTarget();
                                              repaint();

                                              // target ��� �����ϸ� ���� return , ���� ���
                                              if (onTarget()) {
                                                 System.out.println("Success");
                                                 return;
                                              } else {
                                                 System.out.println("Fail");
                                                 // ���� �������� block ���ڸ���
                                                 blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                                 blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                                 blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                                 blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                                 blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                                 blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                                 blockPosChange(blockNum7, blocksPosition[blockNum7][0],blocksPosition[blockNum7][1]);
                                                 blockPosChange(blockNum8, blocksPosition[blockNum8][0],blocksPosition[blockNum8][1]);
                                                 blockPosChange(blockNum9, blocksPosition[blockNum9][0],blocksPosition[blockNum9][1]);
                                                 BoardMapping();
                                              }
                                           }
                                                                }
                                                             }
                                                        }
                                        }
                                     }}}
                                  }
                               }
                            }
                         }
                      }
                                  }
                               }
                            }
                         }
                     }
                      repaint();
                      break;
                      
                 case 10:
                     for (int a = 0; a < 5; a++) {
                         for (int b = 0; b < 5; b++) {
                            for (int c = 0; c < 5; c++) {
                               for (int d = 0; d < 5; d++) {
                                  for (int e = 0; e < 5; e++) {
                                     for (int f = 0; f < 5; f++) {
                                        for (int g = 0; g < 5; g++) {
                                           for (int h = 0; h < 5; h++) {
                                             for (int i = 0; i < 5; i++) {
                                               for (int j = 0; j < 5; j++) {
                                                  for (int k = 0; k < 5; k++) {
                                                     for (int l = 0; l < 5; l++) {
                                                        for (int m = 0; m < 5; m++) {
                                                             for (int n = 0; n < 5; n++) {
                                                                for (int o = 0; o < 5; o++) {
                                                                     for (int p = 0; p < 5; p++) {     
                                                                    	 for (int q = 0; q < 5; q++) {
                                                                             for (int r = 0; r < 5; r++) {
                                                                            	 for (int s = 0; s < 5; s++) {
                                                                                     for (int t = 0; t < 5; t++) {
                                              if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                                    || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                                    || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                                    || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                                    || (e == k && f == l) || (g == k && h == l) || (i == k && j == l) || (a == m && b == n)|| (c == m && d == n)|| (e == m && f== n)|| (g == m && h == n)|| (i == m && j == n)|| (k == m &&l == n)
                                                    || (a == o &&b == p) || (c == o &&d == p) || (e == o &&f == p) || (g == o &&h == p) || (i == o &&j == p) || (k == o &&l == p) || (m == o &&n == p)
                                                    || (a == q &&b == r)|| (c == q &&d == r)|| (e == q &&f == r)|| (g == q &&h == r)|| (i == q &&j == r)|| (k == q &&l == r)|| (m == q &&n == r)|| (o == q &&p == r)
                                                    || (a == s &&b == t)|| (c == s &&d == t)|| (e == s &&f == t)|| (g == s &&h == t)|| (i == s &&j == t)|| (k == s &&l == t)|| (m == s &&n == t)|| (o == s &&p == t) || (q == s &&r == t)) {
                                                 continue;
                                              }
                                              if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0 || BoardArray[m][n] != 0 || BoardArray[o][p] != 0
                                            		  || BoardArray[q][r] != 0 || BoardArray[s][t] != 0){
                                                  continue;
                                              }

                                              // block ��ġ ����
                                              blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                              blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                              blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                              blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                              blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                              blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                              blockPosChange(blockNum7, n * 60 + 10, m * 60 + 10);
                                              blockPosChange(blockNum8, p * 60 + 10, o * 60 + 10);
                                              blockPosChange(blockNum9, r * 60 + 10, q * 60 + 10);
                                              blockPosChange(blockNum10, t * 60 + 10, s * 60 + 10);
                                              BoardMapping();
                                              LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                              LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                              findTarget();
                                              repaint();

                                              // target ��� �����ϸ� ���� return , ���� ���
                                              if (onTarget()) {
                                                 System.out.println("Success");
                                                 return;
                                              } else {
                                                 System.out.println("Fail");
                                                 // ���� �������� block ���ڸ���
                                                 blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                                 blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                                 blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                                 blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                                 blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                                 blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                                 blockPosChange(blockNum7, blocksPosition[blockNum7][0],blocksPosition[blockNum7][1]);
                                                 blockPosChange(blockNum8, blocksPosition[blockNum8][0],blocksPosition[blockNum8][1]);
                                                 blockPosChange(blockNum9, blocksPosition[blockNum9][0],blocksPosition[blockNum9][1]);
                                                 blockPosChange(blockNum10, blocksPosition[blockNum10][0],blocksPosition[blockNum10][1]);
                                                 BoardMapping();
                                              }
                                           }
                                                                }
                                                             }
                                                        }
                                        }}}
                                     }}}
                                  }
                               }
                            }
                         }
                      }
                                  }
                               }
                            }
                         }
                     }
                      repaint();
                      break;
                 case 11:
                     for (int a = 0; a < 5; a++) {
                         for (int b = 0; b < 5; b++) {
                            for (int c = 0; c < 5; c++) {
                               for (int d = 0; d < 5; d++) {
                                  for (int e = 0; e < 5; e++) {
                                     for (int f = 0; f < 5; f++) {
                                        for (int g = 0; g < 5; g++) {
                                           for (int h = 0; h < 5; h++) {
                                             for (int i = 0; i < 5; i++) {
                                               for (int j = 0; j < 5; j++) {
                                                  for (int k = 0; k < 5; k++) {
                                                     for (int l = 0; l < 5; l++) {
                                                        for (int m = 0; m < 5; m++) {
                                                             for (int n = 0; n < 5; n++) {
                                                                for (int o = 0; o < 5; o++) {
                                                                     for (int p = 0; p < 5; p++) {     
                                                                    	 for (int q = 0; q < 5; q++) {
                                                                             for (int r = 0; r < 5; r++) {
                                                                            	 for (int s = 0; s < 5; s++) {
                                                                                     for (int t = 0; t < 5; t++) {
                                                                                    	 for (int u = 0; u < 5; u++) {
                                                                                             for (int v = 0; v < 5; v++) {
                                              if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                                    || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                                    || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                                    || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                                    || (e == k && f == l) || (g == k && h == l) || (i == k && j == l) || (a == m && b == n)|| (c == m && d == n)|| (e == m && f== n)|| (g == m && h == n)|| (i == m && j == n)|| (k == m &&l == n)
                                                    || (a == o &&b == p) || (c == o &&d == p) || (e == o &&f == p) || (g == o &&h == p) || (i == o &&j == p) || (k == o &&l == p) || (m == o &&n == p)
                                                    || (a == q &&b == r)|| (c == q &&d == r)|| (e == q &&f == r)|| (g == q &&h == r)|| (i == q &&j == r)|| (k == q &&l == r)|| (m == q &&n == r)|| (o == q &&p == r)
                                                    || (a == s &&b == t)|| (c == s &&d == t)|| (e == s &&f == t)|| (g == s &&h == t)|| (i == s &&j == t)|| (k == s &&l == t)|| (m == s &&n == t)|| (o == s &&p == t) || (q == s &&r == t)
                                                    || (a == u &&b == v)|| (c == u &&d == v)|| (e == u &&f == v)|| (g == u &&h == v)|| (i == u &&j == v)|| (k == u &&l == v)|| (m == u &&n == v)|| (o == u &&p == v) || (q == u &&r == v)|| (s == u &&t == v)  ) {
                                                 continue;
                                              }
                                              if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0 || BoardArray[m][n] != 0 || BoardArray[o][p] != 0
                                            		  || BoardArray[q][r] != 0 || BoardArray[s][t] != 0 || BoardArray[u][v] != 0){
                                                  continue;
                                              }

                                              // block ��ġ ����
                                              blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                              blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                              blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                              blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                              blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                              blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                              blockPosChange(blockNum7, n * 60 + 10, m * 60 + 10);
                                              blockPosChange(blockNum8, p * 60 + 10, o * 60 + 10);
                                              blockPosChange(blockNum9, r * 60 + 10, q * 60 + 10);
                                              blockPosChange(blockNum10, t * 60 + 10, s * 60 + 10);
                                              blockPosChange(blockNum11, v * 60 + 10, u * 60 + 10);
                                              BoardMapping();
                                              LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                              LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                              findTarget();
                                              repaint();

                                              // target ��� �����ϸ� ���� return , ���� ���
                                              if (onTarget()) {
                                                 System.out.println("Success");
                                                 return;
                                              } else {
                                                 System.out.println("Fail");
                                                 // ���� �������� block ���ڸ���
                                                 blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                                 blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                                 blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                                 blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                                 blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                                 blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                                 blockPosChange(blockNum7, blocksPosition[blockNum7][0],blocksPosition[blockNum7][1]);
                                                 blockPosChange(blockNum8, blocksPosition[blockNum8][0],blocksPosition[blockNum8][1]);
                                                 blockPosChange(blockNum9, blocksPosition[blockNum9][0],blocksPosition[blockNum9][1]);
                                                 blockPosChange(blockNum10, blocksPosition[blockNum10][0],blocksPosition[blockNum10][1]);
                                                 blockPosChange(blockNum11, blocksPosition[blockNum11][0],blocksPosition[blockNum11][1]);
                                                 BoardMapping();
                                              }
                                           }
                                                                }
                                                             }
                                                        }
                                        }}}}}
                                     }}}
                                  }
                               }
                            }
                         }
                      }
                                  }
                               }
                            }
                         }
                     }
                      repaint();
                      break;
                      
                 case 12:
                     for (int a = 0; a < 5; a++) {
                         for (int b = 0; b < 5; b++) {
                            for (int c = 0; c < 5; c++) {
                               for (int d = 0; d < 5; d++) {
                                  for (int e = 0; e < 5; e++) {
                                     for (int f = 0; f < 5; f++) {
                                        for (int g = 0; g < 5; g++) {
                                           for (int h = 0; h < 5; h++) {
                                             for (int i = 0; i < 5; i++) {
                                               for (int j = 0; j < 5; j++) {
                                                  for (int k = 0; k < 5; k++) {
                                                     for (int l = 0; l < 5; l++) {
                                                        for (int m = 0; m < 5; m++) {
                                                             for (int n = 0; n < 5; n++) {
                                                                for (int o = 0; o < 5; o++) {
                                                                     for (int p = 0; p < 5; p++) {     
                                                                    	 for (int q = 0; q < 5; q++) {
                                                                             for (int r = 0; r < 5; r++) {
                                                                            	 for (int s = 0; s < 5; s++) {
                                                                                     for (int t = 0; t < 5; t++) {
                                                                                    	 for (int u = 0; u < 5; u++) {
                                                                                             for (int v = 0; v < 5; v++) {
                                                                                            	 for (int w = 0; w < 5; w++) {
                                                                                                     for (int x = 0; x < 5; x++) {
                                              if ((a == c && b == d) || (a == e && b == f) || (a == g && b == h)
                                                    || (c == e && d == f) || (c == g && d == h) || (e == g && f == h)
                                                    || (a == i && b == j) || (c == i && d == j) || (e == i && f == j)
                                                    || (g == i && h == j) || (a == k && b == l) || (c == k && d == l)
                                                    || (e == k && f == l) || (g == k && h == l) || (i == k && j == l) || (a == m && b == n)|| (c == m && d == n)|| (e == m && f== n)|| (g == m && h == n)|| (i == m && j == n)|| (k == m &&l == n)
                                                    || (a == o &&b == p) || (c == o &&d == p) || (e == o &&f == p) || (g == o &&h == p) || (i == o &&j == p) || (k == o &&l == p) || (m == o &&n == p)
                                                    || (a == q &&b == r)|| (c == q &&d == r)|| (e == q &&f == r)|| (g == q &&h == r)|| (i == q &&j == r)|| (k == q &&l == r)|| (m == q &&n == r)|| (o == q &&p == r)
                                                    || (a == s &&b == t)|| (c == s &&d == t)|| (e == s &&f == t)|| (g == s &&h == t)|| (i == s &&j == t)|| (k == s &&l == t)|| (m == s &&n == t)|| (o == s &&p == t) || (q == s &&r == t)
                                                    || (a == u &&b == v)|| (c == u &&d == v)|| (e == u &&f == v)|| (g == u &&h == v)|| (i == u &&j == v)|| (k == u &&l == v)|| (m == u &&n == v)|| (o == u &&p == v) || (q == u &&r == v)|| (s == u &&t == v)
                                                    || (a == w &&b == x)|| (c == w &&d == x)|| (e == w &&f == x)|| (g == w &&h == x)|| (i == w &&j == x)|| (k == w &&l == x)|| (m == w &&n == x)|| (o == w &&p == x) || (q == w &&r == x)|| (s == w &&t == x)|| (u == w &&v == x) ) {
                                                 continue;
                                              }
                                              if (BoardArray[a][b] != 0 || BoardArray[c][d] != 0 || BoardArray[e][f] != 0 || BoardArray[g][h] != 0|| BoardArray[i][j] != 0|| BoardArray[k][l] != 0 || BoardArray[m][n] != 0 || BoardArray[o][p] != 0
                                            		  || BoardArray[q][r] != 0 || BoardArray[s][t] != 0 || BoardArray[u][v] != 0 || BoardArray[w][x] != 0){
                                                  continue;
                                              }

                                              // block ��ġ ����
                                              blockPosChange(blockNum, b * 60 + 10, a * 60 + 10);
                                              blockPosChange(blockNum2, d * 60 + 10, c * 60 + 10);
                                              blockPosChange(blockNum3, f * 60 + 10, e * 60 + 10);
                                              blockPosChange(blockNum4, h * 60 + 10, g * 60 + 10);
                                              blockPosChange(blockNum5, j * 60 + 10, i * 60 + 10);
                                              blockPosChange(blockNum6,  l* 60 + 10, k * 60 + 10);
                                              blockPosChange(blockNum7, n * 60 + 10, m * 60 + 10);
                                              blockPosChange(blockNum8, p * 60 + 10, o * 60 + 10);
                                              blockPosChange(blockNum9, r * 60 + 10, q * 60 + 10);
                                              blockPosChange(blockNum10, t * 60 + 10, s * 60 + 10);
                                              blockPosChange(blockNum11, v * 60 + 10, u * 60 + 10);
                                              blockPosChange(blockNum12, x * 60 + 10, w * 60 + 10);
                                              BoardMapping();
                                              LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
                                              LaserAlgorithmNoGraphic(); // �гο� ������ �׸�
                                              findTarget();
                                              repaint();

                                              // target ��� �����ϸ� ���� return , ���� ���
                                              if (onTarget()) {
                                                 System.out.println("Success");
                                                 return;
                                              } else {
                                                 System.out.println("Fail");
                                                 // ���� �������� block ���ڸ���
                                                 blockPosChange(blockNum, blocksPosition[blockNum][0],blocksPosition[blockNum][1]);
                                                 blockPosChange(blockNum2, blocksPosition[blockNum2][0],blocksPosition[blockNum2][1]);
                                                 blockPosChange(blockNum3, blocksPosition[blockNum3][0],blocksPosition[blockNum3][1]);
                                                 blockPosChange(blockNum4, blocksPosition[blockNum4][0],blocksPosition[blockNum4][1]);
                                                 blockPosChange(blockNum5, blocksPosition[blockNum5][0],blocksPosition[blockNum5][1]);
                                                 blockPosChange(blockNum6, blocksPosition[blockNum6][0],blocksPosition[blockNum6][1]);
                                                 blockPosChange(blockNum7, blocksPosition[blockNum7][0],blocksPosition[blockNum7][1]);
                                                 blockPosChange(blockNum8, blocksPosition[blockNum8][0],blocksPosition[blockNum8][1]);
                                                 blockPosChange(blockNum9, blocksPosition[blockNum9][0],blocksPosition[blockNum9][1]);
                                                 blockPosChange(blockNum10, blocksPosition[blockNum10][0],blocksPosition[blockNum10][1]);
                                                 blockPosChange(blockNum11, blocksPosition[blockNum11][0],blocksPosition[blockNum11][1]);
                                                 blockPosChange(blockNum12, blocksPosition[blockNum12][0],blocksPosition[blockNum12][1]);
                                                 BoardMapping();
                                              }
                                           }
                                                                                            	 }}                        }
                                                             }
                                                        }
                                        }}}}}
                                     }}}
                                  }
                               }
                            }
                         }
                      }
                                  }
                               }
                            }
                         }
                     }
                      repaint();
                      break;


         }
      }
   };
   //��ư ���� : ������� �� Ÿ�� ����, Ÿ�ٿ� �� ������ ���� �Ǻ�, �ֿܼ� ���
   
   public void blockPosChange(int blockNum, int x, int y) {
      block[blockNum].setX(x);
      block[blockNum].setY(y);
   }
   
   int[][] BoardArray = new int[5][5];
   int[][] blocksPosition = {
         {400,10,11},{460,10,12},{520,10,13},{580,10,14},{640,10,21},

         {400,70,21},{460,70,21},{520,70,22},{580,70,22},{640,70,22},

         {400,130,23},{460,130,23},{520,130,23},{580,130,24},{640,130,24},

         {400,190,24},{460,190,41},{520,190,41},{580,190,42},{640,190,42},

         {400,250,31},{460,250,32},{520,250,5},{580,250,4},{640,250,6}
   };

   // ����� �ʱ� ��ġ, Ÿ�� ����
   /* 11,12,13,14 : �������л�� ��,��,��,��
    * 21,22,23,24 : Ÿ��+�ſ� ��,��,��,��
    * 31,32 : �Ķ��ſ� ��>��/��>��,��>��/��>��
    * 41,42 : �ʷϰſ� ��>��/��>��,��>��/��>��
    * 5 : ��� üũ����Ʈ
    * 6 : �� ���
   */
   public void paintComponent(Graphics g){
      super.paintComponent(g);
   
      for(int a = 0; a<block.length; a++){
         block[a].paintBlock(g);
      } // �гο� ��� �׸�
      for(int x=0; x<6; x++){
         g.drawLine(10+x*60, 10, 10+x*60, 310);
      }
      for(int x=0; x<6; x++){
         g.drawLine(10, 10+x*60, 310, 10+x*60);
      } // ������ ����
      for(int x=0; x<6; x++){
         g.drawLine(400+x*60, 10, 400+x*60, 310);
      }
      for(int x=0; x<6; x++){
         g.drawLine(400, 10+x*60, 700, 10+x*60);
      } // �������� ����
      
      LaserIn = new boolean[4][25]; // LaserIn �迭 �ʱ�ȭ
      LaserAlgorithm(g); // �гο� ������ �׸�
    }

   boolean[][] LaserIn; // �� �迭 �ڸ�(0~24) ���� � ������ �������� ������ �Ǻ��ϱ� ����
   int LstartX,LstartY; // ������ ��ŸƮ ����Ʈ
   int newstartX, newstartY; // �������� ����Ǵ� ��� ���ο� ��ŸƮ ����Ʈ
   public void LaserAlgorithm(Graphics g){
      for(int x = 0; x<5; x++){
         for(int y = 0; y<5; y++){
            if(BoardArray[x][y]==11||BoardArray[x][y]==12||BoardArray[x][y]==13||BoardArray[x][y]==14){ // ������ �л�⿡�� ó�� ����
               LstartX = 40+y*60;
               LstartY = 40+x*60;
               switch(BoardArray[x][y]){
                  case 11: dir1(g, LstartX,LstartY,x,y);break; // RIGHT
                  case 12: dir2(g, LstartX,LstartY,x,y);break; // UP 
                  case 13: dir3(g, LstartX,LstartY,x,y);break; // LEFT
                  case 14: dir4(g, LstartX,LstartY,x,y);break; // DOWN
                  // �� �л�⿡ ���� dir�޼ҵ� ����
               }
            }
         }   
      }
   }
   public void LaserAlgorithmNoGraphic(){
         for(int x = 0; x<5; x++){
            for(int y = 0; y<5; y++){
               if(BoardArray[x][y]==11||BoardArray[x][y]==12||BoardArray[x][y]==13||BoardArray[x][y]==14){ // ������ �л�⿡�� ó�� ����
                  LstartX = 40+y*60;
                  LstartY = 40+x*60;
                  switch(BoardArray[x][y]){
                     case 11: dir1NoGraphic(LstartX,LstartY,x,y);break; // RIGHT
                     case 12: dir2NoGraphic(LstartX,LstartY,x,y);break; // UP 
                     case 13: dir3NoGraphic(LstartX,LstartY,x,y);break; // LEFT
                     case 14: dir4NoGraphic(LstartX,LstartY,x,y);break; // DOWN
                     // �� �л�⿡ ���� dir�޼ҵ� ����
                  }
               }
            }   
         }
      }
   public void drawLaser(Graphics g, int LstartX, int LstartY, int LdestX, int LdestY){
      g.setColor(Color.RED);
      g.drawLine(LstartX, LstartY, LdestX, LdestY);
   }
   // ��ŸƮ����Ʈ-��ǥ����Ʈ �� �޾Ƽ� ������ �׸�
   
   public boolean XYinBoard(int x, int y){
      if(x>4 || y>4 || x<0 || y<0)
         return false; // Point Out of board
      return true;
   }
   // �迭�� ��� x,y���� �Ǻ�
   
   public boolean passCheck(int CurrentX, int CurrentY){
      
      if(!XYinBoard(CurrentX, CurrentY)){
         return false; // Laser Out �迭(������)�� ���� ���
      }
      if(BoardArray[CurrentX][CurrentY]==11 || BoardArray[CurrentX][CurrentY]==12 
            || BoardArray[CurrentX][CurrentY]==13 || BoardArray[CurrentX][CurrentY]==14){
         return false; // Laser on LaserShooter ������ �л�⸦ ���� ��� ����
      }
      if(BoardArray[CurrentX][CurrentY]==21 || BoardArray[CurrentX][CurrentY]==22 
            || BoardArray[CurrentX][CurrentY]==23 || BoardArray[CurrentX][CurrentY]==24){
         return false; // Laser on Target OR Laser Reflect Ÿ��+�ſ��� ������� ���� �Ǵ� �ݻ� 
      }
      if(BoardArray[CurrentX][CurrentY]==31 || BoardArray[CurrentX][CurrentY]==32){
         return false; // Laser Reflect �ſ��� ���� ��� �ݻ�
      }
      return true; // �̿��� ��� ������ �ʰ� ����ؼ� �״�� ��
   }
   // �������� �� ����� �������, �ű⼭ ������ �Ǻ�
   
   public void dir1(Graphics g, int LstartX, int LstartY, int CurrentX, int CurrentY){
      int LdestX = LstartX+60;
      int LdestY = LstartY;
      int splitX, splitY; // �ʷ� �ſ��� ���� ��� ���ο� �������� �����ϱ� ����
      while(passCheck(CurrentX, CurrentY+1)){
         if(BoardArray[CurrentX][CurrentY+1]==42){
            splitX = CurrentX;
            splitY = CurrentY+1;
            dir2(g, LdestX, LdestY,splitX,splitY);
         }
         else if(BoardArray[CurrentX][CurrentY+1]==41){
            splitX = CurrentX;
            splitY = CurrentY+1;
            dir4(g, LdestX, LdestY,splitX,splitY);   
         }
         // �ʷϰſ��� ��� �������� ������ �ʰ� ����Ǳ� ������, ����Ǻ� �޼ҵ�� ���ÿ� ������ ���� While�� ���� ��ġ
         LdestX = LdestX+60;
         CurrentY++;
      }
      newstartX = LdestX;
      newstartY = LdestY;
      CurrentY++;

      if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
         LaserIn[0][(LdestY-40)/12 + LdestX/60] = true;
      } // Ư�� ������ ��ġ (0~24)���� ���� �������� ���� ���, true�� �־� Ÿ�ٿ� �������� �Ǻ�
      drawLaser(g, LstartX, LstartY, LdestX, LdestY);

      if(XYinBoard(CurrentX,CurrentY)){
         if(BoardArray[CurrentX][CurrentY]==21 || BoardArray[CurrentX][CurrentY]==32 ){
            dir2(g,newstartX,newstartY,CurrentX,CurrentY);
         }
         else if(BoardArray[CurrentX][CurrentY]==22 || BoardArray[CurrentX][CurrentY]==31 ){
            dir4(g,newstartX,newstartY,CurrentX,CurrentY);
         }
      }
      // �ݻ�Ǵ� ��� ���⿡ ���� �ٸ� dir�޼ҵ带 ȣ��
   }
   public void dir2(Graphics g, int LstartX, int LstartY, int CurrentX, int CurrentY){
      int LdestY = LstartY-60; 
      int LdestX = LstartX;
      int splitX, splitY;
         
      while(passCheck(CurrentX-1, CurrentY)){
         if(BoardArray[CurrentX-1][CurrentY]==42){
            splitX = CurrentX-1;
            splitY = CurrentY;
            dir1(g, LdestX, LdestY,splitX,splitY);
         }
         else if(BoardArray[CurrentX-1][CurrentY]==41){
            splitX = CurrentX-1;
            splitY = CurrentY;
            dir3(g, LdestX, LdestY,splitX,splitY);   
         }
         LdestY = LdestY-60;
         CurrentX--;
      }

      newstartX = LdestX;
      newstartY = LdestY;
      CurrentX--;
      if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
         LaserIn[1][(LdestY-40)/12 + LdestX/60] = true;
      }

      drawLaser(g, LstartX, LstartY, LdestX, LdestY);
      
      if(XYinBoard(CurrentX,CurrentY)){
         if(BoardArray[CurrentX][CurrentY]==23 || BoardArray[CurrentX][CurrentY]==32 ){
            dir1(g,newstartX,newstartY,CurrentX,CurrentY);
         }
         else if(BoardArray[CurrentX][CurrentY]==22 || BoardArray[CurrentX][CurrentY]==31 ){
            dir3(g,newstartX,newstartY,CurrentX,CurrentY);
         }
      }
   }
   
   public void dir3(Graphics g, int LstartX, int LstartY, int CurrentX, int CurrentY){
      int LdestX = LstartX-60; 
      int LdestY = LstartY;
      int splitX, splitY;
         
      while(passCheck(CurrentX, CurrentY-1)){
         if(BoardArray[CurrentX][CurrentY-1]==42){
            splitX = CurrentX;
            splitY = CurrentY-1;
            dir4(g, LdestX, LdestY,splitX,splitY);
         }
         else if(BoardArray[CurrentX][CurrentY-1]==41){
            splitX = CurrentX;
            splitY = CurrentY-1;
            dir2(g, LdestX, LdestY,splitX,splitY);   
         }
         LdestX = LdestX-60;
         CurrentY--;   
      }

      newstartX = LdestX;
      newstartY = LdestY;
      CurrentY--;
      if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
         LaserIn[2][(LdestY-40)/12 + LdestX/60] = true;
      }

      drawLaser(g, LstartX, LstartY, LdestX, LdestY);

      if(XYinBoard(CurrentX,CurrentY)){
         if(BoardArray[CurrentX][CurrentY]==23 || BoardArray[CurrentX][CurrentY]==32 ){
            dir4(g,newstartX,newstartY,CurrentX,CurrentY);
         }
         else if(BoardArray[CurrentX][CurrentY]==24 || BoardArray[CurrentX][CurrentY]==31 ){
            dir2(g,newstartX,newstartY,CurrentX,CurrentY);
         }
      }   
   }
   public void dir4(Graphics g, int LstartX, int LstartY, int CurrentX, int CurrentY){
      int LdestY = LstartY+60; 
      int LdestX = LstartX;
      int splitX, splitY;
         
      while(passCheck(CurrentX+1, CurrentY)){
         if(BoardArray[CurrentX+1][CurrentY]==42){
            splitX = CurrentX+1;
            splitY = CurrentY;
            dir3(g, LdestX, LdestY,splitX,splitY);
         }
         else if(BoardArray[CurrentX+1][CurrentY]==41){
            splitX = CurrentX+1;
            splitY = CurrentY;
            dir1(g, LdestX, LdestY,splitX,splitY);   
         }
         LdestY = LdestY+60;
         CurrentX++;
      }

      newstartX = LdestX;
      newstartY = LdestY;
      CurrentX++;
      if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
         LaserIn[3][(LdestY-40)/12 + LdestX/60] = true;
      }


      drawLaser(g, LstartX, LstartY, LdestX, LdestY);

      if(XYinBoard(CurrentX,CurrentY)){
         if(BoardArray[CurrentX][CurrentY]==21 || BoardArray[CurrentX][CurrentY]==32 ){
            dir3(g,newstartX,newstartY,CurrentX,CurrentY);
         }
         else if(BoardArray[CurrentX][CurrentY]==24 || BoardArray[CurrentX][CurrentY]==31 ){
            dir1(g,newstartX,newstartY,CurrentX,CurrentY);
         }
      }   
   }
   
   
   public void dir1NoGraphic(int LstartX, int LstartY, int CurrentX, int CurrentY){
         int LdestX = LstartX+60;
         int LdestY = LstartY;
         int splitX, splitY; // �ʷ� �ſ��� ���� ��� ���ο� �������� �����ϱ� ����
         while(passCheck(CurrentX, CurrentY+1)){
            if(BoardArray[CurrentX][CurrentY+1]==42){
               splitX = CurrentX;
               splitY = CurrentY+1;
               dir2NoGraphic(LdestX, LdestY,splitX,splitY);
            }
            else if(BoardArray[CurrentX][CurrentY+1]==41){
               splitX = CurrentX;
               splitY = CurrentY+1;
               dir4NoGraphic(LdestX, LdestY,splitX,splitY);   
            }
            // �ʷϰſ��� ��� �������� ������ �ʰ� ����Ǳ� ������, ����Ǻ� �޼ҵ�� ���ÿ� ������ ���� While�� ���� ��ġ
            LdestX = LdestX+60;
            CurrentY++;
         }
         newstartX = LdestX;
         newstartY = LdestY;
         CurrentY++;

         if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
            LaserIn[0][(LdestY-40)/12 + LdestX/60] = true;
         } // Ư�� ������ ��ġ (0~24)���� ���� �������� ���� ���, true�� �־� Ÿ�ٿ� �������� �Ǻ�

         if(XYinBoard(CurrentX,CurrentY)){
            if(BoardArray[CurrentX][CurrentY]==21 || BoardArray[CurrentX][CurrentY]==32 ){
               dir2NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
            else if(BoardArray[CurrentX][CurrentY]==22 || BoardArray[CurrentX][CurrentY]==31 ){
               dir4NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
         }
         // �ݻ�Ǵ� ��� ���⿡ ���� �ٸ� dir�޼ҵ带 ȣ��
      }
      public void dir2NoGraphic(int LstartX, int LstartY, int CurrentX, int CurrentY){
         int LdestY = LstartY-60; 
         int LdestX = LstartX;
         int splitX, splitY;
            
         while(passCheck(CurrentX-1, CurrentY)){
            if(BoardArray[CurrentX-1][CurrentY]==42){
               splitX = CurrentX-1;
               splitY = CurrentY;
               dir1NoGraphic(LdestX, LdestY,splitX,splitY);
            }
            else if(BoardArray[CurrentX-1][CurrentY]==41){
               splitX = CurrentX-1;
               splitY = CurrentY;
               dir3NoGraphic(LdestX, LdestY,splitX,splitY);   
            }
            LdestY = LdestY-60;
            CurrentX--;
         }

         newstartX = LdestX;
         newstartY = LdestY;
         CurrentX--;
         if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
            LaserIn[1][(LdestY-40)/12 + LdestX/60] = true;
         }
         
         if(XYinBoard(CurrentX,CurrentY)){
            if(BoardArray[CurrentX][CurrentY]==23 || BoardArray[CurrentX][CurrentY]==32 ){
               dir1NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
            else if(BoardArray[CurrentX][CurrentY]==22 || BoardArray[CurrentX][CurrentY]==31 ){
               dir3NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
         }
      }
      
      public void dir3NoGraphic(int LstartX, int LstartY, int CurrentX, int CurrentY){
         int LdestX = LstartX-60; 
         int LdestY = LstartY;
         int splitX, splitY;
            
         while(passCheck(CurrentX, CurrentY-1)){
            if(BoardArray[CurrentX][CurrentY-1]==42){
               splitX = CurrentX;
               splitY = CurrentY-1;
               dir4NoGraphic(LdestX, LdestY,splitX,splitY);
            }
            else if(BoardArray[CurrentX][CurrentY-1]==41){
               splitX = CurrentX;
               splitY = CurrentY-1;
               dir2NoGraphic(LdestX, LdestY,splitX,splitY);   
            }
            LdestX = LdestX-60;
            CurrentY--;   
         }

         newstartX = LdestX;
         newstartY = LdestY;
         CurrentY--;
         if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
            LaserIn[2][(LdestY-40)/12 + LdestX/60] = true;
         }

         if(XYinBoard(CurrentX,CurrentY)){
            if(BoardArray[CurrentX][CurrentY]==23 || BoardArray[CurrentX][CurrentY]==32 ){
               dir4NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
            else if(BoardArray[CurrentX][CurrentY]==24 || BoardArray[CurrentX][CurrentY]==31 ){
               dir2NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
         }   
      }
      public void dir4NoGraphic(int LstartX, int LstartY, int CurrentX, int CurrentY){
         int LdestY = LstartY+60; 
         int LdestX = LstartX;
         int splitX, splitY;
            
         while(passCheck(CurrentX+1, CurrentY)){
            if(BoardArray[CurrentX+1][CurrentY]==42){
               splitX = CurrentX+1;
               splitY = CurrentY;
               dir3NoGraphic(LdestX, LdestY,splitX,splitY);
            }
            else if(BoardArray[CurrentX+1][CurrentY]==41){
               splitX = CurrentX+1;
               splitY = CurrentY;
               dir1NoGraphic(LdestX, LdestY,splitX,splitY);   
            }
            LdestY = LdestY+60;
            CurrentX++;
         }

         newstartX = LdestX;
         newstartY = LdestY;
         CurrentX++;
         if(LdestX>10 &&LdestY>10 &&LdestX<300 &&LdestY<300){
            LaserIn[3][(LdestY-40)/12 + LdestX/60] = true;
         }

         if(XYinBoard(CurrentX,CurrentY)){
            if(BoardArray[CurrentX][CurrentY]==21 || BoardArray[CurrentX][CurrentY]==32 ){
               dir3NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
            else if(BoardArray[CurrentX][CurrentY]==24 || BoardArray[CurrentX][CurrentY]==31 ){
               dir1NoGraphic(newstartX,newstartY,CurrentX,CurrentY);
            }
         }   
      }
   
   public boolean onTarget(){
      int c = 0;
      for(int x = 0; x<5; x++){
         for(int y = 0; y<5; y++){
            if(BoardArray[x][y]==21 || BoardArray[x][y]==22 || 
                  BoardArray[x][y]==23 || BoardArray[x][y]==24){
               c++;
            }
         }
      }
      System.out.println("the Number of Target : "+c);
      System.out.println("the Number of Laser on Target : "+onTargetLaser);
      if (c > 0 && c == onTargetLaser) {
         return true;
      }
     return false;
   }
   // Ÿ���� ���� ���, Ÿ�ٿ� ���� ������ ���� ���
   
   public UI(){
      this.setLayout(new BorderLayout());
      JPanel Panel_btn = new JPanel();
      this.add(Panel_btn, BorderLayout.SOUTH);
      btn_Action.setSize(100, 50);
      btn_Action.addActionListener(btn_Ac);
      Panel_btn.add(btn_Action); // ��ư ����
      initBlocks();// UI������ ��� �ʱ�ȭ ����
      
      this.addMouseListener(new MouseListener() {
         
         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

            
            if(e.getX()>310 || e.getY()>310){
               if(clickedx<310 && clickedy<310){
                  block[Clickedblock].setX(blocksPosition[Clickedblock][0]);
                  block[Clickedblock].setY(blocksPosition[Clickedblock][1]);
                  BoardMapping();
                  repaint();
                  return;
               }
               block[Clickedblock].setX(superx);
               block[Clickedblock].setY(supery);
               BoardMapping();
               repaint();
               return;
            }
            //����� ������ ������ ����� ��� �ʱ� ��ġ�� �ǵ���
            
            block[Clickedblock].setX(((e.getX()-10)/60)*60+10);
            block[Clickedblock].setY(((e.getY()-10)/60)*60+10);
            BoardMapping();
            repaint();
            
            //������ ������ �ִ� ��� ��ġ ����
         }
         
         @Override
         public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            Point p = e.getPoint();
            clickedx = e.getX();
            clickedy = e.getY();
            for (int j = 0; j < block.length; j++) {
               if (block[j].contains(p)) {
                  Clickedblock = j;
                  superx = block[j].getX();
                  supery = block[j].getY();
                  break;
               }
            }
            repaint();
         }
         // �ǵ����� ���� �ش� ���� ����ġ ����
         
         @Override
         public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
         }
      });
      addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent e) {
            block[Clickedblock].setX(e.getX()-30);
            block[Clickedblock].setY(e.getY()-30);
            repaint();
         }
         // �巡�׵ɶ� ����� ������� 
      });
   }
   public void initBlocks(){
      
      for(int q = 0; q<5; q++){
         for(int w = 0; w<5; w++){
            BoardArray[q][w]=0;
         }
      }
      
      block = new Block[blocksPosition.length];
      for(int x = 0; x<block.length; x++){
         block[x] = new Block(blocksPosition[x][0],blocksPosition[x][1],blocksPosition[x][2]);
      }
      //��� ������ �迭 ������ �� ��� �ʱ�ȭ
   }
   public void BoardMapping(){
      //initiate Board Params
      for (int a = 0; a < 5; a++) {
         for (int b = 0; b < 5; b++) {
            BoardArray[a][b] = 0;
         }
      }
      
      //mapping
      for(int e = 0; e<block.length; e++){
         int blockX = (block[e].getX()-10)/60;
         int blockY = (block[e].getY()-10)/60;
         try{
            BoardArray[blockY][blockX] = block[e].getType();
         }
         catch(Exception ex){
         
         }
      }
      //Find target complete
      findTarget();

      printBoard();
   }
   public void findTarget() {
      int ontargetCount = 0;
    //Find target complete
         for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
               if(BoardArray[a][b] == 21 || BoardArray[a][b] == 22 ||
                     BoardArray[a][b] == 23 ||BoardArray[a][b] == 24){
                  switch(BoardArray[a][b]){
                     case 21: if(LaserIn[2][a*5+b]){
                        ontargetCount++;
                     }
                     break;
                     case 22: if(LaserIn[3][a*5+b]){
                        ontargetCount++;
                     }
                     break;
                     case 23: if(LaserIn[0][a*5+b]){
                        ontargetCount++;
                     }
                     break;
                     case 24: if(LaserIn[1][a*5+b]){
                        ontargetCount++;
                     }
                     break;
                  }
                  // Ÿ���� ��ġ�� ������ �´� �������� ���� ��� ī��Ʈ�� ++�Ͽ� Ÿ�ٿ� ������ ������ ���� �Ǻ�
               }
            }
         }
         onTargetLaser = ontargetCount;
         printBoard();
   }
   public void printBoard(){
      for(int q = 0; q<5; q++){
         for(int w = 0; w<5; w++){
            System.out.print(BoardArray[q][w]+" ");
         }
         System.out.println();
      }

      System.out.println();
            
   }
}
class Block{
   private int xPos;
   private int yPos;
   private int type;
   private int wh = 60;
   
   Block(int xPos, int yPos, int type){
      this.xPos = xPos;
      this.yPos = yPos;
      this.type = type;
   }

   public void setX(int xPos) {
      this.xPos = xPos;
   }

   public int getX() {
      return xPos;
   }

   public void setY(int yPos) {
      this.yPos = yPos;
   }

   public int getY() {
      return yPos;
   }

   public int getType() {
      return type;
   }

   public boolean contains(Point p) {
      return new Rectangle(xPos, yPos, wh, wh).contains(p);
   }
   
   public void paintBlock(Graphics g) {
      
      g.drawImage(image(type), xPos, yPos, wh, wh, null);
   }
   public static BufferedImage image(int type) {

      String filename = null;
      
      switch(type){
         case 11: filename = "blockimage\\RED_RIGHT.jpg"; break;
         case 12: filename = "blockimage\\RED_UP.jpg"; break;
         case 13: filename = "blockimage\\RED_LEFT.jpg"; break;
         case 14: filename = "blockimage\\RED_DOWN.jpg"; break;
         case 21: filename = "blockimage\\PURPLE_RIGHT.jpg"; break;
         case 22: filename = "blockimage\\PURPLE_UP.jpg"; break;
         case 23: filename = "blockimage\\PURPLE_LEFT.jpg"; break;
         case 24: filename = "blockimage\\PURPLE_DOWN.jpg"; break;
         case 31: filename = "blockimage\\BLUE_LEFT.jpg"; break;
         case 32: filename = "blockimage\\BLUE_RIGHT.jpg"; break;
         case 41: filename = "blockimage\\GREEN_LEFT.jpg"; break;
         case 42: filename = "blockimage\\GREEN_RIGHT.jpg"; break;
         case 5 : filename = "blockimage\\YELLOW.jpg"; break;
         case 4 : filename = "blockimage\\YELLOW1.jpg"; break;
         case 6 : filename = "blockimage\\BLACK.jpg"; break;
      }
      BufferedImage img = null;
      File file = null;

      try {
         file = new File(filename);
         img = ImageIO.read(file);

      } catch (Exception e) {
         // TODO: handle exception
      }
      
      return img;
   }
   
}