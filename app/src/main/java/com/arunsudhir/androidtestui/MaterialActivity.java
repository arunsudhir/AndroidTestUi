package com.arunsudhir.androidtestui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardViewNative;

import static android.widget.Toast.*;

public class MaterialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<Card> cards = new ArrayList<>();

/*
        // Set supplemental actions as text
        ArrayList<BaseSupplementalAction> actions = new ArrayList<>();

        // Set supplemental actions
        TextSupplementalAction t1 = new TextSupplementalAction(this, R.id.text1);
        t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
              //  Toast.makeText(this," Click on Text SHARE ",Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(t1);

        TextSupplementalAction t2 = new TextSupplementalAction(this, R.id.text2);
        t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
            @Override
            public void onClick(Card card, View view) {
              //  Toast.makeText(this," Click on Text LEARN ",Toast.LENGTH_SHORT).show();
            }
        });
        actions.add(t2);
*/

        /* cards.add(createCard(this, "Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        cards.add(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        CardArrayAdapter adap = new CardArrayAdapter(this, cards);
        */
        CardViewNative cn = (CardViewNative) this.findViewById(R.id.carddemo_largeimage);
       // CardGridView gridView = (CardGridView) this.findViewById(R.id.myList);
        if (cn!=null){
            cn.setCard(createCard(this,"Best of 2015", "The best melodies/chartbusters of 2015", "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg"));
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Card createCard(final Context context, String textOver, String title, final String drawableUrl)
    {
        MaterialLargeImageCard card =
                MaterialLargeImageCard.with(context)
                        .setTextOverImage("Italian Beaches")
                        .setTitle("This is my favorite local beach")
                        .setSubTitle("A wonderful place")
                        .useDrawableExternal(new MaterialLargeImageCard.DrawableExternal() {
                            @Override
                            public void setupInnerViewElements(ViewGroup parent, View viewImage) {

                                Picasso.with(context).setIndicatorsEnabled(true);  //only for debug tests
                                Picasso.with(context)
                                        .load(drawableUrl)
                                       // .error(R.drawable.ic_error_loadingsmall)
                                        .into((ImageView) viewImage);
                            }
                        })
                        //.setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large, actions)
                        .build();
        final Activity act = this;
        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                makeText(act, " Click on ActionArea ", LENGTH_SHORT).show();
            }
        });
        return card;
    }

    private Card createCard2(Context context, String textOver, String title, String drawableUrl)
    {
        Card card = new Card(this, R.layout.card_thumbnail);
        CardThumbnail cdt = new CardThumbnail(context);
        cdt.setUrlResource(drawableUrl);
        card.addCardThumbnail(cdt);
        card.getCardHeader().setTitle(title);
        return card;
    }

}
