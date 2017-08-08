package docomohackathonar.taku.com.docomohackathonar.Screens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.nio.ByteBuffer;

import butterknife.Bind;
import butterknife.ButterKnife;
import docomohackathonar.taku.com.docomohackathonar.R;
import eu.kudan.kudan.ARActivity;
import eu.kudan.kudan.ARImageTrackable;
import eu.kudan.kudan.ARImageTrackableListener;
import eu.kudan.kudan.ARImageTracker;

/**
 * Created by taku24 on 2017/08/07.
 */

public class ShowARActivity extends ARActivity implements ARImageTrackableListener{

    @Bind(R.id.detail)
    Button mDetail;

    @Bind(R.id.ratingBar)
    RatingBar mRatingBar;

    @Bind(R.id.textView)
    TextView mTextView;

    @Bind(R.id.shopInfo)
    RelativeLayout mShopInfo;

    private ARImageTrackable mTrackable;
    private ImageReader imageReader;

    private int displayWidth, displayHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ar);
        ButterKnife.bind(this);
        mShopInfo.setVisibility(View.GONE);
        mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowARActivity.this, DetailActivity.class);
                startActivity(intent);
                mShopInfo.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void setup(){
        super.setup();
        mTrackable = new ARImageTrackable("target");
        mTrackable.loadFromAsset("DSC_0131.JPG");
        mTrackable.addListener(this);

        ARImageTracker trackableManager = ARImageTracker.getInstance();
        trackableManager.addTrackable(mTrackable);
    }

    @Override
    public void didDetect(ARImageTrackable arImageTrackable) {
        mShopInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void didTrack(ARImageTrackable arImageTrackable) {

    }

    @Override
    public void didLose(ARImageTrackable arImageTrackable) {
        mShopInfo.setVisibility(View.GONE);
    }

    private void getScreenshot(){
        // 画面の縦横サイズとdpを取得
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayWidth = displayMetrics.widthPixels;
        displayHeight = displayMetrics.heightPixels;

        Image image = imageReader.acquireLatestImage();
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();

        int pixelStride = planes[0].getPixelStride();
        int rowStride = planes[0].getRowStride();
        int rowPadding = rowStride - pixelStride * displayWidth;

        // バッファからBitmapを生成
        Bitmap bitmap = Bitmap.createBitmap(
                displayWidth + rowPadding / pixelStride, displayHeight,
                Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(buffer);
        image.close();
    }
}
