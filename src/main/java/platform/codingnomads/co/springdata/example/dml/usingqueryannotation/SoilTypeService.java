package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import java.util.List;

@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    @Transactional
    public void getStuff() {
        // FIX THIS
        System.out.println("\nALL SOILTYPES *************");
        List<SoilType> allTypes = soilTypeRepo.findAllOrderByPhDesc();
        for (SoilType soilType : allTypes) {
            System.out.println(soilType.getName() + " " + soilType.getPh());
        }

        System.out.println("\nSOILTYPES GREATER THAN 7.2 *************");
        List<SoilType> phSoilTypeQuery = soilTypeRepo.findByPhGreaterThan(7.2);
        for (SoilType soilType: phSoilTypeQuery) {
            System.out.println(soilType.getName() + " " + soilType.getPh());
        }
        System.out.println("\nDRY SOILTYPES *************");
        List<SoilType> dryTypes = soilTypeRepo.findByDry(true);
        for (SoilType soilType : dryTypes) {
            System.out.println(soilType.getName() + " ----- Is dry: " + soilType.isDry());
        }
        System.out.println("\nNOT DRY AND LESS THAN PH SOILTYPES *************");
        List<SoilType> dryLessThanPh = soilTypeRepo.findByNotDryAndPhLessThan(7.6);
        for (SoilType soilType : dryLessThanPh) {
            System.out.println(soilType.getName() + "\nID: " + soilType.isDry() + "\nPh: "+ soilType.getPh());
        }
        System.out.println("\nFIND BY NAME *************");
        List<SoilType> nameQueryList = soilTypeRepo.findByName("tester2");
        for (SoilType soilType : nameQueryList) {
            System.out.println(soilType.getName() + "\nID: " + soilType.getId() + "\nDry: " + soilType.isDry() + "\nPh: "+ soilType.getPh());
        }
    }

}
