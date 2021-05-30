package hrms.javaBackend.core.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import hrms.javaBackend.core.adapters.abstracts.MernisCheckService;
import hrms.javaBackend.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisCheckAdapters implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.parseLong(candidate.getIdentityNumber()), 
						candidate.getFirstName().toUpperCase(), 
						candidate.getLastName().toUpperCase(), 
						candidate.getBirthDate().getYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
		if(result) {
			return true;
		}else {
			return false;
		}
	}

}
