package br.unama.adonias.myapplication02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button buttonImplicito, buttonCamera, buttonExplicita;
    public static final int CAMERA_CODE = 1888;
    private ImageView i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonImplicito = findViewById(R.id.b1);
        buttonCamera = findViewById(R.id.b3);
        buttonExplicita = findViewById(R.id.b2);
        i = findViewById(R.id.imagem);
        buttonImplicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Assunto01");
                i.putExtra(Intent.EXTRA_TEXT, "Dados");
                startActivity(Intent.createChooser(i, "Compartilhar..."));
            }
        });

        buttonExplicita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("nome", "Adonias Pires");
                startActivity(i);
            }
        });

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(i, CAMERA_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_CODE){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            i.setImageBitmap(photo);
        }
    }
}
