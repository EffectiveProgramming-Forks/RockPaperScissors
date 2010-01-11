package yardspoon.rps;

public enum Throw {
	Rock, Paper, Scissors;

	public Result play(Throw opponent) {
		return Result.Tie;
	}

}
