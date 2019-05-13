package com.example.remindme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventListAdapter extends ArrayAdapter<EventElement>
{

    private final LayoutInflater inflater;
    private Context context;
    private ViewHolder holder;
    private ArrayList<EventElement> events;


    public EventListAdapter(Context context, ArrayList<EventElement> events) {
        super(context, 0, events);
        this.context = context;
        this.events = events;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public EventElement getItem(int position) {
        //return super.getItem(position);
        return events.get(position);
    }
    @Override
    public long getItemId(int position) {
        return events.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.event_element, null);
            holder = new ViewHolder();
            holder.txt_event_name = (TextView)convertView.findViewById(R.id.event_name);
            holder.txt_location = (TextView)convertView.findViewById(R.id.location);
            holder.txt_date = (TextView)convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }
        EventElement person = events.get(position);
        if(person != null){
            holder.txt_date.setText(person.getDate());
            holder.txt_event_name.setText(person.getName());
            holder.txt_location.setText(person.getLocation());

        }
        return convertView;

    }

    private static class ViewHolder {
        TextView txt_event_name;
        TextView txt_location;
        TextView txt_date;
    }

}
