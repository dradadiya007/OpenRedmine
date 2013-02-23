package jp.redmine.redmineclient.task;


import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;

abstract class SelectDataTaskConnectionHandler {
	private DefaultHttpClient client;
	abstract protected DefaultHttpClient getHttpClientCore();
	public DefaultHttpClient getHttpClient(){
		if(client == null)
			client = getHttpClientCore();
		return client;
	}

	public void close(){
		if(client == null)
			return;
		client.getConnectionManager().shutdown();
		client = null;
	}

	public void setupOnMessage(AbstractHttpMessage msg){
	}


}
