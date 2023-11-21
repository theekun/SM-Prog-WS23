package aufgabe;


import java.util.Date;

public class Measurement {
	/*
	 * Attribute
	 */
	private int pulse;
	private int sys_blood;
	private int dia_blood;
	private Date time;

	
	/*
	 * Konstruktor
	 */
	public Measurement(int pulse, int sys_blood, int dia_blood, Date time) {
		super();
		this.pulse = pulse;
		this.sys_blood = sys_blood;
		this.dia_blood = dia_blood;
		this.time = time;
	}
	
	
	/*
	 * Methoden
	 */
	public void printValues() {
        
        System.out.println("Pulse: " + pulse);
        System.out.println("Systolic Blood Pressure: " + sys_blood);
        System.out.println("Diastolic Blood Pressure: " + dia_blood);
        System.out.println("Measurement Time: " + time);
    }
	
	/*
	 * Getters & Setters
	 */
	public int getPulse() {
		return pulse;
	}


	public int getSys_blood() {
		return sys_blood;
	}


	public int getDia_blood() {
		return dia_blood;
	}
	

}
