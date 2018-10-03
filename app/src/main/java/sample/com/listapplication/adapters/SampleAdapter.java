package sample.com.listapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sample.com.listapplication.R;
import sample.com.listapplication.datamodels.SampleDataModel;

public class SampleAdapter extends BaseAdapter {

    ArrayList<SampleDataModel> sampleDataModels;
    Context context;


    public SampleAdapter(ArrayList<SampleDataModel> sampleDataModels) {
        this.sampleDataModels = sampleDataModels;

    }

    @Override
    public int getCount() {
        return sampleDataModels.size();
    }

    @Override
    public SampleDataModel getItem(int i) {
        return sampleDataModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {

            context = viewGroup.getContext();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.updateList(getItem(position));

        return view;
    }

    public class ViewHolder {
        TextView name;
        TextView id;

        public ViewHolder(View convertView) {
            name = (TextView) convertView.findViewById(R.id.textView);
            id = (TextView) convertView.findViewById(R.id.textView2);


        }

        public void updateList(SampleDataModel sampleDataModel) {

            name.setText(sampleDataModel.name);
            id.setText(sampleDataModel.id);
        }
    }
}
