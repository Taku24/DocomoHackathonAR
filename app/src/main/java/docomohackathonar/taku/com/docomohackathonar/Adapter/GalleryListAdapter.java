package docomohackathonar.taku.com.docomohackathonar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class GalleryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> mTitles;
    private List<String> mContens;

    public GalleryListAdapter(Context context) {
        mContext = context;
        mTitles = new ArrayList<>(Arrays.asList(mContext.getResources().getStringArray(R.array.gallery_title)));
        mContens = new ArrayList<>(Arrays.asList(mContext.getResources().getStringArray(R.array.gallery_content)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).mContent.setText(mContens.get(position));
        ((ItemViewHolder) holder).mTitle.setText(mTitles.get(position));
        switch (position){
            case 0:
                ((ItemViewHolder) holder).mImageView.setImageResource(R.drawable.objective);
                break;

            case 1:
                ((ItemViewHolder) holder).mImageView.setImageResource(R.drawable.gyudon);
                break;

            case 2:
                ((ItemViewHolder) holder).mImageView.setImageResource(R.drawable.keitai);
                break;

            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageView)
        ImageView mImageView;

        @Bind(R.id.title)
        TextView mTitle;

        @Bind(R.id.content)
        TextView mContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
