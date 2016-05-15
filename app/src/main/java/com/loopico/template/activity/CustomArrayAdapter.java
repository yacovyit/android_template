package com.loopico.template.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.loopico.template.R;
import com.loopico.template.activity.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yacovyitzhak on 09/05/2016.
 */
public class CustomArrayAdapter extends ArrayAdapter<User> {

    private Context ctx;


    public CustomArrayAdapter(Context context, List<User> objects) {
        super(context,0, objects);
        this.ctx = context;

    }

    private static class ViewHolder {
        private TextView textViewFirstName;
        private TextView textViewLastName;
        public ViewHolder(View view){
            this.textViewFirstName = (TextView)view.findViewById(R.id.textViewFirstName);
            this.textViewLastName = (TextView)view.findViewById(R.id.textViewLastName);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        User user = getItem(position);
        ViewHolder viewHolder ;
        if (convertView == null){

            convertView = LayoutInflater.from(ctx).inflate(R.layout.cutom_user_item,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.textViewFirstName.setText(user.getFirstName());
        viewHolder.textViewLastName.setText(user.getLastName());

        return convertView;
    }
}
