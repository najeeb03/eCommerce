package com.example.administrator.ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.zip.Inflater;


/**
 * Created by Administrator on 9/11/2015.
 */
public class SaleItemAdapter extends ArrayAdapter<SaleItem>{
    public  SaleItemAdapter(Context context, List<SaleItem> objects){
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, null, false);

        TextView nameTextView = (TextView)view.findViewById(R.id.item_name);
        TextView priceTextView = (TextView)view.findViewById(R.id.item_price);
        ImageView imageView = (ImageView)view.findViewById(R.id.item_image);

        SaleItem saleItem = getItem(position);

        nameTextView.setText(saleItem.name);
        priceTextView.setText(saleItem.price);
        imageView.setImageResource(saleItem.imsgeResId);

        return view;
    }
}
