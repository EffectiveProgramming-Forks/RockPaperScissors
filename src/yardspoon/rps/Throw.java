package yardspoon.rps;

public enum Throw {
	Rock, Paper, Scissors;

	public Result play(Throw opponent) {
		if(this == opponent) {
			return Result.Tie;
		}
		
		if(opponent == Scissors) {
			return Result.Win;
		}
		
		return Result.Loss;
	}

}
