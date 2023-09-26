package com.design.patterns.state;

public class PlayingState extends State{

	public PlayingState(Game game) {
		super(game);
		System.out.println("=== Game in playing state ===");
	}

	@Override
	public void onWelcomeScreen() {
		System.out.println("not Allowed");
	}

	@Override
	public void onPlaying() {
		System.out.println("Currently playing");
	}

	@Override
	public void onBreak() {
		game.changeState(new BreakState(game));
	}

	@Override
	public void onEndGame() {
		game.changeState(new EndState(game));
	}

}
