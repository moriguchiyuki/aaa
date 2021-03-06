package com.example.yuichi_oba.ecclesia.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.yuichi_oba.ecclesia.R;
import com.example.yuichi_oba.ecclesia.dialog.AuthDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//
// へろーぐちおさん
//

/*************************************************************************************
 *
 *                                  Hint!
 *
 *  １．サーチビューでなんか打った時(会社名とか）にListView絞り込むやつ　  ｐ１８９
 *  ２．自作アダプタやら自作のレイアウトやらなんやら                       ｐ１６４～ｐ１９２
 *  外部設計の履歴検索にあるまんまをつくる
 *
 **************************************************************************************/

// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
// _/_/
// _/_/ 利用履歴を検索するアクティビティ
// _/_/
// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
public class HistorySearchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    
    private class ListItem {
        private long id;
        private String purpose;
        private String date;
        private String gaiyou;
        private String company;
        private String companyMember;

        public long getId() {
            return id;
        }

        public String getPurpose() {
            return purpose;
        }
        public String getDate() {
            return date;
        }
        public String getGaiyou() {
            return gaiyou;
        }
        public String getCompany() {
            return company;
        }
        public String getCompanyMember() {
            return companyMember;
        }

        public void setId(long id) {
            this.id = id;
        }
        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public void setGaiyou(String gaiyou) {
            this.gaiyou = gaiyou;
        }
        public void setCompany(String company) {
            this.company = company;
        }
        public void setCompanyMember(String companyMember) {
            this.companyMember = companyMember;
        }
    }

    private class MyListAdapter extends BaseAdapter{
        private Context context = null;
        private ArrayList<ListItem> data = null;
        private int resource = 0;

        public MyListAdapter(Context context, ArrayList<ListItem> listdata, int resource) {
            this.context = context;
            this.data = listdata;
            this.resource = resource;
        }

        //データの個数を取得
        @Override
        public int getCount() {
            return data.size();
        }

        //指定された項目を取得
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        //指定された項目を識別するためのID値を取得
        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Activity activity = (Activity) context;
            ListItem item = (ListItem) getItem(position);
            //初回かどうか確認
            if (convertView == null) {
                //Layoutを取得
                convertView = activity.getLayoutInflater().inflate(resource, null);
            }
            ((TextView) convertView.findViewById(R.id.purpose)).setText(item.getPurpose());
            ((TextView) convertView.findViewById(R.id.date)).setText(item.getDate());
            ((TextView) convertView.findViewById(R.id.gaiyou)).setText(item.getGaiyou());
            ((TextView) convertView.findViewById(R.id.company)).setText(item.getCompany());
            ((TextView) convertView.findViewById(R.id.companyMember)).setText(item.getCompanyMember());
            return convertView;
        }
    }

    SearchView searchView;
    ListView listView;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //リストに表示するデータを準備
        String pupose[] = {"定例会","商談"};
        String date[] = {"2017/02/20","2018/01/31"};
        String gaiyou[] = {"内定懇談会","Ecclesiaの売り込み"};
        String company[] = {"株式会社ostraca","株式会社トミー"};
        String companyMember[] = {"xxxx様","yyyy様"};


        //配列の内容をListItemオブジェクトに詰め替え
        ArrayList<ListItem> list = new ArrayList<>();
        for (int i = 0; i < pupose.length; i++)
        {
            ListItem item = new ListItem();
            item.setId((new Random()).nextLong());
            item.setPurpose(pupose[i]);
            item.setDate(date[i]);
            item.setGaiyou(gaiyou[i]);
            item.setCompany(company[i]);
            item.setCompanyMember(companyMember[i]);
            list.add(item);
        }

        //ListItemとレイアウトとを関連付け
        MyListAdapter adapter = new MyListAdapter(this, list,R.layout.list_search_item);
        listView = (ListView) findViewById(R.id.list_history);
        listView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
    // _/_/
    // _/_/ ナビを選択したときの処理
    // _/_/
    // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent = null;
        switch (id) {
            case R.id.nav_reserve_list:
                intent = new Intent(getApplicationContext(), ReserveListActivity.class);
                break;
//            case R.id.nav_rireki:
//                intent = new Intent(getApplicationContext(), HistorySearchActivity.class);
//                break;
            case R.id.nav_admin_auth:
                AuthDialog authDialog = new AuthDialog();
                authDialog.show(getFragmentManager(), "aaa");
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
