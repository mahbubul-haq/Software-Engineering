package ServiceOrganizations.Organizations;

import ServiceOrganizations.JCC;

public abstract class ServiceOrgranization
{

    public abstract String getOrganizationName();
    public abstract void setJcc(JCC jcc);
    public abstract void requestService(String serviceName);
    public abstract void serviceRequest();
    public abstract void proviceService();
    public abstract void receiveService(String serviceType);
}
