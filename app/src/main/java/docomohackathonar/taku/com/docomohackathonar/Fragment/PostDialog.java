package docomohackathonar.taku.com.docomohackathonar.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import docomohackathonar.taku.com.docomohackathonar.R;
import docomohackathonar.taku.com.docomohackathonar.Screens.DetailActivity;

/**
 * Created by taku24 on 2017/08/08.
 */

public class PostDialog extends DialogFragment {

    @Bind(R.id.post)
    Button mPost;

    @Bind(R.id.cancel)
    Button mCancel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_post_dialog);
        ButterKnife.bind(this, dialog);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity activity = (DetailActivity) getActivity();
                activity.showSnackBar();
                dismiss();
            }
        });
        return dialog;
    }

}
