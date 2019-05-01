/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placetopay.model;

/**
 *
 * @author CUSPIDE4
 */
public class Payment {
    
    private String reference;
    private String description;
    private Amount amout;

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the amout
     */
    public Amount getAmout() {
        return amout;
    }

    /**
     * @param amout the amout to set
     */
    public void setAmout(Amount amout) {
        this.amout = amout;
    }
    
    
}
