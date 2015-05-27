/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rstenal.mhbl.jmhblclient.model.builders;

import com.rstenal.mhbl.jmhblclient.model.BloodPressure;
import java.util.Date;

public class BloodPressureBuilder {
 
    private int systolic;
    
    private int diastolic;
    
    private int pulse;
    
    private Date occurrence;
    
    private String description;
    
    public BloodPressureBuilder withSystolic(int systolic) {
        this.systolic = systolic;
        return this;
    }
    
    public BloodPressureBuilder withDiastolic(int diastolic) {
        this.diastolic = diastolic;
        return this;
    }
    
    public BloodPressureBuilder withPulse(int pulse) {
        this.pulse = pulse;
        return this;
    }
    
    public BloodPressureBuilder withOccurrence(Date occurrence) {
        this.occurrence = occurrence;
        return this;
    }
    
    public BloodPressureBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    
    public BloodPressure build() {
        BloodPressure pressure = new BloodPressure();
        pressure.setSystolic(systolic);
        pressure.setDiastolic(diastolic);
        pressure.setPulse(pulse);
        pressure.setOccurrence(occurrence);
        pressure.setDescription(description);
        
        return pressure;
    }
}
