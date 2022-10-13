package TeaGasSys.Packages.Hardware.IdentificationPackage;

public class NFCcard implements Identification{
    @Override
    public void identificationType() {
        System.out.println("NFC card Identification");
    }

}