package com.yuruicai.test.common.bean;

public class PageVo {

    public int page = 1;//当前页数，默认为1
    public int rows = 15;//每页显示条数,默认为15
    private int offset = 0;//每页起始条数
    private int limit = 15;//每页结束条数


    public int getLimit() {
        return (page - 1) * rows;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return page * rows;
    }

    public void setOffset(int offset) {
        this.offset = (page - 1) * rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
