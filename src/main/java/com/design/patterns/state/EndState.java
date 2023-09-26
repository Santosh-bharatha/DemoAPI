package com.design.patterns.state;

public class EndState extends State{

	public EndState(Game game) {
		super(game);
		System.out.println("== Game in EndGame state ==");
	}

	@Override
	public void onWelcomeScreen() {
		game.changeState(new WelcomeScreenState(game));
	}

	@Override
	public void onPlaying() {
		System.out.println("Not Allowed");
	}

	@Override
	public void onBreak() {
		System.out.println("Not Allowed");
	}

	@Override
	public void onEndGame() {
		game.changeState(new EndState(game));
	}

}
