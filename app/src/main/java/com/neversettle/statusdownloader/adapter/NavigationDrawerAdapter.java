package com.neversettle.statusdownloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.neversettle.statusdownloader.model.NavigationDrawerItem;
import com.neversettle.statusdownloader.R;

import java.util.List;



public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

	private List<NavigationDrawerItem> mDataList;
    private LayoutInflater inflater;
    private Context context;
    private NavigationDrawerAdapterListener navigationDrawerAdapterListener;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mDataList = data;
    }
    public NavigationDrawerAdapter(){

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final NavigationDrawerItem current = mDataList.get(position);

	    holder.imgIcon.setImageResource(current.getImageId());
        holder.title.setText(current.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
//		        Toast.makeText(context, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();
		        navigationDrawerAdapterListener.onItemClick(current);
//		        holder.imgIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
	        }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
	    ImageView imgIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =  itemView.findViewById(R.id.title);
	        imgIcon =  itemView.findViewById(R.id.imgIcon);
        }
    }
    public void setNavigationDrawerAdapterListener(NavigationDrawerAdapterListener listener){

        this.navigationDrawerAdapterListener = listener;
    }

    public interface NavigationDrawerAdapterListener{

        void onItemClick(NavigationDrawerItem item);
    }

}
