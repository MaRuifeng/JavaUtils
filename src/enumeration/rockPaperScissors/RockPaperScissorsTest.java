package enumeration.rockPaperScissors;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit tests for the Rock-Paper-Scissors game implemented via Java enum.
 * 
 * @author ruifengm
 * @since 2018-Jul-11
 */

public class RockPaperScissorsTest {
	@Test
	public final void paperBeatsRock() {
		Assert.assertTrue(Gesture.PAPER.beats(Gesture.ROCK));
		Assert.assertFalse(Gesture.ROCK.beats(Gesture.PAPER));
	}

	@Test
	public final void rockBeatsScissors() {
		Assert.assertTrue(Gesture.ROCK.beats(Gesture.SCISSORS));
		Assert.assertFalse(Gesture.SCISSORS.beats(Gesture.ROCK));
	}
	
	@Test
	public final void scissorsBeatsPaper() {
		Assert.assertTrue(Gesture.SCISSORS.beats(Gesture.PAPER));
		Assert.assertFalse(Gesture.PAPER.beats(Gesture.SCISSORS));
	}
}
