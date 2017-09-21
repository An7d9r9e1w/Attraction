package com.attraction.game.Screens;

import com.attraction.game.Attraction;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by Vladicbl on 07.08.2017.
 */

public class LevelScreen implements Screen {
    private Attraction attraction;
    private ExtendViewport viewport;

    public LevelScreen(Attraction attraction){
        this.attraction = attraction;
        //viewport = new ExtendViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),1000,1000,attraction.)
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
