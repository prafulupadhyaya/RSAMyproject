package com.example.rsa_rental_service_application;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {
    private String[] images;
    private String[] productname;
    public String[] productdesc;public String[] rentername;public String[] price;public String[] number;
    private Context context;
    public RecyclerAdapter(String[] images ,String[] productname,Context context,String[] productdesc,String[] price,String[] rentername,String[] number)
    {
        this.images=images;
        this.productname=productname;
        this.context=context;
        this.productdesc=productdesc;
        this.price=price;
        this.rentername=rentername;
        this.number=number;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout,parent,false);
        ImageViewHolder imageViewHolder=new ImageViewHolder(view,context,images,productname,productdesc,price,rentername,number);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
   String image_id=images[position];
   String product_name=productname[position];
        byte [] encodeByte= Base64.decode(images[position],Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
   holder.Album.setImageBitmap(bitmap);
   holder.AlbumTitle.setText(product_name);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }



    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView Album;
        TextView AlbumTitle;
        Context context;
        String[] images;
        String[] productname,productdesc,price,rentername,number;
        public ImageViewHolder(@NonNull View itemView,Context context,String[] images,String[] productname,String[] productdesc,String[] price,String[] rentername,String[] number) {
            super(itemView);
            Album=itemView.findViewById(R.id.album);
            AlbumTitle=itemView.findViewById(R.id.album_title);
            itemView.setOnClickListener(this);
            this.context=context;
            this.images=images;
            this.productname=productname;
            this.productdesc=productdesc;
            this.price=price;
            this.rentername=rentername;
            this.number=number;
        }

        @Override
        public void onClick(View v)
        {
            Intent intent=new Intent(context,Last.class);

            System.out.println("productname***************************************"+productname[getAdapterPosition()]);
            System.out.println("desc**********************************************"+productdesc[getAdapterPosition()]);
            System.out.println("price********************************************"+price[getAdapterPosition()]);
            System.out.println("rentre*******************************************"+rentername[getAdapterPosition()]);
            System.out.println("number*******************************************"+number[getAdapterPosition()]);
            intent.putExtra("images_id",images[getAdapterPosition()]);
            intent.putExtra("productname_id",productname[getAdapterPosition()]);
            intent.putExtra("desc_id",productdesc[getAdapterPosition()]);
            intent.putExtra("price_id",price[getAdapterPosition()]);
            intent.putExtra("renter_id",rentername[getAdapterPosition()]);
            intent.putExtra("number_id",number[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
