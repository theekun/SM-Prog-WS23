package aufgabe;

import java.util.Date;
import java.util.Random;

public class GenericTest {
	
	/*
	 * Attribute
	 */
	private String name;
	private Date time;
	// Referenz auf ein Array vom Typ Measurement
	private Measurement[] measurements;
	
	/*
	 * Konstruktor
	 */
	public GenericTest(String name, int numMeasurements){
		this.name = name;
		this.measurements = new Measurement[numMeasurements];
	}
	
	/*
	 * Methods
	 */
	public void print() {
		System.out.println("Test:"+name);
		for (Measurement m : measurements) {
			m.printValues();
		}
	}

	public void readValues() {
		
		// Generiert random measurement werte
        Random random = new Random();
        for (int i = 0; i < measurements.length; i++) {
            int pulse = random.nextInt(200);
            int systolic = random.nextInt(200);
            int diastolic = random.nextInt(200);
            Date time = new Date();
            measurements[i] = new Measurement(pulse, systolic, diastolic, time);
		}
	}
	/*
	 * Getters & Setters
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Measurement[] getMeasurements(){
		return measurements;
	}
	
	

}
