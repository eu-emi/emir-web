package eu.emi.emir.ui.view.address;

public class Address {
	private static final ThreadLocal<String> addressThreadLocal = new ThreadLocal<String>();
	public static void set(String address) {
		addressThreadLocal.set(address);
    }

    public static void unset() {
    	addressThreadLocal.remove();
    }

    public static String get() {
        return addressThreadLocal.get();
    }
}	
