package life6visitor;

public class AliveStateSingleton {
	private static AliveState aliveState;
	
	private AliveStateSingleton() {
	}
	
	public static AliveState create() {
		//If the alivestate has not been instantiated, one is instantiated. Otherwise, the existing one is returned. 
		if (aliveState==null) {
			aliveState = new AliveState();
		}
		return aliveState;
		
	}
}

