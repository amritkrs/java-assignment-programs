package main.tictactoe;

import main.tictactoe.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import main.utility.*;


public class TicTacToeClient
{
	private String symbol;
	private String opponentSymbol;
	private String board[] = new String[9];
	private Socket socket;
	private static int PORT = 9108;
	private BufferedReader input;
	private PrintWriter output;
	private int ans;	//to keep track of my move
	
	public TicTacToeClient(String serverIP) throws Exception
	{
		socket = new Socket(serverIP,PORT);
		input = new BufferedReader( new InputStreamReader( socket.getInputStream()));
		output = new PrintWriter(socket.getOutputStream(),true);
		initializeBoard();
		printBoard();
	}
	
	public void initializeBoard()
	{
		for(int i=0; i<9; i++)
		{
			board[i] = " ";
		}
		
	}
	
	public static void print(String s)
	{
		System.out.println(s);
	}
	
	public void printBoard()
	{
		for(int i = 0; i < 80 ; i++)
		{
			System.out.print("\n");
		}
		
		print("\t" + board[0] + "____|" + board[1] + "____|" + board[2] + "____" + "\t\t\t1____|2____|3____");
		//print("\t     |     |     ");
		print("\t" + board[3] + "____|" + board[4] + "____|" + board[5] + "____" + "\t\t\t4____|5____|6____");
		//print("\t     |     |     ");
		print("\t" + board[6] + "    |" + board[7] + "    |" + board[8] + "    " + "\t\t\t7    |8    |9    ");
		//print("\t     |     |     \n");
		
		for(int i=0; i<10; i++)
		{
			System.out.print("\n");
			
		}
	}
	
	
	
	public void play() throws Exception
	{
		String response;
		try
		{
			response = input.readLine();
			if(response.startsWith("WELCOME"))
			{
				symbol = response.substring(8);
				opponentSymbol = (symbol.equals("X") ? "O" : "X");
			}
			print(input.readLine());
			
			while(true)
			{
				response = input.readLine();
				if(response.startsWith("VALID_MOVE"))
				{
					board[ans] = symbol;
					printBoard();
					print("Valid move, please wait");
					
				}
				else if(response.startsWith("OPPONENT_MOVED"))
				{
					int location = Integer.parseInt(response.substring(15));
					board[location] = opponentSymbol;
					printBoard();
					response = input.readLine();
					if(response.equals(""))
					{
						print("Opponent Moved, your turn");
						playMove();
					}
					else
					{
						print(response);
						break;
					}
				}
				else if(response.startsWith("VICTORY"))
				{
					print("You Win");
					break;
				}
				else if(response.startsWith("DEFEAT"))
				{
					print("You lose");
					break;
				}
				else if(response.startsWith("TIE"))
				{
					print("Game is tied");
					break;
				}
				else if(response.startsWith("MESSAGE Your Move"))
				{
					print(response);
					playMove();
				}
				else if(response.startsWith("MESSAGE ?"))
				{
					print("Invalid Move");
					playMove();
				}
				else if(response.startsWith("All"))
				{
					print(response);
				}
				else if(response.startsWith("TERMINATE"))
				{
					
					print("Your opponent left the game in middle,and hence terminating you.");
					break;
				}
				else
				{
					print(response);
				}
			}
			
			output.println("QUIT");
		}
		finally
		{
			socket.close();
		}
	}
	
	private void playMove()
	{
		while(true)
		{
			ans = Validator.getInt("Enter the position number as shown right to board <1-9> : ");
			if(ans <= 9 && ans >= 1)
			{
				ans = ans - 1;
				output.println("MOVE " + ans);
				break;
			}
			else
			{
				print("Invalid Entry");
			}
		}
	}
	private static boolean wantsToPlayAgain()
	{
		if(Validator.getString("DO YOU WISH TO PLAY AGAIN : <y/n> : ").toLowerCase().equals("y"))
			return true;
		else
			return false;
	}
	
	public static void play(String serverAddress)
	{
		TicTacToeClient client;
		try
		{
			do
			{
				client = new TicTacToeClient(serverAddress);
				client.play();
			}while(wantsToPlayAgain());
		}
		catch(Exception e)
		{
			print("\nServer address should be given as commandline argument ,unless server is a localhost\nserver might not be running, or wrong server address");
		}
	}
	
	
// 	public static void main(String[] args)
// 	{
// 		String serverAddress = (args.length == 0) ? "localhost" : args[0];
// 		TicTacToeClient client;
// 		try
// 		{
// 			do
// 			{
// 				client = new TicTacToeClient(serverAddress);
// 				client.play();
// 			}while(wantsToPlayAgain());
// 		}
// 		catch(Exception e)
// 		{
// 			print("\nServer address should be given as commandline argument ,unless server is a localhost\nserver might not be running, or wrong server address");
// 		}
// 	}
// 	
}