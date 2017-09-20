package sugoi.android.amazfun;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import com.google.gson.Gson;

import sugoi.android.amazfun.Adapter.FeedAdapter;
import sugoi.android.amazfun.Common.HTTPDataHandler;
import sugoi.android.amazfun.Model.RSSObject;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RSSObject rssobject;
    private final String RSS_link="http://rss.nytimes.com/services/xml/rss/nyt/Science.xml";
    private final String RSS_to_Json_API="https://api.rss2json.com/v1/api.json?rss_url=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Deets");
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadRSS();
    }

    private void loadRSS() {
        AsyncTask<String,String,String> loadRSSAsync= new AsyncTask<String,String,String>(){
            ProgressDialog mdialog = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {
                mdialog.setMessage("Patience is a virtue...");
                mdialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler http=new HTTPDataHandler();
                result=http.getHTTPData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                mdialog.dismiss();
                rssobject =new Gson().fromJson(s,RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssobject,getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        StringBuilder url_get_data =new StringBuilder(RSS_to_Json_API);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_refresh) {
            loadRSS();
        }
        return true;
    }
}
