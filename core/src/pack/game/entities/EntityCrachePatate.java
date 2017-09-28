package pack.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;


import pack.game.RenderUtils;

/**
 * Created by PcFixeGuillaume on 17/09/2017.
 */

public class EntityCrachePatate extends Entity
{
    private float leftEyeX;
    private float rightEyeX;
    private float eyeY;
    private float rightEyeXOffset;
    private float leftEyeXOffset;
    private float eyeYOffset;
    private Vector2 mouseLocation;

    //TODO: Position Y des yeux
    public EntityCrachePatate()
    {
        this.setX(600);
        this.setY(400);
        this.setScale(1.5f);

    }

    @Override
    public void update()
    {
        super.update();
        mouseLocation = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        mouseLocation = RenderUtils.VIEWPORT.unproject(mouseLocation);

        eyeY = getY() + RenderUtils.POTATOTEXTURE.getHeight()*0.57f*getScale();
        leftEyeX = getX() - RenderUtils.EYEDOTTEXTURE.getWidth()/2*getScale() - RenderUtils.POTATOTEXTURE.getWidth()*0.19f*getScale();
        rightEyeX = getX() - RenderUtils.EYEDOTTEXTURE.getWidth()/2*getScale() + RenderUtils.POTATOTEXTURE.getWidth()*0.255f*getScale();
        t += RenderUtils.DELTA;
    }

    float t = 0;

    public float getRightEyeXOffset()
    {
        float XDifferenceBetweenEyeAndMouse = mouseLocation.x - rightEyeX;
        float goalOffset = (float)(Math.atan(XDifferenceBetweenEyeAndMouse/100)*6)*getScale();
        rightEyeXOffset = MathUtils.lerp(rightEyeXOffset, goalOffset, 0.2f);

        return rightEyeXOffset;
    }

    public float getLeftEyeXOffset()
    {
        float XDifferenceBetweenEyeAndMouse = mouseLocation.x - leftEyeX;
        float goalOffset = (float)(Math.atan(XDifferenceBetweenEyeAndMouse/100)*6f)*getScale();
        leftEyeXOffset = MathUtils.lerp(leftEyeXOffset, goalOffset, 0.2f);

        return leftEyeXOffset;
    }

    public float getEyesYOffset()
    {
        float XDifferenceBetweenEyeAndMouse = mouseLocation.y - eyeY;
        float goalOffset = (float)(Math.atan(XDifferenceBetweenEyeAndMouse/100)*2.3f)*getScale();
        eyeYOffset = MathUtils.lerp(eyeYOffset, goalOffset, 0.2f);

        return eyeYOffset;
    }

    public float getMouthY()
    {
        return getY() + RenderUtils.POTATOTEXTURE.getHeight()*0.3f*getScale();
    }

    public float getMouthX()
    {
        return getX() - RenderUtils.MOUTHCLOSEDTEXTURE.getWidth()/2*getScale() + 4;
    }

    public float getEyesX()
    {
        return getX() - RenderUtils.EYESTEXTURE.getWidth()/2*getScale() + 4;
    }

    public float getEyesY()
    {
      return getY() + RenderUtils.POTATOTEXTURE.getHeight()/2*getScale() + 5;
    }

    public float getLeftEyeX()
    {
        return getX() - RenderUtils.EYEDOTTEXTURE.getWidth()/2*getScale() - RenderUtils.POTATOTEXTURE.getWidth()*0.19f*getScale() + getLeftEyeXOffset();
    }

    public float getEyeDotsY()
    {
        return getY() + RenderUtils.POTATOTEXTURE.getHeight()*0.57f*getScale() + getEyesYOffset();
    }

    public float getRightEyeX()
    {
        return getX() - RenderUtils.EYEDOTTEXTURE.getWidth()/2*getScale() + RenderUtils.POTATOTEXTURE.getWidth()*0.255f*getScale() + getRightEyeXOffset();
    }

    @Override
    public void render()
    {
        super.render();

        //Draw Potato
        RenderUtils.draw(RenderUtils.POTATOTEXTURE,
                getX() - RenderUtils.POTATOTEXTURE.getWidth()/2*getScale(),
                getY(),
                RenderUtils.POTATOTEXTURE.getWidth()*getScale(),
                RenderUtils.POTATOTEXTURE.getHeight()*getScale());

        //Draw Eyes
        RenderUtils.draw(RenderUtils.EYESTEXTURE,
                getEyesX(),
                getEyesY(),
                RenderUtils.EYESTEXTURE.getWidth()*getScale(),
                RenderUtils.EYESTEXTURE.getHeight()*getScale());

        //Draw Mouth
        RenderUtils.draw(RenderUtils.MOUTHCLOSEDTEXTURE,
                getMouthX(),
                getMouthY(),
                RenderUtils.MOUTHCLOSEDTEXTURE.getWidth()*getScale(),
                RenderUtils.MOUTHCLOSEDTEXTURE.getHeight()*getScale());

        //Draw Left Eye
        RenderUtils.draw(RenderUtils.EYEDOTTEXTURE,
                getLeftEyeX(),
                getEyeDotsY(),
                RenderUtils.EYEDOTTEXTURE.getWidth()*getScale(),
                RenderUtils.EYEDOTTEXTURE.getHeight()*getScale());

        //Draw Right Eye
        RenderUtils.draw(RenderUtils.EYEDOTTEXTURE,
                getRightEyeX(),
                getEyeDotsY(),
                RenderUtils.EYEDOTTEXTURE.getWidth()*getScale(),
                RenderUtils.EYEDOTTEXTURE.getHeight()*getScale());
    }
}
