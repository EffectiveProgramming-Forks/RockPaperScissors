package yardspoon.rps;

public enum Throw {
	Rock, Paper, Scissors;

	public Result play(Throw opponent) {
		if(this == opponent) {
			return Result.Tie;
		}
		
		if(this == Rock && opponent == Scissors || this == Scissors && opponent == Paper) {
			return Result.Win;
		}
		
		return Result.Loss;
	}

}
