package com.sh.ssm.taotao.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 * 用于封装查询的数据，并返回到前端页面
 */
public class EasyUiDataGridResult {

    public long total;
    public List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
