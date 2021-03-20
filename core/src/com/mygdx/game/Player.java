package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.Random;

public class Player {
static Texture aple =new Texture("apple.png");
    static ArrayList<Integer> snaceX = new ArrayList<>();
    static ArrayList<Integer> snaceY = new ArrayList<>();
    String Name;
    static boolean apple;
  static int longer;
   static int life;
static boolean FalgDead=false;
    static boolean w;
    static boolean a;
    static boolean s;
    static boolean d;
    static public int x;
    static public int y;
   static int apleX;
   static int apleY;
    public Player(String name) {
   longer=1;
        Name = name;
apple=false;
        life = 100;
apleX=10;
apleY=10;
snaceX.add(320);
snaceY.add(240);
        w=false;
        a=false;
        s=false;
        d=false;

    }

    public static void move(Batch batch, Texture character,boolean W,boolean A,boolean S,boolean D) {
        if ((a==false)&&(w==false)&&(s==false)&&(d==false)) {
        drawSprite(batch,character);

        }



if (FalgDead ==true){
    dead();
}

if (apple==false){
    Random random = new Random();
    apleX=(random.nextInt(640))/40;
    apleX=apleX*40;
   apleY=(random.nextInt(480))/40;
    apleY=apleY*40;

    apple=true;

}
if ((apleY==snaceY.get(0))&&(apleX==snaceX.get(0))){
    apple=false;
    longer++;
}
        batch.draw(aple,apleX,apleY);





        if(W){
         w=true;
            a=false;
            s=false;
            d=false;
            if(snaceY.get(0)<440){snaceY.add(0,snaceY.get(0)+40);
                snaceX.add(0,snaceX.get(0));
            }else {dead();}


                drawSprite(batch,character);








        }else
            if(A){
                w=false;
                a=true;
                s=false;
                d=false;
if(snaceX.get(0)>0) {
    snaceX.add(0,snaceX.get(0) - 40);
    snaceY.add(0,snaceY.get(0));
}else {dead();}

                    drawSprite(batch,character);




            }else
            if(S){
                    w=false;
                    a=false;
                    s=true;
                    d=false;
                 if(snaceY.get(0)>0){  snaceY.add(0,snaceY.get(0)-40);
                     snaceX.add(0,snaceX.get(0));
                 }else {dead();}

                    drawSprite(batch,character);




                }else
            if(D){
                        w=false;
                        a=false;
                        s=false;
                        d=true;
                       if(snaceX.get(0)<600){snaceX.add(0,snaceX.get(0) +40);
                           snaceY.add(0,snaceY.get(0));
                       }else {dead();}

                    drawSprite(batch,character);


            }else if (s==true){
                if(snaceY.get(0)>0){  snaceY.add(0,snaceY.get(0)-40);
                    snaceX.add(0,snaceX.get(0));
                }else {dead();}
                drawSprite(batch,character);
            }else if (w==true){
                if(snaceY.get(0)<440){snaceY.add(0,snaceY.get(0)+40);
                    snaceX.add(0,snaceX.get(0));}else {dead();}
                drawSprite(batch,character);
            }else if (a==true){
                if(snaceX.get(0)>0) {
                    snaceX.add(0,snaceX.get(0) - 40);
                    snaceY.add(0,snaceY.get(0));
                }else {dead();}
                drawSprite(batch,character);
            }else if (d==true){
                if(snaceX.get(0)<600){snaceX.add(0,snaceX.get(0) +40);
                snaceY.add(0,snaceY.get(0));
            }else {dead();}
                drawSprite(batch,character);
            }







    }
    private static void drawSprite(Batch batch, Texture texture) {

        for (int i = 0; i < longer; i++) {


            batch.draw(texture, snaceX.get(i), snaceY.get(i));


            if (( snaceY.get(0).equals(snaceY.get(i)) ) && ( ( snaceX.get(0).equals(snaceX.get(i)) ) )&&(i!=0)) {
                dead();
            }

        }
    }
static void dead(){
    FalgDead =true;
    Stage stage = new Stage(new ScreenViewport());
    Gdx.input.setInputProcessor(stage);

    Table table = new Table();
    table.setFillParent(true);
    Skin skin = new Skin(Gdx.files.internal("pixthulhu/skin/pixthulhu-ui.json"));

    TextButton out = new TextButton("you died", skin);


    table.add(out).fillX();
    table.row();
    stage.addActor(table);
    out.addListener(new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.exit();
        }
    });

    stage.act();
    stage.draw();


}


















    }



















