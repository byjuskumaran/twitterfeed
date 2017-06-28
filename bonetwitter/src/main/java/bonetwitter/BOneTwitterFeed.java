package bonetwitter;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.*;

public class BOneTwitterFeed {

	public static void main(String[] args) {
		System.out.print("Hello Twitter");
		new BOneTwitterFeed().readTweets();
	}
	
	public TwitterStream  getStream() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("7MSxiet4wcrNAiwazqnpbDir3");
		cb.setOAuthConsumerSecret("5DTgJgf0XfjmmVRzvgYR13fLp0xlmyjEvdsUuIUsZ3pCfAzGrh");
		cb.setOAuthAccessToken("13302722-ssXm6Tmr80TtmSWSNrxsYPQtdTemQ9EZNQZ2pS7IJ");
		cb.setOAuthAccessTokenSecret("LAmSlujPjUrylAp96Z4DRFYCUdaIeHa7Nz7tjCR7aBh81");
		return new TwitterStreamFactory(cb.build()).getInstance();
	}
	
	public void readTweets() {
		TwitterStream stream = getStream();
		StatusListener listener = new StatusListener() {
			
			public void onException(Exception arg0) {
				System.out.println(arg0.getMessage());
				arg0.printStackTrace();				
			}
			
			public void onTrackLimitationNotice(int arg0) {
				System.out.println("Received TrackLimitationNotice :" + arg0);
				
			}
			
			public void onStatus(Status arg0) {
				System.out.println("OnStatus:" + arg0.getText());
				System.out.println("OnStatus:" + arg0.getText());				
			}
			
			public void onStallWarning(StallWarning arg0) {
				System.out.println("Received Stall Warning:" + arg0.getMessage());
				
			}
			
			public void onScrubGeo(long arg0, long arg1) {
				System.out.println("Scrub Geo:" + arg0 + ":" + arg1);
				
			}
			
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				System.out.println("Deletion Notice for :" + arg0.toString());
				
			}
		};
		FilterQuery query = new FilterQuery();
		String[] keywords = {"Robert"};
		stream.addListener(listener);
		query.track(keywords);
		stream.filter(query);
	}

}
