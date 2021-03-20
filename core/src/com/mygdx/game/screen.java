package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.Random;

public class screen {

    static Stage stage;
    static boolean StartFlag = true;
    static Player player = new Player("asd");
    static int sloznost = 10;





    public screen() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        Skin skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));
        TextButton newgame = new TextButton("New Game", skin);
        TextButton out = new TextButton("Exit", skin);

        table.add(newgame).fillX();
        table.row().pad(10, 0, 10, 0);
        table.add(out).fillX();
        table.row();
        stage.addActor(table);
        out.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        newgame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                StartFlag = false;
                MyGdxGame.red = 0.5f;
                MyGdxGame.green = 1f;
                MyGdxGame.blue = 1f;
            }
        });


    }


    static void render(Batch batch, Texture character,boolean W,boolean A,boolean S,boolean D) {


        if (StartFlag) {
            startmenu();
        } else {


            play(batch, character,W,A,S,D);
        }


    }

    static void play(Batch batch, Texture character,boolean W,boolean A,boolean S,boolean D) {
        player.move(batch, character,W,A,S,D);


        try {
            Thread.sleep(( 200 ));                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

    static void startmenu() {

        stage.act();
        stage.draw();

    }
}

