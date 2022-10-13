package ServiceOrganizations.Organizations;

import ServiceOrganizations.JCC;

public class JPDC extends ServiceOrgranization
{
    private JCC jcc;
    private int requestCount;//how many requests to serve

    public JPDC(){}

    public void setJcc(JCC jcc)
    {
        this.jcc = jcc;
    }

    public JPDC(JCC jcc)
    {
        this.jcc = jcc;
        requestCount = 0;
    }

    @Override
    public String getOrganizationName()
    {
        return "JPDC";
    }

    @Override
    public void requestService(String serviceName)
    {
        jcc.serviceRequest(this, serviceName);
    }
    @Override
    public void serviceRequest()
    {
        this.requestCount++;
    }
    public void proviceService()
    {
        if (this.requestCount > 0)
        {
            jcc.provideService(this);
            this.requestCount--;
        }
        else System.out.println("There is no service request!");

    }

    @Override
    public void receiveService(String serviceType) {}
}
