package com.example.user.odaiaoc2019.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.odaiaoc2019.R;
import com.example.user.odaiaoc2019.model.BloodDonation;

import java.util.List;

/**
 * Created by Sarah on 9/20/2017.
 * this page contains the custom galley that extends
 */

public class CustomAdapter2 extends ArrayAdapter<BloodDonation> {

    private int resourceLayout;
    private Context mContext;

    public CustomAdapter2(Context context, int resource, List<BloodDonation> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    /*
    getView() method. This view is called when a listItem needs to be created and populated with the data.In this method first the View is inflated using the LayoutInflator.inflate() method. It is important that you check that if the view you are trying to inflate is new or reused
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(mContext).inflate(resourceLayout,parent,false);


        BloodDonation p = getItem(position);

        if (p != null) {


            TextView tvDescription = (TextView) v.findViewById(R.id.TextViewDescription);
            tvDescription.setText(p.toString());

            ImageView imageViewBloodType = v.findViewById(R.id.imageViewBloodType);
            if(p.getBloodType().equals("O")){
                imageViewBloodType.setImageResource(R.drawable.bloodotype);
            }

        }

        return v;
    }

}
