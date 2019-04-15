package cs2340.todo_team_name.spacetrader.views;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import cs2340.todo_team_name.spacetrader.model.SolarSystem;

class SolarSystemAdaptor extends ArrayAdapter<SolarSystem> {

    // Your sent context
    private final Context context;
    // Your custom values for the spinner (User)
    private SolarSystem[] values;

    /**
     * Constructor for our SolarSystemAdaptor
     * @param context provided app context
     * @param textViewResourceId a resource id
     * @param values a ser of solar systems
     */
    public SolarSystemAdaptor(Context context, int textViewResourceId,
                       SolarSystem[] values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    /**
     * Gets number of solar systems in our adaptor
     * @return the number of solar systems
     */
    @Override
    public int getCount(){
        return values.length;
    }

    /**
     * returns a solar system at a position in our set of systems
     * @param position position of system
     * @return a solar system at position
     */
    @Override
    public SolarSystem getItem(int position){
        return values[position];
    }

    /**
     * gets the item ID of a specified system position
     * @param position the position of a system
     * @return the item id of the position
     */
    @Override
    public long getItemId(int position){
        return position;
    }


    /**
     * gets a view for the passive state of the spinner
     * @param position the position of the system
     * @param convertView the current view
     * @param parent the view group parent
     * @return the spinner view
     */
    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout
        // for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current
        // position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values[position].getName());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    /**
     * @param position position of system on spinner
     * @param convertView the converted view
     * @param parent the view group parent
     * @return current view
     */
    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values[position].getName());

        return label;
    }
}