package enumeration.stateMachine;

/**
 * State machines encapsulate object behavior depending on a given object state. 
 * 
 * Java Enums are inherently implemented with Class hence they can also contain behavior. 
 * They are guaranteed to be singleton, and have ordering, hashcode, equals and 
 * serialization/deserialization as defined in the parent java.lang.Enum class. 
 * 
 * These properties make Java Enum a good candidate to implement state machines. 
 * 
 * @author ruifengm
 * @since 2018-Jul-10
 *
 * https://www.mirkosertic.de/blog/2013/04/implementing-state-machines-with-java-enums/
 */

public enum State {
	
	INITIAL {
		@Override
		State process(String arg) {
			System.out.println("In INITIAL state. Processing the request " + arg + " and then jumping to NEXT_STEP state.");
			return NEXT_STEP;
		}
	}, 
	NEXT_STEP {
		@Override
		State process(String arg) {
			System.out.println("In NEXT_STEP state. Processing the request " + arg + " and then jumping to FINAL state.");
			return FINAL;
		}
	},
	FINAL {
		@Override
		State process(String arg) {
			System.out.println("In FINAL state. Processing the request " + arg + " and staying.");
			return this; // internally an enum constant is an object of the enum class
		}
	};

	abstract State process(String arg);
}
