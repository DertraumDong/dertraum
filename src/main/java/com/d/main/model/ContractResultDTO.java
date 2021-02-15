package com.d.main.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2020/3/27 17:56
 */
public class ContractResultDTO {
    /**
     *时间
     */
    private Date date;
    /**
     *开盘价
     */
    private BigDecimal open;
    /**
     *最新价
     */
    private BigDecimal now;
    /**
     *最高价
     */
    private BigDecimal top;
    /**
     *最低价
     */
    private BigDecimal down;
    /**
     *当日总交易成交量
     */
    private BigDecimal volume;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getNow() {
        return now;
    }

    public void setNow(BigDecimal now) {
        this.now = now;
    }

    public BigDecimal getTop() {
        return top;
    }

    public void setTop(BigDecimal top) {
        this.top = top;
    }

    public BigDecimal getDown() {
        return down;
    }

    public void setDown(BigDecimal down) {
        this.down = down;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }
}
