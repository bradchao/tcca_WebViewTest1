package tw.org.tcca.app.webviewtest1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private static final int KEYCODE_BACK = 4;

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

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        //webView.loadUrl("https://www.iii.org.tw");

        webView.loadUrl("file:///android_asset/brad.html");

        //String data = "<input type='text'><hr><select><option>item1</option><option>item1</option></select>";
        //webView.loadData(data, "text/html; charset=utf-8", null);

    }

    public void test1(View view) {
        Uri uri = Uri.parse("https://www.iii.org.tw");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KEYCODE_BACK && webView.canGoBack()){
//            webView.goBack();
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();

        }else{
           new AlertDialog.Builder(this)
                    .setMessage("Exit?")
                   .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           finish();
                       }
                   })
                   .setNegativeButton("no", null)
                   .setCancelable(false)
                   .create()
                   .show();

        }
        //super.onBackPressed();
    }

}
