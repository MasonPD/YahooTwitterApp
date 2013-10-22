package com.codepath.apps.twitterapp;

import java.util.ArrayList;

import org.json.JSONArray;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.codepath.apps.twitterapp.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class TimelineActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        TwitterClientApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler(){
        	@Override
        	public void onSuccess(JSONArray jsonTweets){
        		ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
        		ListView lvTweets = (ListView)findViewById(R.id.lvTweets);
        		TweetsAdapter adapter = new TweetsAdapter(getBaseContext(), tweets);
        		lvTweets.setAdapter(adapter);
        	}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timeline, menu);
        return true;
    }
    
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings:
				Intent i = new Intent(getApplicationContext(), PostTweetsActivity.class);
				startActivityForResult(i, 1);
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
