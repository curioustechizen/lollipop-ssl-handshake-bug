package in.kiranrao.aospbug.tls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((TextView) findViewById(R.id.tv_instructions)).setText(Html.fromHtml(getString(R.string.instructions)));

        startService(new Intent(this, HttpsGetService.class).putExtra(Extras.HTTP_CLIENT, Constants.CLIENT_APACHE));
        startService(new Intent(this, HttpsGetService.class).putExtra(Extras.HTTP_CLIENT, Constants.CLIENT_HURL));

    }
}