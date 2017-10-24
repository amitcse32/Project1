package noname.project1.view.activity.welcome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import noname.project1.R;
import noname.project1.utils.controls.TextViewMedium;

/**
 * Created by Amit on 10/24/2017.
 */

public class LeftMenuAdapter extends BaseAdapter {

    Context context;
    String[] titles;

    public LeftMenuAdapter(Context context) {
        this.context = context;
        this.titles = context.getResources().getStringArray(R.array.leftMenuTitle);

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.view_left_menu, null);
            holder.imageViewIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            holder.textViewTitle = (TextViewMedium) convertView.findViewById(R.id.textViewTitle);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.textViewTitle.setText(titles[position]);


        return convertView;

    }


    class ViewHolder {
        public ImageView imageViewIcon;
        public TextViewMedium textViewTitle;
    }

}
