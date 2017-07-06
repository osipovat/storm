package a3;

import java.util.ArrayList;

public class Storm {
	private String name;
	private ArrayList cities;
	private int year;

	public Storm(String name, int year) {
		this.name = name;
		this.year = year;
		this.cities = new ArrayList();
	}

	public String getName() {
        return name;
    }

    public ArrayList<City> getCities() {
        return cities;
    }
    
    public int getYear() {
        return year;
    }

    public void addCity(City c) {
        this.cities.add(c);
        if (!c.getStorms().contains(this)){
        	c.addStorm(this);
        }
    }
    
    @Override
    public boolean equals(Object other) {
    	if (this == other) return true;
    	if (other == null) return false;
    	if (this.getClass() != other.getClass()) return false;
    	Storm otherStorm = (Storm) other;
    	return this.name.equals(otherStorm.name) && 
    			this.year == otherStorm.year;
       
    }
   
    @Override
    public int hashCode() {
    	int result = 17;
    	if(this.name != null)
    		result = 31*result * this.name.hashCode();
    	long l = Double.doubleToLongBits(this.year);
    	result = 31*result + (int)(l^(l>>>32));
    	return result;
    }
    
    public String toString() {
    	String stormInfo = this.name + ", " + String.valueOf(this.year);
        String stormCities = "";
        for (int i = 0; i <this.cities.size(); i++){
        	if (this.cities.get(i) != null){
        		stormCities += System.lineSeparator() + ((City) this.cities.get(i)).getName();
        	}
        }
        return stormInfo + stormCities;
    }
}