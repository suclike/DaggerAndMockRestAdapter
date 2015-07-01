package ciriti.retrofitmockserver.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ciriti.retrofitmockserver.App;
import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.activity.ProcessPhoenix;
import ciriti.retrofitmockserver.api.ApiService;
import ciriti.retrofitmockserver.bean.RespBean;
import ciriti.retrofitmockserver.module.ServiceModule;
import ciriti.retrofitmockserver.widget.DividerItemDecoration;
import ciriti.retrofitmockserver.widget.EmptyRecyclerView;
import ciriti.retrofitmockserver.widget.UsersRecycleViewAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragUsers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragUsers extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static String IS_DIALOG_IN_PROGRESS = "isDialogInProgress";

    /**
     * not jet used
     */
    private OnFragmentInteractionListener mListener;

    @InjectView(R.id.empty_list)
    TextView tvEmpty;

    @InjectView(R.id.switch1)
    SwitchCompat switchCompat;

    @InjectView(R.id.my_recycler_view)
    EmptyRecyclerView mRecyclerView;

    UsersRecycleViewAdapter usersRecycleViewAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Inject
    ApiService apiService;

    @Inject
    SharedPreferences sharedPreferences;

    MaterialDialog dialog;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragUserList.
     */
    // TODO: Rename and change types and number of parameters
    public static FragUsers newInstance(String param1, String param2) {
        FragUsers fragment = new FragUsers();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }public static FragUsers newInstance() {
        FragUsers fragment = new FragUsers();
        return fragment;
    }

    public FragUsers() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ((App) getActivity().getApplication()).getApiComponent().inject(this);


        dialog = new MaterialDialog.Builder(getActivity())
                .content(R.string.loading)
                .progress(true, 0)
                .build();
        // create the adapter
        usersRecycleViewAdapter = new UsersRecycleViewAdapter();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState != null){
            if(savedInstanceState.getBoolean(IS_DIALOG_IN_PROGRESS, false))dialog.show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(IS_DIALOG_IN_PROGRESS, dialog.isShowing());
        dialog.dismiss();
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_frag_user_list, container, false);
        ButterKnife.inject(this, view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // create the layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        // set layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);
        // adding adapter on recycleview
        mRecyclerView.setAdapter(usersRecycleViewAdapter);
        // adding separator on recycleview
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        // adding empty view
        mRecyclerView.setEmptyView(tvEmpty);

        switchCompat.setChecked(sharedPreferences.getBoolean(ServiceModule.HAS_MOCK, false));
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getActivity(), "" + isChecked, Toast.LENGTH_SHORT).show();
                sharedPreferences.edit().putBoolean(ServiceModule.HAS_MOCK, isChecked).commit();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onStop() {
        super.onStop();
        dialog.dismiss();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(ServiceModule.HAS_MOCK))
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ProcessPhoenix.triggerRebirth(getActivity());
                }
            }, 500);

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    @OnClick(R.id.button)
    public void click(){
        if(dialog.isShowing())
            return;

        dialog.show();

        apiService.getUsers(100, new Callback<RespBean>() {
            @Override
            public void success(RespBean respBean, Response response) {
                usersRecycleViewAdapter.addData(respBean.users);
                dialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.dismiss();
            }
        });
    }

}
