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

	public Sound clickSound;
	public Sound heartSound;
	public Sound swordSound;
	public Sound pistolSound;
	public Sound pickUpSwordSound;
	public Sound pickUpGunSound;
	public Sound chestSound;
	public Sound enemyDeathSound;
	public Sound jumpSound;
	public Sound landSound;

	public void init() {
		heartSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Heart.wav"));
		jumpSound        = Gdx.audio.newSound(Gdx.files.internal("audio/JumpSound.wav"));
		landSound        = Gdx.audio.newSound(Gdx.files.internal("audio/LandingSound.wav"));
		swordSound       = Gdx.audio.newSound(Gdx.files.internal("audio/WeaponSword.wav"));
		pistolSound      = Gdx.audio.newSound(Gdx.files.internal("audio/Pistol.wav"));
		pickUpSwordSound = Gdx.audio.newSound(Gdx.files.internal("audio/PickUpSword.wav"));
		pickUpGunSound   = Gdx.audio.newSound(Gdx.files.internal("audio/PickUpGun.wav"));
		chestSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Chest.wav"));
		clickSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Click.wav"));
		enemyDeathSound  = Gdx.audio.newSound(Gdx.files.internal("audio/EnemyDeath.wav"));
	}

	public void dispose() {
		heartSound.dispose();
		swordSound.dispose();
		pistolSound.dispose();
		pickUpSwordSound.dispose();
		pickUpGunSound.dispose();
		chestSound.dispose();
		clickSound.dispose();
		enemyDeathSound.dispose();
		jumpSound.dispose();
		landSound.dispose();
	}
}
