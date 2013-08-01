package jp.redmine.redmineclient;

import com.j256.ormlite.android.apptools.OrmLiteFragmentActivity;

import jp.redmine.redmineclient.activity.handler.ConnectionListHandler;
import jp.redmine.redmineclient.activity.handler.IssueViewHandler;
import jp.redmine.redmineclient.activity.handler.TimeEntryHandler;
import jp.redmine.redmineclient.activity.helper.ActivityHelper;
import jp.redmine.redmineclient.db.cache.DatabaseCacheHelper;
import jp.redmine.redmineclient.form.helper.TextileHelper.IntentAction;
import jp.redmine.redmineclient.fragment.ActivityInterface;
import jp.redmine.redmineclient.fragment.ConnectionList;
import jp.redmine.redmineclient.fragment.IssueView;
import jp.redmine.redmineclient.fragment.TimeEntryList;
import android.os.Bundle;

public class Pane1Activity extends OrmLiteFragmentActivity<DatabaseCacheHelper>
	implements ActivityInterface {
	public Pane1Activity(){
		super();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityHelper.setupTheme(this);
		setContentView(R.layout.fragment_one);


		getSupportFragmentManager().beginTransaction()
			.add(R.id.fragmentOne, ConnectionList.newInstance())
			.commit();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@SuppressWarnings("unchecked")
	public <T> T getHandler(Class<T> cls){
		if(cls.equals(ConnectionList.OnArticleSelectedListener.class))
			return (T) new ConnectionListHandler(getSupportFragmentManager());
		if(cls.equals(IntentAction.class))
			return (T) new IssueViewHandler(getSupportFragmentManager());
		if(cls.equals(IssueView.OnArticleSelectedListener.class))
			return (T) new IssueViewHandler(getSupportFragmentManager());
		if(cls.equals(TimeEntryList.OnArticleSelectedListener.class))
			return (T) new TimeEntryHandler(getSupportFragmentManager());
		return null;
	}
}
