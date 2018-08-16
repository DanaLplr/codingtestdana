package com.appstud.codingtestdana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ListActivity extends AppCompatActivity {

    // on effectue le même listener pour revenir sur la partie map lorsque l'utilisateur clique dessus
    public Button map;

    public void actionmap() {

        map = (Button) findViewById(R.id.btnMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accesmap = new Intent(ListActivity.this, MainActivity.class);

                startActivity(accesmap);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // on appelle la méthode pour lancer l'activité Main
        actionmap();
    }
}
