package com.lzj.socketservice;

import android.Manifest;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzj.socketservice.entity.EventBean;
import com.lzj.socketservice.netty.NettyServer;
import com.lzj.socketservice.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 服务器
 */
public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.tvState)
    TextView tvState;
    @BindView(R.id.tvState2)
    TextView tvState2;
    @BindView(R.id.surface)
    SurfaceView surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        requestPermission();
    }

    //接收
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void responseEvent(EventBean bean) {
        if(bean!=null){
            switch (bean.getCode()){
                case 1://服务器心跳数据
                    ToastUtil.showLong(this,bean.getMsg());
                     tvState.setText(bean.getMsg());
                    break;
                case 2://
                    tvState2.setText(bean.getMsg());
                    break;
            }
        }
    }

    @OnClick({R.id.bt_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
                startNettiyServer();
                break;
        }
    }

    private void startNettiyServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                     NettyServer.getInstance().start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void requestPermission() {
        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            ToastUtil.showLong(this,"可以正常启动服务");
        } else {
            EasyPermissions.requestPermissions(this, "为了更好的用户体验需要获取以下权限", 1001, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        switch (requestCode) {
            case 1001:
                ToastUtil.showLong(this,"可以正常启动服务");
                break;
        }
    }
    /**
     * 拒绝
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        ToastUtil.showLong(this,"您已拒绝相关权限，可到设置里自行开启");
    }
}
