package libararypublisher;

import bookspublisher.service.BooksService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
/**
 * @author Manuka yasas
 *
 */
public class LibraryActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	//	trackers
	public static ServiceTracker booksServiceTracker;

	//Service
	public static BooksService booksService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Displayer Service !!!");
		LibraryService displayService = new LibraryServiceImpl();
		serviceRegistration = bundleContext.registerService(LibraryService.class.getName(), displayService, null);
		booksServiceTracker = new ServiceTracker(bundleContext, BooksService.class.getName(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Displayer Service !!!");
		serviceRegistration.unregister();
	}
	
	public static boolean BooksTrackerChecker() {
		booksServiceTracker.open();
		booksService = (BooksService) booksServiceTracker.getService();
		if (booksService != null)
			return true;
		else
			return false;
	}

}
