package noname.project1.view.activity.welcome;

import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import noname.project1.R;
import noname.project1.view.activity.welcome.adapter.LeftMenuAdapter;
import noname.project1.view.activity.welcome.handler.MenuClickHandler;
import noname.project1.view.fragment.home.HomeFragment;

public class WelcomeActivity extends AppCompatActivity implements MenuClickHandler {


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


    private void setLeftMenuAdapter() {
        LeftMenuAdapter adapter = new LeftMenuAdapter(this, this);
        listViewMenu.setAdapter(adapter);
    }

    @Override
    public void onMenuItemClick(int position) {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawers();

        if (position == 0) {
            replaceFragment(new HomeFragment());
        }
        else if (position == 0) {
            replaceFragment(new HomeFragment());
        }
        else if (position == 0) {
            replaceFragment(new HomeFragment());
        }
        else if (position == 0) {
            replaceFragment(new HomeFragment());
        }
        else if (position == 0) {
            replaceFragment(new HomeFragment());
        }


    }

    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, fragment, fragment.getClass().getName()).addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout, new HomeFragment(), "asdfaisdf").addToBackStack(HomeFragment.class.getName());
        transaction.commit();
    }


    @Override
    public void onBackPressed() {


        FragmentManager manager = getSupportFragmentManager();

        if (manager.getBackStackEntryCount() > 1) {
            manager.popBackStack();
        } else {
            finish();
        }


    }
}
