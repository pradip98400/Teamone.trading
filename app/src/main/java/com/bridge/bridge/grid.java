package com.bridge.bridge;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bridge.bridge.R;

public class grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           // @Override
            public  void OnItemClick(AdapterView<?> parent, View view,int position, long id){
                Toast.makeText(grid.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }




    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mthumbIds.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }


        public long getItemId(int postion) {
            return 0;
        }

        public View getView(int postion, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView();
            imageView.setImageResource(mthumbIds[postion]);
            return imageView;
        }

        private Integer[] mthumbIds = {
                R.drawable.art,
                R.drawable.books,
                R.drawable.mobile,
                R.drawable.sports,
                R.drawable.musical,
                R.drawable.camera,
                R.drawable.others,
        };
    }

}