package com.example.newschecker;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Characteristics_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int PERMISSION_STORAGE_CODE =1000 ;
    Button create,download;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DownloadManager downloadManager;
    ProgressDialog progressDialog;
    Handler handler;

    final String Url="http://192.168.43.76:8000/api/export/json/";
    private OnFragmentInteractionListener mListener;

    public Characteristics_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Characteristics_page.
     */
    // TODO: Rename and change types and number of parameters
    public static Characteristics_page newInstance(String param1, String param2) {
        Characteristics_page fragment = new Characteristics_page();
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
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characteristics,container,false);
        create=view.findViewById(R.id.pick_create_new);
        download=view.findViewById(R.id.pick_download);
        handler=new Handler();
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setTitle("Downloading...");
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL );

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient client=new OkHttpClient();
                        Request request= new Request.Builder().url(Url).build();
                        Response response=null;
                        try{
                            response=client.newCall(request).execute() ;
                            float file_size=response.body().contentLength() ;
                            BufferedInputStream inputStream=new BufferedInputStream(response.body().byteStream());
                            OutputStream outputStream=new FileOutputStream(Environment.getExternalStorageDirectory()+
                                    "/Download/"+System.currentTimeMillis()+".json");
                            byte[] data=new byte[8192];
                            float total=0;
                            int read_bytes=0;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.show();
                                }
                            });
                            while ((read_bytes=inputStream.read(data)) != -1){
                                total=total+read_bytes;
                                outputStream.write(data,0,read_bytes);
                                progressDialog.setProgress((int) ((total/file_size)*100));
                            }
                            progressDialog.dismiss();
                            outputStream.flush();
                            outputStream.close();
                            response.body().close();

                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();
                Toast.makeText(getContext(),"Downloaded",Toast.LENGTH_SHORT).show();
                // startdownload();
            }
        });
        return view;

    }

    private void startdownload() {
        DownloadManager.Request request= new DownloadManager.Request(Uri.parse(Url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE|DownloadManager.Request.NETWORK_WIFI);
        request.setTitle("Download");
        request.setDescription("Downloading file...");

        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS," "+System.currentTimeMillis());
        downloadManager= (DownloadManager) Objects.requireNonNull(getContext()).getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
