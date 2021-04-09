package dbpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("DB service started");
		DBService driverService = new DBServiceImpl();
		serviceRegistration = bundleContext.registerService(DBService.class.getName(), driverService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("DB service stopped");
		serviceRegistration.unregister();
	}

}
