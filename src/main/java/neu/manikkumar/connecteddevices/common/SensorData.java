package neu.manikkumar.connecteddevices.common;

import java.util.Date;
import java.sql.Timestamp;

public class SensorData{
    /*
     *Class to store the sensor data being recording from a sensor
     *contains certain variables such as average, minimum and maximum
     */

    //Defining some class variables we'll be using to store our data in
    //and then initializing the variables
    protected float currentValue = 0.0f;
    protected int totalCount     = 0;
    protected float avgValue   = 0.0f;
    protected float maxValue     = 0.0f;
    protected float minValue     = 99;
    public String timestamp;
    protected String name = "Not Set";

    public SensorData() {
    }

    public boolean addValue(float newVal) {
        /*
         *Method to add new Sensor data to the class object
         */
        try {
            //In a try block just in case a wrong datatype gets passed
            //Logging the data in our class variables
            //Calculating and updating values like averages/min/max as new data is input
            this.avgValue   = (this.avgValue*this.totalCount + newVal)/(this.totalCount + 1);
            this.currentValue = newVal;
            this.timestamp    = String.valueOf(new Timestamp(new Date().getTime()));
            this.totalCount++;
            if (newVal > this.maxValue) { this.maxValue = newVal;}
            if (newVal < this.minValue) { this.minValue = newVal;}
        } catch (Exception e) {
            //returns a false if an exception occurs and logging event
            return false;
        }
        //returns true if method worked properly    
        return true;
    }
    
    public float getCurrentValue() {
        /*
         *Method returns the last data value input 
         */
        return this.currentValue;
    }

    public float getAverageValue() {
        /*
         *Method returns the average value of all the values fed to the class object
         */
        return this.avgValue;
    }

    public float getMaxValue() {
        /*
         *Method returns the maximum value seen till now
         */
        return this.maxValue;
    }

    public int getTotal() {
        /*
         *Method returns the total count of all the values fed to the class object
         */
        return this.totalCount;
    }
    public float getMinValue() {
        /*
         *Method returns the minimum value seen till now
         */
        return this.minValue;
    }

    public String getName() {
        /*
         *Method returns the current name set of the SensorData object
         */
        return this.name;
    }

    public boolean setName(String name) {
        /*
         *Method sets the current name of the SensorData object
         */
        this.name = name;
        return true;
    }
    public String toString(){
        return "{\"Time\":" +this.timestamp+"{\"Current\":"+this.currentValue+"{\"Average\":"+this.getAverageValue()+"{\"Samples\":"+this.totalCount+"{\"Minimum\":"+this.minValue+"{\"Maximum\":"+this.maxValue+"{\"Name\":\""+this.currentValue+"\"}";
    }
}