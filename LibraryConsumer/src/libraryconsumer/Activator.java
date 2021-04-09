package libraryconsumer;

import libararypublisher.LibraryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	LibraryService libraryService;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Started library Consumer Service !!!");
		serviceReference = bundleContext.getServiceReference(LibraryService.class.getName());
		libraryService = (LibraryService) bundleContext.getService(serviceReference); 
		libraryService.publishService();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopped library Consumer Service !!!");
		bundleContext.ungetService(serviceReference);
		libraryService.disposeService();
	}

}
