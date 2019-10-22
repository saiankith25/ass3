package fr.isep.ii3510.assignment3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.isep.ii3510.assignment3.model.Band;

public class BandAdapter extends RecyclerView.Adapter<BandAdapter.ViewHolder>{
    private List<Band> bandList;
    private Context mContext;



    // RecyclerView recyclerView;
    public BandAdapter(List<Band> listdata, Context context) {
        this.bandList = listdata;
        this.mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.band_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


         final Band bandLists = bandList.get(position);
        holder.bandName.setText(bandLists.getBandName());
        Log.d("Ankith","--->"+bandList);
        //holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(mContext,AlbumActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("albums", bandLists);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return bandList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //public ImageView imageView;
        public TextView bandName;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            //this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.bandName = (TextView) itemView.findViewById(R.id.bandName);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.bandList);
        }
    }
}