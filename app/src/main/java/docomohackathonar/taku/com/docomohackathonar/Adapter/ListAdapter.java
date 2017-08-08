package docomohackathonar.taku.com.docomohackathonar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import docomohackathonar.taku.com.docomohackathonar.R;

/**
 * Created by taku24 on 2017/08/08.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<String> itemContens;
    private List<String> ratingArrays;

    public ListAdapter(Context context){
        mContext = context;
        itemContens = new ArrayList<>(Arrays.asList(mContext.getResources().getStringArray(R.array.review_content)));
        ratingArrays = new ArrayList<>(Arrays.asList(mContext.getResources().getStringArray(R.array.rating_array)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).mContent.setText(itemContens.get(position));
        ((ItemViewHolder) holder).mRating.setRating(Float.parseFloat(ratingArrays.get(position)));
    }

    @Override
    public int getItemCount() {
        return itemContens.size();
    }

    public void add(String content, String rating){
        itemContens.add(content);
        ratingArrays.add(rating);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.content)
        TextView mContent;

        @Bind(R.id.ratingBar)
        RatingBar mRating;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
