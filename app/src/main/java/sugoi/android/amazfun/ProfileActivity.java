
package sugoi.android.amazfun;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
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
        import java.util.zip.Inflater;

public class ProfileActivity extends Fragment {


    TextView sellerNamebp;
    TextView sellerBiobp;
    ImageView profilePicture;

    TextView followersbp;
    TextView followingbp;
    public ProfileActivity() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.profile_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View v=getView();

        sellerNamebp=(TextView)v. findViewById(R.id.sellerNamebp);
        sellerBiobp=(TextView)v.findViewById(R.id.sellerbiobp);
        profilePicture=(ImageView)v.findViewById(R.id.profile_image);

        followersbp=(TextView)v.findViewById(R.id.followersbp);
        followingbp=(TextView)v.findViewById(R.id.followingbp);
        //  constraintLayout=(ConstraintLayout)findViewById(R.id.cl);
      /*  CollapsingToolbarLayout cp=(CollapsingToolbarLayout)findViewById(R.id.collaptb);
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
        */

    }
}
