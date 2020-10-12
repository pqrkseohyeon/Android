package com.cookandroid.project9_embossing;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            Paint paint = new  Paint();
            paint.setColor(Color.GRAY);
            EmbossMaskFilter eMask;

//            eMask = new EmbossMaskFilter(new float[] { 3, 3, 3 }, 0.5f, 5, 10);
//            paint.setMaskFilter(eMask);
//            canvas.drawCircle(cenX, cenY, 150, paint);

//             eMask = new EmbossMaskFilter(new float[] {10,3,3}, 0.5f, 5, 10);
//             paint.setMaskFilter(eMask);
//             canvas.drawCircle(cenX, cenY, 150, paint);

            // eMask = new EmbossMaskFilter(new float[] {3,10,3}, 0.5f, 5, 10);
            // paint.setMaskFilter(eMask);
            // canvas.drawCircle(cenX, cenY, 150, paint);

             eMask = new EmbossMaskFilter(new float[] {3,3,10}, 0.5f, 5, 10);
             paint.setMaskFilter(eMask);
             canvas.drawCircle(cenX, cenY, 150, paint);

        }
    }
}
