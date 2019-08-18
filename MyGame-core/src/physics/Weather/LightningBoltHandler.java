package physics.Weather;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.GameAttributeHelper;

/**
 * Handles in game lightning bolts.
 * 
 * Original Author: Cero
 * Modified by: Phased
 *
 */
public class LightningBoltHandler {

	public static int renderLightningBoltTime = 0;

	private static float thickness = .08f;

	private static int numberOfBolts = 1;

	private static Vector2 tempSphereVector = new Vector2(0,0);

	private static Color colourOne = new Color(14f/255f, 100f/255f, 200f/255f, 1f);
	private static Color colourTwo = new Color(54f/255f, 210f/255f, 239f/255f, 1f);

	private static float dx;
	private static float dy;

	private static Vector2 returnVector = new Vector2(0, 0);

	private static Texture texture;
	
	public static void init() {
		setTexture(new Texture("artwork/nature/lightningbolt.png"));
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2     point
	 * @param float       thickness
	 * @param int         numberOfBolts
	 * @param             int radius
	 * @param int         circleSegments
	 */
	public static void drawSphereLightning(SpriteBatch batch, Vector2 point, float thickness, int numberOfBolts, int radius, int circleSegments){
		drawSphereLightning(batch, point, thickness, numberOfBolts, radius, circleSegments, colourOne, colourTwo);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2     point
	 * @param float       thickness
	 * @param int         numberOfBolts
	 * @param             int radius
	 * @param int         circleSegments
	 * @param Color       colourA
	 * @param Color       colourB
	 */
	public static void drawSphereLightning(SpriteBatch batch, Vector2 point, float thickness, int numberOfBolts, int radius, int circleSegments, Color colourA, Color colourB) {
		for (int i = 0; i < 360f; i += (360f / circleSegments)) {
			tempSphereVector = getOrbitLocationDeg(point.x, point.y, i, radius);
			drawP2PLightning(batch, point.x, point.y, tempSphereVector.x, tempSphereVector.y, MathUtils.random(60f, 140f), MathUtils.random(0.8f, 3.8f), thickness, numberOfBolts, colourA, colourB);
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2     startPos
	 * @param Vector2     endPointOne
	 * @param Vector2     endPointTwo
	 */
	public static void drawChainLightningRandomBetweenPoints(SpriteBatch batch, Vector2 startPos, Vector2 endPointOne, Vector2 endPointTwo) {
		Vector2[] points = new Vector2[2];
		points[1] = startPos;
		points[0] = new Vector2(MathUtils.random(endPointOne.x, endPointTwo.x), MathUtils.random(endPointOne.y, endPointTwo.y));
		drawChainLightning(batch, points, thickness, numberOfBolts, colourOne, colourTwo);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2     startPos
	 * @param Vector2     endPointOne
	 * @param Vector2     endPointTwo
	 * @param float       thickness
	 * @param int         numberOfBolts
	 */
	public static void drawChainLightningRandomBetweenPoints(SpriteBatch batch, Vector2 startPos, Vector2 endPointOne, Vector2 endPointTwo, float thickness, int numberOfBolts) {
		Vector2[] points = new Vector2[2];
		points[1] = startPos;
		points[0] = new Vector2(MathUtils.random(endPointOne.x, endPointTwo.x), MathUtils.random(endPointOne.y, endPointTwo.y));
		drawChainLightning(batch, points, thickness, numberOfBolts, colourOne, colourTwo);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2     startPos
	 * @param Vector2     endPointOne
	 * @param Vector2     endPointTwo
	 * @param float       thickness
	 * @param int         numberOfBolts
	 * @param Color       colourA
	 * @param Color       colourB
	 */
	public static void drawChainLightningRandomBetweenPoints(SpriteBatch batch, Vector2 startPos, Vector2 endPointOne, Vector2 endPointTwo, float thickness, int numberOfBolts, Color colourA, Color colourB) {
		Vector2[] points = new Vector2[2];
		points[1] = startPos;
		points[0] = new Vector2(MathUtils.random(endPointOne.x, endPointTwo.x), MathUtils.random(endPointOne.y, endPointTwo.y));
		drawChainLightning(batch, points, thickness, numberOfBolts, colourA, colourB);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2[]   points
	 * @param Color       colourA
	 * @param Color       colourB
	 */
	public static void drawChainLightning(SpriteBatch batch, Vector2[] points, Color colourA, Color colourB) {
		drawChainLightning(batch, points, thickness, numberOfBolts, colourA, colourB);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2[]   points
	 */
	public static void drawChainLightning(SpriteBatch batch, Vector2[] points) {
		drawChainLightning(batch, points, thickness, numberOfBolts, colourOne, colourTwo);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2[]   points
	 * @param float       thickness
	 * @param int         numberOfBolts
	 */
	public static void drawChainLightning(SpriteBatch batch, Vector2[] points, float thickness, int numberOfBolts) {
		drawChainLightning(batch, points, thickness, numberOfBolts, colourOne, colourTwo);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Vector2[]   points
	 * @param float       thickness
	 * @param int         numberOfBolts
	 * @param Color       colourA
	 * @param Color       colourB
	 */
	public static void drawChainLightning(SpriteBatch batch, Vector2[] points, float thickness, int numberOfBolts, Color colourA, Color colourB) {
		for (int i = 0; i < points.length - 1; i++) {
			drawP2PLightning(batch, points[i].x, points[i].y, points[i+1].x, points[i+1].y, MathUtils.random(60f, 140f), MathUtils.random(0.8f, 3.8f), thickness, numberOfBolts, colourA, colourB);
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param float       x1
	 * @param float       y1
	 * @param float       x2
	 * @param float       y2
	 * @param float       thickness
	 * @param Texture     tex
	 */
	private static void drawLine(SpriteBatch batch, float x1, float y1, float x2, float y2, float thickness, Texture tex) {
		float length = getDistanceAccurate(x1, y1, x2, y2);
		float dx = x1;
		float dy = y1;
		dx       = dx - x2;
		dy       = dy - y2;
		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(dy, dx);
		angle = angle-180;
		batch.draw(tex, x1, y1, 0f, thickness * 0.5f, length, thickness, 1f, 1f, angle, 0, 0, tex.getWidth(), tex.getHeight(), false, false);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param float       x1
	 * @param float       y1
	 * @param float       x2
	 * @param float       y2
	 * @param float       displace
	 * @param float       detail
	 * @param float       thickness
	 * @param int         numberOfBolts
	 * @param Color       colourA
	 * @param Color       colourB
	 */
	private static void drawP2PLightning(SpriteBatch batch, float x1, float y1, float x2, float y2, float displace, float detail, float thickness, int numberOfBolts, Color colourA, Color colourB) {
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE);
		for (int i = 0; i < numberOfBolts; i++) {
			batch.setColor(MathUtils.random(colourA.r, colourB.r), MathUtils.random(colourA.g, colourB.g), MathUtils.random(colourA.b, colourB.b), 1f);
			drawSingleP2PLightning(batch, x1, y1, x2, y2, 117, 1.8f, thickness);
		}
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param float       x1
	 * @param float       y1
	 * @param float       x2
	 * @param float       y2
	 * @param float       displace
	 * @param float       detail
	 * @param float       thickness
	 */
	private static void drawSingleP2PLightning(SpriteBatch batch, float x1, float y1, float x2, float y2, float displace, float detail, float thickness) {
		if (displace < detail) {
			drawLine(batch, x1, y1, x2, y2, thickness, texture);
		} else {
			float mid_x = (x2 + x1) * 0.5f;
			float mid_y = (y2 + y1) * 0.5f;
			mid_x += (Math.random() - 0.5f) * displace;
			mid_y += (Math.random() - 0.5f) * displace;
			drawSingleP2PLightning(batch, x1, y1, mid_x, mid_y, displace * 0.5f, detail, thickness);
			drawSingleP2PLightning(batch, x2, y2, mid_x, mid_y, displace * 0.5f, detail, thickness);
		}
	}

	/**
	 * 
	 * @param float setThickness
	 */
	public static void setThickness(float setThickness) {
		thickness = setThickness;
	}

	/**
	 * 
	 * @param int setNumberOfBolts
	 */
	public static void setNumberOfBolts(int setNumberOfBolts) {
		numberOfBolts = setNumberOfBolts;
	}

	public static void setToDefaultColour() {
		colourOne = new Color(14f / 255f, 100f / 255f, 200f / 255f, 1f);
		colourTwo = new Color(54f / 255f, 210f / 255f, 239f / 255f, 1f);
	}

	/**
	 * 
	 * @param Color colourA
	 * @param Color colourB
	 */
	public static void setColour(Color colourA, Color colourB) {
		colourOne = colourA;
		colourTwo = colourB;
	}

	/**
	 * 
	 * @param Texture setTexture
	 */
	public static void setTexture(Texture setTexture) {
		texture = setTexture;
	}

	/**
	 * 
	 * @param float srcX
	 * @param float srcY
	 * @param float relativeX
	 * @param float relativeY
	 * @return float
	 */
	private static float getDistanceAccurate(float srcX, float srcY, float relativeX, float relativeY){
		dx = relativeX - srcX; 
		dy = relativeY - srcY; 
		return (float) Math.sqrt((double)(dx * dx + dy * dy));
	}

	/**
	 * 
	 * @param float srcX
	 * @param float srcY
	 * @param float angle
	 * @param float radius
	 * @return Vector2
	 */
	private static Vector2 getOrbitLocationDeg(float srcX, float srcY, float angle, float radius){
		returnVector.set(srcX + (MathUtils.cosDeg(angle) * radius), srcY + (MathUtils.sinDeg(angle) * radius));
		return returnVector;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public static void drawLightningBolt(MyGame myGame) {
		System.out.println("Drawing lightning bolts!");
		float lightningBoltXPosition = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		Vector2[] lightningBoltVectors = new Vector2[] {
				new Vector2(lightningBoltXPosition, myGame.getGameObject(GameObject.PLAYER_ONE).getY() - 200),
				new Vector2(lightningBoltXPosition, GameAttributeHelper.SCREEN_HEIGHT - 150)
		};

		Color color = new Color(ColorHelper.WHITE);
		drawChainLightning(
				myGame.renderer.batch,
				lightningBoltVectors,
				color,
				color
				);
	}
}
