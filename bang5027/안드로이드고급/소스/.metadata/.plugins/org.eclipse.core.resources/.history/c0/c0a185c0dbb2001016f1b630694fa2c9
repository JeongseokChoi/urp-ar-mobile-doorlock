package app.exam;

import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		LocationManager locationManager = 
			(LocationManager) getSystemService(Context.LOCATION_SERVICE);	
		
		List<String> providerNames = locationManager.getProviders(true);
		
		ListAdapter listAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_single_choice, providerNames);
		this.setListAdapter(listAdapter);
		this.getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
}