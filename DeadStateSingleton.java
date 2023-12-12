package life6visitor;

public class DeadStateSingleton {
	private static DeadState deadState;
	
	private DeadStateSingleton() {
	}
	
	//If deadState already exists, instance variable deadState is returned. 
	//If deadState does not already exist, a new deadState is created and set to the instance variable. 
	public static DeadState create() {
		if (deadState==null) {
			deadState = new DeadState();
		}
		return deadState;
		
	}
}
