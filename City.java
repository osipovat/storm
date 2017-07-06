package a3;

import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList storms;

	public City(String name) {
		this.name = name;
		this.storms = new ArrayList();
	}
	
	public String getName() {
        return name;
    }
	
	public ArrayList getStorms() {
        return storms;
    }

    public boolean wasHit(Storm s) {
    	if (this.storms.contains(s) || s.getCities().contains(this)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public boolean onSamePath(City c) {
    	
    	for (int i = 0; i < this.storms.size(); i++){
    		while (!c.storms.isEmpty()){
    			if (c.storms.contains(this.storms.get(i))){
    				return true;
    			}
    		}
    	}
    	return false;
    }

    public void addStorm(Storm s) {
        this.storms.add(s);
        if (!s.getCities().contains(this)){
        	s.addCity(this);
        }
    }
    
    @Override
    public boolean equals(Object other) {
    	if (this == other) return true;
    	if (other == null) return false;
    	if (this.getClass() != other.getClass())  return false;
    	City otherCity = (City) other;
    	int i = 0;
        while (i != (this.storms.size() - 1) ) {
    		if (this.storms.get(i).equals(otherCity.storms.get(i))) {
    			i = i + 1;
    			continue;
    		}
    		if (otherCity.storms.get(i) == null) {
    			return false;
    		}
    		if (!(otherCity.storms.get(i) instanceof Storm)) {
    			return false;
    		}
    		if (this.storms.get(i).equals(otherCity.storms.get(i))) {
    			i = i + 1;
    			continue;
    		}
            i = i + 1;
        }
    	return this.name.equals(otherCity.name) && 
    			this.storms.size() == otherCity.storms.size();
    }
    
    public String toString() {
        String cityName = this.name;
        String cityStorms = "";
        for (int i = 0; i <this.storms.size(); i++){
        	if (this.storms.get(i) != null){
        		cityStorms += ((Storm) this.storms.get(i)).getName() +", ";
        	}
        }
        int length;
        if (!this.storms.isEmpty()){
        	length = cityStorms.length() - 2;
        }
        else {
        	length = cityStorms.length();
        }
        
		return cityName + " (" + cityStorms.substring(0, length) + ")";
    }
}
