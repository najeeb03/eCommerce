package com.example.administrator.ecommerce;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.list);
        final ArrayList<SaleItem> saleItems = new ArrayList<>();
        SaleItemAdapter saleItemAdapter = new SaleItemAdapter(this, saleItems);

        SaleItem s0 = new SaleItem("name", "price", "www.amazon.com", R.drawable.cart);
        SaleItem s1 = new SaleItem("Blu Studio Energy", "USD 149.00", "http://www.amazon.com/BLU-Studio-Energy-Battery-Unlocked/dp/B00T6J3USK", R.drawable.studioenergy);
        SaleItem s2 = new SaleItem("Mountain Bike", "BDT 16,000", "http://bikroy.com/en/ad/customized-totem-grim-for-sale-dhaka", R.drawable.bike);


        saleItems.add(s0);
        saleItems.add(s1);
        saleItems.add(s2);

        listView.setAdapter(saleItemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SaleItem saleItem = saleItems.get(i);
                String url = saleItem.url;

                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

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
}
