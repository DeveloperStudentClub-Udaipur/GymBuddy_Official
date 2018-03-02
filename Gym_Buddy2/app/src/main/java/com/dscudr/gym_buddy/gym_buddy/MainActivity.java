package com.dscudr.gym_buddy.gym_buddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frame)
    RelativeLayout frame;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private View navHeader;
    private ImageView imgProfile;
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_DAY_WISE = "Day Wise";
    private static final String TAG_BODY_PART_WISE = "Body Part Wise";
    private static final String TAG_DIET_PLANES = "Diet Planes";
    private static final String TAG_UTILITEIS = "Utilities";
    private static final String TAG_COMPETITIONS = "Competitions";
    private static final String TAG_SUPPIMENTS = "Dietary Supplements";
    private static final String TAG_SETTING = "Setting";


    public static String CURRENT_TAG = TAG_DAY_WISE;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mHandler = new Handler();


        // Navigation view header
        navHeader = navView.getHeaderView(0);


        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.titels);


        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_DAY_WISE;
            loadHomeFragment();
        }
    }

    private void loadNavHeader() {

    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawerLayout.closeDrawers();

            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        //Closing drawer on item click
        drawerLayout.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // daywisefragment
                DayWise daywisefragment = new DayWise();
                return daywisefragment;
            case 1:
                // bodypartwise
                BodyPartWise bodyPartWiseFragment = new BodyPartWise();
                return bodyPartWiseFragment;
            case 2:
                // movies fragment
                DietPlans dietPlans = new DietPlans();
                return dietPlans;
            case 3:
                // utilitiesfragment
                Utilities utilitiesfragment = new Utilities();
                return utilitiesfragment;
            case 4:
                // utilitiesfragment
                Competitions competitions = new Competitions();
                return competitions;
            case 5:
                // utilitiesfragment
                Suppliments suppliments = new Suppliments();
                return suppliments;
            case 6:
                // utilitiesfragment
                Settings setting = new Settings();
                return setting;
            default:
                return new BodyPartWise();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.day_wise:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_DAY_WISE;
                        break;
                    case R.id.b_part_wise:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_BODY_PART_WISE;
                        break;
                    case R.id.diet_plans:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_DIET_PLANES;
                        break;
                    case R.id.utilities:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_UTILITEIS;
                        break;
                    case R.id.competitions:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_COMPETITIONS;
                        break;
                    case R.id.supplimens:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_SUPPIMENTS;
                        break;
                    case R.id.nav_setting:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_SETTING;
                        break;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_DAY_WISE;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }



        // when fragment is notifications, load the menu created for notifications
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //about us
        if (id == R.id.action_aboutus) {
            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_Share) {
            Intent in = new Intent(Intent.ACTION_SEND);
            in.setType("plain/text");
            in.putExtra(Intent.EXTRA_TEXT, "Hey ! there I am Using A Great App fOR Gyming You Would Try Here is the link -> goo.gl/UBQLcs");
            startActivity(Intent.createChooser(in, "SHARE APP"));

            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}
