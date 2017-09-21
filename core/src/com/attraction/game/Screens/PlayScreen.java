package com.attraction.game.Screens;

import com.attraction.game.Attraction;
import com.attraction.game.LineActor;
import com.attraction.game.SphereActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

import sun.awt.image.GifImageDecoder;


/**
 * Created by Vladicbl on 02.08.2017.
 */

public class PlayScreen implements Screen {

    private final int WIDTH = 300;
    private final int HEIGHT = 500;

    private Attraction attraction;
    private Stage stage;
    private ArrayList<SphereActor> actors;
    private RandomXS128 random;
    private boolean relation[][];
    private LineActor line;
    private Animation a;

    public PlayScreen(Attraction attraction){

        this.attraction = attraction;
        stage = new Stage(attraction.viewport);
        Gdx.input.setInputProcessor(stage);
        for (byte i = 0; i < 15; i++){
            for (byte j = 0; j < 15; j++){
                //relation[i][j] = ;
            }
        }
        //MathUtils.atan2(2,12);
        //Math.Atan2(y1 - y2, x1 - x2) / Math.PI * 180;

        random = new RandomXS128();
        actors = new ArrayList<SphereActor>();
        //actors.add(new SphereActor(new Vector2((float)random.nextInt(WIDTH)+10,(float)random.nextInt(HEIGHT)+10),40));
        actors.add(new SphereActor(new Vector2((float)random.nextInt(11)+10,(float)random.nextInt(11)+10),40));
        stage.addActor(actors.get(0));
        actors.add(new SphereActor(new Vector2((float)random.nextInt(111)+10,(float)random.nextInt(11)+10),40));
        stage.addActor(actors.get(1));
        for (byte i = 1; i < 2; i++) {
            actors.add(new SphereActor(sampleCandidate(),40));
            stage.addActor(actors.get(i));
        }
        line = new LineActor(new Vector2(actors.get(0).getSphereVector()),
                (MathUtils.atan2(actors.get(0).getSphereVector().y - actors.get(1).getSphereVector().y,
                actors.get(0).getSphereVector().x - actors.get(1).getSphereVector().x)) / (float)Math.PI * 180);
        LineActor line1 = new LineActor(new Vector2(actors.get(1).getSphereVector()),
                (MathUtils.atan2(actors.get(0).getSphereVector().y - actors.get(1).getSphereVector().y,
                        actors.get(0).getSphereVector().x - actors.get(1).getSphereVector().x)) / (float)Math.PI * 180);

        stage.addActor(line);
        //stage.addActor(line1);
        float b = MathUtils.atan2(actors.get(0).getSphereVector().y - actors.get(1).getSphereVector().y,
                actors.get(0).getSphereVector().x - actors.get(1).getSphereVector().x) / (float)Math.PI * 180;
        System.out.print(b);
    }

    private Vector2 sampleCandidate(){
        byte numCandidates = 100;
        Vector2 candidate = new Vector2();
        Vector2 bestCandidate = new Vector2();
        float bestDistance = 0f;
        float distance;
        for (byte i = 0; i < numCandidates; i++){
            candidate.set((float)random.nextInt(WIDTH)+10,(float)random.nextInt(HEIGHT)+10);
            distance = candidate.dst(findClosest(candidate));
            if (distance > bestDistance) {
                //bestCandidate = candidate; делал это и творилась дичь.
                bestCandidate.set(candidate.x,candidate.y);
                bestDistance = distance;
            }
        }
        return bestCandidate;
    }

    private Vector2 findClosest(Vector2 sample){
        float bestDistance = 1000f;
        Vector2 closest = new Vector2();
        for (byte i = 0; i < actors.size(); i++){
            if (sample.dst(actors.get(i).getSphereVector()) < bestDistance){
                bestDistance = sample.dst(actors.get(i).getSphereVector());
                closest = actors.get(i).getSphereVector();
            }
        }
        return closest;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0, 0.4f,0.3f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        stage.draw();

    }

    public void update(float delta){
        stage.act(Gdx.graphics.getDeltaTime());
        float i=0;
        line.setRotation(i);
        i++;
        //intersection();
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
        stage.dispose();
    }





    private boolean intersection(Vector2 start1, Vector2 end1, Vector2 start2, Vector2 end2, Vector2 out_intersection) {
        /*Vector2 dir1 = end1 - start1;
        Vector2 dir2 = end2 - start2;

        //считаем уравнения прямых проходящих через отрезки
        float a1 = -dir1.y;
        float b1 = +dir1.x;
        float d1 = -(a1*start1.x + b1*start1.y);

        float a2 = -dir2.y;
        float b2 = +dir2.x;
        float d2 = -(a2*start2.x + b2*start2.y);

        //подставляем концы отрезков, для выяснения в каких полуплоскотях они
        float seg1_line2_start = a2*start1.x + b2*start1.y + d2;
        float seg1_line2_end = a2*end1.x + b2*end1.y + d2;

        float seg2_line1_start = a1*start2.x + b1*start2.y + d1;
        float seg2_line1_end = a1*end2.x + b1*end2.y + d1;

        //если концы одного отрезка имеют один знак, значит он в одной полуплоскости и пересечения нет.
        if (seg1_line2_start * seg1_line2_end >= 0 || seg2_line1_start * seg2_line1_end >= 0)
            return false;

        float u = seg1_line2_start / (seg1_line2_start - seg1_line2_end);
        //*out_intersection =  start1 + u*dir1;
*/
        return true;
    }
}
