package physics.Lighting;

/**
 * Handles ALL in game lighting.
 * 
 * @author Fabulous Fellini
 *
 */
public class LightingHandler {
	
	public LightHandler lightHandler;
	
	public ShadowHandler shadowHandler;
	
	/**
	 * Constructor.
	 */
	public LightingHandler() {
		lightHandler  = new LightHandler();
		shadowHandler = new ShadowHandler();
	}

}
