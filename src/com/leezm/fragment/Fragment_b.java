package com.leezm.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class Fragment_b extends BaseFragment {

	private String FRAGMENTNAME="Fragment_b";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_fragment_b, container, false);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		//TODO
	}
	
	@Override
	public String getFragmentName() {
		return FRAGMENTNAME;
	}

}
