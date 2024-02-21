
package com.javamaster.model;

import java.util.Objects;

/**
 *
 * @author yepp
 */
public class EnergyModel {
private int id;
private String title;
private float cost;
private float rate;

public EnergyModel(){
    
}

    public EnergyModel(Integer id, String title, float cost, float rate) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Float.floatToIntBits(this.cost);
        hash = 97 * hash + Float.floatToIntBits(this.rate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EnergyModel other = (EnergyModel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.cost) != Float.floatToIntBits(other.cost)) {
            return false;
        }
        if (Float.floatToIntBits(this.rate) != Float.floatToIntBits(other.rate)) {
            return false;
        }
        return Objects.equals(this.title, other.title);
    }

    @Override
    public String toString() {
        return "EnergyModel{" + "id=" + id + ", title=" + title + ", cost=" + cost + ", rate=" + rate + '}';
    }

}

    