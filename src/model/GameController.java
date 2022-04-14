package model;

public class GameController {
	//Attributes
	private int numberOfRows;
	private int numberOfColumns;
	private int numOfBlocks;
	private String playerName;
	private int posPlayer;
	private int projectedPosition;
	private BoxersList<String> listOfBoxers;
	
	
	public GameController() {
		listOfBoxers = new BoxersList<String>();
		posPlayer = 1;
		projectedPosition = 1;
	}
	
	public void toCreateGameBoard(int numberOfRows, int numberOfColumns, String playerName ) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.numOfBlocks = numberOfRows* numberOfColumns;
		this.playerName = playerName;
		
		
		for(int i = 1;i<=numOfBlocks;i++) {
			
			if(i == 1) {
				listOfBoxers.add(playerName);
			}
			
			else {
				listOfBoxers.add(String.valueOf(i));
			}
		}
	}
	
	public boolean validateMovement(int movement) {
		int aux = posPlayer + movement;
		
		if(aux<=numOfBlocks) {
			setProjectedPosition(aux);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

	public void movePlayer() {
		String pPosition = String.valueOf(projectedPosition);
		
		String currentPosition = String.valueOf(posPlayer);
		
		//To modify boxer's value where the player is.
		listOfBoxers.toLookForAnElementAndModify(playerName, currentPosition);
		//To modify the current position where the player was.
		setPosPlayer(projectedPosition);
		//To modify boxer's value where the player has moved.
		listOfBoxers.toLookForAnElementAndModify(pPosition,playerName);
	}
	
	public boolean validatePlayerWon() {
		if(posPlayer == numOfBlocks) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int toCalculateMissingBoxers() {
		return numOfBlocks-posPlayer;
	}
	
	
	//
	// === GETTERS AND SETTERS
	//
	
	
	public int getNumberOfRows() {
		return numberOfRows;
	}
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
	
	
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}
	
	
	
	public int getNumOfBBlocks() {
		return numOfBlocks;
	}
	public void setNumOfBlocks(int numOfBlocks) {
		this.numOfBlocks = numOfBlocks;
	}
	
	
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public int getPosPlayer() {
		return posPlayer;
	}

	public void setPosPlayer(int posPlayer) {
		this.posPlayer = posPlayer;
	}
	
	public int getProjectedPosition() {
		return projectedPosition;
	}

	public void setProjectedPosition(int projectedPosition) {
		this.projectedPosition = projectedPosition;
	}
	
	
	public String toShowGameBoard() {
		String out = "*** GAME BOARD ***\n";		
		out += listOfBoxers.toShowList(numberOfColumns);
		
		return out;
	}
	
}
