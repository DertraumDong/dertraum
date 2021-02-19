package com.d.main.bank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* ������合约ģ��
* @author Administrator
* @date 2020-03-23 05:34:21
*/
public class Contract extends BaseModel implements java.io.Serializable {

    /**
    *
    */
    private Integer id;
    /**
    *合约名称
    */
    private String name;
    /**
    *机构代码
    */
    private String code;
    /**
    *开盘价
    */
    private BigDecimal open;
    /**
    *最高价
    */
    private BigDecimal top;
    /**
    *最低价
    */
    private BigDecimal down;
    /**
    *昨收
    */
    private BigDecimal closing;
    /**
    *最新价
    */
    private BigDecimal now;
    /**
    *当前卖出价
    */
    private BigDecimal onesell;
    /**
    *当前买入价
    */
    private BigDecimal onebuy;
    /**
    *结算价
    */
    private BigDecimal settlement;
    /**
    *昨日结算价
    */
    private BigDecimal yessettlement;
    /**
    *当前买入挂量
    */
    private BigDecimal onebuynum;
    /**
    *当前卖出挂量
    */
    private BigDecimal onesellnum;
    /**
    *目前持仓量
    */
    private BigDecimal holdings;
    /**
    *当日总交易成交量
    */
    private BigDecimal volume;
    /**
    *交易所
    */
    private String exchange;
    /**
    *品种
    */
    private String varieties;
    /**
    *时间
    */
    private Date date;
    /**
    *未知参数1
    */
    private String unknownparameters1;
    /**
    *未知参数2
    */
    private String unknownparameters2;
    /**
    *未知参数3
    */
    private String unknownparameters3;
    /**
    *未知参数4
    */
    private String unknownparameters4;
    /**
    *未知参数5
    */
    private String unknownparameters5;
    /**
    *未知参数6
    */
    private String unknownparameters6;
    /**
    *未知参数7
    */
    private String unknownparameters7;
    /**
    *合约最高价格
    */
    private String historytop;
    /**
    *合约最低价格
    */
    private String historydown;
    /**
    *平均价格
    */
    private BigDecimal avg;

    /**
     * 唯一标识
     */
    private String flag;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getOpen() {
        return this.open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getTop() {
        return this.top;
    }

    public void setTop(BigDecimal top) {
        this.top = top;
    }

    public BigDecimal getDown() {
        return this.down;
    }

    public void setDown(BigDecimal down) {
        this.down = down;
    }

    public BigDecimal getClosing() {
        return this.closing;
    }

    public void setClosing(BigDecimal closing) {
        this.closing = closing;
    }

    public BigDecimal getNow() {
        return this.now;
    }

    public void setNow(BigDecimal now) {
        this.now = now;
    }

    public BigDecimal getOnesell() {
        return this.onesell;
    }

    public void setOnesell(BigDecimal onesell) {
        this.onesell = onesell;
    }

    public BigDecimal getOnebuy() {
        return this.onebuy;
    }

    public void setOnebuy(BigDecimal onebuy) {
        this.onebuy = onebuy;
    }

    public BigDecimal getSettlement() {
        return this.settlement;
    }

    public void setSettlement(BigDecimal settlement) {
        this.settlement = settlement;
    }

    public BigDecimal getYessettlement() {
        return this.yessettlement;
    }

    public void setYessettlement(BigDecimal yessettlement) {
        this.yessettlement = yessettlement;
    }

    public BigDecimal getOnebuynum() {
        return this.onebuynum;
    }

    public void setOnebuynum(BigDecimal onebuynum) {
        this.onebuynum = onebuynum;
    }

    public BigDecimal getOnesellnum() {
        return this.onesellnum;
    }

    public void setOnesellnum(BigDecimal onesellnum) {
        this.onesellnum = onesellnum;
    }

    public BigDecimal getHoldings() {
        return this.holdings;
    }

    public void setHoldings(BigDecimal holdings) {
        this.holdings = holdings;
    }

    public BigDecimal getVolume() {
        return this.volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getExchange() {
        return this.exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getVarieties() {
        return this.varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUnknownparameters1() {
        return this.unknownparameters1;
    }

    public void setUnknownparameters1(String unknownparameters1) {
        this.unknownparameters1 = unknownparameters1;
    }

    public String getUnknownparameters2() {
        return this.unknownparameters2;
    }

    public void setUnknownparameters2(String unknownparameters2) {
        this.unknownparameters2 = unknownparameters2;
    }

    public String getUnknownparameters3() {
        return this.unknownparameters3;
    }

    public void setUnknownparameters3(String unknownparameters3) {
        this.unknownparameters3 = unknownparameters3;
    }

    public String getUnknownparameters4() {
        return this.unknownparameters4;
    }

    public void setUnknownparameters4(String unknownparameters4) {
        this.unknownparameters4 = unknownparameters4;
    }

    public String getUnknownparameters5() {
        return this.unknownparameters5;
    }

    public void setUnknownparameters5(String unknownparameters5) {
        this.unknownparameters5 = unknownparameters5;
    }

    public String getUnknownparameters6() {
        return this.unknownparameters6;
    }

    public void setUnknownparameters6(String unknownparameters6) {
        this.unknownparameters6 = unknownparameters6;
    }

    public String getUnknownparameters7() {
        return this.unknownparameters7;
    }

    public void setUnknownparameters7(String unknownparameters7) {
        this.unknownparameters7 = unknownparameters7;
    }

    public String getHistorytop() {
        return this.historytop;
    }

    public void setHistorytop(String historytop) {
        this.historytop = historytop;
    }

    public String getHistorydown() {
        return this.historydown;
    }

    public void setHistorydown(String historydown) {
        this.historydown = historydown;
    }

    public BigDecimal getAvg() {
        return this.avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}