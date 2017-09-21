package com.attraction.game.Screens;

import com.attraction.game.Attraction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Vladicbl on 02.08.2017.
 */

public class MainMenuScreen implements Screen {
    final Attraction attraction;

    private Stage stage;
    private TextButton play, exit;
    private Button mute;
    private Table table;
    private Sprite background;
    private Label.LabelStyle labelStyle;

    public MainMenuScreen(final Attraction attraction){
        this.attraction = attraction;
        stage = new Stage();

        Skin skin = new Skin();
        TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("Images/1.pack"));
        skin.addRegions(buttonAtlas);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = attraction.font;

        labelStyle = new Label.LabelStyle();
        labelStyle.font = attraction.font;
        table = new Table();
        table.setFillParent(true);



        play = new TextButton("Play", textButtonStyle);
        play.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.input.vibrate(20);
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //attraction.setScreen(new LevelScreen(attraction));
                attraction.setScreen(new PlayScreen(attraction));
                dispose();
                //super.touchUp(event, x, y, pointer, button);
            }
        });

        exit = new TextButton("Exit",  textButtonStyle);
        exit.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.input.vibrate(20);
                return true;
                //return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                dispose();
                //super.touchUp(event, x, y, pointer, button);
            }
        });

        //mute = new Button();

        table.add(play);
        table.row();
        table.add(exit);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
        //Gdx.input.setCatchMenuKey(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void show() {

        Gdx.gl.glClearColor(0, 1, 1, .2f);

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
        //table.setRotation(22);
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
        stage.dispose();
        //attraction.dispose();
    }
}
