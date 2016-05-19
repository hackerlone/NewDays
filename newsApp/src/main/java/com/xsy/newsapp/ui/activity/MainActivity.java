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
 * ��Ŀ����Activity�����е�Fragment��Ƕ������� 
 *  
 * @author xiaosenyu
 */  
public class MainActivity extends FragmentActivity implements OnClickListener {  
  
    /** 
     * ����չʾ�Ƽ���Fragment 
     */  
    private TuiJianFragment tuijianFragment;  
  
    /** 
     * ����չʾ������Fragment 
     */  
    private DaoHangFragment daohangFragment;  
  
    /** 
     * ����չʾ��Ա��Fragment 
     */  
    private HuiYuanFragment huiyuanFragment;  
  
    /** 
     * ����չʾ�ҵĵ�Fragment 
     */  
    private WoDeFragment wodeFragment;  
  

    /** 
     * ����չʾ���ѵ�Fragment 
     */  
    
  
    
    /** 
     * �Ƽ����沼�� 
     */  
    private View tuijianLayout;  
  
    /** 
     * �������沼�� 
     */  
    private View daohangLayout;  
  
    /** 
     * ��Ա���沼�� 
     */  
    private View huiyuanLayout;  
  
    /** 
     * �ҵĽ��沼�� 
     */  
    private View wodeLayout;  
    
    /** 
     * ���ѽ��沼�� 
     */  

  
    /** 
     * ��Tab��������ʾ�Ƽ�ͼ��Ŀؼ� 
     */  
    private ImageView tuijianImage;  
  
    /** 
     * ��Tab��������ʾ����ͼ��Ŀؼ� 
     */  
    private ImageView daohangImage;  
  
    /** 
     * ��Tab��������ʾ��Աͼ��Ŀؼ� 
     */  
    private ImageView huiyuanImage;  
  
    /** 
     * ��Tab��������ʾ�ҵ�ͼ��Ŀؼ� 
     */  
    private ImageView wodeImage;  
  
    /** 
     * ��Tab��������ʾ����ͼ��Ŀؼ� 
     */  
   
    /** 
     * ��Tab��������ʾ�Ƽ�����Ŀؼ� 
     */  
    private TextView tuijianText;  
  
    /** 
     * ��Tab��������ʾ��������Ŀؼ� 
     */  
    private TextView daohangText;  
  
    /** 
     * ��Tab��������ʾ��Ա����Ŀؼ� 
     */  
    private TextView huiyuanText;  
  
    /** 
     * ��Tab��������ʾ�ҵı���Ŀؼ� 
     */  
    private TextView wodeText;  
  
    /** 
     * ��Tab��������ʾ���ѱ���Ŀؼ� 
     */  
  
    
    /** 
     * ���ڶ�Fragment���й��� 
     */  
    private FragmentManager fragmentManager;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.main);  
        // ��ʼ������Ԫ��  
        initViews();  
        fragmentManager =getSupportFragmentManager();  
        // ��һ������ʱѡ�е�0��tab  
        setTabSelection(0);  
    }  
  
    /** 
     * �������ȡ��ÿ����Ҫ�õ��Ŀؼ���ʵ���������������úñ�Ҫ�ĵ���¼��� 
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
            // ��������Ƽ�tabʱ��ѡ�е�1��tab  
            setTabSelection(0);  
            break;  
        case R.id.daohang_layout:  
            // ������˵���tabʱ��ѡ�е�2��tab  
            setTabSelection(1);  
            break;  
        case R.id.huiyuan_layout:  
            // ������˻�Աtabʱ��ѡ�е�3��tab  
            setTabSelection(2);  
            break;  
        case R.id.wode_layout:  
            // ��������ҵ�tabʱ��ѡ�е�4��tab  
            setTabSelection(3);  
            break;  
      
        default:  
            break;  
        }  
    }  
  
    /** 
     * ���ݴ����index����������ѡ�е�tabҳ�� 
     *  
     * @param index 
     *            ÿ��tabҳ��Ӧ���±ꡣ0��ʾ�Ƽ���1��ʾ������2��ʾ��Ա��3��ʾ�ҵģ�4��ʾ���� 
     */  
    private void setTabSelection(int index) {  
        // ÿ��ѡ��֮ǰ��������ϴε�ѡ��״̬  
        clearSelection();  
        // ����һ��Fragment����  
        FragmentTransaction transaction = fragmentManager.beginTransaction();  
        // �����ص����е�Fragment���Է�ֹ�ж��Fragment��ʾ�ڽ����ϵ����  
        hideFragments(transaction);  
        switch (index) {  
        case 0:  
            // ��������Ƽ�tabʱ���ı�ؼ���ͼƬ��������ɫ  
            tuijianImage.setImageResource(R.drawable.home_tabbar_press);  
            tuijianText.setTextColor(Color.RED);  
            if (tuijianFragment == null) {  
                // ���MessageFragmentΪ�գ��򴴽�һ������ӵ�������  
                tuijianFragment = new TuiJianFragment();  
                transaction.add(R.id.content, tuijianFragment);  
            } else {  
                // ���MessageFragment��Ϊ�գ���ֱ�ӽ�����ʾ����  
                transaction.show(tuijianFragment);  
            }  
            break;  
        case 1:  
            // �������������tabʱ���ı�ؼ���ͼƬ��������ɫ  
            daohangImage.setImageResource(R.drawable.b_newvideo_tabbar_press);  
            daohangText.setTextColor(Color.RED);  
            if (daohangFragment == null) {  
                // ���ContactsFragmentΪ�գ��򴴽�һ������ӵ�������  
                daohangFragment = new DaoHangFragment();  
                transaction.add(R.id.content, daohangFragment);  
            } else {  
                // ���ContactsFragment��Ϊ�գ���ֱ�ӽ�����ʾ����  
                transaction.show(daohangFragment);  
            }  
            break;  
        case 2:  
            // ������˻�Աtabʱ���ı�ؼ���ͼƬ��������ɫ  
            huiyuanImage.setImageResource(R.drawable.b_newcare_tabbar_press);  
            huiyuanText.setTextColor(Color.RED);  
            if (huiyuanFragment == null) {  
                // ���NewsFragmentΪ�գ��򴴽�һ������ӵ�������  
                huiyuanFragment = new HuiYuanFragment();  
                transaction.add(R.id.content, huiyuanFragment);  
            } else {  
                // ���NewsFragment��Ϊ�գ���ֱ�ӽ�����ʾ����  
                transaction.show(huiyuanFragment);  
            }  
            break;  
        case 3:  
       
            // ��������ҵ�tabʱ���ı�ؼ���ͼƬ��������ɫ  
            wodeImage.setImageResource(R.drawable.b_newmine_tabbar_press);  
            wodeText.setTextColor(Color.RED);  
            if (wodeFragment == null) {  
                // ���SettingFragmentΪ�գ��򴴽�һ������ӵ�������  
                wodeFragment = new WoDeFragment();  
                transaction.add(R.id.content, wodeFragment);  
            } else {  
                // ���SettingFragment��Ϊ�գ���ֱ�ӽ�����ʾ����  
                transaction.show(wodeFragment);  
            }  
            break;  
    
        }  
        transaction.commit();  
    }  
  
    /** 
     * ��������е�ѡ��״̬�� 
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
     * �����е�Fragment����Ϊ����״̬�� 
     *  
     * @param transaction 
     *            ���ڶ�Fragmentִ�в��������� 
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