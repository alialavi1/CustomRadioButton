package com.puji.customerrangebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class CustomerRangeBar extends View {

	private static final String TAG = "customerrangebar";

	/**
	 * 滑块外圆环默认宽度
	 */
	private final static int DEFAULT_THUMB_OUTER_CIRCLE_WIDTH_DP = 5;

	/**
	 * 滑块内圆环默认高度
	 */
	private final static int DEFAULT_THUMB_INNER_CIRCLE_WIDTH_DP = 5;

	/**
	 * 滑块内圆默认半径
	 */
	private final static int DEFAULT_THUMB_CIRCLE_RADIUS_DP = 10;

	/**
	 * 刻度外圆环默认宽度
	 */
	private final static int DEFAULT_TICK_OUTER_CIRCLE_WIDTH_DP = 5;

	/**
	 * 刻度内圆默认半径
	 */
	private final static int DEFAULT_TICK_CIRCLE_RADIUS_DP = 5;

	/**
	 * 时间轴默认厚度
	 */
	private final static int DEFAULT_BASELINE_WEIGHT_DP = 5;

	/**
	 * 默认的刻度字体大小
	 */
	private final static int DEAFULT_TICK_TEXT_SIZE_SP = 12;

	/**
	 * 滑块外圆环宽度
	 */
	private float mThumbOuterCircleWidth;

	/**
	 * 滑块外圆环颜色
	 */
	private int mThumbOuterCircleColor;

	/**
	 * 滑块内圆环宽度
	 */
	private float mThumbInnerCircleWidth;

	/**
	 * 滑块内圆环颜色
	 */
	private int mThumbInnerCircleColor;

	/**
	 * 滑块内圆半径
	 */
	private float mThumbCircleRadius;

	/**
	 * 滑块内圆颜色
	 */
	private int mThumbCircleColor;

	/**
	 * 刻度内圆半径
	 */
	private float mTickCircleRadius;

	/**
	 * 刻度内圆颜色
	 */
	private int mTickCircleColor;

	/**
	 * 刻度外圆环宽度
	 */
	private float mTickOuterCircleWidth;

	/**
	 * 刻度外圆环颜色
	 */
	private int mTickOuterCircleColor;

	/**
	 * 时间轴厚度
	 */
	private float mBaseLineWeight;

	/**
	 * 刻度文字对齐方式
	 */
	private int mTickTextAlign;

	/**
	 * 正常的刻度文字颜色
	 */
	private int mTickTextNormalColor;

	/**
	 * 处于选中状态的刻度文字颜色
	 */
	private int mTickTextSelectedColor;

	/**
	 * 刻度文字大小
	 */
	private float mTickTextSize;

	/**
	 * 当前被选中刻度索引
	 */
	private int mTickIndex;

	/**
	 * 刻度总数
	 */
	private int mTickCount;

	/**
	 * 控件的默认宽度
	 */
	private float mDefaultWidth;

	/**
	 * 控件的默认高度
	 */
	private float mDefaultHeight;

	private Paint mTickCirclePaint = new Paint();
	private Paint mTickInnerCirclePaint = new Paint();
	private Paint mTickTextPaint = new Paint();
	private Paint mBaseLinePaint = new Paint();
	private Paint mThumbCirclePaint = new Paint();
	private Paint mThumbInnerCirclePaint = new Paint();
	private Paint mThumbOuterCirclePaint = new Paint();

	public float getThumbOuterCircleWidth() {
		return mThumbOuterCircleWidth;
	}

	public void setThumbOuterCircleWidth(float mThumbOuterCircleWidth) {
		this.mThumbOuterCircleWidth = mThumbOuterCircleWidth;
	}

	public int getThumbOuterCircleColor() {
		return mThumbOuterCircleColor;
	}

	public void setThumbOuterCircleColor(int mThumbOuterCircleColor) {
		this.mThumbOuterCircleColor = mThumbOuterCircleColor;
	}

	public float getThumbInnerCircleWidth() {
		return mThumbInnerCircleWidth;
	}

	public void setThumbInnerCircleWidth(float mThumbInnerCircleWidth) {
		this.mThumbInnerCircleWidth = mThumbInnerCircleWidth;
	}

	public int getThumbInnerCircleColor() {
		return mThumbInnerCircleColor;
	}

	public void setThumbInnerCircleColor(int mThumbInnerCircleColor) {
		this.mThumbInnerCircleColor = mThumbInnerCircleColor;
	}

	public float getThumbCircleRadius() {
		return mThumbCircleRadius;
	}

	public void setThumbCircleRadius(float mThumbCircleRadius) {
		this.mThumbCircleRadius = mThumbCircleRadius;
	}

	public int getThumbCircleColor() {
		return mThumbCircleColor;
	}

	public void setThumbCircleColor(int mThumbCircleColor) {
		this.mThumbCircleColor = mThumbCircleColor;
	}

	public float getTickCircleRadius() {
		return mTickCircleRadius;
	}

	public void setTickCircleRadius(float mTickCircleRadius) {
		this.mTickCircleRadius = mTickCircleRadius;
	}

	public int getTickCircleColor() {
		return mTickCircleColor;
	}

	public void setTickCircleColor(int mTickCircleColor) {
		this.mTickCircleColor = mTickCircleColor;
	}

	public float getTickOuterCircleWidth() {
		return mTickOuterCircleWidth;
	}

	public void setTickOuterCircleWidth(float mTickOuterCircleWidth) {
		this.mTickOuterCircleWidth = mTickOuterCircleWidth;
	}

	public int getTickOuterCircleColor() {
		return mTickOuterCircleColor;
	}

	public void setTickOuterCircleColor(int mTickOuterCircleColor) {
		this.mTickOuterCircleColor = mTickOuterCircleColor;
	}

	public float getBaseLineWeight() {
		return mBaseLineWeight;
	}

	public void setBaseLineWeight(float mBaseLineWeight) {
		this.mBaseLineWeight = mBaseLineWeight;
	}

	public int getTickTextAlign() {
		return mTickTextAlign;
	}

	public void setTickTextAlign(int mTickTextAlign) {
		this.mTickTextAlign = mTickTextAlign;
	}

	public int getTickTextNormalColor() {
		return mTickTextNormalColor;
	}

	public void setTickTextNormalColor(int mTickTextNormalColor) {
		this.mTickTextNormalColor = mTickTextNormalColor;
	}

	public int getTickTextSelectedColor() {
		return mTickTextSelectedColor;
	}

	public void setTickTextSelectedColor(int mTickTextSelectedColor) {
		this.mTickTextSelectedColor = mTickTextSelectedColor;
	}

	public float getTickTextSize() {
		return mTickTextSize;
	}

	public void setTickTextSize(float mTickTextSize) {
		this.mTickTextSize = mTickTextSize;
	}

	public int getTickIndex() {
		return mTickIndex;
	}

	public void setTickIndex(int mTickIndex) {
		this.mTickIndex = mTickIndex;
	}

	public int getTickCount() {
		return mTickCount;
	}

	public void setTickCount(int mTickCount) {
		this.mTickCount = mTickCount;
	}

	public float getDefaultWidth() {
		return mDefaultWidth;
	}

	public void setDefaultWidth(float mDefaultWidth) {
		this.mDefaultWidth = mDefaultWidth;
	}

	public float getDefaultHeight() {
		return mDefaultHeight;
	}

	public void setDefaultHeight(float mDefaultHeight) {
		this.mDefaultHeight = mDefaultHeight;
	}

	public CustomerRangeBar(Context context) {
		super(context);

	}

	public CustomerRangeBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		rangeBarInit(context, attrs);

	}

	public CustomerRangeBar(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		rangeBarInit(context, attrs);

	}

	public void rangeBarInit(Context context, AttributeSet attrs) {

		DisplayMetrics metrics = getResources().getDisplayMetrics();

		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.RangeBar, 0, 0);
		mThumbCircleColor = ta.getColor(R.styleable.RangeBar_thumbCircleColor,
				Color.YELLOW);
		mThumbInnerCircleColor = ta.getColor(
				R.styleable.RangeBar_thumbInnerCircleColor, Color.BLUE);
		mThumbOuterCircleColor = ta.getColor(
				R.styleable.RangeBar_thumbOuterCircleColor, Color.WHITE);
		mThumbCircleRadius = ta.getDimension(
				R.styleable.RangeBar_thumbCircleRadius, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_THUMB_CIRCLE_RADIUS_DP, metrics));
		mThumbInnerCircleWidth = ta.getDimension(
				R.styleable.RangeBar_thumbInnerCircleWidth, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_THUMB_INNER_CIRCLE_WIDTH_DP, metrics));
		mThumbOuterCircleWidth = ta.getDimension(
				R.styleable.RangeBar_thumbOuterCircleWidth, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_THUMB_OUTER_CIRCLE_WIDTH_DP, metrics));
		mBaseLineWeight = ta.getDimension(R.styleable.RangeBar_baselineWeight,
				TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						DEFAULT_BASELINE_WEIGHT_DP, metrics));
		mTickCircleColor = ta.getColor(R.styleable.RangeBar_tickCircleColor,
				Color.BLUE);
		mTickCircleRadius = ta.getDimension(
				R.styleable.RangeBar_thumbCircleRadius, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_TICK_CIRCLE_RADIUS_DP, metrics));
		mTickCount = ta.getInteger(R.styleable.RangeBar_tickCount, 4);
		mTickIndex = ta.getInteger(R.styleable.RangeBar_tickIndex, 0);
		mTickOuterCircleColor = ta.getColor(
				R.styleable.RangeBar_tickOuterCircleColor, Color.WHITE);
		mTickOuterCircleWidth = ta.getDimension(
				R.styleable.RangeBar_tickOuterCircleWidth, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
								DEFAULT_TICK_OUTER_CIRCLE_WIDTH_DP, metrics));
		mTickTextAlign = ta.getInteger(R.styleable.RangeBar_tickTextAlign, 3);
		mTickTextNormalColor = ta.getColor(
				R.styleable.RangeBar_tickTextNormalColor, Color.BLACK);
		mTickTextSelectedColor = ta.getColor(
				R.styleable.RangeBar_tickTextSelectedColor, Color.YELLOW);
		mTickTextSize = ta.getDimension(R.styleable.RangeBar_tickTextSize,
				TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
						DEAFULT_TICK_TEXT_SIZE_SP, metrics));
		ta.recycle();

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);

		int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
		int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

		int width = 0;
		int height = 0;

		if (widthMode == MeasureSpec.EXACTLY) {
			width = measureWidth;
		} else {
			width = (int) mDefaultWidth;
		}

		if (heightMode == MeasureSpec.EXACTLY) {
			height = Math.max(measureHeight,
					Math.round(calculateDefaultHeight() + 0.5f));
		} else {
			height = Math.round(calculateDefaultHeight() + 0.5f);
		}

		width = width + getPaddingLeft() + getPaddingRight();
		height = height + getPaddingTop() + getPaddingBottom();
		setMeasuredDimension(width, height);
	}

	/**
	 * 得到字体所占的高度
	 * 
	 * @return
	 */
	private int getFontHeight() {
		Paint paint = new Paint();
		paint.setTextSize(mTickTextSize);
		FontMetrics fontMetrics = paint.getFontMetrics();
		return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
	}

	/**
	 * 计算默认高度
	 * 
	 * @return
	 */
	private float calculateDefaultHeight() {
		return getFontHeight()
				+ (getDp(DEFAULT_THUMB_CIRCLE_RADIUS_DP
						+ DEFAULT_THUMB_INNER_CIRCLE_WIDTH_DP
						+ DEFAULT_THUMB_OUTER_CIRCLE_WIDTH_DP)) * 2 + getDp(10);

	}

	private float getDp(float value) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
				getResources().getDisplayMetrics());
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		float length = getWidth() - getPaddingLeft() - getPaddingRight() - 2
				* mThumbCircleRadius - 2 * mThumbInnerCircleWidth - 2
				* mThumbOuterCircleWidth;
		float len = length / mTickCount;

		mThumbOuterCirclePaint = new Paint();
		mThumbOuterCirclePaint.setDither(true);
		mThumbOuterCirclePaint.setAntiAlias(true);
		mThumbOuterCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mThumbOuterCirclePaint.setStyle(Paint.Style.FILL);
		mThumbOuterCirclePaint.setColor(Color.WHITE);

		mThumbInnerCirclePaint = new Paint();
		mThumbInnerCirclePaint.setDither(true);
		mThumbInnerCirclePaint.setAntiAlias(true);
		mThumbInnerCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mThumbInnerCirclePaint.setStyle(Paint.Style.FILL);
		mThumbInnerCirclePaint.setColor(Color.BLUE);

		mThumbCirclePaint = new Paint();
		mThumbCirclePaint.setDither(true);
		mThumbCirclePaint.setAntiAlias(true);
		mThumbCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mThumbCirclePaint.setStyle(Paint.Style.FILL);
		mThumbCirclePaint.setColor(Color.RED);

		mTickTextPaint = new Paint();
		mTickTextPaint.setDither(true);
		mTickTextPaint.setAntiAlias(true);
		mTickTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mTickTextPaint.setColor(Color.WHITE);
		mTickTextPaint.setTextSize(mTickTextSize);

		mBaseLinePaint = new Paint();
		mBaseLinePaint.setDither(true);
		mBaseLinePaint.setAntiAlias(true);
		mBaseLinePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mBaseLinePaint.setStyle(Paint.Style.FILL);
		mBaseLinePaint.setColor(Color.WHITE);
		mBaseLinePaint.setStrokeWidth(mBaseLineWeight);

		for (int i = 0; i <= mTickCount; i++) {
			if (i != mTickCount) {
				canvas.drawLine(i * len + getPaddingLeft() + mThumbCircleRadius
						+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
						getFontHeight() + getDp(10) + mThumbCircleRadius
								+ mThumbInnerCircleWidth
								+ mThumbOuterCircleWidth, (i + 1) * len
								+ getPaddingLeft() + mThumbCircleRadius
								+ mThumbInnerCircleWidth
								+ mThumbOuterCircleWidth, getFontHeight()
								+ getDp(10) + mThumbCircleRadius
								+ mThumbInnerCircleWidth
								+ mThumbOuterCircleWidth, mBaseLinePaint);
			}

			canvas.drawCircle(i * len + getPaddingLeft() + mThumbCircleRadius
					+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
					getFontHeight() + getDp(10) + mThumbCircleRadius
							+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
					mThumbCircleRadius + mThumbInnerCircleWidth
							+ mThumbOuterCircleWidth, mThumbOuterCirclePaint);
			canvas.drawCircle(i * len + getPaddingLeft() + mThumbCircleRadius
					+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
					getFontHeight() + getDp(10) + mThumbCircleRadius
							+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
					mThumbCircleRadius + mThumbInnerCircleWidth,
					mThumbInnerCirclePaint);
			canvas.drawCircle(i * len + getPaddingLeft() + mThumbCircleRadius
					+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
					getFontHeight() + getDp(10) + mThumbCircleRadius
							+ mThumbInnerCircleWidth + mThumbOuterCircleWidth,
					mThumbCircleRadius, mThumbCirclePaint);

			canvas.drawText("b", i * len + getPaddingLeft()
					+ mThumbCircleRadius + mThumbInnerCircleWidth
					+ mThumbOuterCircleWidth, getFontHeight() + getDp(5),
					mTickTextPaint);

		}

	}
}
