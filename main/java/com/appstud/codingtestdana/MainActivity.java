package com.appstud.codingtestdana;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    // on déclare les variables
    public Button list;
    public Marker myMarker; // utiliser lorsque l'application ne récupère pas la localisation
    public LocationManager locationMan; // afin de trouver la localisation
    public GoogleMap gMap;
//    public double lat = 43.6111186;
//    public double lon;

    public LatLng latLng(double latitude, double longitude) {
        return null;
    }

    //on déclare les getter et setter des variables
    public Marker getMyMarker() {
        return myMarker;
    }

    public void setMyMarker(Marker myMarker) {
        this.myMarker = myMarker;
    }

    public GoogleMap getgMap() {
        return gMap;
    }

    public void setgMap(GoogleMap gMap) {
        this.gMap = gMap;
    }

    public LocationManager getLocationMan() {
        return locationMan;
    }

    public void setLocationMan(LocationManager locationMan) {
        this.locationMan = locationMan;
    }

    public void actionlist() {
        // on attribut au bouton l'id correspondant
        list = (Button) findViewById(R.id.btnList);
        // action lorsque l'utilisateur clique sur le bouton
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pour accéder à la ListActivity (la page ou se trouve la liste des endroits)
                Intent acceslist = new Intent(MainActivity.this, ListActivity.class);

                startActivity(acceslist);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on appelle la méthode pour lancer l'activité List
        actionlist();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) throws SecurityException {
        gMap = googleMap;
//        gMap.setMaxZoomPreference(15);
//        gMap.setMinZoomPreference(10);
        gMap.setMyLocationEnabled(false); // n'affiche pas le rond bleu de localisation
        gMap.getUiSettings().setZoomControlsEnabled(true); // affiche les boutons de zoom
        gMap.getUiSettings().setZoomGesturesEnabled(true); // autorise le zoom tactile
        gMap.getUiSettings().setCompassEnabled(false); // n'affiche pas le compas
        gMap.getUiSettings().setMyLocationButtonEnabled(true); // affiche le bouton de localisation

        myMarker = gMap.addMarker(new MarkerOptions().position(new LatLng(43.6111186, 1.4460483)));

        // gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng(43.6111186, 1.4460483), 15));

        // desabonnementGPS();
    }

    // méthode appelée quand les coordonnées GPS du smartphone changent
    public void onLocationChanged(final Location myLoc) {

        // Récupération des cordonnées (latitude, longitude) et création d’un objet
        // myPos de la classe LatLng représentant cette position
        final LatLng myPos = new LatLng(myLoc.getLatitude(), myLoc.getLongitude());
        // Centrage de la carte sur la position GPS obtenue
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPos, 15));
        myMarker.setPosition(myPos);
    }

//    @Override // méthode appelée quand le status d’une source de localisation change
//    public void onStatusChanged(final String provider, final int status, final Bundle extras) {
//    }
//
//    public void abonnementGPS() throws SecurityException {
//        // demande de réception de localisations du GPS au minimum toutes les 5000 ms et
//        // lorsque la distance entre la dernière localisation reçue est supérieure à 10 m
//        locationMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, pending);
//    }
//
//    public void desabonnementGPS() throws SecurityException {
//        locationMan.removeUpdates(this);
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        // On appelle la méthode pour se désabonner
//        desabonnementGPS();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        // Obtention de la référence du service
//        locationMan = (LocationManager) this.getSystemService(LOCATION_SERVICE);
//        // Si le GPS est disponible, on s'y abonne
//        if (locationMan.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            abonnementGPS();
//        }
//    }
//
//    //méthode appelé quand les coordonnées GPS du smarthphone change
//    public void onLocationChanged(final Location myLoc) {
//
//    }
}
