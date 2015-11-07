package com.arunsudhir.androidtestui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class MaterialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ArrayList<Card> cards = new ArrayList<>();


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

        //Create a Card, set the title over the image and set the thumbnail
        MaterialLargeImageCard card =
                MaterialLargeImageCard.with(this)
                        .setTextOverImage("Best of 2015")
                        .setTitle("The best melodies/chartbusters of 2015")
                        .setSubTitle("Includes Premam, Oru Vadakkan Selfie, Ennu Ninde Moideen etc")
                        .useDrawableUrl("http://www.mywimbo.com/MalRadio/PlaylistHeroImages/2015_1.jpg")
                        .setupSupplementalActions(R.layout.material, actions)
                        .build();

        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
               // Toast.makeText(this," Click on ActionArea ", Toast.LENGTH_SHORT).show();
            }
        });

        cards.add(card);
        CardArrayAdapter adap = new CardArrayAdapter(this, cards);
        CardListView gridView = (CardListView) this.findViewById(R.id.myList);
        if (gridView!=null){
            gridView.setAdapter(adap);
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

}
