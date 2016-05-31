package am.widget.shapeimageview;

import android.content.Context;
import android.util.AttributeSet;



/**
 * 固定高宽比
 * Created by Alex on 2015/11/3.
 */
public class FixedSizeImageView extends PressShapeImageView {


    public static final int ST_AUTO = -1;
    public static final int ST_HEIGHT = 0;
    public static final int ST_WIDTH = 1;
    private int widthScale = 0;
    private int heightScale = 0;
    private int scaleTarget = ST_AUTO;

    public FixedSizeImageView(Context context) {
        super(context);
        initView(null);
    }

    public FixedSizeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public FixedSizeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(attrs);
    }

    public void initView(AttributeSet attrs) {
//        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FixedSizeImageView);
//        widthScale = typedArray.getInteger(R.styleable.FixedSizeImageView_widthScale, 0);
//        heightScale = typedArray.getInteger(R.styleable.FixedSizeImageView_heightScale, 0);
//        scaleTarget = typedArray.getInt(R.styleable.FixedSizeImageView_scaleTarget, ST_AUTO);
//        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (widthScale <= 0 || heightScale <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int measureWidth = getMeasuredWidth();
        final int measureHeight = getMeasuredHeight();
        switch (scaleTarget) {
            default:
            case ST_AUTO:
                if (measureWidth < measureWidth * heightScale / widthScale) {
                    setMeasuredDimension(measureWidth, measureWidth * heightScale / widthScale);
                } else {
                    setMeasuredDimension(measureHeight * widthScale / heightScale, measureHeight);
                }
                break;
            case ST_HEIGHT:
                setMeasuredDimension(measureWidth, measureWidth * heightScale / widthScale);
                break;
            case ST_WIDTH:
                setMeasuredDimension(measureHeight * widthScale / heightScale, measureHeight);
                break;
        }
    }

    public int getScaleTarget() {
        return scaleTarget;
    }

    public void setScaleTarget(int scaleTarget) {
        this.scaleTarget = scaleTarget;
        requestLayout();
        invalidate();
    }

    public void setFixedSize(int widthScale, int heightScale) {
        this.widthScale = widthScale;
        this.heightScale = heightScale;
        requestLayout();
        invalidate();
    }
}
