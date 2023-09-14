package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Level.Level_maker;
import com.mygdx.game.Level.Player;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;

    OrthographicCamera camera;
    OrthogonalTiledMapRenderer mapRender;

    TiledMap map;
    Level_maker level1;
    Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Player();
        level1 = new Level_maker("test.tmx");
        map = new TmxMapLoader().load("test.tmx");
        mapRender = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.keyDown(Input.Keys.A);
        }
        player.render(batch);
        mapRender.setView(camera);
        camera.update();
        mapRender.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();

    }
}
