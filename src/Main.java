
public class Main {
	static final int TANK_HEIGHT = 10;
	static final int TANK_WIDTH = 50;
	static final int FISH_MAX_NUM = 10;
	static final int TANK_DISPLAY_TIME = 1000;
	static boolean mating_status = false;
	static int ms_cooldown = 20;	// mating status cool down time
	
	public static void main(String[] args) {
		FishTank.TankInit();	// initialize the fish tank
		Fish fish1 = new Fish("fish1");
		Fish fish2 = new Fish("fish2");
		Fish fish3 = new Fish("fish3");
		Fish[] fishes = new Fish[FISH_MAX_NUM];	// maximum tank capacity
		
		fishes[0] = fish1;
		fishes[1] = fish2;
		fishes[2] = fish3;
		int num = 2;	// number of fishes right now
		
		fish1.start();
		fish2.start();
		fish3.start();
		
		displayTank(fishes, num);
	}
	
	public static void displayTank(Fish[] fishes, int num) {
		for(int i=0; i<TANK_DISPLAY_TIME; i++) {
			System.out.println("\n\n\n\n\n\n");
			System.out.println("****************************************************");
			
			for(int j=0; j<TANK_HEIGHT; j++) {
				System.out.print('*');
			
				for(int k=0; k<TANK_WIDTH; k++) {
					if(FishTank.grid[j][k].cellM			
						&& FishTank.grid[j][k].cellF 
						&& ms_cooldown < 1) {	// if cell has two, gender  different, fish they mate.
						
						System.out.print('J'); 				// display 'JOIN' message: 'J'.
						fishes[num] = new Fish("fish" + num + 1);
						fishes[num].start();				// Create new fish.
						num++;								// Increment number of fish.
						mating_status = true;
						ms_cooldown = 10;
					}
					
					else if(FishTank.grid[j][k].cellM
							&& !FishTank.grid[j][k].cellF)	// if cell only has 
						System.out.print('M');				// male fish, display 'M'.
					
					else if(!FishTank.grid[j][k].cellM
							&& FishTank.grid[j][k].cellF)	// if cell only has
						System.out.print('F');				// female fish, display 'F'.
					
					else System.out.print(' ');				// if cell has no fish display ' '.
				}
				System.out.println("*");
			}
			System.out.println("****************************************************");
			System.out.println("Number of fish in the tank: " + num);
			System.out.printf("Did any fish mate in the past 3 seconds? " + mating_status);
			
			if(mating_status && ms_cooldown > 0) 
				ms_cooldown--;
			else 
				mating_status = false;
			
			FishTank.clear();	// clear the fish tank to avoid atomicity problems
			try {Thread.sleep(150);}
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
