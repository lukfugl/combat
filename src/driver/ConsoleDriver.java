package driver;

import model.Character;
import model.Target;

public class ConsoleDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Character character = new Character();
		Target target = new Target();
		System.out.println(character.dps(target));
	}
}
