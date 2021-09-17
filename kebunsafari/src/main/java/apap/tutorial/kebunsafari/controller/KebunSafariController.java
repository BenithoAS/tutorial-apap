package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam (value = "id", required = true) String idKebunSafari,
            @RequestParam (value = "nama", required = true) String namaKebunSafari,
            @RequestParam (value = "alamat", required = true) String alamat,
            @RequestParam (value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        // Membuat Objek Kebun Safari baru
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        // Membuat service addKebunSafari
        kebunSafariService.addKebunSafari(kebunSafari);

        // Menambahkan variabel kebunSafari untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mereturn template html yang sipakai
        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        // Mendapatkan list seluruh objek Kebun Safari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        // Menambahkan list untuk dirender di thymeleaf
        model.addAttribute("listKebunSafari", listKebunSafari);

        // Mereturn template html yang dipakai
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value = "id", required = true) String idKebunSafari, Model model){
        // Mendapatkan Objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        // Menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    // Latihan 1
    @RequestMapping("/kebun-safari/view/{idKebunSafari}")
    public String getKebunSafariByIdView(@PathVariable("idKebunSafari") String idKebunSafari, Model model){
        // Mendapatkan Objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        // Menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    // Latihan 2
    @RequestMapping("/kebun-safari/update/{id}")
    public String updateNoTelpById(
            @PathVariable("id") String idKebunSafari,
            @RequestParam (value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        kebunSafari.setNoTelepon(noTelepon);

        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }

    // Latihan 3
    @RequestMapping("/kebun-safari/delete/{id}")
    public String deleteKebunSafariByIdView(@PathVariable("id") String idKebunSafari, Model model){
        // Mendapatkan Objek Kebun Safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        if(kebunSafari != null){
            List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
            listKebunSafari.remove(kebunSafari);

            model.addAttribute("listKebunSafari", listKebunSafari);
            return "get-all-kebun-safari";
        }
        else{
            return "ErrorCode";
        }

    }
    // http://localhost:8080/kebun-safari/update/id-kebun/{id}/alamat/{alamat}
    @RequestMapping("/kebun-safari/update/id-kebun/{id}/alamat/{alamat}")
    public String updateAlamatById(
            @PathVariable("id") String idKebunSafari,
            @PathVariable("alamat") String alamat,
            Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);
        String alamatKebun = alamat;

        for(int i=0; i<listKebunSafari.size(); i++){
            if(listKebunSafari.get(i).getAlamat().equals(alamatKebun)){
                return "ErrorCode";
            }
        }

        kebunSafari.setAlamat(alamat);
        model.addAttribute("kebunSafari", kebunSafari);
        return "detail-kebun-safari";
    }
}
