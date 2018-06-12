package com.example.aluno.ifapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

public class TelaHorario extends AppCompatActivity {

    private ImageView imagem;
    private final int GALERIA_IMAGENS = 1;
    private final int PERMISSAO_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_horario);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                !=  PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){
            }else{
                ActivityCompat.requestPermissions(this,
                        new  String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }
        }

        imagem =  (ImageView)  findViewById(R.id.ivImagem);
        Button  galeria =  (Button)  findViewById(R.id.btnImagem);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent , GALERIA_IMAGENS);


            }
        });

    }


    @Override
    protected  void  onActivityResult(int requestCode,  int resultCode,  Intent  data)  {
        super.onActivityResult(requestCode,  resultCode,  data);
        if  (resultCode==  RESULT_OK  &&  requestCode==  GALERIA_IMAGENS)
        {Uri selectedImage=  data.getData();
        String[] filePath=  {MediaStore.Images.Media.DATA};
        Cursor c  =  getContentResolver().query(selectedImage,filePath,  null,  null,  null);
        c.moveToFirst();
        int columnIndex =  c.getColumnIndex(filePath[0]);
        String  picturePath=  c.getString(columnIndex);
        c.close();
        Bitmap imagemGaleria  =  (BitmapFactory.decodeFile(picturePath));
        imagem.setImageBitmap(imagemGaleria);}
    }

    //https://www.youtube.com/watch?v=AnNpUGyryiE


}


