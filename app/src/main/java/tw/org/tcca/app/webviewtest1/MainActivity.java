package tw.org.tcca.app.webviewtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        initWebView();

    }

    private void initWebView(){
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);



        webView.loadUrl("https://www.iii.org.tw");

        //webView.loadUrl("file:///android_asset/brad.html");

        //String data = "<input type='text'><hr><select><option>item1</option><option>item1</option></select>";
        //webView.loadData(data, "text/html; charset=utf-8", null);

    }

    public void test1(View view) {
        Uri uri = Uri.parse("https://www.iii.org.tw");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}
