package com.example.apple.android_tupian_lunbo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    //设置图片资源
    String[] images = new String[]{
            "http://a1.qpic.cn/psb?/V14Pve6b3V2xM5/ECHkDlrbbYEwbnFL8loGrtTSfq1u9oWAgGu4FvVYXoo!/b/dFYBAAAAAAAA&bo=wAMABQAAAAARB*Y!&rf=viewer_4",
            "http://a2.qpic.cn/psb?/V14Pve6b3V2xM5/H*bJgrHxTTSIVI5uAn5XK3qEnooer9xhSyGX7jBS0og!/b/dMcAAAAAAAAA&bo=0AIABQAAAAAFAPQ!&rf=viewer_4",
            "http://a2.qpic.cn/psb?/V14Pve6b3V2xM5/ZGUIt.wkTbs8yXYb7poqU5rgemFzrkjz4TQHYkwFSUI!/b/dGkBAAAAAAAA&bo=wAMABQAAAAARAPE!&rf=viewer_4",
            "http://a2.qpic.cn/psb?/V14Pve6b3V2xM5/dQCEGwNfNZkH54JNRGP819jQbSUOYt.NBzpVhNDwn10!/b/dGkBAAAAAAAA&bo=wAMABQAAAAARAPE!&rf=viewer_4"};

    //设置图片标题
    String[] titles = new String[]{"春意阑珊", "夏雨雨人", "秋水伊人", "冬日可爱"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        banner = (Banner) findViewById(R.id.banner);

        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);

        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        banner.setIndicatorGravity(Banner.CENTER);

        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        banner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        banner.isAutoPlay(true);

        //设置轮播图片间隔时间（不设置默认为2000）
        banner.setDelayTime(3000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);

        //自定义图片加载框架
        banner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                System.out.println("加载中");
                Glide.with(getApplicationContext()).load(url).into(view);
                System.out.println("加载完");
            }
        });
        //设置点击事件，下标是从1开始
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}