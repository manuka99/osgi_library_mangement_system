/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import dbpublisher.DBService;
import issue_books.service.IssueBooksService;
import issue_books.service.IssueBooksServiceImpl;

public class IssueBookActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	public static ServiceTracker servicetracker;
	public static DBService dbService;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Issuing Book Service Started");
		
		servicetracker = new ServiceTracker(bundleContext, DBService.class.getName(), null);
		
		IssueBooksService issueBooksService = new IssueBooksServiceImpl();
		serviceRegistration = bundleContext.registerService(IssueBooksService.class.getName(), issueBooksService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Issue Books Service Stoped.");
		serviceRegistration.unregister();
	}
	
	public static boolean dbServiceChecker() {
		servicetracker.open();
		
		dbService = (DBService) servicetracker.getService();
		
		if(dbService != null) {
			return true;
		}
		else {
			return false;
		}
	}

}
