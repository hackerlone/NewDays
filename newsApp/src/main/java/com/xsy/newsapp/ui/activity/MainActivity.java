package com.xsy.newsapp.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.xsy.newsapp.R;

/** 
 * 项目的主Activity，所有的Fragment都嵌入在这里。 
 *  
 * @author xiaosenyu
 */  
public class MainActivity extends FragmentActivity implements OnClickListener {  
  
    /** 
     * 用于展示推荐的Fragment 
     */  
    private TuiJianFragment tuijianFragment;  
  
    /** 
     * 用于展示导航的Fragment 
     */  
    private DaoHangFragment daohangFragment;  
  
    /** 
     * 用于展示会员的Fragment 
     */  
    private HuiYuanFragment huiyuanFragment;  
  
    /** 
     * 用于展示我的的Fragment 
     */  
    private WoDeFragment wodeFragment;  
  

    /** 
     * 用于展示交友的Fragment 
     */  
    
  
    
    /** 
     * 推荐界面布局 
     */  
    private View tuijianLayout;  
  
    /** 
     * 导航界面布局 
     */  
    private View daohangLayout;  
  
    /** 
     * 会员界面布局 
     */  
    private View huiyuanLayout;  
  
    /** 
     * 我的界面布局 
     */  
    private View wodeLayout;  
    
    /** 
     * 交友界面布局 
     */  

  
    /** 
     * 在Tab布局上显示推荐图标的控件 
     */  
    private ImageView tuijianImage;  
  
    /** 
     * 在Tab布局上显示导航图标的控件 
     */  
    private ImageView daohangImage;  
  
    /** 
     * 在Tab布局上显示会员图标的控件 
     */  
    private ImageView huiyuanImage;  
  
    /** 
     * 在Tab布局上显示我的图标的控件 
     */  
    private ImageView wodeImage;  
  
    /** 
     * 在Tab布局上显示交友图标的控件 
     */  
   
    /** 
     * 在Tab布局上显示推荐标题的控件 
     */  
    private TextView tuijianText;  
  
    /** 
     * 在Tab布局上显示导航标题的控件 
     */  
    private TextView daohangText;  
  
    /** 
     * 在Tab布局上显示会员标题的控件 
     */  
    private TextView huiyuanText;  
  
    /** 
     * 在Tab布局上显示我的标题的控件 
     */  
    private TextView wodeText;  
  
    /** 
     * 在Tab布局上显示交友标题的控件 
     */  
  
    
    /** 
     * 用于对Fragment进行管理 
     */  
    private FragmentManager fragmentManager;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.main);  
        // 初始化布局元素  
        initViews();  
        fragmentManager =getSupportFragmentManager();  
        // 第一次启动时选中第0个tab  
        setTabSelection(0);  
    }  
  
    /** 
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。 
     */  
    private void initViews() {  
        tuijianLayout = findViewById(R.id.tuijian_layout);  
        daohangLayout = findViewById(R.id.daohang_layout);  
        huiyuanLayout = findViewById(R.id.huiyuan_layout);  
        wodeLayout = findViewById(R.id.wode_layout);  
        
        
        tuijianImage = (ImageView) findViewById(R.id.tuijian_image);  
        daohangImage = (ImageView) findViewById(R.id.daohang_image);  
        huiyuanImage = (ImageView) findViewById(R.id.huiyuan_image);  
        wodeImage = (ImageView) findViewById(R.id.wode_image); 
        
        
        tuijianText = (TextView) findViewById(R.id.tuijian_text);  
        daohangText = (TextView) findViewById(R.id.daohang_text);  
        huiyuanText = (TextView) findViewById(R.id.huiyuan_text);  
        wodeText = (TextView) findViewById(R.id.wode_text);  
       
        
        tuijianLayout.setOnClickListener(this);  
        daohangLayout.setOnClickListener(this);  
        huiyuanLayout.setOnClickListener(this);  
        wodeLayout.setOnClickListener(this);  
       
    }  
  
    @Override  
    public void onClick(View v) {  
        switch (v.getId()) {  
        case R.id.tuijian_layout:  
            // 当点击了推荐tab时，选中第1个tab  
            setTabSelection(0);  
            break;  
        case R.id.daohang_layout:  
            // 当点击了导航tab时，选中第2个tab  
            setTabSelection(1);  
            break;  
        case R.id.huiyuan_layout:  
            // 当点击了会员tab时，选中第3个tab  
            setTabSelection(2);  
            break;  
        case R.id.wode_layout:  
            // 当点击了我的tab时，选中第4个tab  
            setTabSelection(3);  
            break;  
      
        default:  
            break;  
        }  
    }  
  
    /** 
     * 根据传入的index参数来设置选中的tab页。 
     *  
     * @param index 
     *            每个tab页对应的下标。0表示推荐，1表示导航，2表示会员，3表示我的，4表示交友 
     */  
    private void setTabSelection(int index) {  
        // 每次选中之前先清楚掉上次的选中状态  
        clearSelection();  
        // 开启一个Fragment事务  
        FragmentTransaction transaction = fragmentManager.beginTransaction();  
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况  
        hideFragments(transaction);  
        switch (index) {  
        case 0:  
            // 当点击了推荐tab时，改变控件的图片和文字颜色  
            tuijianImage.setImageResource(R.drawable.home_tabbar_press);  
            tuijianText.setTextColor(Color.RED);  
            if (tuijianFragment == null) {  
                // 如果MessageFragment为空，则创建一个并添加到界面上  
                tuijianFragment = new TuiJianFragment();  
                transaction.add(R.id.content, tuijianFragment);  
            } else {  
                // 如果MessageFragment不为空，则直接将它显示出来  
                transaction.show(tuijianFragment);  
            }  
            break;  
        case 1:  
            // 当点击了联导航tab时，改变控件的图片和文字颜色  
            daohangImage.setImageResource(R.drawable.b_newvideo_tabbar_press);  
            daohangText.setTextColor(Color.RED);  
            if (daohangFragment == null) {  
                // 如果ContactsFragment为空，则创建一个并添加到界面上  
                daohangFragment = new DaoHangFragment();  
                transaction.add(R.id.content, daohangFragment);  
            } else {  
                // 如果ContactsFragment不为空，则直接将它显示出来  
                transaction.show(daohangFragment);  
            }  
            break;  
        case 2:  
            // 当点击了会员tab时，改变控件的图片和文字颜色  
            huiyuanImage.setImageResource(R.drawable.b_newcare_tabbar_press);  
            huiyuanText.setTextColor(Color.RED);  
            if (huiyuanFragment == null) {  
                // 如果NewsFragment为空，则创建一个并添加到界面上  
                huiyuanFragment = new HuiYuanFragment();  
                transaction.add(R.id.content, huiyuanFragment);  
            } else {  
                // 如果NewsFragment不为空，则直接将它显示出来  
                transaction.show(huiyuanFragment);  
            }  
            break;  
        case 3:  
       
            // 当点击了我的tab时，改变控件的图片和文字颜色  
            wodeImage.setImageResource(R.drawable.b_newmine_tabbar_press);  
            wodeText.setTextColor(Color.RED);  
            if (wodeFragment == null) {  
                // 如果SettingFragment为空，则创建一个并添加到界面上  
                wodeFragment = new WoDeFragment();  
                transaction.add(R.id.content, wodeFragment);  
            } else {  
                // 如果SettingFragment不为空，则直接将它显示出来  
                transaction.show(wodeFragment);  
            }  
            break;  
    
        }  
        transaction.commit();  
    }  
  
    /** 
     * 清除掉所有的选中状态。 
     */  
    private void clearSelection() {  
        tuijianImage.setImageResource(R.drawable.b_newhome_tabbar);  
        tuijianText.setTextColor(Color.parseColor("#82858b"));  
        daohangImage.setImageResource(R.drawable.b_newvideo_tabbar);  
        daohangText.setTextColor(Color.parseColor("#82858b"));  
        huiyuanImage.setImageResource(R.drawable.b_newcare_tabbar);  
        huiyuanText.setTextColor(Color.parseColor("#82858b"));  
        wodeImage.setImageResource(R.drawable.b_newmine_tabbar);  
        wodeText.setTextColor(Color.parseColor("#82858b"));  
        
    }  
  
    /** 
     * 将所有的Fragment都置为隐藏状态。 
     *  
     * @param transaction 
     *            用于对Fragment执行操作的事务 
     */  
    private void hideFragments(FragmentTransaction transaction) {  
        if (tuijianFragment != null) {  
            transaction.hide(tuijianFragment);  
        }  
        if (daohangFragment != null) {  
            transaction.hide(daohangFragment);  
        }  
        if (huiyuanFragment != null) {  
            transaction.hide(huiyuanFragment);  
        }  
        if (wodeFragment != null) {  
            transaction.hide(wodeFragment);  
        }  
       
    }  
}  