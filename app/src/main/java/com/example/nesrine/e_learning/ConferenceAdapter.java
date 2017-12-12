package com.example.nesrine.e_learning;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nesrine on 10/12/2017.
 */

public class ConferenceAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ConferenceAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView titre , adr , date , hD, hF, descp, form;
    }
    public void add( Conference object) {

        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_conference,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.titre =(TextView)row.findViewById(R.id.T);
            layoutHandler.date =(TextView)row.findViewById(R.id.D);
            layoutHandler.hD =(TextView) row.findViewById(R.id.hd);
            layoutHandler.hF =(TextView) row.findViewById(R.id.hf);
            layoutHandler.form =(TextView) row.findViewById(R.id.form);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        Conference conference = (Conference)this.getItem(position);
        layoutHandler.titre.setText(conference.getTitre());
        layoutHandler.date.setText(conference.getDateConf());
        layoutHandler.hD.setText(conference.getHeureD());
        layoutHandler.hF.setText(conference.getHeureF());
        layoutHandler.form.setText(conference.getForm_ref());
        return row;
    }
}
