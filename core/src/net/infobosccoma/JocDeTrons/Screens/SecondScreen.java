package net.infobosccoma.JocDeTrons.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Una pantalla del joc: la pantalla de presentació d'inici
 *
 * @author Marc
 *
 */
public class SecondScreen extends AbstractScreen {

    //<editor-fold desc="Atributs">
    private Texture splashTexture;	// la textura a mostrar
    private Image splashImage;		// la imatge
    private Music musica;			// l'àudio a reproduir
    //</editor-fold>

    //<editor-fold desc="Constructor">
    public SecondScreen(net.infobosccoma.JocDeTrons.JocDeTrons joc) {
        super(joc);
    }
    //</editor-fold>

    //<editor-fold desc="Mêtodes sobreescrits">
    @Override
    public void show() {

        super.show();

        musica = Gdx.audio.newMusic(Gdx.files
                .internal("sons/surprise.mp3"));
        musica.setLooping(false);
        musica.setVolume(1f);
        musica.play();

        // carregar la imatge
        splashTexture = new Texture(
                Gdx.files.internal("imatges/segonaPantalla.png"));
        // seleccionar Linear per millorar l'estirament
        splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        splashImage = new Image(splashTexture);
        splashImage.setFillParent(true);

        // això només és necessari perquè funcioni correctament l'efecte fade-in
        // Només fa la imatge completament transparent
        splashImage.getColor().a = 0f;

        // configuro l'efecte de fade-in/out de la imatge de splash
        // sequence indica que es faran de manera consecutiva.
        splashImage.addAction(Actions.sequence(Actions.fadeIn(1f),
                Actions.delay(4f), Actions.fadeOut(1f), new Action() {
                    @Override
                    public boolean act(float delta) {
                        nextScreen();
                        return true;
                    }
                }));

        // finalment afegim l'actor a l'stage
        stage.addActor(splashImage);

    }

    /**
     * canviar a la següent pantalla
     */
    private void nextScreen() {
//        musica.stop();
        // la darrera acció ens porta cap a la següent pantalla
        joc.setScreen(new SplashScreen(joc));
    }

    /**
     * en aixecar el botó del mouse després de fer clic o bé en aixecar el dit després de fer
     * touch
     *
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     * @return
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        nextScreen();
        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
        splashTexture.dispose();
    }
    //</editor-fold>
}
