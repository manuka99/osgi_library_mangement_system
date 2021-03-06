package memberpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import dbpublisher.DBService;
import memberpublisher.Service.MemberServiceImpl;
import memberpublisher.Service.MembersService;

public class MemberActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
//	ServiceReference dbServiceReference;
	public static ServiceTracker dbServiceTracker;
	public static DBService dbService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started member service");

		// get the db service
//		dbServiceReference = bundleContext.getServiceReference(DBService.class.getName());
//		DBService dbService1 = (DBService) bundleContext.getService(dbServiceReference);

		dbServiceTracker = new ServiceTracker(bundleContext, DBService.class.getName(), null);

		MembersService membersService = new MemberServiceImpl();
		serviceRegistration = bundleContext.registerService(MembersService.class.getName(), membersService, null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop member service");
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