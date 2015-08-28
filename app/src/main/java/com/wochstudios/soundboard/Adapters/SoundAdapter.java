package com.wochstudios.soundboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wochstudios.soundboard.Models.Sound;
import com.wochstudios.soundboard.R;

import java.util.List;

/**
 * Created by dave on 8/6/2015.
 */
public class SoundAdapter extends ArrayAdapter<Sound> {

    private ViewHolder viewHolder;

    public SoundAdapter(Context context, List<Sound> objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Sound sound  = getItem(position);
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder.soundTitleText = (TextView)convertView.findViewById(R.id.listItemTxt);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.soundTitleText.setText(sound.getTitle());

        return convertView;
    }

    private class ViewHolder{
        TextView soundTitleText;
    }
}
