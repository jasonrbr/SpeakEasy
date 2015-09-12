package com.mhacks.speakeasy;

import com.parse.Parse;

/**
 * Created by Sarthak on 9/12/15.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "qJq2KO9TNwGiXmj9ghgAaIN1UDoowkWuaCv67BUU",
                "UJtMZAbBl6KISiRxKGBSQFpH7dZhzowCmDGxeuuE");
    }
}
