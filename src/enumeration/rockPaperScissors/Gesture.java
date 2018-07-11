package enumeration.rockPaperScissors;

/**
 * Java enum is polymorphic. Below is an implementation of the Rock-Paper-Scissors game which 
 * primarily relies on the ordinal integer of each enum constant. 
 * 
 * @author ruifengm
 * @since 2018-Jul-11
 * http://cyrille.martraire.com/2012/08/java-enums-you-have-grace-elegance-and-power-and-this-is-what-i-love/
 */

public enum Gesture {
	ROCK() {
		@Override
		public boolean beats(Gesture other) { // polymorphic
			return other == Gesture.SCISSORS;
		}
	}, 
	PAPER, SCISSORS;
	
	public boolean beats(Gesture other) {
		return ordinal() - other.ordinal() == 1; 
	}
}
