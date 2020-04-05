package ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.AnimationHandler;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LootUi extends TextBasedUiParent {

	/**
	 * Constructor.
	 */
	public LootUi() {
		super();
		int size     = 1;
		this.width   = size;
		this.height  = size;
		textureAtlas = new TextureAtlas(Gdx.files.internal("artwork/ui/loot.atlas"));
		animation    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_LOOT, textureAtlas.getRegions());
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameOjbect  player
	 */
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame,  
			GameObject player
			) {
		updateElapsedTime();
		float xPos = player.getX() - 12.5f;
		float yPos = player.getY() - 5.0f;
		AnimationHandler.renderAnimation(
				batch, 
				elapsedTime, 
				animation, 
				xPos, 
				yPos, 
				width,
				height,
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_LOOT
				);
		super.renderUi(batch, imageLoader, myGame, player, xPos + 2, yPos, player.getPlayerLoot());
	}
}
