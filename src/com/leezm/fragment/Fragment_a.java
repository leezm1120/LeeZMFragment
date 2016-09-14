package com.leezm.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class Fragment_a extends BaseFragment {

	private String FRAGMENTNAME="Fragment_a";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_fragment_a, container, false);
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
