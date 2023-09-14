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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Level.Level_maker;
import com.mygdx.game.Level.Player;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    OrthographicCamera camera;
    OrthogonalTiledMapRenderer mapRender;
    World world;
    TiledMap map;
    Level_maker level1;
    Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        world = new World(new Vector2(0, -10), true);
        player = new Player(world);
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
        player.render(batch);
        mapRender.setView(camera);
        camera.update();
        mapRender.render();
        batch.end();
        world.step(1/60f,6,2);
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();

    }
}
