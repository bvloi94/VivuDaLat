package com.loibv.vivudalat.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loibv.vivudalat.model.Place;
import com.loibv.vivudalat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanloibui on 12/21/15.
 */
public class ListAdapter extends ArrayAdapter<Place> {

    private List<Place> placeList = new ArrayList<Place>();

    static class PlaceViewHolder {
        ImageView placeImg;
        TextView placeName;
    }

    public ListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlaceViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.lv_item, parent, false);
            viewHolder = new PlaceViewHolder();
            viewHolder.placeName = (TextView) row.findViewById(R.id.tvPlaceName);
            viewHolder.placeImg = (ImageView) row.findViewById(R.id.ivPlacePhoto);
            row.setTag(viewHolder);
        } else {
            viewHolder = (PlaceViewHolder) row.getTag();
        }

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto.ttf");
        Place place = getItem(position);

        viewHolder.placeName.setText(place.getName());
        viewHolder.placeName.setTypeface(tf);

        viewHolder.placeImg.setImageResource(place.getImageId());
        return row;
    }
}
