package com.rocdev.android.bestellingtellerv1;

import android.content.res.Resources;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
//        implements View.OnClickListener {


    private TextView bestellingTextView;
    private TextView omzetTextView;
    private TextView gemiddeldeTextView;

    private final double FRIS = 2.0;
    private final double BIER = 2.25;
    private final double WIJN = 2.50;
    private final double KOFFIE = 1.75;
    private final double BIN_DIST = 2.75;
    private final double BUIT_DIST = 3.50;

    double bestelling;
    double omzet;
    double gemiddeldeBestelling;
    int aantalBestellingen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Button frisButton = (Button) findViewById(R.id.frisButton);
//        frisButton.setOnClickListener(this);
        frisButton.setOnClickListener(new FrisKL());
        Button bierButton = (Button) findViewById(R.id.bierButton);
//        bierButton.setOnClickListener(this);
        bierButton.setOnClickListener(new BierKL());
        Button wijnButton = (Button) findViewById(R.id.wijnButton);
//        wijnButton.setOnClickListener(this);
        wijnButton.setOnClickListener(new WijnKL());
        Button koffieButton = (Button) findViewById(R.id.koffieButton);
//        koffieButton.setOnClickListener(this);
        koffieButton.setOnClickListener(new KoffieKL());
        Button binDistButton = (Button) findViewById(R.id.binDistButton);
//        binDistButton.setOnClickListener(this);
        binDistButton.setOnClickListener(new BinDistKL());
        Button buitDistButton = (Button) findViewById(R.id.buitDistButton);
//        buitDistButton.setOnClickListener(this);
        buitDistButton.setOnClickListener(new BuitDistKL());
        Button nieuweBestellingButton = (Button) findViewById(R.id.nieuweBestellingButton);
//        nieuweBestellingButton.setOnClickListener(this);
        nieuweBestellingButton.setOnClickListener(new NieuweBestellingKL());
        bestellingTextView = (TextView) findViewById(R.id.bestellingTextView);
        omzetTextView = (TextView) findViewById(R.id.omzetTextView);
        gemiddeldeTextView = (TextView) findViewById(R.id.gemiddeldeBestellingTextView);

        bestelling = 0.0;
        omzet = 0.0;
        gemiddeldeBestelling = 0.0;
        aantalBestellingen = 0;
        toon();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    /************** De eigen klasse implementeert OnClickListener interface ******************/
//
// @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.frisButton:
//                bestelling += FRIS;
//                omzet += FRIS;
//                toon();
//                break;
//            case R.id.bierButton:
//                bestelling += BIER;
//                omzet += BIER;
//                toon();
//                break;
//            case R.id.wijnButton:
//                bestelling += WIJN;
//                omzet += WIJN;
//                toon();
//                break;
//            case R.id.koffieButton:
//                bestelling += KOFFIE;
//                omzet += KOFFIE;
//                toon();
//                break;
//            case R.id.binDistButton:
//                bestelling += BIN_DIST;
//                omzet += BIN_DIST;
//                toon();
//                break;
//            case R.id.buitDistButton:
//                bestelling += BUIT_DIST;
//                omzet += BUIT_DIST;
//                toon();
//                break;
//            case R.id.nieuweBestellingButton:
//                bestelling = 0;
//                toon();
//                break;
//        }
//
//    }

    private class FrisKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            bestelling += FRIS;
            omzet += FRIS;
            toon();
        }
    }

    private class BierKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            bestelling += BIER;
            omzet += BIER;
            toon();
        }
    }

    private class WijnKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            bestelling += WIJN;
            omzet += WIJN;
            toon();
        }
    }

    private class KoffieKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            bestelling += KOFFIE;
            omzet += KOFFIE;
            toon();
        }
    }

    private class BinDistKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            bestelling += BIN_DIST;
            omzet += BIN_DIST;
            toon();
        }
    }

    private class BuitDistKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            bestelling += BUIT_DIST;
            omzet += BUIT_DIST;
            toon();
        }
    }

    private class NieuweBestellingKL implements OnClickListener {

        @Override
        public void onClick(View v) {
            aantalBestellingen++;
            gemiddeldeBestelling = omzet / aantalBestellingen;
            bestelling = 0;
            toon();
        }
    }



    private void toon() {
        DecimalFormat df = new DecimalFormat("€ #,##0.00");
        Resources res = getResources();
        String b = res.getString(R.string.bestelling) + " " + df.format(bestelling);
        String o = res.getString(R.string.omzet) + " " + df.format(omzet);
        String g = res.getString(R.string.gemiddelde) + " " + df.format(gemiddeldeBestelling);
        bestellingTextView.setText(b);
        omzetTextView.setText(o);
        gemiddeldeTextView.setText(g);
    }
}
