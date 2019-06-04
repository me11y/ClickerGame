package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Server;

public class MenuScreen extends GameScreen {
    private Texture background;
    private TextButton playbtn;
    private TextButton regbtn;
    private TextField login;
    private TextField password;
    private Stage gui;
    private Skin skin;

    public MenuScreen(GameScreenManager gsm) {
        super(gsm);
        Buttons.load();
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture("menu.jpg");
        playbtn = new TextButton("Log in", skin);
        regbtn = new TextButton("Register", skin);
        password = new TextField("", skin);
        password.setBounds( Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.54f,Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.05f);
        login = new TextField("", skin);
        login.setBounds(Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.6f, Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.05f);
        password.getStyle().font.getData().setScale(Gdx.graphics.getHeight()/700f);
        playbtn.setBounds(Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.48f, Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.05f);
        regbtn.setBounds(Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.42f, Gdx.graphics.getWidth()*0.55f, Gdx.graphics.getHeight()*0.05f);
        gui = new Stage();
        Gdx.input.setInputProcessor(gui);
        gui.addActor(password);
        gui.addActor(login);
        gui.addActor(playbtn);
        gui.addActor(regbtn);
    }

    protected void handleInput() {
       if(regbtn.isChecked()){
           regbtn.setChecked(false);
           Server.register(login.getText(), password.getText());
           gsm.set(new GameplayScreen(gsm));
       }
    }

    @Override
    public void update(float dtime) {
        handleInput();
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        gui.act(Gdx.graphics.getDeltaTime());
        gui.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}