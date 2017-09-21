package sugoi.android.amazfun.Adapter;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sugoi.android.amazfun.Interface.ItemClickListener;
import sugoi.android.amazfun.Model.RSSObject;
import sugoi.android.amazfun.R;

/**
 * Created by awasthi's on 9/20/2017.
 */

class FeedViewHolder extends ViewHolder implements View.OnClickListener,View.OnLongClickListener
{

    public TextView txtTitle,txtPubDate,txtContent;
    public ImageView pro_img;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView)
    {
        super(itemView);
        this.txtTitle =(TextView) itemView.findViewById(R.id.txtTitle);
        this.txtPubDate=(TextView) itemView.findViewById(R.id.txtPubDate);
        this.txtContent=(TextView) itemView.findViewById(R.id.txtContent);
        this.pro_img=(ImageView) itemView.findViewById(R.id.pro_img);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v)
    {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v)
    {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder>
{
    private RSSObject rssobject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSObject rssobject, Context mContext) {
        this.rssobject = rssobject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position)
    {
        holder.txtTitle.setText(rssobject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(rssobject.getItems().get(position).getPubDate());
        holder.txtContent.setText(rssobject.getItems().get(position).getContent());
        holder.pro_img.setImageResource(R.drawable.whilewalker);


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssobject.getItems().get(position).getLink()));
                    mContext.startActivity(browserIntent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return rssobject.items.size();
    }
}
