package com.arunsudhir.androidtestui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;

public class GridActivity extends AppCompatActivity {

    public static String baseUrl = "http://www.mywimbo.com/MalRadio/PlaylistHeroImages/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(addCard("2015_1.jpg"));
        cards.add(addCard("medley_1.jpg"));
        cards.add(addCard("jaya_1.jpg"));
        cards.add(addCard("newly_1.jpg"));
        cards.add(addCard("vidya_1.jpg"));
        cards.add(addCard("2013_1.jpg"));
        cards.add(addCard("2014_1.jpg"));
        /*cards.add(addCard());
        cards.add(addCard());
        cards.add(addCard());
        cards.add(addCard());*/


        CardGridArrayAdapter mCardArrayAdapter = new CardGridArrayAdapter(this,cards);

        CardGridView gridView = (CardGridView) this.findViewById(R.id.myGrid);
        if (gridView!=null){
            gridView.setAdapter(mCardArrayAdapter);
        }
    }

    public Card addCard(String cardPath)
    {
        //Create a Card
        Card card = new Card(this);

        //Create a CardHeader
        CardHeader header = new CardHeader(this);
        header.setTitle("Best of 2015");
        // Create acard thumbnail
        CardThumbnail ct = new CardThumbnail(this);
        ct.setUrlResource(baseUrl + cardPath);

        //Add Header to card
        card.addCardHeader(header);
        card.addCardThumbnail(ct);
        card.setTitle("  blah blah");
          return card;
    }

}
