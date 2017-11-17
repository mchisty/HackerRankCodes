
package misc;

public class Test1 {

	public static void main(String[] args) {
		Long l = (long) 2.245;
		Test1 t1 = new Test1();
		double lat1 = 43.7415985072208;
		double lon1 = -79.7179065174291;
		double lat2 = 43.7416411785851;
		double lon2 = -79.7179209825712;
		System.out.println("Distance in meter: " + t1.getDistanceFromLatLonInKm(lat1, lon1, lat2, lon2) * 1000);
		System.out.println("Distance in meter: " + t1.distanceBetweenTwoPointInMeter(lat1, lon1, lat2, lon2));
	}

	public double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
		// Radius of the earth in km
		final int R = 6371;
		double dLat = deg2rad(lat2 - lat1);
		// deg2rad below
		double dLon = deg2rad(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		// Distance in km
		return d;
	}

	private double deg2rad(double deg) {
		return deg * (Math.PI / 180);
	}

	double distanceBetweenTwoPointInMeter(double lat1, double lon1, double lat2, double lon2) {
		double earthRadius = 3958.75;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;
		double meterConversion = 1609;
		return (int) (dist * meterConversion);
	}
}
