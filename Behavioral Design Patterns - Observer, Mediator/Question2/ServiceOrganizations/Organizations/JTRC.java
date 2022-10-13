package ServiceOrganizations.Organizations;


import ServiceOrganizations.JCC;

public class JTRC extends ServiceOrgranization{

    private JCC jcc;
    private int requestCount;//how many requests to serve

    public JTRC(){}

    public void setJcc(JCC jcc)
    {
        this.jcc = jcc;
    }

    public JTRC(JCC jcc)
    {
        this.jcc = jcc;
    }

    @Override
    public String getOrganizationName()
    {
        return "JTRC";
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
