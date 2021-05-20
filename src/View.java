import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View {
    Logic sudokuLogic = new Logic();
    private JFrame gameFrame = new JFrame(); //Krijimi i nje objekti JFrame

    //Krijimi 81 JTextField qe vendosen ne frame me layout grid
    public void SudokuFrame(){
        gameFrame.setLayout(new GridLayout(9,9));
        Font bigFont = new Font("sans-serif", Font.BOLD, 24);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField cell = new JTextField();
                gameFrame.add(cell);
                cell.addKeyListener(sudokuLogic);
                cell.setFocusable(true);
                sudokuLogic.getCells()[i][j] = cell;
                cell.setFont(bigFont);
                cell.setHorizontalAlignment(JTextField.CENTER);
                Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY);
                sudokuLogic.getCells()[i][j].setBorder(border);
                if (i % 3 == 0 && i > 0){
                    Border newBorder = BorderFactory.createMatteBorder(10, 2, 2, 2, Color.GRAY);
                    sudokuLogic.getCells()[i][j].setBorder(newBorder);
                }
                if (j % 3 == 2 && j < 8){
                    Border newBorder = BorderFactory.createMatteBorder(2, 2, 2, 10, Color.GRAY);
                    sudokuLogic.getCells()[i][j].setBorder(newBorder);
                }
                if ((i%3==0 && j%3 == 2 && i>0 && j<8)){
                    Border newBorder = BorderFactory.createMatteBorder(10, 2, 2, 10, Color.GRAY);
                    sudokuLogic.getCells()[i][j].setBorder(newBorder);
                }
            }
        }
        sudokuLogic.uneditableNums(); //Shfaqja e numrave fillestare(default) ne sudoku, keta numra nuk mund te ndryshohen
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(532, 532);
        gameFrame.setTitle("Sudoku");
        gameFrame.setVisible(true); //Shfaqja e kornizez;
    }
}