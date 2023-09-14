package com.mygdx.game.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends InputAdapter {

    private static final float MAX_VELOCITY = 800f;
    PolygonShape playerShape;
    FixtureDef fixtureDef;
    private Body body;
    private float width = 32;
    private float height = 32;
    public float position_x = 200;
    public float position_y = 300;
    float PlayersSpeed = 550.0f;


    Texture playerTexture;

    public Player(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position_x, position_y);

        body = world.createBody(bodyDef);

        playerShape = new PolygonShape();
        playerShape.setAsBox(width / 2, height / 2);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = playerShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.2f;
        body.createFixture(fixtureDef);
        playerTexture = new Texture("Textures/player/Fall (32x32).png");


    }


    public void render(SpriteBatch batch) {
        batch.draw(playerTexture, position_x - width / 2, position_y - height / 2);
        Vector2 vel = this.body.getLinearVelocity();
        Vector2 pos = this.body.getPosition();
        if (Gdx.input.isKeyPressed(Input.Keys.A) && vel.x > -MAX_VELOCITY) {
            this.body.applyLinearImpulse(-0.80f, 0, pos.x, pos.y, true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position_x += Gdx.graphics.getDeltaTime() * PlayersSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position_y += Gdx.graphics.getDeltaTime() * PlayersSpeed;
            System.out.println(position_x + " " + position_y);
        }
          /*if (Gdx.input.isKeyPressed(Input.Keys.S)) {
          *    position_y -= 1f;
        } */
    }

    public void dispose() {
        playerTexture.dispose();
        playerShape.dispose();
    }
}
