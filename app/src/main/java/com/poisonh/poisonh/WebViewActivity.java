package com.poisonh.poisonh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.poisonh.poisonh.api.RequestURL;

/**
 * Created by PoisonH on 2016/3/17.
 */
public class WebViewActivity extends AppCompatActivity
{
    private String mStrArticleUrl;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mStrArticleUrl = this.getIntent().getStringExtra("id");
        mWebView = (WebView) findViewById(R.id.wb_view);
        mWebView.loadUrl(splicingUrl(mStrArticleUrl));
        mWebView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);

                return true;
            }
        });
    }

    private String splicingUrl(String id)
    {
        return RequestURL.ARTICLEURL + id + ".html?from=app_android&action=";
    }
}
