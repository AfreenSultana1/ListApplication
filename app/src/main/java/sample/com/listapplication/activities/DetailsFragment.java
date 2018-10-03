package sample.com.listapplication.activities;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sample.com.listapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
TextView detailsName;
TextView detailsId;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailsName=view.findViewById(R.id.details_name);
        detailsId=view.findViewById(R.id.details_id);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle  bundle=getArguments();
        String name=bundle.getString("name");
        String id=bundle.getString("id");
        detailsName.setText(name);
        detailsId.setText(id);


    }
}
