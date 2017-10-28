package com.gaoyy.delivery4driver.main;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gaoyy.delivery4driver.R;
import com.gaoyy.delivery4driver.api.Constant;
import com.gaoyy.delivery4driver.api.bean.OrderNewInfo;
import com.gaoyy.delivery4driver.base.BaseActivity;
import com.gaoyy.delivery4driver.util.CommonUtils;
import com.gaoyy.delivery4driver.util.PrintUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PrintActivity extends BaseActivity implements AdapterView.OnItemClickListener
{
    private static final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private BluetoothAdapter bluetoothAdapter;

    private LinearLayout activityPrint;
    private Toolbar printToolbar;
    private ListView printDeviceList;

    private ArrayAdapter<String> arrayAdapter;
    private List<String> deviceList = new ArrayList<>();
    public BluetoothSocket bluetoothSocket;


    private OrderNewInfo orderNewInfo;

    private final BroadcastReceiver receiver = new BroadcastReceiver()
    {
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            Log.e(Constant.TAG, "AC-->" + action);
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action))
            {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the name and address to an array adapter to show in a ListView

//                if (device.getBondState() == BluetoothDevice.BOND_NONE)
//                {
                    String str = "打印设备|" + device.getName() + "|" + device.getAddress();
                    Log.e(Constant.TAG, "==receiver found device  未配对==>" + device.getName() + "===" + device.getAddress());
                    if (deviceList.indexOf(str) == -1)// 防止重复添加
                        deviceList.add(str); // 获取设备名称和mac地址
                    arrayAdapter.notifyDataSetChanged();
//                }

            }
            else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action))
            {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                switch (device.getBondState())
                {
                    case BluetoothDevice.BOND_BONDING:
                        Log.d(Constant.TAG, "正在配对......");
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        Log.d(Constant.TAG, "完成配对");
                        connect(device);//连接设备
                        break;
                    case BluetoothDevice.BOND_NONE:
                        Log.d(Constant.TAG, "取消配对");
                    default:
                        break;
                }
            }

        }
    };


    @Override
    protected void initContentView()
    {
        setContentView(R.layout.activity_print);
    }

    @Override
    protected void assignViews()
    {
        super.assignViews();
        activityPrint = (LinearLayout) findViewById(R.id.activity_print);
        printToolbar = (Toolbar) findViewById(R.id.print_toolbar);
        printDeviceList = (ListView) findViewById(R.id.print_device_list);
    }


    @Override
    protected void initToolbar()
    {
        super.initToolbar(printToolbar, R.string.toolbar_title_print, true, -1);
    }

    @Override
    protected void configViews()
    {
        super.configViews();

        orderNewInfo = (OrderNewInfo) getIntent().getSerializableExtra("orderNewInfo");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, deviceList);
        printDeviceList.setAdapter(arrayAdapter);

        printDeviceList.setOnItemClickListener(this);
        Log.e(Constant.TAG, "注册广播");
        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothDevice.ACTION_FOUND);// 用BroadcastReceiver来取得搜索结果
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(receiver, filter);
        setOnBluetoothAndScan();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 开启蓝牙并扫描
     */
    private void setOnBluetoothAndScan()
    {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null)
        {
            Log.e(Constant.TAG, "当前手机不支持蓝牙");
            CommonUtils.showToast(this,R.string.bluetooth_unsupport);
            setResult(RESULT_CANCELED);
            finish();
        }
        else
        {
            Log.e(Constant.TAG, "当前手机支持蓝牙");
            if (!bluetoothAdapter.isEnabled())
            {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, Constant.REQUEST_BLUETOOTH_ON);
            }
            else
            {
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
                // If there are paired devices
                if (pairedDevices.size() > 0)
                {
                    // Loop through paired devices
                    for (BluetoothDevice device : pairedDevices)
                    {
                        // Add the name and address to an array adapter to show in a ListView
                        Log.e(Constant.TAG, "==已配对设备==>" + device.getName() + "===" + device.getAddress());
                        String str = "打印设备|" + device.getName() + "|" + device.getAddress();
                        if (deviceList.indexOf(str) == -1)// 防止重复添加
                            deviceList.add(str); // 获取设备名称和mac地址
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
                else
                {
                    Log.e(Constant.TAG, "未有已配对设备");
                }
                scanDevices();
            }
        }
    }

    /**
     * 扫描设备
     */
    private void scanDevices()
    {
        if (bluetoothAdapter.isDiscovering())
        {
            Log.e(Constant.TAG, "停止正在扫描，重启扫描");
            bluetoothAdapter.cancelDiscovery();
            bluetoothAdapter.startDiscovery();
        }
        else
        {
            Log.e(Constant.TAG, "启动扫描");
            bluetoothAdapter.startDiscovery();
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(receiver);
        if(bluetoothAdapter != null)
        {
            //Activity不可见时停止扫描
            if (bluetoothAdapter.isDiscovering())
            {
                bluetoothAdapter.cancelDiscovery();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_BLUETOOTH_ON)
        {
            if (resultCode == RESULT_OK)
            {
                Log.e(Constant.TAG, "启动蓝牙");
                scanDevices();
            }
            else
            {
                Log.e(Constant.TAG, "启动蓝牙失败");
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        if (bluetoothAdapter.isDiscovering()) bluetoothAdapter.cancelDiscovery();
        String str = deviceList.get(position);
        String[] values = str.split("\\|");
        String address = values[2];
        Log.e(Constant.TAG, values[2]);
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
        try
        {
            Boolean returnValue = false;
            if (device.getBondState() == BluetoothDevice.BOND_NONE)
            {
                //利用反射方法调用BluetoothDevice.createBond(BluetoothDevice remoteDevice);
                Method createBondMethod = BluetoothDevice.class
                        .getMethod("createBond");
                Log.d(Constant.TAG, "开始配对");
                returnValue = (Boolean) createBondMethod.invoke(device);
                Log.d(Constant.TAG, "returnValue-->" + returnValue);

            }
            else if (device.getBondState() == BluetoothDevice.BOND_BONDED)
            {
                connect(device);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void connect(BluetoothDevice btDev)
    {
        UUID uuid = UUID.fromString(SPP_UUID);
        try
        {
            bluetoothSocket = btDev.createRfcommSocketToServiceRecord(uuid);
            Log.d(Constant.TAG, "开始连接...");
            bluetoothSocket.connect();

            printOrder();
            //返回打印结果
            setResult(RESULT_OK);
            finish();

        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 打印订单
     *
     * @throws IOException
     */
    private void printOrder() throws IOException
    {
        OutputStream mOutputStream = bluetoothSocket.getOutputStream();

        PrintUtils.setOutputStream(mOutputStream);

        PrintUtils.selectCommand(PrintUtils.RESET);
        PrintUtils.printText("\n");
        PrintUtils.selectCommand(PrintUtils.ALIGN_CENTER);
        PrintUtils.selectCommand(PrintUtils.DOUBLE_HEIGHT_WIDTH);
        PrintUtils.printText(orderNewInfo.getBody().getStoreName() + "\n");
        PrintUtils.selectCommand(PrintUtils.NORMAL);
        PrintUtils.printText("--------------------------------\n");
        PrintUtils.selectCommand(PrintUtils.NORMAL);
        PrintUtils.selectCommand(PrintUtils.ALIGN_LEFT);
        PrintUtils.printText("订单号：" + orderNewInfo.getBody().getObj().getOrder_id() + "\n");
        PrintUtils.printText("期望时间：" + orderNewInfo.getBody().getObj().getAppointment_time() + "\n");
        PrintUtils.printText("--------------------------------\n");
        PrintUtils.printText(PrintUtils.printThreeData("商品", "数量", "单价\n"));

        List<OrderNewInfo.BodyBean.ObjBean.GcsBean> goods = orderNewInfo.getBody().getObj().getGcs();
        for (OrderNewInfo.BodyBean.ObjBean.GcsBean item : goods)
        {
            PrintUtils.printText(PrintUtils.printThreeData("" + item.getGoods_name(), item.getCount() + "", "$"+item.getPrice() + "\n"));
        }
        PrintUtils.printText("--------------------------------\n");

        OrderNewInfo.BodyBean.ObjBean data = orderNewInfo.getBody().getObj();
        if(!data.getDistribution_type().equals("Pick-Up"))
        {
            //小费
            if (data.getTipPrice() != null && (Double) (data.getTipPrice()) != 0.0)
                PrintUtils.printText(PrintUtils.printTwoData("小费", "$"+data.getTipPrice() + "\n"));
        }
        //配送费
        if (data.getShip_price() != null && (Double) (data.getShip_price()) != 0.0)
            PrintUtils.printText(PrintUtils.printTwoData("配送费", "$"+data.getShip_price() + "\n"));
        //税1
        if (data.getTaxation() != null && (Double) (data.getTaxation()) != 0.0)
            PrintUtils.printText(PrintUtils.printTwoData("税1", "$"+data.getTaxation() + "\n"));
        //税2
        if (data.getTaxation_tvq() != null  && (Double) (data.getTaxation_tvq()) != 0.0)
            PrintUtils.printText(PrintUtils.printTwoData("税2", "$"+data.getTaxation_tvq() + "\n"));
        //收益
        if (data.getUseIncomePrice() != null  && (Double) (data.getUseIncomePrice()) != 0.0)
            PrintUtils.printText(PrintUtils.printTwoData("收益", "-$" + data.getUseIncomePrice() + "\n"));
        //代金券
        if (data.getCouponPrice() != null  && (Double) (data.getCouponPrice()) != 0.0)
            PrintUtils.printText(PrintUtils.printTwoData("代金券", "-$" + data.getCouponPrice() + "\n"));
        //商家满减
        if (data.getActivityPrice() != null  && (Double) (data.getActivityPrice()) != 0.0)
            PrintUtils.printText(PrintUtils.printTwoData("商家满减", "-$" + data.getActivityPrice() + "\n"));

        PrintUtils.printText("--------------------------------\n");
        PrintUtils.selectCommand(PrintUtils.ALIGN_CENTER);
        PrintUtils.selectCommand(PrintUtils.DOUBLE_HEIGHT_WIDTH);
        PrintUtils.printText("合计：" + "$"+orderNewInfo.getBody().getObj().getTotalPrice() + "\n");
        PrintUtils.selectCommand(PrintUtils.NORMAL);
        PrintUtils.selectCommand(PrintUtils.ALIGN_LEFT);
        PrintUtils.printText("--------------------------------\n");
        PrintUtils.printText("下单人：" + orderNewInfo.getBody().getObj().getAddr().getTrueName() + "\n");
        PrintUtils.printText("电话：" + orderNewInfo.getBody().getObj().getAddr().getMobile() + "\n");
        PrintUtils.printText("地址：" + orderNewInfo.getBody().getObj().getAddr().getArea_info() + "\n");
        PrintUtils.printText("备注：" + orderNewInfo.getBody().getObj().getMsg() + "\n");


        print1DCodeBy2(orderNewInfo.getBody().getObj().getOrder_id() + "", mOutputStream);

        PrintUtils.printText("\n\n\n\n\n");
    }

    private void print1DCodeBy2(String content, OutputStream outputStream)
    {
        byte[] bytes = content.getBytes();
        byte[] cmd = new byte[bytes.length + 4];
        // 打印条码的指令
        cmd[0] = 0x1D;// 29
        cmd[1] = 0x6B;// 107
        cmd[2] = 73;// 条码的类型 code39:69 code128:73 具体参考文档
        cmd[3] = (byte) bytes.length;// 条码数据的字节数
        for (int i = 0; i < bytes.length; i++)
        {
            cmd[4 + i] = bytes[i];
        }

//        initPrinter();// 一定要初始化，不然条码打不出来

        byte[] initPrinter = {0x1B, 0x40};// 初始化
        write(initPrinter, outputStream);

        // 设置对齐方式
        byte[] alignByte = {0x1B, 0x61, 1};// 0：左对齐；1：居中；2：右对齐
        write(alignByte, outputStream);

        // 设置条码的高度(注：高度与宽度要么全设置，要么全不设置)
        byte[] setCodeHeigthByte = {0x1D, 0x68, (byte) 150};
        write(setCodeHeigthByte, outputStream);
        // 设置条码的宽度
        byte[] setCodeWidthByte = {0x1D, 0x77, 2};
        write(setCodeWidthByte, outputStream);

        // 设置字符打印在条码下方
        byte[] codeStrByte = {0x1D, 0x48, 2};
        write(codeStrByte, outputStream);

        // 打印条码
        write(cmd, outputStream);

        // 设置换行
        byte[] LF = {0x0A, 0x0A};// 两行
        write(LF, outputStream);
    }


    public void write(byte[] buffer, OutputStream outputStream)
    {
        // TODO 打印
        try
        {
            outputStream.write(buffer);
            outputStream.flush();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
