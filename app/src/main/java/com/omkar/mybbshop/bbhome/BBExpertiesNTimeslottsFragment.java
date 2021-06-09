package com.omkar.mybbshop.bbhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.omkar.mybbshop.R;
import com.omkar.mybbshop.bbhome.adapter.BBTimeslotAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class BBExpertiesNTimeslottsFragment extends Fragment {

    @BindView(R.id.rcvTimeslott)
    public RecyclerView rcvTimeslott;


    private BBTimeslotAdapter slotAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.bbtimeslottsfragment,container,false);

        List<String> listSlotts = new ArrayList<String>();
        listSlotts.add("Morning"); listSlotts.add("Afternoon");listSlotts.add( "Evening");listSlotts.add( "Night");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcvTimeslott = view.findViewById(R.id.rcvTimeslott);
        rcvTimeslott.setLayoutManager(layoutManager);
        slotAdapter = new BBTimeslotAdapter(listSlotts,getContext());
        rcvTimeslott.setAdapter(slotAdapter);

        rcvTimeslott.addItemDecoration(new DividerItemDecoration(getActivity(),layoutManager.getOrientation()));
        return view;



    }






}
