package com.attraction.game;

import com.attraction.game.Screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Attraction extends Game {
	public Viewport viewport;
	public OrthographicCamera camera;
	public BitmapFont font, levels;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁ" +
			"ЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrst" +
			"uvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567" +
			"89][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

//	private static Attraction instance = new Attraction();
//	public static Attraction getInstance(){
//		return instance;
//	}

	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new StretchViewport(400,400);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/BAUHS93.TTF"));
		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = Gdx.graphics.getHeight() / 20;
		param.characters = FONT_CHARACTERS;
		font = generator.generateFont(param);
		param.size = Gdx.graphics.getHeight() / 22;
		font.setColor(Color.BLACK);
		generator.dispose();
		setScreen(new MainMenuScreen(this));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose () {
	}

	@Override
	public void resize(int width, int height) {

	}
}

/*

		// BLURE - https://github.com/mattdesl/lwjgl-basics/wiki/ShaderLesson5
		//boolean npotSupported = Gdx.graphics.supportsExtension("GL_OES_texture_npot")
		//		|| Gdx.graphics.supportsExtension("GL_ARB_texture_non_power_of_two"); // chek support of NPOT images																	//создание сфер
		//NOTE use 1024x1024 textures or lesser.
		//abs((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1))  расстояние между 2 точками.
		// swipe https://github.com/mattdesl/lwjgl-basics/wiki/LibGDX-Finger-Swipe
		// signing your apk https://developer.android.com/studio/publish/app-signing.html
		Random random;
		Vector3 vector3;
		float distance;
		random = new Random();
		vector3 = new Vector3(random.nextInt(100),random.nextInt(100),0); //создание сфер
		spheres[0] = new SphereClass(vector3,32f);
		for (int i = 1; i < 10; i++){
		vector3.set(random.nextInt(100),random.nextInt(100),0);
		spheres[i] = new SphereClass(vector3,32f);
		for (int j = 0; j < i - 1; j++){
		distance =  abs((spheres[j].getX()-spheres[i].getX())*(spheres[j].getX()-spheres[i].getX()) +
		(spheres[j].getY()-spheres[i].getY())*(spheres[j].getY()-spheres[i].getY()));
		if (distance < 10) {
		} else {
		}
		}
		}*/