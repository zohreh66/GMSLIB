package com.example.map;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;

public class MainActivity extends SherlockFragmentActivity {
static final LatLng Kerman = new LatLng(30.247995,57.046509);
private GoogleMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map =((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		if(map!=null){
			Marker kerman = map.addMarker(new MarkerOptions()
			  .position(Kerman).title("Kerman").icon(BitmapDescriptorFactory
			  .fromResource(R.drawable.ic_launcher)));
			  map.moveCamera(CameraUpdateFactory.newLatLngZoom(Kerman, 11));
			  }else{ 
				  Log.d("","OpppPsssS");
}}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
	MenuInflater inflater=this.getSupportMenuInflater();
	inflater.inflate(R.menu.main, menu);
	return true;
}
@Override	
public boolean onOptionsItemSelected(MenuItem item){
	if(item.getItemId()==R.id.subitem1){
		if(map!=null)
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);	
	}else if(item.getItemId()==R.id.subitem2){
		if(map!=null)
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	}
	else if(item.getItemId()==R.id.subitem3){
		if(map!=null)
			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);	
	}
	return super.onOptionsItemSelected(item);
}
}
