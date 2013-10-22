package com.codepath.apps.twitterapp;

import org.json.JSONArray;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.JsonHttpResponseHandler;

public class PostTweetsActivity extends Activity {

	EditText etQuery;
	Button btnTweets;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_tweets);
		setupViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_tweets, menu);
		return true;
	}

	public void setupViews(){
		etQuery = (EditText)findViewById(R.id.editTextTweets);
		btnTweets = (Button)findViewById(R.id.buttonTweets);
		
	}
	
	public void onTweets(View v){
		String query = etQuery.getText().toString();
		TwitterClientApp.getRestClient().postTweet(query, new JsonHttpResponseHandler(){
			@Override
        	public void onSuccess(JSONArray jsonTweets){
				
			}
		});
		finish();
	}
}
