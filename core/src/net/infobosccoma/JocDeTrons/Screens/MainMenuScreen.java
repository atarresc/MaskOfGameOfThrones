package net.infobosccoma.JocDeTrons.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Classe que modela la pantalla principal del joc, la qual té un menú d'opcions
 */
public class MainMenuScreen extends AbstractScreen {
    //<editor-fold desc="Atributs">
    private Table table;
    private TextButton buttonPlay, buttonExit;
    private Label title;
    //</editor-fold>

    //<editor-fold desc="Constructor">

    /**
     * Constructor
     *
     * @param joc Classe principal del joc
     */
    public MainMenuScreen(net.infobosccoma.JocDeTrons.JocDeTrons joc) {
        super(joc);

        table = new Table();
        buttonPlay = new TextButton("Play", joc.getSkin(),"buttonStyle");
        buttonExit = new TextButton("Exit", joc.getSkin(),"buttonStyle");
        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new Level1(getGame()));
            }
        });
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        title = new Label("MASK OF GAME OF THRONES",joc.getSkin(),"defaultStyle");
    }
    //</editor-fold>

    //<editor-fold desc="Mètodes sobreescrits">
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        calculRedimensionat();
        stage.act();
        stage.draw();
    }


    @Override
    public void show() {
        table.add(title).padBottom(40 * Gdx.graphics.getDensity()).row();
        table.add(buttonPlay).size(150*Gdx.graphics.getDensity(),60*Gdx.graphics.getDensity()).padBottom(20*Gdx.graphics.getDensity()).row();
        table.add(buttonExit).size(150*Gdx.graphics.getDensity(),60*Gdx.graphics.getDensity()).padBottom(20*Gdx.graphics.getDensity()).row();
        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
    //</editor-fold>

}