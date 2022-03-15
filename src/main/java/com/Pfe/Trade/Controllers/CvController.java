package com.Pfe.Trade.Controllers;

import com.Pfe.Trade.Entities.Annonce;
import com.Pfe.Trade.Entities.CV;
import com.Pfe.Trade.Repositories.CvRepository;
import com.Pfe.Trade.Services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Cv")
public class CvController {
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private CvService cvService;

    @PostMapping("/")
    public CV addCv (@RequestBody CV cv){
        return cvService.saveCv(cv);
    }
    @GetMapping("/")
    public List<CV> getAllCv(Pageable pageable){
        return cvService.retrieveAllCv(pageable);
    }

    @PutMapping ("/{id}")
    public CV updateCv (@RequestBody CV cv , @PathVariable("id") String id ){
        return cvService.UpdateCv(cv,id);
    }
    @DeleteMapping("/{id}")
    public String DeletCv (@PathVariable ("id") String id){
        return cvService.DeleteCv(id);
    }
    @GetMapping("/{id}")
    public CV findCvById(@PathVariable String id) {

        return cvService.getCvById(id);
    }

    @PostMapping("/up")
    public void uploadFile (@RequestParam ("file") MultipartFile file) throws IOException {
        cvService.uploadFile(file);
    }

    @GetMapping("/search/{key}")
    @ResponseBody
    public List<CV>  search(@PathVariable ("key") String key) {
        return cvService.searchCvByFor(key);  }
}
