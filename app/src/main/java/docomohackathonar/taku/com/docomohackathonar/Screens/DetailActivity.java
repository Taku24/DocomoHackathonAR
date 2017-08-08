package docomohackathonar.taku.com.docomohackathonar.Screens;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import docomohackathonar.taku.com.docomohackathonar.Adapter.ListAdapter;
import docomohackathonar.taku.com.docomohackathonar.Fragment.PostDialog;
import docomohackathonar.taku.com.docomohackathonar.R;

/**
 * Created by taku24 on 2017/08/08.
 */

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.mainLayout)
    RelativeLayout mMainLayout;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Bind(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;

    private ListAdapter mListAdapter;
    public String mReviewContent;
    public String mRatingStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        mListAdapter = new ListAdapter(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mListAdapter);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostDialog dialog = new PostDialog();
                dialog.show(getSupportFragmentManager(), "0");
            }
        });
    }

    public void addContent(){
        mListAdapter.add(mReviewContent, mRatingStar);
    }

    public void showSnackBar(){
        Snackbar.make(mMainLayout, "Post Complete", Snackbar.LENGTH_LONG).show();
    }

}
