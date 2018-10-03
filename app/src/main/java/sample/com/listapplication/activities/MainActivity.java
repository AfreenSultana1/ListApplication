package sample.com.listapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import sample.com.listapplication.R;
import sample.com.listapplication.adapters.SampleAdapter;
import sample.com.listapplication.datamodels.SampleDataModel;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    SampleAdapter sampleAdapter;
    ArrayList<SampleDataModel> sampleDataModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mainActivity_listView);
        sampleDataModelArrayList.add(new SampleDataModel("afreen", "100"));
        sampleDataModelArrayList.add(new SampleDataModel("asra", "200"));
        sampleDataModelArrayList.add(new SampleDataModel("asma", "300"));


        sampleAdapter = new SampleAdapter(sampleDataModelArrayList);
        listView.setAdapter(sampleAdapter);

        listView.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        SampleDataModel sampleDataModel = (SampleDataModel) adapterView.getItemAtPosition(position);
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", sampleDataModel.name);
        bundle.putString("id",sampleDataModel.id);
        detailsFragment.setArguments(bundle);
        replaceFragment(detailsFragment);

    }

    public void replaceFragment(Fragment fragment) {
        if (findViewById(R.id.container_frame_right) != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_frame_right, fragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_frame, fragment).commit();
        }
    }
}
