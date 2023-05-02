package com.jaivikpatoliya.library;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dashbordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dashbordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RelativeLayout rl1, rl2, rl3, rl4, rl5, rl6, rl7, rl8;
    public dashbordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dashbord_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dashbordFragment newInstance(String param1, String param2) {
        dashbordFragment fragment = new dashbordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dashbord_fragment, container,false);
        rl1 = (RelativeLayout) view.findViewById(R.id.rl1);
        rl1.setOnClickListener(view1 -> {
            Intent b1 = new Intent(getContext(),book1_activity.class);
            startActivity(b1);
        });
        rl2 = (RelativeLayout) view.findViewById(R.id.rl2);
        rl2.setOnClickListener(view12 -> {
            Intent b2 = new Intent(getContext(),book2_activity.class);
            startActivity(b2);
        });
        rl3 = (RelativeLayout) view.findViewById(R.id.rl3);
        rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b3 = new Intent(getContext(),book3_activity.class);
                startActivity(b3);
            }
        });
        rl4 = (RelativeLayout) view.findViewById(R.id.rl4);
        rl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b4 = new Intent(getContext(),book4_activity.class);
                startActivity(b4);
            }
        });
        rl5 = (RelativeLayout) view.findViewById(R.id.rl5);
        rl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b5 = new Intent(getContext(),book5_activity.class);
                startActivity(b5);
            }
        });
        rl6 = (RelativeLayout) view.findViewById(R.id.rl6);
        rl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b6 = new Intent(getContext(),book6_activity.class);
                startActivity(b6);
            }
        });
        rl7 = (RelativeLayout) view.findViewById(R.id.rl7);
        rl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b7 = new Intent(getContext(),book7_activity.class);
                startActivity(b7);
            }
        });
        rl8 = (RelativeLayout) view.findViewById(R.id.rl8);
        rl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b8 = new Intent(getContext(),book8_activity.class);
                startActivity(b8);
            }
        });
        return view;
    }
}