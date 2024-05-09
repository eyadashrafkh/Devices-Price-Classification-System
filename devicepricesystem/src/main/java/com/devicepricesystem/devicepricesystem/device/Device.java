package com.devicepricesystem.devicepricesystem.device;

import jakarta.persistence.*;

@Entity
@Table
public class Device {
    @Id
    @SequenceGenerator(
        name = "device_sequence",
        sequenceName = "device_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "device_sequence"
    )
    // Fields
    private Long id;
    private int batteryPower;
    private int blue;
    private double clockSpeed;
    private int dualSim;
    private int fc;
    private int four_G;
    private int intMemory;
    private double mDep;
    private double mobileWt;
    private int nCores;
    private int pc;
    private int pxHeight;
    private int pxWidth;
    private int ram;
    private int sc_H;
    private int sc_W;
    private int talkTime;
    private int three_G;
    private int touchScreen;
    private int wifi;
    private int priceRange;

    // Constructors
    public Device() {
        // Default constructor
    }

    // Constructor with all fields
    public Device(int batteryPower, int blue, double clockSpeed, int dualSim, int fc, int fourG,
            int intMemory, double mDep, double mobileWt, int nCores, int pc, int pxHeight, int pxWidth,
            int ram, int scH, int scW, int talkTime, int threeG, int touchScreen, int wifi,
            int priceRange) {
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.four_G = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.sc_H = scH;
        this.sc_W = scW;
        this.talkTime = talkTime;
        this.three_G = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
    }

    // Constructor with all fields and id
    public Device(Long id, int batteryPower, int blue, double clockSpeed, int dualSim, int fc, int fourG,
            int intMemory, double mDep, double mobileWt, int nCores, int pc, int pxHeight, int pxWidth,
            int ram, int scH, int scW, int talkTime, int threeG, int touchScreen, int wifi,
            int priceRange) {
        this.id = id;
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.four_G = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.sc_H = scH;
        this.sc_W = scW;
        this.talkTime = talkTime;
        this.three_G = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public int isBlue() {
        return blue;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public int isDualSim() {
        return dualSim;
    }

    public int getFc() {
        return fc;
    }

    public int isFourG() {
        return four_G;
    }

    public int getIntMemory() {
        return intMemory;
    }

    public double getmDep() {
        return mDep;
    }

    public double getMobileWt() {
        return mobileWt;
    }

    public int getnCores() {
        return nCores;
    }

    public int getPc() {
        return pc;
    }

    public int getPxHeight() {
        return pxHeight;
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public int getRam() {
        return ram;
    }

    public int getSc_H() {
        return sc_H;
    }

    public int getSc_W() {
        return sc_W;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public int isThreeG() {
        return three_G;
    }

    public int isTouchScreen() {
        return touchScreen;
    }

    public int isWifi() {
        return wifi;
    }

    public int getPriceRange() {
        return priceRange;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public void setDualSim(int dualSim) {
        this.dualSim = dualSim;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public void setFour_G(int fourG) {
        this.four_G = fourG;
    }

    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    public void setmDep(double mDep) {
        this.mDep = mDep;
    }

    public void setMobileWt(double mobileWt) {
        this.mobileWt = mobileWt;
    }

    public void setnCores(int nCores) {
        this.nCores = nCores;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setSc_H(int scH) {
        this.sc_H = scH;
    }

    public void setSc_W(int scW) {
        this.sc_W = scW;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public void setThree_G(int threeG) {
        this.three_G = threeG;
    }

    public void setTouchScreen(int touchScreen) {
        this.touchScreen = touchScreen;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    // toString
    @Override
    public String toString() {
        return "Device [batteryPower=" + batteryPower + ", blue=" + blue + ", clockSpeed=" + clockSpeed + ", dualSim="
                + dualSim + ", fc=" + fc + ", fourG=" + four_G + ", intMemory=" + intMemory + ", mDep=" + mDep
                + ", mobileWt=" + mobileWt + ", nCores=" + nCores + ", pc=" + pc + ", pxHeight=" + pxHeight + ", pxWidth="
                + pxWidth + ", ram=" + ram + ", scH=" + sc_H + ", scW=" + sc_W + ", talkTime=" + talkTime + ", threeG="
                + three_G + ", touchScreen=" + touchScreen + ", wifi=" + wifi + ", priceRange=" + priceRange + "]";
    }
    
}
