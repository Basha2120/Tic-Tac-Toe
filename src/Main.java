import java.util.*;
public class Main {
    static String[] board;
    static String turn;

    public static String checkWinner()
    {
        // To check the row,column,and diagonals to determine the winner
        for(int i=0;i<8;i++)
        {
            String line=null;
            switch(i)
            {
                case 0:
                    line=board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[3]+board[6];
                    break;
                case 4:
                    line=board[1]+board[4]+board[7];
                    break;
                case 5:
                    line=board[2]+board[5]+board[8];
                    break;
                case 6:
                    line=board[0]+board[4]+board[8];
                    break;
                case 7:
                    line=board[2]+board[4]+board[6];
                    break;
            }

            if(line.equals("XXX"))
            {
                return "X";
            }
            else if(line.equals("OOO"))
            {
                return "O";
            }
        }

        for(int i=0;i<9;i++)
        {
            if(Arrays.asList(board).contains(String.valueOf(i+1)))
            {
                break;
            }
            else if(i==8) {
                return "Draw"; //If every slot is filled , It is a Draw
            }
        }

        System.out.println(turn+"'s turn. "+turn+" Enter your slot.");
        return null;
    }

    public static void printBoard(){
        System.out.println("-------------");
        System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
        System.out.println("-------------");
        System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
        System.out.println("-------------");
        System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
        System.out.println("-------------");

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        board=new String[9];
        turn="X";
        String winner=null;
        for(int i=0;i<9;i++)
        {
            board[i]=String.valueOf(i+1);
        }
        System.out.println("Welcome to Tic-Tac-Toe Game");
        Main.printBoard();
        System.out.println("Game Starts with X. X Enter your slo.t");

        while(winner==null)
        {
            int input;
            try{
                input=sc.nextInt();
                if(!(input>0 && input<=9)) // Invalid input logic
                {
                    System.out.println("Enter a valid Input.");
                    continue;
                }
                if(board[input-1].equals(String.valueOf(input)))
                {
                    board[input-1]=turn;
                    turn=(turn.equals("X"))?"O":"X"; // Toggle operation to switch turn

                    Main.printBoard();
                    winner=checkWinner();
                }
                else{
                    System.out.println("Slot already booked.");
                }
            }
            catch(InputMismatchException e) // Catches anything other than Integer is given as input
            {
                System.out.println("Enter a valid Slot number.");
                sc.nextLine();
            }
        }
        if (winner.equalsIgnoreCase("Draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
        sc.close();
    }
}