package docomohackathonar.taku.com.docomohackathonar.Screens;

import android.os.Bundle;

import docomohackathonar.taku.com.docomohackathonar.R;
import eu.kudan.kudan.ARActivity;
import eu.kudan.kudan.ARImageNode;
import eu.kudan.kudan.ARImageTrackable;
import eu.kudan.kudan.ARImageTracker;

/**
 * Created by taku24 on 2017/08/07.
 */

public class ShowARActivity extends ARActivity {

    private ARImageTrackable mTrackable;
    private ARImageNode mMarkerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ar);
    }

    @Override
    public void setup(){
        super.setup();
        mTrackable = new ARImageTrackable("target");
        mTrackable.loadFromAsset("DSC_0131.JPG");

        ARImageTracker trackableManager = ARImageTracker.getInstance();
        trackableManager.addTrackable(mTrackable);

        mMarkerImage = new ARImageNode("dos.png");
        mTrackable.getWorld().addChild(mMarkerImage);
    }

}
