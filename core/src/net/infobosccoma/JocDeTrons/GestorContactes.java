package net.infobosccoma.JocDeTrons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import net.infobosccoma.JocDeTrons.Screens.DeathScreen;
import net.infobosccoma.JocDeTrons.Screens.EndingScreen;
import net.infobosccoma.JocDeTrons.Screens.Level1;
import net.infobosccoma.JocDeTrons.Screens.Level2;
import net.infobosccoma.JocDeTrons.Screens.SplashScreen;

import java.util.ArrayList;

/**
 * Classe que implementa la interface de gestió de contactes
 *
 * @author Marc
 */
public class GestorContactes implements ContactListener {
    //<editor-fold desc="Atributs">
    // de moment, no utilitzat
    private ArrayList<Body> bodyDestroyList;
    private JocDeTrons joc;
    private Personatge personatge;
    //</editor-fold>


    //<editor-fold desc="Constructors">
    public GestorContactes(JocDeTrons joc, Personatge personatge, ArrayList<Body> bodyDestroyList) {

        this.joc = joc;
        this.personatge = personatge;
        this.bodyDestroyList = bodyDestroyList;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        if (fixtureA.getBody().getUserData() == null
                || fixtureB.getBody().getUserData() == null) {
            return;
        }

        if (fixtureA.getBody().getUserData().equals("Personatge")
                && fixtureB.getBody().getUserData().equals("Mask")
                || fixtureA.getBody().getUserData().equals("Mask")
                && fixtureB.getBody().getUserData().equals("Personatge")) {

            /*
             * Afegir cos a destruir
			 */
            if (!fixtureA.getBody().getUserData().equals("Personatge")) {
                bodyDestroyList.add(fixtureA.getBody());
            } else {
                bodyDestroyList.add(fixtureB.getBody());
            }
        }

        if (fixtureA.getBody().getUserData().equals("Personatge")
                && fixtureB.getBody().getUserData().equals("aigua")
                || fixtureA.getBody().getUserData().equals("aigua")
                && fixtureB.getBody().getUserData().equals("Personatge")) {


            if (fixtureA.getBody().getUserData().equals("Personatge")) {
                personatge.setLives(personatge.getLives() - 1);
                if (personatge.getLives() >= 0) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new Level1(joc, personatge.getLives()));
                        }
                    });
                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new DeathScreen(joc));
                        }
                    });
                }

            } else {
                personatge.setLives(personatge.getLives() - 1);
                if (personatge.getLives() >= 0) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new Level1(joc, personatge.getLives()));
                        }
                    });
                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new DeathScreen(joc));
                        }
                    });
                }
            }
        }

        if (fixtureA.getBody().getUserData().equals("Personatge")
                && fixtureB.getBody().getUserData().equals("aigua2")
                || fixtureA.getBody().getUserData().equals("aigua2")
                && fixtureB.getBody().getUserData().equals("Personatge")) {


            if (fixtureA.getBody().getUserData().equals("Personatge")) {
                personatge.setLives(personatge.getLives() - 1);
                if (personatge.getLives() >= 0) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new Level2(joc, personatge.getLives()));
                        }
                    });
                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new DeathScreen(joc));
                        }
                    });
                }

            } else {
                personatge.setLives(personatge.getLives() - 1);
                if (personatge.getLives() >= 0) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new Level2(joc, personatge.getLives()));
                        }
                    });
                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new DeathScreen(joc));
                        }
                    });
                }
            }
        }

        if (fixtureA.getBody().getUserData().equals("Personatge")
                && fixtureB.getBody().getUserData().equals("dreta")
                || fixtureA.getBody().getUserData().equals("dreta")
                && fixtureB.getBody().getUserData().equals("Personatge")) {

            if (!personatge.isMask()) {
                if (fixtureA.getBody().getUserData().equals("Personatge")) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new Level2(joc, personatge.getLives()));
                        }
                    });

                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new Level2(joc, personatge.getLives()));
                        }
                    });
                }
            }
        }

        if (fixtureA.getBody().getUserData().equals("Personatge")
                && fixtureB.getBody().getUserData().equals("dreta2")
                || fixtureA.getBody().getUserData().equals("dreta2")
                && fixtureB.getBody().getUserData().equals("Personatge")) {

            if (!personatge.isMask()) {
                if (fixtureA.getBody().getUserData().equals("Personatge")) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new EndingScreen(joc));
                        }
                    });

                } else {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            joc.setScreen(new EndingScreen(joc));
                        }
                    });
                }
            }
        }
    }
    //</editor-fold>


    //<editor-fold desc="Mètodes implementats de la interface ContactListener">
    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // TODO Auto-generated method stub

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // TODO Auto-generated method stub

    }
    //</editor-fold>

}
