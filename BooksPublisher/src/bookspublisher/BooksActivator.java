package bookspublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import bookspublisher.service.BooksService;
import bookspublisher.service.BooksServiceImpl;
import dbpublisher.DBService;
/**
 * @author Manuka yasas
 *
 */
public class BooksActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
//	ServiceReference dbServiceReference;
	public static ServiceTracker dbServiceTracker;
	public static DBService dbService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started books service");
		
		//get the db service
//		dbServiceReference = bundleContext.getServiceReference(DBService.class.getName());
//		DBService dbService1 = (DBService) bundleContext.getService(dbServiceReference);
		
		dbServiceTracker = new ServiceTracker(bundleContext, DBService.class.getName(), null);
		dbServiceTracker.open();
		dbService = (DBService) dbServiceTracker.getService();
		
		BooksService booksService = new BooksServiceImpl(dbService.getConnection());
		serviceRegistration = bundleContext.registerService(BooksService.class.getName(), booksService, null);
		
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
