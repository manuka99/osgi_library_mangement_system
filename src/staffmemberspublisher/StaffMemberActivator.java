package staffmemberspublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import DB.DBService;
import service.StaffMembersService;
import service.StaffsServiceImpl;

public class StaffMemberActivator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration serviceRegistration;
	public static ServiceTracker dbServiceTracker;
	public static DBService dbService;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started books service");
		dbServiceTracker = new ServiceTracker(bundleContext, DBService.class.getName(), null);

		StaffMembersService staffMembersService = new StaffsServiceImpl();
		serviceRegistration = bundleContext.registerService(StaffMembersService.class.getName(), staffMembersService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop book service");
		serviceRegistration.unregister();
	}

	public static boolean dbServiceChecker() {
		dbServiceTracker.open();

		dbService = (DBService) dbServiceTracker.getService();

		if (dbService != null)
			return true;
		else
			return false;
	}

}
