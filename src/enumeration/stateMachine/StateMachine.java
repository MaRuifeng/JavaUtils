package enumeration.stateMachine;

/**
 * Main function to test behavior of the state machine implemented using Java Enum. 
 * 
 * @author ruifengm
 * @since 2018-Jul-10
 */

public class StateMachine {

	private State state; 
	
	public StateMachine() {
		state = State.INITIAL; // initialization
	}
	
	public void processRequest(String arg) {
		state = state.process(arg);
	}
	
	public static void main(String[] args) {
		StateMachine sm = new StateMachine(); 
		sm.processRequest("Shout");
		sm.processRequest("Walk");
		sm.processRequest("Run");
		sm.processRequest("Stand");
		sm.processRequest("Sit");
		sm.processRequest("Jump");
	}
}
