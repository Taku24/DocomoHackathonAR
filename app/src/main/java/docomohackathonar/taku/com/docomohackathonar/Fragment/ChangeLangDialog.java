package docomohackathonar.taku.com.docomohackathonar.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.DialogFragment;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import docomohackathonar.taku.com.docomohackathonar.R;

/**
 * Created by taku24 on 2017/08/08.
 */

public class ChangeLangDialog extends DialogFragment {

    @Bind(R.id.radio)
    RadioGroup mRadioGroup;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_change_lang);
        ButterKnife.bind(this, dialog);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                dismiss();
            }
        });
        return dialog;
    }

}
