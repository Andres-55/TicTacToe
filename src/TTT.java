import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TTT implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JLabel tryAgaintxt = new JLabel();
    JLabel xWin = new JLabel();
    JLabel oWin = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton tryAgainButton = new JButton();
    boolean player1_Turn;
    int xAmount = 0;
    int oAmount = 0;

    TTT()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(87, 23, 124));
        textField.setFont(new Font("Impact", Font.PLAIN, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        xWin.setBackground(new Color(25, 25, 25));
        xWin.setForeground(new Color(87, 23, 124));
        xWin.setFont(new Font("Impact", Font.PLAIN, 40));
        xWin.setHorizontalAlignment(JLabel.CENTER);
        xWin.setText("X-Wins: " + xAmount);
        xWin.setOpaque(true);

        oWin.setBackground(new Color(25, 25, 25));
        oWin.setForeground(new Color(87, 23, 124));
        oWin.setFont(new Font("Impact", Font.PLAIN, 40));
        oWin.setHorizontalAlignment(JLabel.CENTER);
        oWin.setText("O-Wins: " + oAmount);
        oWin.setOpaque(true);

        tryAgaintxt.setBackground(new Color(201, 14, 14));
        tryAgaintxt.setForeground(new Color(255, 255, 255));
        tryAgaintxt.setFont(new Font("Impact", Font.PLAIN, 50));
        tryAgaintxt.setHorizontalAlignment(JLabel.CENTER);
        tryAgaintxt.setText("Play Again?");
        tryAgaintxt.setOpaque(true);


        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        titlePanel.setBackground(new Color(157, 152, 152));

        tryAgainButton.setVisible(false);
        tryAgainButton.setEnabled(false);
        tryAgainButton.setLayout(new BorderLayout());
        tryAgainButton.setBounds(0, 690, 7900, 75);
        tryAgainButton.setBackground(new Color(169, 4, 4));
        tryAgainButton.setFocusable(true);
        tryAgainButton.addActionListener(this);



        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(16, 14, 14));
        }

        titlePanel.add(textField);
        titlePanel.add(xWin, BorderLayout.WEST);
        titlePanel.add(oWin, BorderLayout.EAST);
        tryAgainButton.add(tryAgaintxt);
        frame.add(tryAgainButton, BorderLayout.SOUTH);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);


         try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("hi");
        if(e.getSource() == tryAgainButton)
        {
            System.out.println("hi2");
            tryAgainButton.setVisible(false);
            tryAgainButton.setEnabled(false);

            for(int i = 0; i < 9;  i++)
            {
                buttons[i].setText("");
                buttons[i].setBackground(new Color(16, 14, 14));
                buttons[i].setEnabled(true);
            }

            firstTurn();
        }

        else
        {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    if (player1_Turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText("X");
                            player1_Turn = false;
                            textField.setText("O turn");
                            check();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(31, 50, 169));
                            buttons[i].setText("O");
                            player1_Turn = true;
                            textField.setText("X turn");
                            check();
                        }
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        if(random.nextInt(2) == 0)
        {
            player1_Turn = true;
            textField.setText("X turn");
        }

        else
        {
            player1_Turn = false;
            textField.setText("O turn");
        }

    }

    public void check()
    {
        if(buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X")
        {
            xWins(0, 1, 2);
        }

        else if(buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X")
        {
            xWins(3, 4, 5);
        }

        else if(buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X")
        {
            xWins(6, 7, 8);
        }

        else if(buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X")
        {
            xWins(0, 3, 6);
        }

        else if(buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X")
        {
            xWins(1, 4, 7);
        }

        else if(buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X")
        {
            xWins(2, 5, 8);
        }

        else if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X")
        {
            xWins(0, 4, 8);
        }

        else if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X")
        {
            xWins(2, 4, 6);
        }

        else if(buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O")
        {
            oWins(0, 1, 2);
        }

        else if(buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O")
        {
            oWins(3, 4, 5);
        }

        else if(buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O")
        {
            oWins(6, 7, 8);
        }

        else if(buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O")
        {
            oWins(0, 3, 6);
        }

        else if(buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O")
        {
            oWins(1, 4, 7);
        }

        else if(buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O")
        {
            oWins(2, 5, 8);
        }

        else if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O")
        {
            oWins(0, 4, 8);
        }

        else if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O")
        {
            oWins(2, 4, 6);
        }

        else if(buttons[0].getText() != "" && buttons[1].getText() != "" && buttons[2].getText() != "" && buttons[3].getText() != "" && buttons[4].getText() != "" && buttons[5].getText() != "" && buttons[6].getText() != "" && buttons[7].getText() != "" && buttons[8].getText() != "" )
        {
            tie();
        }
    }

    public void xWins(int a, int b, int c)
    {
        buttons[a].setBackground(new Color(49, 213, 26));
        buttons[b].setBackground(new Color(49, 213, 26));
        buttons[c].setBackground(new Color(49, 213, 26));

        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins");
        xAmount++;
        xWin.setText("X Wins: " + xAmount);

        tryAgainButton.setVisible(true);
        tryAgainButton.setEnabled(true);
    }

    public void oWins(int a, int b, int c)
    {
        buttons[a].setBackground(new Color(49, 213, 26));
        buttons[b].setBackground(new Color(49, 213, 26));
        buttons[c].setBackground(new Color(49, 213, 26));

        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");
        oAmount++;
        oWin.setText("O Wins: " + oAmount);

        tryAgainButton.setVisible(true);
        tryAgainButton.setEnabled(true);
    }

    public void tie()
    {
        for(int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("Tie");

        tryAgainButton.setVisible(true);
        tryAgainButton.setEnabled(true);
    }
}
