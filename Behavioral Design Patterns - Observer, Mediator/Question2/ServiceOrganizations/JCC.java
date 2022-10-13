package ServiceOrganizations;

import ServiceOrganizations.Organizations.*;

import java.util.Queue;
import java.util.LinkedList;

public class JCC
{
    ServiceOrgranization jpdc, jrta, jtrc, jwsa;
    private Queue<ServiceOrgranization> powerRequestInfos, telecomRequestInfos, waterRequestInfos, transportRequestInfos;

    public JCC(){}

    public JCC(JPDC jpdc, JRTA jrta, JTRC jtrc, JWSA jwsa)
    {
        this.jpdc = jpdc;
        this.jrta = jrta;
        this.jtrc = jtrc;
        this.jwsa = jwsa;

        this.jpdc.setJcc(this);
        this.jrta.setJcc(this);
        this.jwsa.setJcc(this);
        this.jtrc.setJcc(this);

        powerRequestInfos = new LinkedList<>();
        telecomRequestInfos = new LinkedList<>();
        waterRequestInfos = new LinkedList<>();
        transportRequestInfos = new LinkedList<>();
    }

    public void provideService(ServiceOrgranization serviceOrgranization)
    {
        if (serviceOrgranization.getOrganizationName().equalsIgnoreCase("jpdc"))
        {
            powerRequestInfos.peek().receiveService("POWER");
            System.out.println("JPDC serves the request of " + powerRequestInfos.peek().getOrganizationName());
            powerRequestInfos.remove();
        }
        else if (serviceOrgranization.getOrganizationName().equalsIgnoreCase("jrta"))
        {
            transportRequestInfos.peek().receiveService("TRANSPORT");
            System.out.println("JRTA serves the request of " + transportRequestInfos.peek().getOrganizationName());
            transportRequestInfos.remove();
        }
        else if (serviceOrgranization.getOrganizationName().equalsIgnoreCase("jtrc"))
        {
            telecomRequestInfos.peek().receiveService("TELECOM");
            System.out.println("JTRC serves the request of " + telecomRequestInfos.peek().getOrganizationName());
            telecomRequestInfos.remove();
        }
        else if (serviceOrgranization.getOrganizationName().equalsIgnoreCase("jwsa"))
        {
            waterRequestInfos.peek().receiveService("WATER");
            System.out.println("JWSA serves the request of " + waterRequestInfos.peek().getOrganizationName());
            waterRequestInfos.remove();
        }
    }

    public void serviceRequest(ServiceOrgranization serviceOrgranization, String serviceType)
    {
        if (serviceType.equalsIgnoreCase("POWER"))
        {
            powerRequestInfos.add(serviceOrgranization);
            jpdc.serviceRequest();
            System.out.println(serviceOrgranization.getOrganizationName() + " requests for POWER service");
        }
        else if(serviceType.equalsIgnoreCase("TELECOM"))
        {
            telecomRequestInfos.add(serviceOrgranization);
            jtrc.serviceRequest();
            System.out.println(serviceOrgranization.getOrganizationName() + " requests for TELECOM service");
        }
        else if(serviceType.equalsIgnoreCase("WATER"))
        {
            waterRequestInfos.add(serviceOrgranization);
            jwsa.serviceRequest();
            System.out.println(serviceOrgranization.getOrganizationName() + " requests for WATER service");
        }
        else if(serviceType.equalsIgnoreCase("TRANSPORT"))
        {
            transportRequestInfos.add(serviceOrgranization);
            jrta.serviceRequest();
            System.out.println(serviceOrgranization.getOrganizationName() + " requests for TRANSPORT service");

        }
    }
}
