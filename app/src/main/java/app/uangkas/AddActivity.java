package app.uangkas;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.andexert.library.RippleView;

import app.uangkas.helper.SqliteHelper;

public class AddActivity extends AppCompatActivity {

    RadioGroup  radio_status;
    EditText    edit_jumlah, edit_keterangan;
    Button      btn_simpan;
    RippleView  rip_simpan;

    String status;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        status = "";
        sqliteHelper = new SqliteHelper(this);

        radio_status    = findViewById(R.id.radio_status);
        edit_jumlah     = findViewById(R.id.edit_jumlah);
        edit_keterangan = findViewById(R.id.edit_keterangan);
        btn_simpan      = findViewById(R.id.btn_simpan);
        rip_simpan      = findViewById(R.id.rip_simpan);

        radio_status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId){
                    case R.id.radio_masuk:
                        status = "MASUK";
                        break;
                    case R.id.radio_keluar:
                        status = "KELUAR";
                        break;
                }

                Log.d("Log status", status);
            }
        });

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        rip_simpan.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                if (status.equals("") || edit_jumlah.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Isi data dengan benar",
                            Toast.LENGTH_LONG).show();
                } else {
                    SQLiteDatabase database = sqliteHelper.getWritableDatabase();
                    database.execSQL("INSERT INTO transaksi(status, jumlah, keterangan) VALUES('" +
                            status + "','" +
                            edit_jumlah.getText().toString() + "','" +
                            edit_keterangan.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Transaksi berhasil disimpan", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add");

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
