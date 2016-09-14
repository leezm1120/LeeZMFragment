package com.leezm.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.leezm.adapter.FragmentAdapter;
import com.leezm.fragment.Fragment_a;
import com.leezm.fragment.Fragment_b;
import com.leezm.fragment.Fragment_c;
import com.leezm.fragment.Fragment_d;
import com.leezm.fragment.R;

public class MainActivity extends FragmentActivity {
	private ViewPager mPager;
	private ArrayList<Fragment> fragmentList;
	private TextView barText;
	private TextView view1, view2, view3, view4;
	private int currIndex;// 当前页卡编号
	private int page = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		InitTextView();
		InitTextBar();
		InitViewPager();
	}

	/*
	 * 初始化标签名
	 */
	public void InitTextView() {
		view1 = (TextView) findViewById(R.id.tv_guid1);
		view2 = (TextView) findViewById(R.id.tv_guid2);
		view3 = (TextView) findViewById(R.id.tv_guid3);
		view4 = (TextView) findViewById(R.id.tv_guid4);

		view1.setOnClickListener(new txListener(0));
		view2.setOnClickListener(new txListener(1));
		view3.setOnClickListener(new txListener(2));
		view4.setOnClickListener(new txListener(3));
	}

	public class txListener implements View.OnClickListener {
		private int index = 0;

		public txListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	}

	/*
	 * 初始化图片的位移像素
	 */
	public void InitTextBar() {
		barText = (TextView) super.findViewById(R.id.cursor);
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		// 得到显示屏宽度
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		// 1/3屏幕宽度
		int tabLineLength = metrics.widthPixels / page;
		LayoutParams lp = (LayoutParams) barText.getLayoutParams();
		lp.width = tabLineLength;
		barText.setLayoutParams(lp);

	}

	/*
	 * 初始化ViewPager
	 */
	public void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.viewpager);
		fragmentList = new ArrayList<Fragment>();

		Fragment_a fA = new Fragment_a();
		Fragment_b fB = new Fragment_b();
		Fragment_c fC = new Fragment_c();
		Fragment_d fD = new Fragment_d();

		fragmentList.add(fA);
		fragmentList.add(fB);
		fragmentList.add(fC);
		fragmentList.add(fD);

		// 给ViewPager设置适配器
		mPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragmentList));
		mPager.setCurrentItem(0);// 设置当前显示标签页为第一页
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());// 页面变化时的监听器
		mPager.setOffscreenPageLimit(page-1);//增加ViewPager的缓存页面 ，防止ViewPager中的Fragment被销毁
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// 取得该控件的实例
			LinearLayout.LayoutParams ll = (android.widget.LinearLayout.LayoutParams) barText.getLayoutParams();

			if (currIndex == arg0) {
				ll.leftMargin = (int) (currIndex * barText.getWidth() + arg1* barText.getWidth());
			} else if (currIndex > arg0) {
				ll.leftMargin = (int) (currIndex * barText.getWidth() - (1 - arg1)* barText.getWidth());
			}
			barText.setLayoutParams(ll);
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageSelected(int arg0) {
			currIndex = arg0;
			// int i = currIndex + 1;
			// Toast.makeText(MainActivity.this, "您选择了第"+i+"个页卡",
			// Toast.LENGTH_SHORT).show();
		}
	}

}
