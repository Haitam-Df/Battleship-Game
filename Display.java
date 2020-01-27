import java.util.Scanner;
import java.util.Random;

public class Display {
	
	Scanner keyboard = new Scanner(System.in);
	private char [][] grid = new char [8][8];
	private char [][] display = new char [8][8];
	private int shipsH = 0;
	private int shipsC = 0;
	private int grenadeH = 2;
	private int grenadeC = 2;
	private int totalNade = 0;
	
	/**
	 * 
	 */
	public Display(){
		display = display;
		grid = grid;
	}
	
	
	
	public char [] [] ships() 
	{
		System.out.println("Hi, lets play battleship!");
		int shipc = 1;
		String input;
		
		while (shipc != 7)
		{
			System.out.print("Enter the coordinates of your ship #"+shipc+": ");
			
			input = keyboard.next();
			int letter = input.toUpperCase().charAt(0) - 'A';
			int number = input.charAt(1) - '1'; 
		
		
		if(letter <0 || letter >7 || number <0 || number >7)
		{
			System.out.println("Sorry, coordinates outside the grid. Try again.");
		}
		
		if(letter>=0 && letter<=7 && number >=0 && number <=7)
		{
			String verifys = String.valueOf(grid[letter][number]);
			
			if((verifys).equals("s"))
			{
				System.out.println("sorry, coordinates already used. try again.");
			}
			else
			{
			grid[letter][number] = 's';
			shipc++;
			}
		
		}
		
		
		}
		return grid;

	}
	
	
	
	public char [][] grenades()
	{	
		String input;
		int nadec = 1;
		
		while( nadec !=5){
			
			System.out.print("Enter the coordinates of your grenade #"+nadec+": ");
			
			input = keyboard.next();
			int letter = input.toUpperCase().charAt(0) - 'A';
			int number = input.charAt(1) - '1'; 
			
			if(letter <0 || letter >7 || number <0 || number >7)
			{
				System.out.println("sorry, coordinates outside the grid. try again.");
			}
			
			if(letter >=0 && letter <=7 && number >=0 && number <=7){
				
				String verifyg = String.valueOf(grid[letter][number]);
				if((verifyg).equals("g")||(verifyg).equals("s"))
				{
					System.out.println("sorry, coordinates already used. try again.");
				}
			
				else
				{
				grid[letter][number] = 'g';
				nadec++;
				}
			}
		}
		
		return grid;
	}
	
	
	
	
	
	public char[][] shipC()
	{
		int SCounter = 1;
		Random sr = new Random();
		
		while(SCounter !=7)
		{
			int letter = sr.nextInt(8);
			int number = sr.nextInt(8);
			
		
			 if(letter>=0 && letter<=7 && number >=0 && number <=7){
				 
			String verifys = String.valueOf(grid[letter][number]);
			
			if((verifys).equals("g") || (verifys).equals("s") || (verifys).equals("S")){
				
			
				
			}else{
			grid[letter][number] = 'S';
			SCounter++;
			
	   }
		}
		}
		return grid;
	}
	
	
	
	
	
	public char[][] grenadeC()
	{
		int GCounter = 1;
		Random gr = new Random();
		
		while(GCounter !=5)	
		{
			int letG = gr.nextInt(8);
			int numG = gr.nextInt(8);
		
				 
			String verifyG = String.valueOf(grid[letG][numG]);
			
			if(verifyG.equals("g") || verifyG.equals("s") || verifyG.equals("G") || verifyG.equals("S"))
			{
			
			}else{
			
			grid[letG][numG] = 'G';
			GCounter++;
		}
			 
		}
		return grid;
	}
		
	
	
	public void displayGrid()
	{
		
		for(int i=0; i<8;i++)
		{
			for(int j=0; j<8;j++)
			{
				if(String.valueOf(display [j][i]).equals("s") || String.valueOf(display [j][i]).equals("S") ||String.valueOf(display [j][i]).equals("g")||String.valueOf(display [j][i]).equals("G")|| String.valueOf(display [j][i]).equals("*"))
				{
					
				}else{
					display [j][i] = '_';
					}
				
				System.out.print(display [j][i] + "     ");
			}
				System.out.println();
		 }
			
	}
		
	
	
	public void emptyGrid()
	{
		
		for(int i=0; i<8;i++)
		{
			for(int j=0; j<8;j++)
			{
				if(String.valueOf(grid [j][i]).equals("s") || String.valueOf(grid [j][i]).equals("S") ||String.valueOf(grid [j][i]).equals("g")||String.valueOf(grid [j][i]).equals("G")|| String.valueOf(display [j][i]).equals("*"))
				{
					
				}else{
					grid [j][i] = '1';
					}
				
			}
		
		 }
			
	}
	
	
	
	public void PlaceHC()
	{
		Random CC = new Random();
		
		while(shipsH !=6 && shipsC !=6){
			
			if(grenadeH == 2){
		String coordinates;
		
		System.out.print("Shoot a rocket, select coordinates: ");
		coordinates = keyboard.next();
		
		int letCD = coordinates.toUpperCase().charAt(0) - 'A';
		int numCD = coordinates.charAt(1) - '1'; 
		
		
		while(letCD <0 || letCD >7 || numCD <0 || numCD >7)
		{
			System.out.println("Sorry, coordinates outside the grid. Try again.");
			System.out.println("");
			System.out.print("Shoot a rocket, select coordinates: ");
			coordinates = keyboard.next();
			letCD = coordinates.toUpperCase().charAt(0) - 'A';
			numCD = coordinates.charAt(1) - '1'; 
		}
		
		if(String.valueOf(display [letCD][numCD]).equals("s") || String.valueOf(display [letCD][numCD]).equals("S") ||String.valueOf(display [letCD][numCD]).equals("g")||String.valueOf(display [letCD][numCD]).equals("G")|| String.valueOf(display [letCD][numCD]).equals("*"))
		{
			System.out.println("Position already called");
		}else{
		
		if(String.valueOf(grid[letCD][numCD]).equals("s"))
		{
			System.out.println("Ship, Hit!");
			display[letCD][numCD] = 's';
			shipsH++;
			
		}
		
		if(String.valueOf(grid[letCD][numCD]).equals("g"))
		{
			System.out.println("Grenade, Hit!");
			display[letCD][numCD] = 'g';
			grenadeH = 0;
			totalNade++;
		}
		
		if(String.valueOf(grid[letCD][numCD]).equals("S"))
		{
			shipsC++;
			display[letCD][numCD] = 'S';
			System.out.println("Ship, Hit!");
		}
		
		if(String.valueOf(grid[letCD][numCD]).equals("G"))
		{
			System.out.println("Grenade, Hit!");
			display[letCD][numCD] = 'G';
			grenadeH = 0;
			totalNade++;
		}
		
		if(String.valueOf(grid[letCD][numCD]).equals("1"))
		{
			display[letCD][numCD] = '*';
		}
		}
		
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
			
				if(String.valueOf(display [j][i]).equals("s") || String.valueOf(display [j][i]).equals("S") ||String.valueOf(display [j][i]).equals("g")||String.valueOf(display [j][i]).equals("G")|| String.valueOf(display [j][i]).equals("*"))
				{
					
				}
				
				else
				{
					display [j][i] = '_';
				}
				
			System.out.print(display[j][i] + "     ");
			
			}
			System.out.println();
		}
		
			}
		int letCC = CC.nextInt(8);
		int numCC = CC.nextInt(8);
		
		
		char let1 = (char) (letCC+65);
		if(grenadeC == 2){
		
		System.out.println("");
		System.out.println("--> Computer have selected: " + let1+(numCC+1));
		
		if(String.valueOf(display [letCC][numCC]).equals("s") || String.valueOf(display [letCC][numCC]).equals("S") ||String.valueOf(display [letCC][numCC]).equals("g")||String.valueOf(display [letCC][numCC]).equals("G")|| String.valueOf(display [letCC][numCC]).equals("*"))
		{
			System.out.println("Position already called!");
		}
		else
		{
			
		if(String.valueOf(grid[letCC][numCC]).equals("s"))
		{
			System.out.println("Ship, Hit!");
			display[letCC][numCC] = 's';
			shipsH++;
		}
		
		if(String.valueOf(grid[letCC][numCC]).equals("g"))
		{
			System.out.println("Grenade, Hit!");
			display[letCC][numCC] = 'g';
			grenadeC = 0;
			totalNade++;
		}
		
		if(String.valueOf(grid[letCC][numCC]).equals("S"))
		{
			System.out.println("Ship, Hit!");
			display[letCC][numCC] = 'S';
			shipsC++;
		}
		
		if(String.valueOf(grid[letCC][numCC]).equals("G"))
		{
			System.out.println("Grenade, Hit!");
			display[letCC][numCC] = 'G';
			grenadeC = 0;
			totalNade++;
		}
		
		if(String.valueOf(grid[letCC][numCC]).equals("1"))
		{
			display[letCC][numCC] = '*';
		}
		}
		
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
			
				if(String.valueOf(display [j][i]).equals("s") || String.valueOf(display [j][i]).equals("S") ||String.valueOf(display [j][i]).equals("g")||String.valueOf(display [j][i]).equals("G")|| String.valueOf(display [j][i]).equals("*"))
				{
					
				}
				
				else
				{
					display [j][i] = '_';
				}
				
			System.out.print(display[j][i]+ "     ");
			
			}
			System.out.println();
			
			
		}
		}
		
		if(grenadeH ==0 || grenadeH == 1){
			grenadeH++;
		}
		if(grenadeC == 0 || grenadeC ==1){
			grenadeC++;
		}
	}
	}
	
	
		public void Result(){
		if(shipsH == 6){
			System.out.println();
			System.out.println();
			System.out.println("That's unfortunate, You lost!");
			System.out.println("Missed turns: " + totalNade);
			
		}
		
		
		if(shipsC == 6){
			System.out.println();
			System.out.println();
			System.out.println("Awesome, You won!");
			System.out.println("Missed turns: " +totalNade);
		}
		
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(String.valueOf(grid [j][i]).equals("s") || String.valueOf(grid [j][i]).equals("S") ||String.valueOf(grid [j][i]).equals("g")||String.valueOf(grid [j][i]).equals("G")){
						
					}else
					{
						grid [j][i] = '_';
					}
					
				System.out.print(grid[j][i]+ "     ");
				
				}
				System.out.println();
			
		}
		
		
		}

		
	
	
	
}
