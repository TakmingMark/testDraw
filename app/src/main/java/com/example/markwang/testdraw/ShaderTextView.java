package com.example.markwang.testdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * reference https://www.jianshu.com/p/a9d09cb7577f

 */
public class ShaderTextView extends AppCompatTextView {

    Matrix matrix=new Matrix();
    int translate=0;
    int mViewWidth=0;
    int mViewHeight=0;
    LinearGradient linearGradient;
    public ShaderTextView(Context context) {
        super(context);
    }

    public ShaderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(matrix!=null){
            translate+=mViewWidth/5;
            if(translate>2*mViewWidth){
                translate=-mViewWidth;
            }


            matrix.setTranslate(translate,0);
            linearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(100);
        }
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh){

        super.onSizeChanged(w,h,oldw,oldh);
        if(mViewWidth==0){
            mViewWidth=getMeasuredWidth();
            if(mViewWidth>0){
                Paint paint=getPaint();
                linearGradient=new LinearGradient(0,0,mViewWidth,0,new int[]{
                    Color.BLUE,Color.BLACK,Color.BLUE},null,Shader.TileMode.CLAMP);
                paint.setShader(linearGradient);
                matrix=new Matrix();
            }
        }

    }

}
