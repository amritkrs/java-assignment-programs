package main.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.NullPointerException;
import main.utility.*;

/** 
	TicTacToe  server class can be run independently on its own,here it is one service.
	This server can handle multiple client on its own. It waits for 2 client to connect, then starts the game, and continue waiting for more client. 

*/
public class TicTacToeServer extends Thread
{

	public TicTacToeServer()
	{
		;
	}
	public void run()
	{
		ServerSocket listener = null;
		System.out.println("TicTacToeServer has started and running");
		try
		{
			listener = new ServerSocket(9108);
		}
		catch(IOException e)
		{
			System.out.println("An I/O error occured." + e);
		}
		catch(SecurityException e)
		{
			System.out.println("Security Exception" + e);
		}
		
		try
		{
			while(true)
			{
				Game game = new Game();	
				Game.Player playerX = game.new Player(listener.accept(),"X");
				Game.Player playerO = game.new Player(listener.accept(),"O");
				playerX.setOpponent(playerO);
				playerO.setOpponent(playerX);
				game.currentPlayer = playerX;
				playerX.start();
				playerO.start();
			}
		}
		catch(IOException e)
		{
			System.out.println("IOError " + e);
		}
		finally
		{
			try
			{
				listener.close();
			}
			catch(IOException e)
			{
				;
			}
		}
	}
}

/** 
	This handle the game aspect of tictactoe game, including board, currentplayer etc.
*/
class Game
{
		public String board[] = new String[9] ;
		Player currentPlayer;
		
		public void initializeBoard()
		{
			for(int i=0; i<9; i++)
				board[i] = " ";
		}
		
		public boolean checkWinner()
		{
			int flagX = 0;
			int flagO = 0;
			for(int j=0; j<9; j += 3)
			{
				flagX = 0;
				flagO = 0;
				
				for(int i=0; i<3; i++)
				{	
					if(board[i+j].equals("X"))
						flagX += 1;
					else if(board[i+j].equals("O"))
						flagO += 1;
				}
				
				if(flagX == 3)
					return true;
				else if(flagO == 3)
					return true;
			}
			
			for(int j=0; j<3; j++)
			{
				flagX = 0;
				flagO = 0;
				
				for(int i=0; i<9; i+= 3)
				{
					if(board[i+j].equals("X"))
						flagX += 1;
					else if(board[i+j].equals("O"))
						flagO += 1;
				}
				
				if(flagX == 3)
					return true;
				else if(flagO == 3)
					return true;
			}
			
			if(board[0].equals("X") && board[4].equals("X") && board[8].equals("X"))
				return true;
			else if(board[2].equals("X") && board[4].equals("X") && board[6].equals("X"))
				return true;
			else if(board[0].equals("O") && board[4].equals("O") && board[8].equals("O"))
				return true;
			else if(board[2].equals("O") && board[4].equals("O") && board[6].equals("O"))
				return true;
				
			return false;
		}
		
		/** 
			this method is synchronized as it changes properties shared by both clients.
		*/
		public synchronized boolean isLegalMove(int location , Player player)
		{
			//System.out.println(board[1].equals(" "));
			if(player == currentPlayer && board[location].equals(" "))
			{
				board[location] = player.symbol;
				currentPlayer = player.opponent;
				currentPlayer.otherPlayerMoved(location);
				return true;
			}
			return false;
		}
		
		public boolean checkBoardFull()
		{
			int i = 0;
			for(i=0; i<9 ; i++)
			{
				if(board[i].equals(" "))
					return false;
			}
			
			return true;
		}
		
		/**
			Player class emulate player and manages their moves and keep sufficient information to handleevery unknown condition.
		*/
		class Player extends Thread
		{
			String symbol;
			Player opponent;
			Socket socket;
			BufferedReader input;
			PrintWriter output;
			
			public Player(Socket socket, String symbol)
			{
				this.socket = socket;
				this.symbol = symbol;
				initializeBoard();
				try
				{
					input = new BufferedReader(new InputStreamReader( socket.getInputStream()));
					output = new PrintWriter( socket.getOutputStream(),true);
					output.println("WELCOME " + symbol);
					output.println("MESSAGE waiting for opponent to connect");
				}
				catch(IOException e)
				{
					System.out.println("Player terminated" + e);
				}
			}
			
			public void setOpponent(Player opponent)
			{
				this.opponent = opponent;
			}
			
			public void otherPlayerMoved(int location)
			{
				output.println("OPPONENT_MOVED " + location );
				output.println(checkWinner() ? "DEFEAT" : checkBoardFull() ? "TIE" : "");
			}
			
			public void terminate()
			{
				output.println("TERMINATE ");
			}
			
			public void run()
			{
				try
				{
					output.println("All Players Connected");
					
					if(symbol.equals("X"))
						output.println("MESSAGE Your Move");
					else
						output.println("Waiting for opponent to move");
					
					while(true)
					{
						String command = input.readLine();
						//System.out.println(command);
						if(command.startsWith("MOVE"))
						{
							int location = Integer.parseInt(command.substring(5));
							//System.out.println(location);
							if(isLegalMove(location,this))
							{
								output.println("VALID_MOVE");
								output.println(checkWinner() ? "VICTORY" : checkBoardFull() ? "TIE" : "");
							}
							else
							{
								output.println("MESSAGE ?");
							}
						}
						else if(command.startsWith("QUIT"))
						{
							return;
						}	
					}
				}
				catch(IOException e)
				{
					System.out.println("Player terminated" + e);
				}
				catch(NullPointerException e)
				{
					opponent.terminate();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
					
				finally
				{
					try
					{
						socket.close();
					}
					catch(IOException e)
					{
						;//Do Nothing.
					}
				}
			}
		}
	
}
					
				
			
			
				
		
	
	
				
				
				
				
				
				
				
	