
package com.javamaster.model;

import java.util.Objects;

/**
 *
 * @author yepp
 */
public class GameModel {
private int id;
private String title;
private Integer year;
private float cost;
private float rate;

public GameModel(){
    
}

    public GameModel(Integer id, String title, Integer year, float cost, float rate) {
        this.id = id;
        this.title = title;
        this.year = year;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.year);
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
        final GameModel other = (GameModel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.cost) != Float.floatToIntBits(other.cost)) {
            return false;
        }
        if (Float.floatToIntBits(this.rate) != Float.floatToIntBits(other.rate)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.year, other.year);
    }

    @Override
    public String toString() {
        return "GameModel{" + "id=" + id + ", title=" + title + ", year=" + year + ", cost=" + cost + ", rate=" + rate + '}';
    }

}

    