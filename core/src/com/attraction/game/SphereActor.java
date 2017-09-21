package com.attraction.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * Created by Vladicbl on 19.07.2017.
 */



public class SphereActor extends Actor { //https://stackoverflow.com/questions/30155374/libgdx-actor-undetected-touch-input
    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("Images/SphL.png")));
    Vector2 coords = new Vector2();
    Circle circle;


    public SphereActor(Vector2 vector2, float radius){
        circle = new Circle(vector2.x+radius,vector2.y+radius,radius);
        coords = vector2;
        sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        this.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setTouchable(Touchable.enabled);
        this.setPosition(coords.x,coords.y);
        sprite.setPosition(coords.x,coords.y);
        //sprite.setSize(150,150);
        //this.setZIndex(10);

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (circle.contains(x,y)) System.out.print("c");
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public Vector2 getSphereVector(){
        return coords;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
/*

    public Actor hit (float x, float y, boolean touchable) {
        if (touchable && getTouchable() != Touchable.enabled) return null;
        return x >= 0 && x < width && y >= 0 && y < height ? this : null;
    }

    Animation animation;
    Texture spriteSheet;
    TextureRegion currentFrame;
    public TextureRegion[][] frames;
    public float ftameTime;

    public SphereActor(float x, float y){
        setBounds(x, y, 10, 10);
        setTouchable(Touchable.disabled);
        spriteSheet = new Texture(Gdx.files.internal("man.png"));
        frames = TextureRegion.split(spriteSheet,spriteSheet.getWidth() / 4, spriteSheet.getHeight() / 4);
        animation = new Animation(0.10f,frames[0]);
    }/**/
}
