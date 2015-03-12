package com.tenforwardconsulting.cordova.bgloc.data;

import java.lang.Exception;
import java.math.BigDecimal;
import java.lang.Double;
import java.util.Date;

import android.os.SystemClock;


public class Location {
	private String latitude;
	private String longitude;
	private Date recordedAt;
	private String accuracy;
	private String speed;
	private String altitude;
	private String bearing;

	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Date getRecordedAt() {
		return recordedAt;
	}
	public void setRecordedAt(Date recordedAt) {
		this.recordedAt = recordedAt;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getBearing() {
		return bearing;
	}
	public void setBearing(String bearing) {
		this.bearing = bearing;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	public static Location fromAndroidLocation(android.location.Location originalLocation) {
		Location location = new Location();
		location.setRecordedAt(new Date(originalLocation.getTime()));
		location.setLongitude(String.valueOf(setScale(originalLocation.getLongitude())));
		location.setLatitude(String.valueOf(setScale(originalLocation.getLatitude())));
		location.setAccuracy(String.valueOf(originalLocation.getAccuracy()));
		location.setSpeed(String.valueOf(originalLocation.getSpeed()));
		location.setBearing(String.valueOf(originalLocation.getBearing()));
		location.setAltitude(String.valueOf(originalLocation.getAltitude()));
		
		return location;
	}

    private static Double setScale (Double value) {
        Double rounded = value;
        try {
            BigDecimal fixedScale = new BigDecimal(value).setScale(7, BigDecimal.ROUND_HALF_EVEN);
            rounded = fixedScale.doubleValue();
        } catch (Exception e) {
            // There was a problem setting the scale!
        }
        return rounded;
    }
}
