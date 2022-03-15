package com.Pfe.Trade.Controllers;


import com.Pfe.Trade.Entities.Annonce;
import com.Pfe.Trade.Services.AnnonceService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/annonce")
public class AnnonceController {



    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/")
    public Annonce addAnnonce (@RequestBody Annonce annonce){
        return annonceService.saveAnnonce(annonce);
    }

    @PutMapping ("/{id}")
    public Annonce updateAnnonce (@RequestBody Annonce annonce , @PathVariable("id") String id ){
        return annonceService.UpdateAnnonce(annonce,id);
    }

    @GetMapping("/")
    public List<Annonce> getAllAnnonces(Pageable pageable){
        return annonceService.retrieveAllAnnonces(pageable);
    }

    @GetMapping("/{id}")
    public Annonce findAnnonceById(@PathVariable String id) {
        return annonceService.getAnnonceById(id);
    }

    @DeleteMapping("/{id}")
    public String DeletAnnonce (@PathVariable ("id") String id){
       return annonceService.DeleteAnnonce(id);
    }

    @GetMapping("/search/{key}")
    @ResponseBody
    public List<Annonce>  search(@PathVariable ("key") String key) {
        return annonceService.searchAnnonceByDesc(key);  }

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @RequestMapping(value = "/search/{datePub}", method = RequestMethod.GET)
    @ResponseBody
    public List<Annonce>  search(@PathVariable ("datePub") LocalDate datePub) {
        return annonceService.searchAnnonceByDate(datePub);  }

}
