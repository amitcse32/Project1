package noname.project1.view.activity.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import noname.project1.R;
import noname.project1.view.activity.welcome.adapter.LeftMenuAdapter;

public class WelcomeActivity extends AppCompatActivity {


    @BindView(R.id.listViewMenu)
    ListView listViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);


        setLeftMenuAdapter();
    }


    private void setLeftMenuAdapter()
    {
        LeftMenuAdapter adapter=new LeftMenuAdapter(this);
        listViewMenu.setAdapter(adapter);
    }

}
