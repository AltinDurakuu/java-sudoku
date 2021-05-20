import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Logic implements KeyListener{
        private int patternOfGame;
        private int randomNumsToShow;

        private JTextField cells[][] = new JTextField[9][9];

        //Disa game te ndryshme sudoku
        private int gameSolution[][][] = {
                {       {9, 7, 1, 2, 4, 5, 6, 3, 8},
                        {2, 8, 4, 7, 6, 3, 9, 1, 5},
                        {6, 5, 3, 1, 9, 8, 4, 2, 7},
                        {5, 4, 6, 3, 7, 1, 8, 9, 2},
                        {3, 2, 8, 4, 5, 9, 1, 7, 6},
                        {1, 9, 7, 8, 2, 6, 5, 4, 3},
                        {4, 6, 9, 5, 3, 7, 2, 8, 1},
                        {7, 1, 2, 6, 8, 4, 3, 5, 9},
                        {8, 3, 5, 9, 1, 2, 7, 6, 4}
                        },
                {       {4, 9, 8, 1, 6, 5, 2, 7, 3},
                        {2, 7, 5, 8, 3, 4, 9, 6, 1},
                        {6, 1, 3, 9, 7, 2, 4, 8, 5},
                        {9, 8, 2, 6, 5, 7, 1, 3, 4},
                        {5, 4, 7, 3, 1, 9, 8, 2, 6},
                        {1, 3, 6, 4, 2, 8, 7, 5, 9},
                        {8, 6, 1, 7, 4, 3, 5, 9, 2},
                        {3, 2, 9, 5, 8, 1, 6, 4, 7},
                        {7, 5, 4, 2, 9, 6, 3, 1, 8}
                },
                {       {9, 1, 3, 4, 2, 7, 6, 5, 8},
                        {6, 8, 7, 9, 1, 5, 4, 3, 2},
                        {2, 5, 4, 6, 8, 3, 9, 1, 7},
                        {3, 4, 5, 8, 7, 1, 2, 9, 6},
                        {7, 2, 6, 3, 4, 9, 5, 8, 1},
                        {8, 9, 1, 2, 5, 6, 7, 4, 3},
                        {1, 6, 2, 5, 9, 8, 3, 7, 4},
                        {4, 7, 9, 1, 3, 2, 8, 6, 5},
                        {5, 3, 8, 7, 6, 4, 1, 2, 9}
        },
        };

        //Shfaqja e numrave fillestare te cilet nuk mund te editohet
        private boolean toEdit[][][] = {
                {       {true, true, true, true, true, true, true, true, true},
                        {false, true, true, true, true, false, false, true, true},
                        {true, false, true, false, true, true, false, true, true},
                        {true, true, false, false, true, true, true, false, true},
                        {true, true, true, true, true, true, true, false, false},
                        {true, false, true, false, true, true, false, true, true},
                        {true, false, true, true, true, false, true, true, true},
                        {true, false, true, true, true, false, false, true, true},
                        {true, true, false, true, true, false, false, true, false}
                },
                {       {true, false, false, false, true, true, true, true, true},
                        {true, true, true, false, false, true, true, false, false},
                        {false, false, true, true, true, true, false, false, true},
                        {false, true, true, true, false, false,  true, true, true},
                        {false, true, true, true, true, true, true, true, true},
                        {false, false, false, true, true, true, false, false, false},
                        {false, true, true, false, true, true, false, true, false},
                        {true, true, true, false, true, true, true, false, true},
                        {true, false, true, true, false, true, false, false, true}
                 },
                {       {false, true, false, false, true, true, true, true, false},
                        {true, true, false, false, true, true, true, false, true},
                        {true, true, true, true, false, true, true, false, true},
                        {true, false, false, true, false, true, false, false, true},
                        {false, true, true, false, false, true, false, true, false},
                        {false, true, true, true, true, false, true, true, true},
                        {true, false, true, true, true, false, true, true, true},
                        {true, true, true, false, false, true, true, true, false},
                        {true, false, false, true, false, true, true, true, true}
                 },
        };

            public  Logic() {
                patternOfGame = (int) ((Math.random() * 3));
                randomNumsToShow = (int) ((Math.random() * 3));
            }

        public void uneditableNums(){
            for (int i = 0; i < gameSolution[patternOfGame].length; i++) {
                for (int j = 0; j < gameSolution[patternOfGame][i].length; j++) {
                    if (!toEdit[randomNumsToShow][i][j]){
                        cells[i][j].setText(String.valueOf(gameSolution[patternOfGame][i][j]));
                        cells[i][j].setEditable(false);
                        cells[i][j].setBackground(new Color(80, 89, 145));
                    }
                }
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(!cells[i][j].getText().isEmpty() && cells[i][j].isEditable()) {
                        if (Integer.parseInt(cells[i][j].getText()) != (gameSolution[patternOfGame][i][j])) {
                            cells[i][j].setBackground(new Color(232, 2, 2));
                        }else{
                            cells[i][j].setBackground(new Color(73, 176, 0));
                        }
                    }else if (cells[i][j].isEditable()){
                        cells[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        }

        public JTextField[][] getCells(){
            return cells;
        }
}
