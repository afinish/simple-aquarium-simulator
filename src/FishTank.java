
public class FishTank {
	static final int TANK_HEIGHT = 10;
	static final int TANK_WIDTH = 50;
	
	public static TankCells[][] grid = new TankCells[TANK_HEIGHT+1][TANK_WIDTH+1];
	
	public static void TankInit() {
		for(int i=0; i<=TANK_HEIGHT; i++) {
			for(int j=0; j<=TANK_WIDTH; j++) {
				grid[i][j] = new TankCells();
			}
		}
	}
	
	public static void updatePosition(int x, int y, boolean gender) {
		if(gender)						// if gender is true (male) 
			grid[x][y].cellM = true;	// then fill the cell with male.
		else 							// else fill it
			grid[x][y].cellF = true; 	// with female
	}
	
	public static void clear() {
		for(int i=0; i<=TANK_HEIGHT; i++) {
			for(int j=0; j<=TANK_WIDTH; j++) {
				grid[i][j].cellM = false;
				grid[i][j].cellF = false;	
			}
		}
	}
}

class TankCells {
	boolean cellM = false;
	boolean cellF = false;
}