package com.example.remindme;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.json.JSONObject;
import java.util.ArrayList;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EventFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    static List<EventElement> result = null;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EventFragment newInstance(int columnCount) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://malikalbeik.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonAPI jsonAPI = retrofit.create(JsonAPI.class);

        Call<List<EventElement>> call = jsonAPI.GetEvents();

        call.enqueue(new Callback<List<EventElement>>() {
            @Override
            public void onResponse(Call<List<EventElement>> call, Response<List<EventElement>> response) {
                if (response.isSuccessful()) {
                    Log.d("CREATION","the results list is being filled");
                }
                else {
                    Log.d("CREATION","the results list is being filled");
                    result = new ArrayList<EventElement>(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<EventElement>> call, Throwable t) {
                Log.d("CREATION","the results list is empty");
                result = new ArrayList<EventElement>();
            }
        });


        result = new ArrayList<EventElement>();
        result.add(new EventElement(1, "my Event", "des", "sfs", "sdfsd"));
        result.add(new EventElement(2, "my Event1", "des", "sfs", "sdfsd"));
        result.add(new EventElement(3, "my Event2", "des", "sfs", "sdfsd"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            if (result != null) {
                Log.d("MYtag","we are fucking up in here");
                recyclerView.setAdapter(new MyEventRecyclerViewAdapter(result, mListener));
            }
            Log.d("Mytag","we are fucking up in here2");
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(EventElement item);
    }
}
