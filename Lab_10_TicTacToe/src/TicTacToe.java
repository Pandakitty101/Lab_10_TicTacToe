import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    private static Scanner in = new Scanner(System.in);

        public static void main (String[]args)
        {

            boolean playAgain = false;

            do{
                String player = "X";
                int moves = 0;

                clearBoard();

                do {

                    showBoard();

                    if (moves == 0) {
                        player = "X";
                    }
                    else {
                        if (player.equals("X")) {
                            player = "O";
                        }
                        else if (player.equals("O")) {
                            player = "X";
                        }
                    }
                    boolean gotValidMove = false;

                    do {
                        // get player input and subtract by 1
                        int playerRowMove = SafeInput.getRangedInt(in, "Player " + player + " move. Which row do you want to play in", 1, 3);
                        playerRowMove -= 1;

                        int playerColMove = SafeInput.getRangedInt(in, "Player " + player + " move. Which column do you want to play in", 1, 3);
                        playerColMove -= 1;

                        if (isValidMove(playerRowMove, playerColMove)) {

                            board[playerRowMove][playerColMove] = player;
                            gotValidMove = true;
                        }
                        else{

                            gotValidMove = false;
                        }
                    }
                    while(!gotValidMove);


                    moves += 1;
                }
                while(!gameOver(player));


                showBoard();

                if (isWin(player)) {
                    System.out.println("\nPlayer " + player + " wins!");
                } else if (isTie()) {
                    System.out.println("\nIt's a tie!");
                }

                String response;
                response = SafeInput.getYNConfirm(in, "Do you want to play again?");
                if (response.equalsIgnoreCase("y")) {
                    playAgain = true;
                } else if (response.equalsIgnoreCase("n")) {
                    playAgain = false;
                }
            }while (playAgain);

        }

        private static void clearBoard ()
        {
            for (int row = 0; row < ROW; row++)
            {
                for (int col = 0; col < COL; col++)
                {
                    board[row][col] = " ";
                }
            }
        }

    private static void showBoard()
        {
            for (int row = 0; row < ROW; row++)
            {
                for (int col = 0; col < COL; col++)
                {
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println("");
            }
        }


        private static boolean isValidMove(int row, int col) {
            if (board[row][col].equals(" "))
            {
                return true;
            }
            return false;


        }

        private static boolean gameOver(String player) {
            if (isWin(player) || isTie()) {
                return true;
            }
            return false;
        }

        private static boolean isTie() {
            if (rowOneTie() && rowTwoTie() && rowThreeTie() && colOneTie() && colTwoTie() && colThreeTie() && diagOneTie() && diagTwoTie()) {
                return true;
            }
            return false;
        }

        private static boolean rowOneTie() {
            if (board[0][0].equals("X")) {
                if (board[0][1].equals("O") || board[0][2].equals("O")) {
                    return true;
                }
            }
            else if (board[0][0].equals("O")) {
                if (board[0][1].equals("X") || board[0][2].equals("X")) {
                    return true;
                }
            }
            else if (board[0][0].equals(" ")) {
                if (board[0][1].equals("X") && board[0][2].equals("O")) {
                    return true;
                }
                else if (board[0][1].equals("O") && board[0][2].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean rowTwoTie() {
            if (board[1][0].equals("X")) {
                if (board[1][1].equals("O") || board[1][2].equals("O")) {
                    return true;
                }
            }
            else if (board[1][0].equals("O")) {
                if (board[1][1].equals("X") || board[1][2].equals("X")) {
                    return true;
                }
            }
            else if (board[1][0].equals(" ")) {
                if (board[1][1].equals("X") && board[1][2].equals("O")) {
                    return true;
                }
                else if (board[1][1].equals("O") && board[1][2].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean rowThreeTie() {
            if (board[2][0].equals("X")) {
                if (board[2][1].equals("O") || board[2][2].equals("O")) {
                    return true;
                }
            }
            else if (board[2][0].equals("O")) {
                if (board[2][1].equals("X") || board[2][2].equals("X")) {
                    return true;
                }
            }
            else if (board[2][0].equals(" ")) {
                if (board[2][1].equals("X") && board[2][2].equals("O")) {
                    return true;
                }
                else if (board[2][1].equals("O") && board[2][2].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean colOneTie() {
            if (board[0][0].equals("X")) {
                if (board[1][0].equals("O") || board[2][0].equals("O")) {
                    return true;
                }
            }
            else if (board[0][0].equals("O")) {
                if (board[1][0].equals("X") || board[2][0].equals("X")) {
                    return true;
                }
            }
            else if (board[0][0].equals(" ")) {
                if (board[1][0].equals("X") && board[2][0].equals("O")) {
                    return true;
                }
                else if (board[1][0].equals("O") && board[2][0].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean colTwoTie() {
            if (board[0][1].equals("X")) {
                if (board[1][1].equals("O") || board[2][1].equals("O")) {
                    return true;
                }
            }
            else if (board[0][1].equals("O")) {
                if (board[1][1].equals("X") || board[2][1].equals("X")) {
                    return true;
                }
            }
            else if (board[0][1].equals(" ")) {
                if (board[1][1].equals("X") && board[2][1].equals("O")) {
                    return true;
                }
                else if (board[1][1].equals("O") && board[2][1].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean colThreeTie() {
            if (board[0][2].equals("X")) {
                if (board[1][2].equals("O") || board[2][2].equals("O")) {
                    return true;
                }
            }
            else if (board[0][2].equals("O")) {
                if (board[1][2].equals("X") || board[2][2].equals("X")) {
                    return true;
                }
            }
            else if (board[0][2].equals(" ")) {
                if (board[1][2].equals("X") && board[2][2].equals("O")) {
                    return true;
                }
                else if (board[1][2].equals("O") && board[2][2].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean diagOneTie() {
            if (board[0][0].equals("X")) {
                if (board[1][1].equals("O") || board[2][2].equals("O")) {
                    return true;
                }
            }
            else if (board[0][0].equals("O")) {
                if (board[1][1].equals("X") || board[2][2].equals("X")) {
                    return true;
                }
            }
            else if (board[0][0].equals(" ")) {
                if (board[1][1].equals("X") && board[2][2].equals("O")) {
                    return true;
                }
                else if (board[1][1].equals("O") && board[2][2].equals("X")) {
                    return true;
                }
            }
            return false;
        }

        private static boolean diagTwoTie() {
            if (board[2][0].equals("X")) {
                if (board[1][1].equals("O") || board[0][2].equals("O")) {
                    return true;
                }
            }
            else if (board[2][0].equals("O")) {
                if (board[1][1].equals("X") || board[0][2].equals("X")) {
                    return true;
                }
            }
            else if (board[2][0].equals(" ")) {
                if (board[1][1].equals("X") && board[0][2].equals("O")) {
                    return true;
                }
                else if (board[1][1].equals("O") && board[0][2].equals("X")) {
                    return true;
                }
            }
            return false;
        }


        private static boolean isWin(String player)
        {
            if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
            {
                return true;
            }
            return false;
        }

        private static boolean isRowWin(String player)
        {
            for(int row = 0; row < ROW; row++)
            {
                if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
                {
                    return true;
                }
            }
            return false; // no row win;
        }

        private static boolean isColWin(String player)
        {
            for(int col = 0; col < COL; col++)
            {
                if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
                {
                 return true;
                }
            }
            return false; // no row win;
        }

        private static boolean isDiagonalWin(String player)
        {
            if((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            {
                return true;
            }
            return false; // no row win;
        }

        }

