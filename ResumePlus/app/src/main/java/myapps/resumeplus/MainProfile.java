package myapps.resumeplus;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.provider.DocumentsContract.getDocumentId;

/**
 * Created by Acer on 14-06-2017.
 */

public class MainProfile extends AppCompatActivity {

    private static final String MYPREFER ="pref" ;

    ImageView imageView1,imageView2;
    TextView textView1,textView2,textView3,textView4;
    Button button_next;
    EditText editText1;
    private static final int PICK_FROM_GALLERY = 1;
    private static final int PICK_FROM_GALLERY_SIGN = 1;

    Bitmap bitmap2,photo;
    int turn1=6;

    int picturepath=0;
    Button  mClear, mGetSign, mCancel;
    int turn=1;

    File file;
    File file1;
    Dialog dialog;
    LinearLayout mContent,mcontent2;
    View view;
    signature mSignature;
    Bitmap bitmap;
    Bitmap textBitmap1,textBitmap2;
    Bitmap bmt1, bmt2;

    // Creating Separate Directory for saving Generated Images
    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";
    String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss",Locale.getDefault()).format(new Date());
    String StoredPath = DIRECTORY + pic_name + ".png";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainprofile);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);

        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));

        toolbar.setTitle(R.string.college_student);
        
        
        imageView1= (ImageView) findViewById(R.id.image_profileload);
        imageView2= (ImageView) findViewById(R.id.image_sign);
        
        textView1= (TextView) findViewById(R.id.textViewupload);
        textView2= (TextView) findViewById(R.id.signature);
        textView3= (TextView) findViewById(R.id.objectiveness);
        textView4= (TextView) findViewById(R.id.textView4);

        editText1= (EditText) findViewById(R.id.editTextobjective);

        button_next= (Button) findViewById(R.id.next_button);




        // Dialog Function
        dialog = new Dialog(MainProfile.this);
        // Removing the features of Normal Dialogs
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_signature);
        dialog.setCancelable(true);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 loadImage();
            }
        });

        
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String obj=editText1.getText().toString();

              /*  if(!(obj.length()>20&&obj.length()<=140)){
                    editText1.setError("Your description is too short");
                    return;
                }*/

                if(obj.length()>160){
                    int len=obj.length();
                    editText1.setError("Max lenght :160\nCurrent length :"+len);
                    return;
                }

                SharedPreferences address=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=address.edit();

                editor.putString("OBJECTIVE", obj);

                try {

                    if (turn1 == 0) {
                        editor.putString("IMAGE", encode(bitmap2));
                    } else if(turn1==2) {
                        editor.putString("IMAGE", encode(textBitmap1));

                    }
                    else if(turn1==3) {
                        editor.putString("IMAGE", encode(textBitmap2));

                    }
                    else {
                        editor.putString("IMAGE","");

                    }
                }
                catch (Exception e){
                    Toast.makeText(MainProfile.this, ""+e, Toast.LENGTH_SHORT).show();
                }
                if(bmt1!=null) {
                    editor.putString("MAIN_IMAGE", encode(bmt2));
                }
                else {
                    editor.putString("MAIN_IMAGE", "");
                }


                editor.apply();


                Intent intent=new Intent(MainProfile.this,PersonnelDetail.class);
                startActivity(intent);
            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn1=0;
                Toast.makeText(MainProfile.this, "Try to avoid fingerpaint sign, uploading sign from file is a good idea", Toast.LENGTH_SHORT).show();
                dialog_action();

            }
        });

        // Method to create Directory, if the Directory doesn't exists
        file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn1=1;
                turn=1;
                try {
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){

                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);

                        intent.setType("image/*");


                        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_FROM_GALLERY_SIGN);

                    }
                    else{
                        Intent intent=new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);

                        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_FROM_GALLERY_SIGN);

                    }
                }catch (Exception e){
                   // Toast.makeText(MainProfile.this, ""+e, Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    private void loadImage() {
        turn=2;
        try {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);

                intent.setType("image/*");


               startActivityForResult(Intent.createChooser(intent,"Select Picture from Gallery "),PICK_FROM_GALLERY);
            }
            else{
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_FROM_GALLERY);

            }
        }catch (Exception e){
            //Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_FROM_GALLERY&&resultCode==RESULT_OK&&turn==2){
            Bundle extras=data.getExtras();
            ByteArrayOutputStream bout=new ByteArrayOutputStream();
            try {
                if (data.getData() != null) {
                    Uri selectedImage = data.getData();

                 /*   File path=new File(String.valueOf(selectedImage));
                    Bitmap bitmap=BitmapFactory.decodeFile(String.valueOf(path));

                    Bitmap bm=Bitmap.createScaledBitmap(bitmap,imageView.getWidth(),imageView.getHeight(),true);
                    bm.compress(Bitmap.CompressFormat.PNG,50,bout);
                    imageView.setImageBitmap(bitmap);*/

                    String[] filepath={MediaStore.Images.Media.DATA};
                    Cursor cursor=getContentResolver().query(selectedImage,filepath,null,null,null);
                    assert cursor != null;
                    cursor.moveToFirst();

                    int coloumindex=cursor.getColumnIndex(filepath[0]);
                    String picturePath=cursor.getString(coloumindex);

                    cursor.close();

                    //Toast.makeText(this, ""+picturePath, Toast.LENGTH_SHORT).show();
                    if(picturePath!=null) {

                        bmt1 = BitmapFactory.decodeFile(picturePath);

                        bmt2 = Bitmap.createScaledBitmap(bmt1, imageView1.getWidth(), imageView1.getHeight(), true);

                        bmt2.compress(Bitmap.CompressFormat.PNG, 50, bout);

                        imageView1.setImageBitmap(bmt2);
                    }
                    else {
                        String filePath2="";

                        String wholeId= getDocumentId(selectedImage);

                        String id=wholeId.split(":")[1];

                        String[] coloum={MediaStore.Images.Media.DATA};

                        String sel=MediaStore.Images.Media._ID+ "=?";

                        Cursor cursor2=getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,coloum,sel,new String[]{id},null);

                        int colomINDEX=cursor2.getColumnIndex(coloum[0]);
                        if(cursor2.moveToFirst()){
                            filePath2=cursor2.getString(colomINDEX);
                            cursor2.close();

                            Toast.makeText(this, ""+filePath2, Toast.LENGTH_SHORT).show();

                            bmt1=BitmapFactory.decodeFile(filePath2);

                            bmt2= Bitmap.createScaledBitmap(bmt1, imageView1.getWidth(), imageView1.getHeight(), true);

                            bmt2.compress(Bitmap.CompressFormat.PNG, 50, bout);

                            imageView1.setImageBitmap(bmt2);
                        }

                    }
                }
            }
            catch (Exception e){
               // Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }

        }
       if(requestCode==PICK_FROM_GALLERY_SIGN&&resultCode==RESULT_OK&&turn==1){


           Bundle extras=data.getExtras();
           ByteArrayOutputStream bout=new ByteArrayOutputStream();
           try {
               if (data.getData() != null) {
                   Uri selectedImage = data.getData();

                 /*   File path=new File(String.valueOf(selectedImage));
                    Bitmap bitmap=BitmapFactory.decodeFile(String.valueOf(path));

                    Bitmap bm=Bitmap.createScaledBitmap(bitmap,imageView.getWidth(),imageView.getHeight(),true);
                    bm.compress(Bitmap.CompressFormat.PNG,50,bout);
                    imageView.setImageBitmap(bitmap);*/

                   String[] filepath={MediaStore.Images.Media.DATA};
                   Cursor cursor=getContentResolver().query(selectedImage,filepath,null,null,null);
                   assert cursor != null;
                   cursor.moveToFirst();

                   int coloumindex=cursor.getColumnIndex(filepath[0]);
                   String picturePath=cursor.getString(coloumindex);

                   cursor.close();

                   //Toast.makeText(this, ""+picturePath, Toast.LENGTH_SHORT).show();
                   if(picturePath!=null) {
                       turn1=2;

                       Bitmap bitmap = BitmapFactory.decodeFile(picturePath);

                       textBitmap1 = Bitmap.createScaledBitmap(bitmap, imageView2.getWidth(), imageView2.getHeight(), true);

                       textBitmap1.compress(Bitmap.CompressFormat.PNG, 50, bout);

                       imageView2.setImageBitmap(textBitmap1);
                   }
                   else {
                       String filePath2="";

                       String wholeId= getDocumentId(selectedImage);

                       String id=wholeId.split(":")[1];

                       String[] coloum={MediaStore.Images.Media.DATA};

                       String sel=MediaStore.Images.Media._ID+ "=?";

                       Cursor cursor2=getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,coloum,sel,new String[]{id},null);

                       int colomINDEX=cursor2.getColumnIndex(coloum[0]);
                       if(cursor2.moveToFirst()){
                           turn1=3;
                           filePath2=cursor2.getString(colomINDEX);
                           cursor2.close();

                           Toast.makeText(this, ""+filePath2, Toast.LENGTH_SHORT).show();

                           Bitmap bmt=BitmapFactory.decodeFile(filePath2);

                           textBitmap2= Bitmap.createScaledBitmap(bmt, imageView2.getWidth(), imageView2.getHeight(), true);

                           textBitmap2.compress(Bitmap.CompressFormat.PNG, 50, bout);

                           imageView2.setImageBitmap(textBitmap2);
                       }

                   }
               }
           }
           catch (Exception e){
               //Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
           }

        }
      




    }


    //Function for Digital Signature
    public void dialog_action() {

        mContent = (LinearLayout) dialog.findViewById(R.id.linearLayout);

        mSignature = new signature(getApplicationContext(), null);
        mSignature.setBackgroundColor(Color.WHITE);
        // Dynamically generating Layout through java code
        mContent.addView(mSignature, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mClear = (Button) dialog.findViewById(R.id.clear);
        mGetSign = (Button) dialog.findViewById(R.id.getsign);
        mGetSign.setEnabled(true);
        mCancel = (Button) dialog.findViewById(R.id.cancel);
        view = mContent;

        mClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("tag", "Panel Cleared");
                mSignature.clear();
                mGetSign.setEnabled(true);
            }
        });
        mGetSign.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                turn1=0;

                Log.v("tag", "Panel Saved");
                view.setDrawingCacheEnabled(true);
                mSignature.save(view, StoredPath);
                file1=new File(StoredPath);
               // Uri uri=Uri.fromFile(file1);
                //imageView2.setImageURI(uri);
                bitmap2=BitmapFactory.decodeFile(StoredPath);
                Bitmap bitmap1=Bitmap.createScaledBitmap(bitmap2,imageView2.getWidth(),imageView2.getHeight(),true);
                imageView2.setImageBitmap(bitmap1);
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
                // Calling the same class
              //recreate();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("tag", "Panel Cancelled");
                dialog.dismiss();
                // Calling the same class
               // recreate();
            }
        });
        dialog.show();
    }

    public class signature extends View {
        private static final float STROKE_WIDTH = 5f;
        private static final float HALF_STROKE_WIDTH = STROKE_WIDTH / 2;
        private Paint paint = new Paint();
        private Path path = new Path();

        private float lastTouchX;
        private float lastTouchY;
        private final RectF dirtyRect = new RectF();
        Canvas canvas;



        public signature(Context context, AttributeSet attrs) {
            super(context, attrs);
            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(STROKE_WIDTH);
        }

        public void save(View v, String StoredPath) {

                bitmap = Bitmap.createBitmap(mContent.getWidth(), mContent.getHeight(), Bitmap.Config.RGB_565);


            canvas = new Canvas(bitmap);
            try {
                // Output the file
                FileOutputStream mFileOutStream = new FileOutputStream(StoredPath);
                v.draw(canvas);
                // Convert the output file to Image such as .png
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, mFileOutStream);
               mFileOutStream.flush();
               mFileOutStream.close();
            } catch (Exception e) {
                Log.v("log_tag", e.toString());
            }
        }

        public void clear() {



          if(bitmap!=null) {

             // Toast.makeText(MainProfile.this, "bitmap is not null", Toast.LENGTH_SHORT).show();
              mContent.removeAllViews();
              mSignature=new signature(MainProfile.this,null);
              mContent.addView(mSignature);
}

            path.reset();
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float eventX = event.getX();
            float eventY = event.getY();
            mGetSign.setEnabled(true);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(eventX, eventY);
                    lastTouchX = eventX;
                    lastTouchY = eventY;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    path.lineTo(eventX,eventY);
                    break;

                case MotionEvent.ACTION_UP:
                    resetDirtyRect(eventX, eventY);
                    int historySize = event.getHistorySize();
                    for (int i = 0; i < historySize; i++) {
                        float historicalX = event.getHistoricalX(i);
                        float historicalY = event.getHistoricalY(i);
                        expandDirtyRect(historicalX, historicalY);
                        path.lineTo(historicalX, historicalY);
                    }
                    path.lineTo(eventX, eventY);
                    break;
                default:
                    debug("Ignored touch event: " + event.toString());
                    return false;
            }

            invalidate((int) (dirtyRect.left - HALF_STROKE_WIDTH),
                    (int) (dirtyRect.top - HALF_STROKE_WIDTH),
                    (int) (dirtyRect.right + HALF_STROKE_WIDTH),
                    (int) (dirtyRect.bottom + HALF_STROKE_WIDTH));

            lastTouchX = eventX;
            lastTouchY = eventY;

            return true;
        }

        private void debug(String string) {
            Log.v("log_tag", string);
        }

        private void expandDirtyRect(float historicalX, float historicalY) {
            if (historicalX < dirtyRect.left) {
                dirtyRect.left = historicalX;
            } else if (historicalX > dirtyRect.right) {
                dirtyRect.right = historicalX;
            }

            if (historicalY < dirtyRect.top) {
                dirtyRect.top = historicalY;
            } else if (historicalY > dirtyRect.bottom) {
                dirtyRect.bottom = historicalY;
            }
        }

        private void resetDirtyRect(float eventX, float eventY) {
            dirtyRect.left = Math.min(lastTouchX, eventX);
            dirtyRect.right = Math.max(lastTouchX, eventX);
            dirtyRect.top = Math.min(lastTouchY, eventY);
            dirtyRect.bottom = Math.max(lastTouchY, eventY);
        }
    }

    public static String encode(Bitmap image){

        Bitmap images=image;

        ByteArrayOutputStream baos=new ByteArrayOutputStream();

        images.compress(Bitmap.CompressFormat.PNG,100,baos);

        byte[] b=baos.toByteArray();

        return Base64.encodeToString(b,Base64.DEFAULT);
    }




}
