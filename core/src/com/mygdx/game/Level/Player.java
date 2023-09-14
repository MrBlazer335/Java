package com.mygdx.game.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends InputAdapter {
    float position_x = 200;
    float position_y = 300;
    float PlayersSpeed = 55.0f;
    Vector2 vector2;
    Texture playerTexture;

    public Player() {
        playerTexture = new Texture("Textures/player/Fall (32x32).png");
        vector2 = new Vector2(position_x, position_y);
    }


    public void render(SpriteBatch batch) {
        batch.draw(playerTexture, position_x, position_y);
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position_x -= Gdx.graphics.getDeltaTime() * PlayersSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position_x += Gdx.graphics.getDeltaTime() * PlayersSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position_y += Gdx.graphics.getDeltaTime() * PlayersSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position_y -= 1f;
        }
    }

    public void dispose() {
        playerTexture = null;
    }
}
