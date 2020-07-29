package com.MikhailHathey.carListView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {

    ListView lv;
    String cars[]={"Ford","Volkswagen","Toyota","BMW","Mercedez-Benz","Honda","Alfa-Romeo", "Volvo", "Peugeot"};
    int brandLogos[] = {R.drawable.ford,R.drawable.vw, R.drawable.toyota,R.drawable.bmw,R.drawable.mercedes,R.drawable.honda,R.drawable.alfa,R.drawable.volvo,R.drawable.peugeot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = findViewById(R.id.lv);

        CarAdapter ViewList = new CarAdapter(this, cars, brandLogos);
        lv.setAdapter(ViewList);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(ListViewActivity.this, "You clicked on Ford", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(ListViewActivity.this, "You clicked on Volkswagen", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(ListViewActivity.this, "You clicked on Toyota", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(ListViewActivity.this, "You clicked on BMW", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(ListViewActivity.this, "You clicked on Mercedez", Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    Toast.makeText(ListViewActivity.this, "You clicked on Honda", Toast.LENGTH_SHORT).show();
                }
                if (position == 6){
                    Toast.makeText(ListViewActivity.this, "You clicked on Alfa-Romeo", Toast.LENGTH_SHORT).show();
                }
                if (position == 7){
                    Toast.makeText(ListViewActivity.this, "You clicked on Volvo", Toast.LENGTH_SHORT).show();
                }
                if (position == 8){
                    Toast.makeText(ListViewActivity.this, "You clicked on Peuguot", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class CarAdapter extends ArrayAdapter<String>{

        Context context;
        String cars[];
        int brandLogos [];

        CarAdapter (Context c, String car[], int brandLogo[]){
            super(c, R.layout.activity_list_item, R.id.carText, car);
            this.context = c;
            this.cars = car;
            this.brandLogos = brandLogo;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View listItem = layoutInflater.inflate(R.layout.activity_list_item, parent, false);
            ImageView brandLogoView = listItem.findViewById(R.id.brandLogo);
            TextView car = listItem.findViewById(R.id.carText);
            brandLogoView.setImageResource(brandLogos[position]);
            car.setText(cars[position]);
            return listItem;
        }
    }
}
