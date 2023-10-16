/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uts.inventarisasi.rpc;

import com.uts.inventarisasi.dto.BarangDto;
import java.util.List;

/**
 *
 * @author AFNAN
 */

public class JsonRpcResponse {

    private String jsonrpc = "2.0";
    private Object result;
    private Object error;
    private String id;

    public JsonRpcResponse(Object result, String id) {
        this.result = result;
        this.id = id;
    }

    public JsonRpcResponse(String created, String id) {
        this.result = created;
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
