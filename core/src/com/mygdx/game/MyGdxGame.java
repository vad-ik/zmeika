package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Texture character;
	boolean loader = false;
	screen sc;
	public static float red =0.1f;
	public static float blue =0.4f;
	public static float green =0.4f;
	@Override
	public void create () {

		character= new Texture("SNACE.png");
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
  sc=new screen();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(red, green, blue, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		boolean W=false;boolean A=false;boolean S=false;boolean D=false;
if (Gdx.input.isKeyPressed(Input.Keys.S)){
	S=true;
}else {
	S=false;
}
		if (Gdx.input.isKeyPressed(Input.Keys.W)){
			W=true;
		}else {
			W=false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)){
			A=true;
		}else {
			A=false;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			D=true;
		}else {
			D=false;
		}






		 sc.render(batch,character,W,A,S,D);


		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();

character.dispose();
	}
}
