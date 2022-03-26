package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.parser.api.Column;

import java.math.BigDecimal;

public class WeatherData {
    private Integer day;
    private Integer mxt;
    private Integer mnt;
    private Integer avt;
    private BigDecimal avdp;
    @Column("1hrp_tpcpn")
    private Integer hrpTpcpn;
    private Integer pdir;
    private BigDecimal avsp;
    private Integer dir;
    private Integer mxs;
    private BigDecimal skyc;
    private Integer mxr;
    private Integer mn;
    @Column("r_avslp")
    private BigDecimal rAvSLP;

    public Integer getTemperatureSpread() {
        return mxt - mnt;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMxt() {
        return mxt;
    }

    public void setMxt(Integer mxt) {
        this.mxt = mxt;
    }

    public Integer getMnt() {
        return mnt;
    }

    public void setMnt(Integer mnt) {
        this.mnt = mnt;
    }

    public Integer getAvt() {
        return avt;
    }

    public void setAvt(Integer avt) {
        this.avt = avt;
    }

    public BigDecimal getAvdp() {
        return avdp;
    }

    public void setAvdp(BigDecimal avdp) {
        this.avdp = avdp;
    }

    public Integer getHrpTpcpn() {
        return hrpTpcpn;
    }

    public void setHrpTpcpn(Integer hrpTpcpn) {
        this.hrpTpcpn = hrpTpcpn;
    }

    public Integer getPdir() {
        return pdir;
    }

    public void setPdir(Integer pdir) {
        this.pdir = pdir;
    }

    public BigDecimal getAvsp() {
        return avsp;
    }

    public void setAvsp(BigDecimal avsp) {
        this.avsp = avsp;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }

    public Integer getMxs() {
        return mxs;
    }

    public void setMxs(Integer mxs) {
        this.mxs = mxs;
    }

    public BigDecimal getSkyc() {
        return skyc;
    }

    public void setSkyc(BigDecimal skyc) {
        this.skyc = skyc;
    }

    public Integer getMxr() {
        return mxr;
    }

    public void setMxr(Integer mxr) {
        this.mxr = mxr;
    }

    public Integer getMn() {
        return mn;
    }

    public void setMn(Integer mn) {
        this.mn = mn;
    }

    public BigDecimal getrAvSLP() {
        return rAvSLP;
    }

    public void setrAvSLP(BigDecimal rAvSLP) {
        this.rAvSLP = rAvSLP;
    }
}
