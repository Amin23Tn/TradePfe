package com.Pfe.Trade.Services;

import com.Pfe.Trade.Entities.Annonce;
import com.Pfe.Trade.Entities.CV;
import com.Pfe.Trade.Entities.User;
import com.Pfe.Trade.Repositories.CvRepository;
import com.Pfe.Trade.Repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CvService {
    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private UserRepository userRepository;

    public CV saveCv (CV cv){
        return cvRepository.save(cv);
    }

    public CV UpdateCv (CV cv , String id){
        CV c = cvRepository.findById(id).orElse(null);
        c.setNom(cv.getNom());
        c.setPrenom(cv.getPrenom());
        c.setProfil(cv.getProfil());
        c.setDossComp(cv.getDossComp());
        c.setExpProf(cv.getExpProf());
        c.setDiplome(cv.getDiplome());
        c.setFormation(cv.getFormation());
        c.setLangue(cv.getLangue());
        return cvRepository.save(c);
    }

    private static final Logger l = LogManager.getLogger(CvService.class);
    public List<CV> retrieveAllCv(Pageable pageable) {
        return StreamSupport.stream(cvRepository.findAll(pageable).spliterator(), false).collect(Collectors.toList());
    }
    public CV getCvById(String id) {
        return cvRepository.findById(id).orElse(null);
    }

    public String DeleteCv (String id) {
        cvRepository.deleteById(id);
        return "CV Removed !!" + id ;
    }

    public void uploadFile (MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\Amin\\Desktop\\FileUp\\"+file.getOriginalFilename()));
    }

    public List<CV> searchCvByFor(String formation) {

        List<CV> cvs = cvRepository.searchCVByFormationLike(formation);
        return cvs;
    }


}
