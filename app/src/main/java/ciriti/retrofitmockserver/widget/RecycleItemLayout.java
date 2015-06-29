package ciriti.retrofitmockserver.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ciriti.retrofitmockserver.R;
import ciriti.retrofitmockserver.bean.RespBean;

/**
 * Created by ciriti on 29/06/15.
 */
public class RecycleItemLayout extends RelativeLayout {

    @InjectView(R.id.item_profile_image)
    ImageView userImage;

    @InjectView(R.id.item_profile_name)
    TextView username;

    @InjectView(R.id.item_profile_anni)
    TextView userAnni;

    public RecycleItemLayout(Context context) {
        super(context);
    }

    public RecycleItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecycleItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    public void bindData(RespBean.User user){
        Picasso.with(getContext()).load(user.profileImage).into(userImage);
        username.setText(user.displayName);
        userAnni.setText(user.age);
    }
}
