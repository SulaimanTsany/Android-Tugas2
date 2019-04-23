package com.tugasmobile.diss.tugas02sules;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> listMovie;

    public ListMovieAdapter (Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public ListMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tvName.setText(getListMovie().get(i).getTitle());
        viewHolder.tvDescription.setText(getListMovie().get(i).getOverview());
        viewHolder.tvVote.setText(String.valueOf(getListMovie().get(i).getVote_average()));
        viewHolder.tvRelease.setText(getListMovie().get(i).getRelease_date());
        Glide.with(context)
                .load(Integer.valueOf(getListMovie().get(i).getPoster_path()))
                .apply(new RequestOptions().override(100,130))
                .into(viewHolder.ivPhoto);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailMovieActivity.class);
                intent.putExtra("MOVIE", getListMovie().get(i));
                Log.e("Title", getListMovie().get(i).getTitle());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MovieData.getListData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDescription;
        TextView tvVote;
        TextView tvRelease;
        ImageView ivPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_desc);
            tvVote = itemView.findViewById(R.id.tv_item_star);
            tvRelease = itemView.findViewById(R.id.tv_item_release_date);
            ivPhoto = itemView.findViewById(R.id.iv_item_photo);
        }
    }
}
