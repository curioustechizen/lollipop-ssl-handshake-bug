package in.kiranrao.aospbug.tls;

import android.app.IntentService;
import android.content.Intent;

public class HttpsGetService extends IntentService {

    public HttpsGetService() {
        super("HttpsGetService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String client = intent.getStringExtra(Extras.HTTP_CLIENT);
        System.out.println("Fetching using "+client );
        if(Constants.CLIENT_APACHE.equals(client)){
            new ApacheClient().get("https://api.github.com/users/curioustechizen/gists");
        } else if (Constants.CLIENT_HURL.equals(client)){
            new HurlClient().get("https://api.github.com/users/curioustechizen/repos");
        }
    }
}
