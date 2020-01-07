package app.uangkas;

import android.app.DatePickerDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.andexert.library.RippleView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import app.uangkas.helper.CurrentDate;


public class FilterActivity extends AppCompatActivity {

    EditText edit_dari, edit_ke;
    Button btn_filter;
    RippleView rip_filter;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        edit_dari   = findViewById(R.id.edit_dari);
        edit_ke     = findViewById(R.id.edit_ke);
        btn_filter  = findViewById(R.id.btn_filter);
        rip_filter  = findViewById(R.id.rip_filter);

        edit_dari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(FilterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month_of_year, int day_of_month) {
                        NumberFormat numberFormat = new DecimalFormat("00");
                        MainActivity.tgl_dari = year  + "-" + numberFormat.format(month_of_year + 1) + "-" +
                                numberFormat.format(day_of_month);
                        edit_dari.setText(numberFormat.format(day_of_month) + "/" + numberFormat.format(month_of_year + 1) +
                                "/" + year);
                    }
                }, CurrentDate.year, CurrentDate.month, CurrentDate.day);
                datePickerDialog.show();
            }
        });

        edit_ke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(FilterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month_of_year, int day_of_month) {
                        NumberFormat numberFormat = new DecimalFormat("00");
                        MainActivity.tgl_ke = year  + "-" + numberFormat.format(month_of_year + 1) + "-" +
                                numberFormat.format(day_of_month);
                        edit_ke.setText(numberFormat.format(day_of_month) + "/" + numberFormat.format(month_of_year + 1) +
                                "/" + year);
                    }
                }, CurrentDate.year, CurrentDate.month, CurrentDate.day);
                datePickerDialog.show();
            }
        });

        rip_filter.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                if (edit_dari.getText().toString().equals("") || edit_ke.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Isi data dengan benar",
                            Toast.LENGTH_LONG).show();
                } else {
                    MainActivity.filter = true;
                    MainActivity.text_filter.setText( edit_dari.getText().toString() + " - " + edit_ke.getText().toString() );
                    MainActivity.text_filter.setVisibility(View.VISIBLE);

                    finish();
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Set Date");

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
