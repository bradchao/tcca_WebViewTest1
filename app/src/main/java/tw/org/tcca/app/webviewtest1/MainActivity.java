package tw.org.tcca.app.webviewtest1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private static final int KEYCODE_BACK = 4;
    private EditText editN;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editN = findViewById(R.id.n);
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);

        webView = findViewById(R.id.webview);
        initWebView();

    }

    private void initWebView(){
        MyWebViewClient client = new MyWebViewClient();
        webView.setWebViewClient(client);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        //settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);


        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(true);



        //webView.loadUrl("https://www.pchome.com.tw");

        webView.loadUrl("file:///android_asset/brad.html");

        //String data = "<input type='text'><hr><select><option>item1</option><option>item1</option></select>";
        //webView.loadData(data, "text/html; charset=utf-8", null);

    }

    public void test2(View view) {

        webView.loadUrl("javascript:test1(" + editN.getText().toString() + ")");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
        }

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
