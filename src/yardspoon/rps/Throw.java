package yardspoon.rps;

public enum Throw {
	Rock("Scissors"),
	Paper("Rock"),
	Scissors("Paper");
	
	private final String theThrowIBeatAsName;

	private Throw(String theThrowIBeatAsName) {
		this.theThrowIBeatAsName = theThrowIBeatAsName;
	}

	public Result play(Throw opponent) {
		if(this == opponent) {
			return Result.Tie;
		}
		
		if(opponent == Throw.valueOf(theThrowIBeatAsName)) {
			return Result.Win;
		}
		
		return Result.Loss;
	}

}
