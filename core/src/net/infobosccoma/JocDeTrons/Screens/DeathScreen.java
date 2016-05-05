package net.infobosccoma.JocDeTrons.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import net.infobosccoma.JocDeTrons.JocDeTrons;

/**
 * Classe que modela la pantalla principal del joc, la qual té un menú d'opcions
 */
public class DeathScreen extends AbstractScreen {
    //<editor-fold desc="Atributs">
    private Table table;
    private TextButton buttonMenu, buttonPlay;
    private Label title;
    private Music musica;
    //</editor-fold>

    //<editor-fold desc="Constructor">

    /**
     * Constructor
     *
     * @param joc Classe principal del joc
     */
    public DeathScreen(net.infobosccoma.JocDeTrons.JocDeTrons joc) {
        super(joc);
        carregarMusica();

        table = new Table();
        buttonPlay = new TextButton("Retry", joc.getSkin(), "buttonStyle");
        buttonMenu = new TextButton("Return to main menu", joc.getSkin(),"buttonStyle");

        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new Level1(getGame(),2));
            }
        });
        buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen(getGame()));
            }
        });

        title = new Label("GAME OVER",joc.getSkin(),"defaultStyle");
    }

    private void carregarMusica() {
        musica = Gdx.audio.newMusic(Gdx.files
                .internal("sons/gameover.mp3"));
        musica.setLooping(false);
        musica.setVolume(2f);
        musica.play();
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
        table.add(buttonMenu).size(150*Gdx.graphics.getDensity(),60*Gdx.graphics.getDensity()).padBottom(20*Gdx.graphics.getDensity()).row();
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