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
//	public static ServiceTracker membersServiceTracker;

	//Service
	public static BooksService booksService;
//	public static MembersService membersService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started Library Service !!!");
		LibraryService libraryService = new LibraryServiceImpl();
		serviceRegistration = bundleContext.registerService(LibraryService.class.getName(), libraryService, null);
		
		booksServiceTracker = new ServiceTracker(bundleContext, BooksService.class.getName(), null);
		//membersServiceTracker = new ServiceTracker(bundleContext, MembersService.class.getName(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped Library Service !!!");
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
	
//	public static boolean MembersTrackerChecker() {
//		membersServiceTracker.open();
//		membersService = (MembersService) membersServiceTracker.getService();
//		if (membersService != null)
//			return true;
//		else
//			return false;
//	}

}
