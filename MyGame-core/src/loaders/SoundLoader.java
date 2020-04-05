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
	public Sound rumSound;
	public Sound swordSound;
	public Sound pistolSound;
	public Sound pickUpSwordSound;
	public Sound pickUpGunSound;
	public Sound chestSound;
	public Sound enemyDeathSound;
	public Sound jumpSound;
	public Sound landSound;
	public Sound bubbleSound;
	public Sound bombSound;
	public Sound cannonFire;
	public Sound giantLandingSound;
	public Sound playerHit;

	public void init() {
		heartSound        = Gdx.audio.newSound(Gdx.files.internal("audio/Heart.wav"));
		rumSound          = Gdx.audio.newSound(Gdx.files.internal("audio/Bottle.wav"));
		jumpSound         = Gdx.audio.newSound(Gdx.files.internal("audio/JumpSound.wav"));
		landSound         = Gdx.audio.newSound(Gdx.files.internal("audio/LandingSound.wav"));
		swordSound        = Gdx.audio.newSound(Gdx.files.internal("audio/WeaponSword.wav"));
		pistolSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Pistol.wav"));
		pickUpSwordSound  = Gdx.audio.newSound(Gdx.files.internal("audio/PickUpSword.wav"));
		pickUpGunSound    = Gdx.audio.newSound(Gdx.files.internal("audio/PickUpGun.wav"));
		chestSound        = Gdx.audio.newSound(Gdx.files.internal("audio/Chest.wav"));
		clickSound        = Gdx.audio.newSound(Gdx.files.internal("audio/Click.wav"));
		enemyDeathSound   = Gdx.audio.newSound(Gdx.files.internal("audio/EnemyDeath.wav"));
		bubbleSound       = Gdx.audio.newSound(Gdx.files.internal("audio/Bubble.wav"));
		bombSound         = Gdx.audio.newSound(Gdx.files.internal("audio/Bomb.wav"));
		cannonFire        = Gdx.audio.newSound(Gdx.files.internal("audio/CannonFire.wav"));
		giantLandingSound = Gdx.audio.newSound(Gdx.files.internal("audio/rumble.wav"));
		playerHit         = Gdx.audio.newSound(Gdx.files.internal("audio/PlayerHit.wav"));
	}

	public void dispose() {
		heartSound.dispose();
		rumSound.dispose();
		swordSound.dispose();
		pistolSound.dispose();
		pickUpSwordSound.dispose();
		pickUpGunSound.dispose();
		chestSound.dispose();
		clickSound.dispose();
		enemyDeathSound.dispose();
		jumpSound.dispose();
		landSound.dispose();
		bubbleSound.dispose();
		bombSound.dispose();
		cannonFire.dispose();
		giantLandingSound.dispose();
		playerHit.dispose();
	}
}
