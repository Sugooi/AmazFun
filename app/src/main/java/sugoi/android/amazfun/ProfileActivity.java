package sugoi.android.amazfun;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;

public class ProfileActivity extends AppCompatActivity {

    TextView sellerName;
    TextView sellerBio;
    TextView sellerNamebp;
    TextView sellerBiobp;
    ImageView profilePicture;
    ImageView profilePicturelp;
    TextView followersbp;
    TextView followingbp;
    TextView followers;
    TextView following;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        sellerName=(TextView) findViewById(R.id.sellername);
        sellerBio=(TextView)findViewById(R.id.sellerbio);

        sellerNamebp=(TextView) findViewById(R.id.sellerNamebp);
        sellerBiobp=(TextView)findViewById(R.id.sellerbiobp);
        profilePicture=(ImageView)findViewById(R.id.profile_image);
        profilePicturelp=(ImageView)findViewById(R.id.profile_imagelp);
        followersbp=(TextView)findViewById(R.id.followersbp);
        followingbp=(TextView)findViewById(R.id.followingbp);
        followers=(TextView)findViewById(R.id.followers);
        following=(TextView)findViewById(R.id.following);

        constraintLayout=(ConstraintLayout)findViewById(R.id.cl);
        CollapsingToolbarLayout cp=(CollapsingToolbarLayout)findViewById(R.id.collaptb);
        cp.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
        NestedScrollView fsa=(NestedScrollView)findViewById(R.id.nstscmain);
        fsa.setFillViewport(true);
        AppBarLayout appbarLayout=(AppBarLayout) findViewById(R.id.abinmain);


// Add Tab
        appbarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d("STATE", state.name());
                if(state==State.COLLAPSED)
                {
                    sellerName.setVisibility(View.VISIBLE);
                    sellerBio.setVisibility(View.VISIBLE);
                    sellerNamebp.setVisibility(GONE);
                    sellerBiobp.setVisibility(GONE);
                    profilePicture.setVisibility(GONE);
                    profilePicturelp.setVisibility(View.VISIBLE);

                    followersbp.setVisibility(View.GONE);
                    followingbp.setVisibility(View.GONE);
                    followers.setVisibility(View.VISIBLE);
                    following.setVisibility(View.VISIBLE);
                }
                else if(state==State.EXPANDED)
                {
                    sellerName.setVisibility(View.GONE);
                    sellerBio.setVisibility(View.GONE);
                    sellerNamebp.setVisibility(View.VISIBLE);
                    sellerBiobp.setVisibility(View.VISIBLE);
                    profilePicture.setVisibility(View.VISIBLE);
                    profilePicturelp.setVisibility(View.GONE);

                    followersbp.setVisibility(View.VISIBLE);
                    followingbp.setVisibility(View.VISIBLE);
                    followers.setVisibility(View.GONE);
                    following.setVisibility(View.GONE);
                }
            }
        });
    }

}
