package com.probir.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.photoViewHolder> {


    private Context mycontext;
    private List<PhotoConstractor> mdata;
    private GridLayoutManager layoutManager;
    private PhotoAdapter adapter;

    public PhotoAdapter(Context mycontext, List<PhotoConstractor> mdata) {
        this.mycontext = mycontext;
        this.mdata = mdata;
    }

    //-------------------------------------
    @NonNull
    @Override
    public photoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mycontext);
        view = inflater.inflate(R.layout.rv_item, parent, false);

        return new photoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull photoViewHolder holder, int position) {
        holder.img_photo.setImageResource(mdata.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void setLayoutManager(GridLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public GridLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setAdapter(PhotoAdapter adapter) {
        this.adapter = adapter;
    }

    public PhotoAdapter getAdapter() {
        return adapter;
    }

    //--------------------------View Holder-------------------------------

    public static class photoViewHolder extends RecyclerView.ViewHolder {

        ImageView img_photo;

        public photoViewHolder(@NonNull View itemView) {
            super(itemView);

            img_photo = itemView.findViewById(R.id.iv_1);
        }
    }


}
