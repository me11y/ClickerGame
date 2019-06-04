package com.mygdx.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.net.Socket;
import com.mygdx.game.Server;

public class Main extends ApplicationAdapter {
	public static final int HEIGHT = 1280;
	public static final int WIDTH = 720;

	public static final String TITLE = "RPGClicker";
	private GameScreenManager gsm;

	@Override
	public void create () {
		Server.serv("accounts");
		gsm = new GameScreenManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuScreen(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}

}
