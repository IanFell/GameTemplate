package loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Loads sounds.
 * 
 * @author Fabulous Fellini
 *
 */
public class SoundLoader {

	// Debug explosion sound.
	public Sound sound;

	/**
	 * Game Sounds.
	 */
	// Inventory select click sound.
	public Sound clickSound;
	
	public Sound heartSound;
	public Sound swordSound;
	public Sound pickUpSwordSound;
	public Sound chestSound;
	public Sound enemyDeathSound;

	public void init() {
		sound = Gdx.audio.newSound(Gdx.files.internal("bomb.wav"));
		
		heartSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Heart.wav"));
		swordSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Whoosh.wav"));
		pickUpSwordSound = Gdx.audio.newSound(Gdx.files.internal("audio/PickUpSword.wav"));
		chestSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Chest.wav"));
		clickSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Click.wav"));
		enemyDeathSound  = Gdx.audio.newSound(Gdx.files.internal("audio/EnemyDeath.wav"));
	}

	public void dispose() {
		sound.dispose();
		
		heartSound.dispose();
		swordSound.dispose();
		pickUpSwordSound.dispose();
		chestSound.dispose();
		clickSound.dispose();
		enemyDeathSound.dispose();
	}
}
