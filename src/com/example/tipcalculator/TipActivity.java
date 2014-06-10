package com.example.tipcalculator;

import java.lang.NumberFormatException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip);
	}

	public void tipCalculate(View view) {
		TextView tipTotal = (TextView) findViewById (R.id.totalTip);
		TextView errMsg = (TextView) findViewById(R.id.errText);
		EditText editText = (EditText) findViewById(R.id.editText);
		
		errMsg.setText("");	// reset error message
		
		String temp = view.getTag().toString();
		int percent = Integer.valueOf(temp);
		double fee, tip;
		temp = editText.getText().toString();

		if(temp == null || temp.length()==0) {
			errMsg.setText("Input cannot be empty");
			return;
		}
		
		try {
			fee = Double.valueOf(temp);
			if(fee < 0) {
				errMsg.setText("Input cannot be negative number");
				return;
			}
			tip = (double) percent * fee / 100;
		} catch (NumberFormatException e){
			errMsg.setText("This is not a valid number");
			return;
		}
		tipTotal.setText("$"+String.format("%.2f", tip)); 
	}
	
}
