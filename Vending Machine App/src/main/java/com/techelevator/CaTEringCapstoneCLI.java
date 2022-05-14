package com.techelevator;

import com.techelevator.view.MainMenu;

public class CaTEringCapstoneCLI {



	private MainMenu menu;

	public CaTEringCapstoneCLI(MainMenu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		menu.run();



	}


}
