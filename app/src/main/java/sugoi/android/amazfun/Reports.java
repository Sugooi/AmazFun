package sugoi.android.amazfun;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
public class Reports extends Fragment {
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    CollapsingToolbarLayout cp;
    View v;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_reports, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        v=getView();
        gridView = (GridView) v.findViewById(R.id.gridView);
        cp = (CollapsingToolbarLayout) v.findViewById(R.id.collaptb);
        cp.setContentScrimColor(ContextCompat.getColor(getActivity(), R.color.black));
        NestedScrollView fsa = (NestedScrollView) v.findViewById(R.id.nstscmain);
        fsa.setFillViewport(true);
        final ArrayList<ImageItem> aa = new ArrayList<>();
        aa.add(new ImageItem(R.drawable.userbase, "Customer base", Userbase.class));
        aa.add(new ImageItem(R.drawable.revenue, "Revenue", revenue.class));
        aa.add(new ImageItem(R.drawable.sales, "Total Sales", sales.class));
        aa.add(new ImageItem(R.drawable.salesofproducts, "Sales of products", salesproducts.class));
        aa.add(new ImageItem(R.drawable.salesbyproduct, "Specific product sales", salesspcprd.class));
        aa.add(new ImageItem(R.drawable.rating, "Rating of products", productrating.class));
        gridAdapter = new GridViewAdapter(getActivity(), R.layout.reportgriditem, aa);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                startActivity(new Intent(getActivity(), item.getCls()));
            }
        });

    }



}
