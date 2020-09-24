package com.cookandroid.project8_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {
    //myPictureView에 보여줄 이미지 파일의 경로 및 파일 이름을 저장할 변수이다.
    String imagePath = null;

    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // imagePath에 값이 있으면 (즉, 이미지 파일의 경로 및 파일 이름이 지정되었다면)
        if (imagePath != null){
            //화면에 그림 파일을 출력,
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap,0,0,null);
            bitmap.recycle();
        }
    }
}

