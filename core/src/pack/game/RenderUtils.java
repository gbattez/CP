package pack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class RenderUtils
{
    public static Texture PLAINSTEXTURE = new Texture(Gdx.files.internal("plains.png"));
    public static Texture EYEDOTTEXTURE = new Texture(Gdx.files.internal("eyedot.png"));
    public static Texture EYESTEXTURE = new Texture(Gdx.files.internal("eyes.png"));
    public static Texture MOUTHCLOSEDTEXTURE = new Texture(Gdx.files.internal("mouthclosed.png"));
    public static Texture MOUHTOPENTEXTURE = new Texture(Gdx.files.internal("mouthopen.png"));
    public static Texture POTATOTEXTURE = new Texture(Gdx.files.internal("potato.png"));
    public static Texture GROUNDTEXTURE = new Texture(Gdx.files.internal("groundPlains.png"));
    public static Texture SKYTEXTURE = new Texture(Gdx.files.internal("sky.png"));

    public static SpriteBatch BATCH;
    public static OrthographicCamera CAMERA = new OrthographicCamera();
    public static final int V_WIDTH = 1920;
    public static final int V_HEIGHT = 1080;
    public static Viewport VIEWPORT;
    public static float DELTA = 0;

    public static void draw(Texture texture, float x, float y)
    {
        BATCH.draw(texture, x, y);
    }

    public static void draw(Texture texture, float x, float y, float width, float height)
    {
        BATCH.draw(texture, x, y, width, height);
    }

    public static void dispose()
    {
        BATCH.dispose();
        PLAINSTEXTURE.dispose();
        EYEDOTTEXTURE.dispose();
        MOUTHCLOSEDTEXTURE.dispose();
        POTATOTEXTURE.dispose();
        MOUHTOPENTEXTURE.dispose();
        EYESTEXTURE.dispose();
        GROUNDTEXTURE.dispose();
        SKYTEXTURE.dispose();
    }
}