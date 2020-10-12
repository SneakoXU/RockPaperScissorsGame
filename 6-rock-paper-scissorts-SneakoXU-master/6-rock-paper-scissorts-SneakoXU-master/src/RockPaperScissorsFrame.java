import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    final int WIDTH = 650;
    final int HEIGHT = 400;
    JPanel top, middle, bottom, main;
    JButton rock, paper, scissors, quit, secondQ;
    JLabel playerWins, computerWins, ties;
    JTextField stats;
    JTextArea results;
    JScrollPane gameScroll;
    ImageIcon rockIcon, paperIcon, scissorsIcon, quitIcon;
    Random random = new Random();
    int playerWinTally = 0;
    int computerWinTally = 0;
    int tiesTally = 0;




    public RockPaperScissorsFrame(String title) {
        super("ROCK. PAPER. SCISSORS.");

        //top panel with RCP icons
        top = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border titled = BorderFactory.createTitledBorder(blackline, "Pick one.", TitledBorder.CENTER, TitledBorder.TOP, new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        top.setBorder(titled);
        rockIcon = new ImageIcon("RockPaperScissorsGame-master\\assets\\rock.jpg");
        Image rockImage = rockIcon.getImage();
        Image modRock = rockImage.getScaledInstance(125,125, Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon(modRock);
        rock = new JButton("Rock", rockIcon);
        rock.setVerticalTextPosition(SwingConstants.BOTTOM);
        rock.setHorizontalTextPosition(SwingConstants.CENTER);
        rock.addActionListener(actionEvent ->
                {
                    results.append("Your move: ROCK\n");
                    computer(0);
                }
                );

        paperIcon = new ImageIcon("RockPaperScissorsGame-master\\assets\\paper.jpg");
        Image paperImage = paperIcon.getImage();
        Image modPaper = paperImage.getScaledInstance(125,125, Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon(modPaper);
        paper = new JButton("Paper", paperIcon);
        paper.setVerticalTextPosition(SwingConstants.BOTTOM);
        paper.setHorizontalTextPosition(SwingConstants.CENTER);
        paper.addActionListener(actionEvent ->
                {
                    results.append("Your move: PAPER\n");
                    computer(1);
                }
        );

        scissorsIcon = new ImageIcon("RockPaperScissorsGame-master\\assets\\paper.jpg\\scissors.jpg");
        Image scissorsImage = scissorsIcon.getImage();
        Image modScissors = scissorsImage.getScaledInstance(125,125, Image.SCALE_SMOOTH);
        scissorsIcon = new ImageIcon(modScissors);
        scissors = new JButton("Scissors", scissorsIcon);
        scissors.setVerticalTextPosition(SwingConstants.BOTTOM);
        scissors.setHorizontalTextPosition(SwingConstants.CENTER);
        scissors.addActionListener(actionEvent ->
                {
                    results.append("Your move: SCISSORS\n");
                    computer(2);
                }
        );

        quitIcon = new ImageIcon("RockPaperScissorsGame-master\\assets\\quit.jpg");
        Image quitImage = quitIcon.getImage();
        Image modQuit = quitImage.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        quitIcon = new ImageIcon(modQuit);
        quit = new JButton("Quit", quitIcon);
        quit.setVerticalTextPosition(SwingConstants.BOTTOM);
        quit.setHorizontalTextPosition(SwingConstants.CENTER);
        quit.addActionListener(actionEvent ->
                {
                    System.exit(0);
                }
        );

        top.add(rock);
        top.add(paper);
        top.add(scissors);
        top.add(quit);

        //middle panel with the moves/results
        middle = new JPanel();
        results = new JTextArea(50,50);
        gameScroll = new JScrollPane(results);
        gameScroll.setPreferredSize(new Dimension(350,650));
        gameScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gameScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        results.setFont(new Font("Georgia", Font.PLAIN, 10));
        //gameScroll.add(results);
        middle.add(gameScroll);
        //middle.add(results);

        //bottom panel with the stats
        bottom = new JPanel();
        playerWins = new JLabel("Player wins: 0");
        computerWins = new JLabel("Computer wins: 0");
        ties = new JLabel("Ties: 0");
        bottom.add(playerWins);
        bottom.add(computerWins);
        bottom.add(ties);


        main = new JPanel();
        main.setLayout(new BorderLayout());
        main.add(top, BorderLayout.NORTH);
        main.add(middle, BorderLayout.CENTER);
        main.add(bottom, BorderLayout.SOUTH);

        add(main);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void computer(int playerMove){
        int computerMove = random.nextInt(3);

    if(computerMove == playerMove){
        if(computerMove == 0) {
            results.append("Computer selects ROCK\nResult: TIE!\n-------\n");
        }
        else if(computerMove == 1) {
            results.append("Computer selects PAPER\nResult: TIE!\n-------\n");
        }
        else{
            results.append("Computer selects SCISSORS\nResult: TIE!\n-------\n");
        }
        tiesTally++;
        ties.setText("Ties: " + tiesTally);
    }
    else if (computerMove == 0 && playerMove == 1){
        results.append("Computer selects ROCK\nResult: YOU WIN!\n-------\n");
        playerWinTally++;
    }
    else if (computerMove == 0 && playerMove == 2){
        results.append("Computer selects ROCK\nResult: WOMP, WOMP! YOU LOSE!\n-------\n");
        computerWinTally++;
    }
    else if (computerMove == 1 && playerMove == 0){
        results.append("Computer selects PAPER\nResult: WOMP, WOMP! YOU LOSE!\n-------\n");
        computerWinTally++;
    }
    else if (computerMove == 1 && playerMove == 2){
        results.append("Computer selects PAPER\nResult: YOU WIN!\n-------\n");
        playerWinTally++;
    }
    else if (computerMove == 2 && playerMove == 0){
        results.append("Computer selects SCISSORS\nResult: YOU WIN!\n-------\n");
        playerWinTally++;
    }
    else if (computerMove == 2 && playerMove == 1){
        results.append("Computer selects SCISSORS\nResult: WOMP, WOMP! YOU LOSE!\n-------\n");
        computerWinTally++;
    }
    playerWins.setText("Player wins: " + playerWinTally);
    computerWins.setText("Computer wins: " + computerWinTally);
    }
}
