package tien.demo.bailab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class checkBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String code= intent.getStringExtra("code");

        try {
            if (code.length()!=9){
                Toast.makeText(context, "Mã phải có 9 kí tự", Toast.LENGTH_SHORT).show();
            }
            String chu=code.substring(0,3);
            String so=code.substring(3,9);
            if (chu.equals("MEM")){
                if (so.equals("537128")){
                    Toast.makeText(context, "Loại tài khoản: "+chu+" khuyến mại 10%", Toast.LENGTH_SHORT).show();
                }
                else if (so.equals("537129")){
                    Toast.makeText(context, "Loại tài khoản: "+chu+" khuyến mại 20%", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Mã nhập không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
            else if (chu.equals("VIP")){
                if (so.equals("537128")){
                    Toast.makeText(context, "Loại tài khoản: "+chu+" khuyến mại 30%", Toast.LENGTH_SHORT).show();
                }
                else if (so.equals("537129")){
                    Toast.makeText(context, "Loại tài khoản: "+chu+" khuyến mại 50%", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Mã nhập không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(context, "Nhập sai mã", Toast.LENGTH_SHORT).show();
            }
            /*if (chu.equals("MEM")&&so.equals("537128")){
                Toast.makeText(context, "Bạn sử dụng code MEM khuyến mãi 10%", Toast.LENGTH_SHORT).show();
            }
            else if (chu.equals("VIP")&&so.equals("537128")){
                Toast.makeText(context, "Bạn sử dụng code VIP khuyến mãi 30%", Toast.LENGTH_SHORT).show();
            }
            else if (chu.equals("MEM")&&so.equals("537129")){
                Toast.makeText(context, "Bạn sử dụng code MEM khuyến mãi 20%", Toast.LENGTH_SHORT).show();
            }
            else if (chu.equals("VIP")&&so.equals("537129")){
                Toast.makeText(context, "Bạn sử dụng code VIP khuyến mãi 50%", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Nhập sai mã", Toast.LENGTH_SHORT).show();
            }*/
        }catch (NullPointerException e){
            Toast.makeText(context, "Không đc để trống", Toast.LENGTH_SHORT).show();
        }
        catch (StringIndexOutOfBoundsException e){
            Toast.makeText(context, "Nhập sai định dạng mã", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e)
        {
            Toast.makeText(context, "Lỗi"+e, Toast.LENGTH_SHORT).show();
        }


        //Toast.makeText(context, "dd"+dd, Toast.LENGTH_SHORT).show();
    }
}
