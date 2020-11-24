import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private Container pane;
    private String currentPlayer;
    private JButton[][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    public GUI(){
        super();
        pane = getContentPane();
        pane.setLayout(new GridLayout(3,3));
        setTitle("Крестики нолики");
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        currentPlayer="x";
        board = new JButton[3][3];
        hasWinner=false;
        initializeBoard();
        initializeMenuBar();

    }
    private void initializeMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("Файл");
        newGame = new JMenuItem("Новая игра");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });
        quit = new JMenuItem("Закрить");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    private void resetBoard(){
        currentPlayer = "x";
        hasWinner=false;
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j].setText("");
            }
        }
    }
    private void initializeBoard(){
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                JButton btn = new JButton();
                board[i][j]=btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().equals("")&&
                                hasWinner == false){
                            btn.setText(currentPlayer);
                            hasWinner();
                            togglePlayer();
                        }
                    }
                });
                pane.add(btn);
            }
        }
    }
    private void togglePlayer(){
        if(currentPlayer.equals("x"))
            currentPlayer = "o";
        else
            currentPlayer = "x";
    }

    private void hasWinner() {
        if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        } else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Игрок " + currentPlayer + " победил");
            hasWinner = true;
        }
    }



}
