package com.example.recyclerviewfood;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodGridActivity extends RecyclerView.Adapter<FoodGridActivity.GridViewHolder> {
    private static final String TAG = "ListView";
    private ArrayList<String> mImages;
    private ArrayList<String> mImageNames;
    private ArrayList<String> mImageDet;

    private Context context;

    FoodGridActivity(Context mContext, ArrayList<String> mImages, ArrayList<String> mImagesNames,
                     ArrayList<String> mImagesDet){
        this.mImages = mImages;
        this.mImageNames = mImagesNames;
        this.mImageDet = mImagesDet;
        this.context = mContext;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_grid_layout, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ mImageNames.get(position));
                Toast.makeText(context, mImageNames.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, FoodDetailActivity.class);
                intent.putExtra("image_url",mImages.get(position));
                intent.putExtra("image_name",mImageNames.get(position));
                intent.putExtra("image_desc",mImageDet.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView imageName;
        TextView imageDesc;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            imageName = itemView.findViewById(R.id.image_name);
            imageDesc = itemView.findViewById(R.id.image_desc);
        }
    }
}

