package pack.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.List;

import pack.game.entities.Entity;
import static pack.game.RenderUtils.*;
import pack.game.entities.EntityCrachePatate;

public class Main extends ApplicationAdapter
{
	private List<Entity> entityList = new ArrayList<>();
    private static EntityCrachePatate PLAYER;

	@Override
	public void create()
    {
        VIEWPORT = new FitViewport(V_WIDTH, V_HEIGHT, CAMERA);
		BATCH = new SpriteBatch();
        CAMERA.translate(V_WIDTH/2, V_HEIGHT/2);
        PLAYER = new EntityCrachePatate();
        entityList.add(PLAYER);
	}

	@Override
	public void render()
    {
        //Clear
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update
        update();
        entityList.forEach(Entity::update);
        CAMERA.update();
        BATCH.setProjectionMatrix(CAMERA.combined);
        //Render
        BATCH.begin();
        draw(SKYTEXTURE, 0, 0, V_WIDTH, V_HEIGHT);
        draw(GROUNDTEXTURE, V_WIDTH/2, -20, V_WIDTH/2, GROUNDTEXTURE.getHeight()/2);
        draw(GROUNDTEXTURE, 0, -20, V_WIDTH/2, GROUNDTEXTURE.getHeight()/2);
		entityList.forEach(Entity::render);
        BATCH.end();
	}

	private void update()
    {
        DELTA = Gdx.graphics.getDeltaTime();
    }

	@Override
	public void dispose()
    {
        RenderUtils.dispose();
	}

    @Override
    public void resize(int width, int height)
    {
        VIEWPORT.update(width, height);
    }
}
