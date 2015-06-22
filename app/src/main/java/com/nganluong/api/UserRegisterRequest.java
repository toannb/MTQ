package com.nganluong.api;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nganluong.config.Constant;
import com.nganluong.util.Methods;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DucChinh on 6/22/2015.
 */
public class UserRegisterRequest {

    private UserRegisterRequestOnResult userRegisterRequestOnResult;

    public void execute(Context pContext, String phoneNumber, String iStyleUser) {
        JSONObject jSONObject1 = new JSONObject();
        try {
            jSONObject1.put("mobile", phoneNumber);
            jSONObject1.put("type", iStyleUser);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        String data = jSONObject1.toString();
        String encodeData = "";
        String md5Data = "";

        try {
            encodeData = Methods.encrypt(data);
            md5Data = Methods.md5(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestParams lvParams = new RequestParams();
        lvParams.put("function", Constant.CONNECT_USER_REQUEST_REGISTER);
        lvParams.put("params", encodeData);
        lvParams.put("app_id", Methods.getDeviceID(pContext));
        lvParams.put("os_system", Constant.OS_SYSTEM);
        lvParams.put("checksum", md5Data);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Constant.MAIN_URL, lvParams, new AsyncHttpResponseHandler() {

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                if (userRegisterRequestOnResult != null) {
                    userRegisterRequestOnResult.onUserRegisterRequestOnResult(false, content);
                }
            }

            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                try {
                    if (userRegisterRequestOnResult != null) {
                        userRegisterRequestOnResult.onUserRegisterRequestOnResult(true, content);
                    }
                } catch (NullPointerException e) {
                    if (userRegisterRequestOnResult != null) {
                        userRegisterRequestOnResult.onUserRegisterRequestOnResult(false, content);
                    }
                } catch (Exception e) {
                    if (userRegisterRequestOnResult != null) {
                        userRegisterRequestOnResult.onUserRegisterRequestOnResult(false, content);
                    }
                } catch (OutOfMemoryError e) {
                    if (userRegisterRequestOnResult != null) {
                        userRegisterRequestOnResult.onUserRegisterRequestOnResult(false, content);
                    }
                }
            }

        });
    }

    public void getUserRegisterRequestOnResult(UserRegisterRequestOnResult userRegisterRequestOnResult) {
        this.userRegisterRequestOnResult = userRegisterRequestOnResult;
    }

    public interface UserRegisterRequestOnResult {
        void onUserRegisterRequestOnResult(boolean result, String data);
    }
}
